package com.vimukthi.studentsystem.service;

import com.vimukthi.studentsystem.entity.Course;
import com.vimukthi.studentsystem.repository.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// CourseService.java
@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepo courseRepo;

    public Course save(Course course) {
        return courseRepo.save(course);
    }

    public List<Course> getAll() {
        return courseRepo.findAll();
    }

    public Course getById(Long id) {
        return courseRepo.findById(id).orElseThrow();
    }

    // Add to CourseService.java
    public Course update(Long id, Course courseDetails) {
        Course course = courseRepo.findById(id).orElseThrow();
        course.setName(courseDetails.getName());
        course.setDuration(courseDetails.getDuration());
        course.setCreditCount(courseDetails.getCreditCount());
        return courseRepo.save(course);
    }

    public void delete(Long id) {
        courseRepo.deleteById(id);
    }
}
