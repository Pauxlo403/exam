package edu.itstep.academy.service;

import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.repository.GradeRepository;
import edu.itstep.academy.repository.StudentRepository;
import edu.itstep.academy.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents()
    {
        return studentRepository.findAllStudents();
    }

    @Override
    public Student findStudentByUsername(String username)
    {
        Student student = null;
        for(Student stud : studentRepository.findAllStudents())
        {
            if(stud.getUsername().equals(username))
            {
                student = stud;
                break;
            }
        }
        return student;
    }

    @Override
    public Student findStudentById(int id)
    {
        return studentRepository.findStudentById(id);
    }
}
