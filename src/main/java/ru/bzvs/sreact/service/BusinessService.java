package ru.bzvs.sreact.service;

import ru.bzvs.sreact.model.Course;

import java.util.List;

public interface BusinessService {

    List<Course> findAll();

    Course deleteById(long id);
}
