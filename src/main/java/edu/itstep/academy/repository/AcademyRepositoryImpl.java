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
public class AcademyRepositoryImpl implements AcademyRepository
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Student> findAll()
    {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Student ")
                .list();
    }

    @Override
    @Transactional
    public List<Subject> findAllSkills(int teacherid)
    {
        return sessionFactory.getCurrentSession().createQuery
                ("from Subject where id in " +
                        "(select skillid from Grade where teacherid = :teacherid)")
                .setParameter("teacherid", teacherid)
                .list();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Teacher teacher)
    {
        sessionFactory
                .getCurrentSession().saveOrUpdate(teacher);
    }

    @Override
    @Transactional
    public List<Subject> getAllSkills()
    {
        return sessionFactory.getCurrentSession().createQuery("from Subject").list();
    }

    @Override
    @Transactional
    public Teacher findTeacherById(int id) {
        return sessionFactory
                .getCurrentSession()
                .get(Teacher.class, id);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        sessionFactory
                .getCurrentSession()
                .createQuery("delete from Teacher where id=" + id)
                .executeUpdate();
    }
}
