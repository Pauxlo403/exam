package edu.itstep.academy.service;

import edu.itstep.academy.entity.Grade;

public interface GradeService {
    void createGrade(Grade grade, int idStudent, int idSubject, int idGrade);
    Grade updateGrade(int id);
    void deleteGrade(int id);
}
