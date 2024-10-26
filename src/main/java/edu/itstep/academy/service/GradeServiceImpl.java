package edu.itstep.academy.service;

import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService
{
    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public void createGrade(Grade grade)
    {
        gradeRepository.saveOrUpdate(grade);
    }

    @Override
    public void updateGrade(Grade grade)
    {

    }

    @Override
    public void deleteGrade(int id)
    {

    }
}
