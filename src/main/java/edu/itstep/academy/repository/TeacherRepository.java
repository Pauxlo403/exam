package edu.itstep.academy.repository;

import edu.itstep.academy.entity.Teacher;
import java.util.List;

public interface TeacherRepository
{
    List<Teacher> findAllTeachers();
}
