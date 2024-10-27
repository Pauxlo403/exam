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
public class StudentRepositoryImpl implements StudentRepository
{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Student> findAllStudents()
    {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Student ", Student.class)
                .list();
    }

    @Override
    @Transactional
    public Student findStudentById(int id) {
        return sessionFactory.getCurrentSession().get(Student.class, id);
    }

    @Override
    @Transactional
    public List<Subject> getAllSkills()
    {
        return sessionFactory.getCurrentSession().createQuery("from Subject").list();
    }

}
