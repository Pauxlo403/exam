package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.entity.Teacher;

import java.util.List;

public interface StudentRepository
{
    List<Student> findAllStudents();
    Student findStudentById(int id);
    List<Subject> getAllSkills();

}
