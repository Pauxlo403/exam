package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Grade;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
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
    public List<Grade> findGradesByStudent(int id)
    {
       return sessionFactory
                .getCurrentSession().createQuery("from Grade where student.id =" + id).list();
    }

    @Override
    @Transactional
    public  List<Grade> findGradesBySubject(int idSubject)
    {
        return sessionFactory
                .getCurrentSession().createQuery("from Grade where subject.id =" +idSubject).list();
    }

    @Override
    @Transactional
    public List<Grade> findGradesByDate(Date date)
    {
        return sessionFactory
                .getCurrentSession().createQuery("from Grade where datecurrent = :date " ).setParameter("date", date).list();
    }

    @Override
    @Transactional
    public List<Grade> findGradesByStudentAndSubject(int idStudent, int idSubject)
    {
        return sessionFactory
                .getCurrentSession().createQuery("from Grade where student.id =" + idStudent
                + "and subject.id =" +idSubject).list();
    }

    @Override
    @Transactional
    public List<Grade> findGradesByStudentAndDate(int idStudent, Date date)
    {
        return sessionFactory
                .getCurrentSession().createQuery("from Grade where student.id = " + idStudent
                       + " and datecurrent = :date " ).setParameter("date", date).list();
    }

    @Override
    @Transactional
    public List<Grade> findGradesBySubjectAndDate(int idSubject, Date date)
    {
        return sessionFactory
                .getCurrentSession().createQuery("from Grade where subject.id = " + idSubject
                        + " and datecurrent = :date " ).setParameter("date", date).list();
    }

    @Override
    @Transactional
    public List<Grade> findGradesByStudentSubjectAndDate(int idStudent, int idSubject , Date date)
    {
        return sessionFactory
                .getCurrentSession().createQuery("from Grade where student.id =" + idStudent
                        + " and datecurrent = :date" + " and subject.id =" +idSubject).setParameter("date", date).list();
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
    public void deleteById(int id)
    {
        sessionFactory
                .getCurrentSession()
                .createQuery("delete from Grade where id=" + id)
                .executeUpdate();
    }
}
