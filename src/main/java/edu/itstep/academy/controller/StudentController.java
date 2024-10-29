package edu.itstep.academy.controller;

import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.repository.GradeRepository;
import edu.itstep.academy.repository.StudentRepository;
import edu.itstep.academy.service.GradeService;
import edu.itstep.academy.service.StudentService;
import edu.itstep.academy.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

        model.addAttribute("gradesAllForTeacher", gradesAllForTeacher);
        return "home";
    }

//    @RequestMapping("/teacher-grade-form")
//    public String asdasdasdasd(Model model)
//    {
//        List<Student> students = academyRepository.findAllStudents();
//        model.addAttribute("students", students);
//        model.addAttribute("grade", new Grade());
//
//        return "teacher-grade-form";
//    }

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
//
//    @RequestMapping("/saveContact")
//    public String saveContact(@ModelAttribute("teacher") Teacher teacher)
//    {
//        List<Subject> subjects = new ArrayList<>();
//        for (Subject subject : teacher.getSkills())
//        {
//            Subject newSubject = new Subject();
//            int startIndexId = subject.getTitle().indexOf('=');
//            int endIndexId = subject.getTitle().indexOf(',');
//            int id = Integer.parseInt(subject.getTitle().substring(startIndexId+1,endIndexId));
//
//            int startIndexTitle = subject.getTitle().indexOf('\'');
//            int endIndexTitle = subject.getTitle().lastIndexOf('\'');
//            String title = subject.getTitle().substring(startIndexTitle+1,endIndexTitle);
//
//            newSubject.setId(id);
//            newSubject.setTitle(title);
//            subjects.add(newSubject);
//        }
//        teacher.setSkills(subjects);
//        contactRepository.saveOrUpdate(teacher);
//        return "redirect:/";
//    }
//
//    @RequestMapping("/upgradeSkills")
//    public String upgradeSkills(@RequestParam("selectedTeacherId") int id, Model model)
//    {
//        Teacher selectedTeacher = contactRepository.findTeacherById(id);
//        selectedTeacher.setSkills(contactRepository.findAllSkills(selectedTeacher.getId()));
//        List<Subject> subjects = contactRepository.getAllSkills();
//
//        model.addAttribute("teacher", selectedTeacher);
//        model.addAttribute("allSkills", subjects);
//        return "upgrade-skills";
//    }
//
//    @RequestMapping("/deleteContact")
//    public String deleteByID(@RequestParam("teacherId") int id){
//        contactRepository.deleteById(id);
//        return "redirect:/";
//    }
//
//    @RequestMapping("/updateContact")
//    public String updateContact(@RequestParam("teacherId") int id, Model model) {
//        Teacher teacher = contactRepository.findTeacherById(id);
//        model.addAttribute("contact", teacher);
//        return "contact-form";
//    }
}
