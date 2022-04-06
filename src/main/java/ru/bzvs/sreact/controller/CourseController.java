package ru.bzvs.sreact.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.bzvs.sreact.model.Course;
import ru.bzvs.sreact.service.CourseService;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/instructors/{username}/courses")
    public List<Course> getAllCourses(@PathVariable String username) {
        return courseService.findAll();
    }

    @DeleteMapping("/instructors/{username}/courses/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String username, @PathVariable long id) {
        Course course = courseService.deleteById(id);
        if (course != null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/instructors/{username}/courses/{id}")
    public Course getCourse(@PathVariable String username, @PathVariable long id) {
        return courseService.findById(id);
    }

    @PutMapping("instructors/{username}/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable String username, @PathVariable long id, @RequestBody Course course) {
        Course updatedCourse = courseService.save(course);
        return new ResponseEntity<Course>(updatedCourse, HttpStatus.OK);
    }

    @PostMapping("instructors/{username}/courses")
    public ResponseEntity<Void> createCourse(@PathVariable String username, @RequestBody Course course) {
        Course createdCourse = courseService.save(course);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/id").
                buildAndExpand(createdCourse.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
