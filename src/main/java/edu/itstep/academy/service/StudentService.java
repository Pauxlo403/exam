package edu.itstep.academy.service;

import edu.itstep.academy.entity.Student;
import java.util.List;

public interface StudentService
{
    List<Student> findAllStudents();
    Student findStudentByUsername(String username);
    Student findStudentById(int id);

}
