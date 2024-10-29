package edu.itstep.academy.service;

import edu.itstep.academy.entity.Grade;

import java.util.Date;
import java.util.List;

public interface GradeService {
    List<Grade> findAllGrades();
    List<Grade> findAllGradesForStudent(String username);
    List<Grade> findFilteredGrade(String username, int idSubject, Date date);
    void createGrade(Grade grade);
    Grade updateGrade(int id);
    void deleteGrade(int id);
    Boolean validateGrade(Grade grade);
    Boolean validateDate(Grade grade);
    Boolean validateStudent(Grade grade);
    Boolean validateSubject(Grade grade);
    Grade setStudentAndSubject(Grade grade, int idStudent, int idSubject, int idGrade);
}
