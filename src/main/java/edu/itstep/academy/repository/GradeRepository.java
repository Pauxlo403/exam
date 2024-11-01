package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Grade;
import java.util.Date;
import java.util.List;

public interface GradeRepository
{
    List<Grade> findAllGrades();

    void saveOrUpdate(Grade grade);

    Grade findGradeById(int id);

    List<Grade> findGradesByStudent(int id);

    List<Grade> findGradesBySubject(int idSubject);

    List<Grade> findGradesByDate(Date date);

    List<Grade> findGradesByStudentAndSubject(int idStudent, int idSubject);

    List<Grade> findGradesByStudentAndDate(int idStudent, Date date);

    List<Grade> findGradesBySubjectAndDate(int idSubject , Date date);

    List<Grade> findGradesByStudentSubjectAndDate(int idStudent, int idSubject , Date date);

    void deleteById(int id);
}
