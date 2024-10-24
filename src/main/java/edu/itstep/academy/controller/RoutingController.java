package edu.itstep.academy.controller;

import edu.itstep.academy.entity.Student;
import edu.itstep.academy.repository.AcademyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RoutingController
{
    @Autowired
    private AcademyRepository academyRepository;

    @RequestMapping("/")
    public String home()
    {
        return "home";
    }

//    @RequestMapping("/")
//    public String showAll(Model model)
//    {
//        List<Student> students = academyRepository.findAll();
//
//        model.addAttribute("students", students);
//        return "teacher-all-students";
//    }
//
//    @RequestMapping("/createContact")
//    public String create(Model model)
//    {
//        model.addAttribute("teacher", new Teacher());
//        return "contact-form";
//    }
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
