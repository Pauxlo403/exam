package edu.itstep.academy.controller;

import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.service.GradeService;
import edu.itstep.academy.service.StudentService;
import edu.itstep.academy.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/")
    public String homeStudent(Model model)
    {
        List<Grade> gradesAllForTeacher = gradeService.findAllGrades();
        List<Subject> subjects = subjectService.findAllSubjects();
        List<Student> students = studentService.findAllStudents();

        model.addAttribute("gradesAllForTeacher", gradesAllForTeacher);
        model.addAttribute("selectedSubjectId", 0);
        model.addAttribute("usernameStudent", "all");
        model.addAttribute("students", students);
        model.addAttribute("subjects", subjects);

        return "home";
    }

    @RequestMapping("/student-all-grades")
    public String showAll(Model model)
    {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        String username = principal.getName();

        List<Grade> gradesAllForStudent = gradeService.findAllGradesForStudent(username);
        List<Subject> subjects = subjectService.findAllSubjects();

        model.addAttribute("gradesAllForStudent", gradesAllForStudent);
        model.addAttribute("selectedSubjectId", 0);
        model.addAttribute("subjects", subjects);
        return "student-all-grades";
    }

    @RequestMapping("/studentFilter")
    public String studentFilter(@RequestParam("idSubject") int idSubject,
                                @RequestParam("dateGrade") @Nullable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                                Model model)
    {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        String username = principal.getName();

        List<Grade> filteredGradesForStudent = gradeService.findFilteredGrade(username, idSubject, date);
        List<Subject> subjects = subjectService.findAllSubjects();

        model.addAttribute("selectedSubjectId", idSubject);
        model.addAttribute("gradesAllForStudent", filteredGradesForStudent);
        model.addAttribute("subjects", subjects);

        return "student-all-grades";
    }
}
