package edu.itstep.academy.service;

import edu.itstep.academy.entity.Grade;

public interface GradeService {
    void createGrade(Grade grade);
    void updateGrade(Grade grade);
    void deleteGrade(int id);
}
