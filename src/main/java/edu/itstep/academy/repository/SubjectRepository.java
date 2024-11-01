package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Subject;
import java.util.List;

public interface SubjectRepository
{
    List<Subject> findAllSubjects();
    Subject findSubjectById(int id);
}
