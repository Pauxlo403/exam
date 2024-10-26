package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.entity.Teacher;

import java.util.List;

public interface GradeRepository
{
    List<Grade> findAllGrades();

    void saveOrUpdate(Grade grade);

    void deleteById(int id);
}
