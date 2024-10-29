package edu.itstep.academy.controller;

import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.service.GradeService;
import edu.itstep.academy.service.StudentService;
import edu.itstep.academy.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TeacherController
{
    @Autowired
    GradeService gradeService;

    @Autowired
    StudentService studentService;

    @Autowired
    SubjectService subjectService;

    @RequestMapping("/teacherCreateGrade")
    public String teacherCreateGrade(Model model)
    {
        List<Student> students = studentService.findAllStudents();
        List<Subject> subjects = subjectService.findAllSubjects();
        model.addAttribute("grade", new Grade());
        model.addAttribute("students", students);
        model.addAttribute("subjects", subjects);
        model.addAttribute("idStudent", 0);
        model.addAttribute("idSubject", 0);
        model.addAttribute("errorMessage", "");

        return "teacher-grade-form";
    }

    @RequestMapping("/teacherAddGrade")
    public String teacherAddGrade(@ModelAttribute("grade") Grade grade,
                                  @RequestParam("idStudent") int idStudent,
                                  @RequestParam("idSubject") int idSubject,
                                  @RequestParam("idGrade") int idGrade,
                                  Model model)
    {
        grade = gradeService.setStudentAndSubject(grade, idStudent, idSubject, idGrade);
        if (gradeService.validateGrade(grade) == false)
        {
            List<Student> students = studentService.findAllStudents();
            List<Subject> subjects = subjectService.findAllSubjects();

            model.addAttribute("grade", grade);
            model.addAttribute("students", students);
            model.addAttribute("subjects", subjects);

            model.addAttribute("errorMessage", "Grade must be between 0 and 100");
            return "teacher-grade-form";
        }
        if (gradeService.validateDate(grade) == false)
        {
            List<Student> students = studentService.findAllStudents();
            List<Subject> subjects = subjectService.findAllSubjects();

            model.addAttribute("grade", grade);
            model.addAttribute("students", students);
            model.addAttribute("subjects", subjects);

            model.addAttribute("errorMessage", "Date can`t be empty!");
            return "teacher-grade-form";
        }
        if (gradeService.validateStudent(grade) == false)
        {
            List<Student> students = studentService.findAllStudents();
            List<Subject> subjects = subjectService.findAllSubjects();
            model.addAttribute("grade", grade);
            model.addAttribute("students", students);
            model.addAttribute("subjects", subjects);

            model.addAttribute("errorMessage", "Student can`t be empty!");
            return "teacher-grade-form";
        }
        if (gradeService.validateSubject(grade) == false)
        {
            List<Student> students = studentService.findAllStudents();
            List<Subject> subjects = subjectService.findAllSubjects();
            model.addAttribute("grade", grade);
            model.addAttribute("students", students);
            model.addAttribute("subjects", subjects);

            model.addAttribute("errorMessage", "Subject can`t be empty!");
            return "teacher-grade-form";
        }
        gradeService.createGrade(grade);
        return "redirect:/";
    }

    @RequestMapping("/teacherDeleteGrade")
    public String teacherDeleteGrade(@RequestParam("gradeId") int gradeId)
    {
        gradeService.deleteGrade(gradeId);
        return "redirect:/";
    }

    @RequestMapping("/teacherUpdateGrade")
    public String teacherUpdateGrade(@RequestParam("gradeId") int gradeId, Model model)
    {
        Grade grade = gradeService.updateGrade(gradeId);

        List<Student> students = studentService.findAllStudents();
        List<Subject> subjects = subjectService.findAllSubjects();

        model.addAttribute("grade", grade);
        model.addAttribute("students", students);
        model.addAttribute("subjects", subjects);
        model.addAttribute("idStudent", grade.getStudent().getId());
        model.addAttribute("idSubject", grade.getSubject().getId());

        return "teacher-grade-form";
    }
}
