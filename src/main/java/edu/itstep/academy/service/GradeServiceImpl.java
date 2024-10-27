package edu.itstep.academy.service;

import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.repository.GradeRepository;
import edu.itstep.academy.repository.StudentRepository;
import edu.itstep.academy.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService
{
    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public void createGrade(Grade grade, int idStudent, int idSubject, int idGrade)
    {
        Student student = studentRepository.findStudentById(idStudent);
        Subject subject = subjectRepository.findSubjectById(idSubject);
        grade.setId(idGrade);
        grade.setStudent(student);
        grade.setSubject(subject);
        gradeRepository.saveOrUpdate(grade);
    }

    @Override
    public Grade updateGrade(int id)
    {
        return gradeRepository.findGradeById(id);
    }

    @Override
    public void deleteGrade(int id)
    {
        gradeRepository.deleteById(id);
    }
}
