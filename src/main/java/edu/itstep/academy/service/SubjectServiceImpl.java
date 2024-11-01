package edu.itstep.academy.service;

import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService
{
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> findAllSubjects()
    {
       return subjectRepository.findAllSubjects();
    }
    @Override
    public Subject findSubjectById(int id)
    {
        return subjectRepository.findSubjectById(id);
    }
}
