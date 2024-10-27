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

    Grade findGradeById(int id);

    void deleteById(int id);
}
