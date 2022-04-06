package ru.bzvs.sreact.service;

import ru.bzvs.sreact.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAll();

    Course deleteById(long id);

    Course findById(long id);

    Course save(Course course);
}
