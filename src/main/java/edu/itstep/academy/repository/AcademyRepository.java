package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.entity.Teacher;

import java.util.List;

public interface AcademyRepository
{
    List<Student> findAll();

    List<Subject> findAllSkills(int id);

    List<Subject> getAllSkills();

    void saveOrUpdate(Teacher teacher);

    Teacher findTeacherById(int id);

    void deleteById(int id);
}
