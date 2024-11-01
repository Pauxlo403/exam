package edu.itstep.academy.service;

import edu.itstep.academy.entity.Teacher;
import edu.itstep.academy.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService
{
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> findAllTeachers()
    {
        return teacherRepository.findAllTeachers();
    }
}
