package edu.itstep.academy.service;


import edu.itstep.academy.entity.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> findAllSubjects();
    Subject findSubjectById(int id);
}
