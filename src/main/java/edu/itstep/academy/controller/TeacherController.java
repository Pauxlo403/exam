package edu.itstep.academy.controller;

import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.repository.StudentRepository;
import edu.itstep.academy.repository.SubjectRepository;
import edu.itstep.academy.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TeacherController
{
    @Autowired
    GradeService gradeService;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @RequestMapping("/teacherCreateGrade")
    public String teacherCreateGrade(Model model)
    {
        List<Student> students = studentRepository.findAllStudents();
        List<Subject> subjects = subjectRepository.findAllSubjects();

        model.addAttribute("grade", new Grade());
        model.addAttribute("students", students);
        model.addAttribute("subjects", subjects);
        model.addAttribute("idStudent", 0);

        return "teacher-grade-form";
    }

    @RequestMapping("/teacherAddGrade")
    public String teacherAddGrade(@ModelAttribute("grade") Grade grade,
                                  @RequestParam("idStudent") int idStudent, Model model)
    {
        gradeService.createGrade(grade);
        return "redirect:/";
    }
}
