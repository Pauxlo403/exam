package edu.itstep.academy.service;

import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class GradeServiceImpl implements GradeService
{
    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    @Override
    public List<Grade> findAllGrades()
    {
        return gradeRepository.findAllGrades();
    }

    @Override
    public List<Grade> findAllGradesForStudent(String username)
    {
        Student student = studentService.findStudentByUsername(username);
        return gradeRepository.findGradesByStudent(student.getId());
    }

    @Override
    public List<Grade> findFilteredGrade(String username, int idSubject, Date date)
    {
        Student student = studentService.findStudentByUsername(username);
        if(username.equals("all"))
        {
            if(date == null)
            {
                if(idSubject == 0)
                {
                    return findAllGrades();
                }
                else
                {
                    return gradeRepository.findGradesBySubject(idSubject);
                }
            }
            else
            {
                if(idSubject == 0)
                {
                    return gradeRepository.findGradesByDate(date);
                }
                else
                {
                    return gradeRepository.findGradesBySubjectAndDate(idSubject, date);
                }
            }
        }
        else
        {
            if(date == null)
            {
                if(idSubject == 0)
                {

                    return gradeRepository.findGradesByStudent(student.getId());
                }
                else
                {
                    return gradeRepository.findGradesByStudentAndSubject(student.getId(), idSubject);
                }
            }
            else
            {
                if(idSubject == 0)
                {
                    return gradeRepository.findGradesByStudentAndDate(student.getId(), date);
                }
                else
                {
                    return gradeRepository.findGradesByStudentSubjectAndDate(student.getId(), idSubject, date);
                }
            }
        }
    }

    @Override
    public void createGrade(Grade grade)
    {
        gradeRepository.saveOrUpdate(grade);
    }

    @Override
    public Boolean validateGrade(Grade grade)
    {
        if (grade.getGrade() < 0 || grade.getGrade() > 100)
        {
            return false;
        }
        return true;
    }

    @Override
    public Grade updateGrade(int id)
    {
        return gradeRepository.findGradeById(id);
    }

    @Override
    public Grade setStudentAndSubject(Grade grade, int idStudent, int idSubject, int idGrade)
    {
        Student student = studentService.findStudentById(idStudent);
        Subject subject = subjectService.findSubjectById(idSubject);
        grade.setId(idGrade);
        grade.setStudent(student);
        grade.setSubject(subject);
        return grade;
    }

    @Override
    public Boolean validateDate(Grade grade)
    {
        if(grade.getDatecurrent() == null)
        {
            return false;
        }
        return true;
    }
    @Override
    public Boolean validateStudent(Grade grade)
    {
        if (grade.getStudent() == null)
        {
            return false;
        }
        return true;
    }
    @Override
    public Boolean validateSubject(Grade grade)
    {
        if(grade.getSubject() == null)
        {
            return false;
        }
        return true;
    }

    @Override
    public void deleteGrade(int id)
    {
        gradeRepository.deleteById(id);
    }
}
