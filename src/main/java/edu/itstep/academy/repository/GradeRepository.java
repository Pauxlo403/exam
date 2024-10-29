package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.entity.Teacher;

import java.util.Date;
import java.util.List;

public interface GradeRepository
{
    List<Grade> findAllGrades();

    void saveOrUpdate(Grade grade);

    Grade findGradeById(int id);

    List<Grade> findGradesByStudent(int id);

    List<Grade> findGradesBySubject(int idStudent,int idSubject);

    List<Grade> findGradesByDate(int idStudent, Date date);

    List<Grade> findGradesBySubjectAndDate(int idStudent, int idSubject , Date date);

    void deleteById(int id);
}
