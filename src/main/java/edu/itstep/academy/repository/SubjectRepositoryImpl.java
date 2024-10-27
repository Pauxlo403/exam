package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.entity.Teacher;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SubjectRepositoryImpl implements SubjectRepository
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Subject> findAllSubjects()
    {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Subject ", Subject.class)
                .list();
    }

    @Override
    @Transactional
    public Subject findSubjectById(int id) {
        return sessionFactory.getCurrentSession().get(Subject.class, id);
    }
}
