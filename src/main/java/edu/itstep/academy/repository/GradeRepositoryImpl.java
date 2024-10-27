package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Grade;
import edu.itstep.academy.entity.Student;
import edu.itstep.academy.entity.Subject;
import edu.itstep.academy.entity.Teacher;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GradeRepositoryImpl implements GradeRepository
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Grade> findAllGrades()
    {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Grade ")
                .list();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Grade grade)
    {
        sessionFactory
                .getCurrentSession().saveOrUpdate(grade);
    }

    @Override
    @Transactional
    public Grade findGradeById(int id)
    {
        return sessionFactory
                .getCurrentSession().get(Grade.class, id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        sessionFactory
                .getCurrentSession()
                .createQuery("delete from Grade where id=" + id)
                .executeUpdate();
    }
}
