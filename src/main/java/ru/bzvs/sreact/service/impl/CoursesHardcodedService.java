package ru.bzvs.sreact.service.impl;

import org.springframework.stereotype.Service;
import ru.bzvs.sreact.model.Course;
import ru.bzvs.sreact.service.CourseService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesHardcodedService implements CourseService {

    private static final List<Course> courses = new ArrayList<>();
    private static long idCounter;


    static {
        courses.add(new Course(++idCounter, "in28minutes", "Learn Full stack with Spring Boot and Angular"));
        courses.add(new Course(++idCounter, "in28minutes", "Learn Full stack with Spring Boot and React"));
        courses.add(new Course(++idCounter, "in28minutes", "Master Microservices with Spring Boot and Spring Cloud"));
        courses.add(new Course(++idCounter, "in28minutes",
                "Deploy Spring Boot Microservices to Cloud with Docker and Kubernetes"));
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public Course deleteById(long id) {
        Course course = findById(id);
        if (course == null) {
            return null;
        } else {
            if (courses.remove(course)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public Course findById(long id) {
        return courses.stream().
                filter(course -> course.getId().equals(id)).
                findFirst().orElse(null);
    }

    @Override
    public Course save(Course course) {
        if (course.getId() == -1 || course.getId() == 0) {
            course.setId(++idCounter);
        } else {
            deleteById(course.getId());
        }
        courses.add(course);
        return course;
    }
}
