package com.vimukthi.studentsystem.service;

import com.vimukthi.studentsystem.entity.Course;
import com.vimukthi.studentsystem.entity.Department;
import com.vimukthi.studentsystem.entity.Lecturer;
import com.vimukthi.studentsystem.repository.CourseRepo;
import com.vimukthi.studentsystem.repository.DepartmentRepo;
import com.vimukthi.studentsystem.repository.LecturerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// CourseService.java
@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepo courseRepo;
    private final LecturerRepo lecturerRepo; // Inject new repo
    private final DepartmentRepo departmentRepo; // Inject new repo

    public Course save(Course course) {
        return courseRepo.save(course);
    }

    public List<Course> getAll() {
        return courseRepo.findAll();
    }

    public Course getById(Long id) {
        return courseRepo.findById(id).orElseThrow();
    }

    // Updated update method in CourseService.java
    public Course update(Long id, Course courseDetails) {
        Course course = courseRepo.findById(id).orElseThrow();

        // 1. Update basic fields
        course.setName(courseDetails.getName());
        course.setDuration(courseDetails.getDuration());
        course.setCreditCount(courseDetails.getCreditCount());

        // 2. Update Relationships (This was what was missing!)
        // Handle Department
        if (courseDetails.getDepartment() != null && courseDetails.getDepartment().getId() != null) {
            Department dept = departmentRepo.findById(courseDetails.getDepartment().getId()).orElse(null);
            course.setDepartment(dept);
        } else {
            course.setDepartment(null); // Clear it if "None" was selected
        }

        // Handle Lecturer
        if (courseDetails.getLecturer() != null && courseDetails.getLecturer().getId() != null) {
            Lecturer lecturer = lecturerRepo.findById(courseDetails.getLecturer().getId()).orElse(null);
            course.setLecturer(lecturer);
        } else {
            course.setLecturer(null); // Clear it if "None" was selected
        }

        return courseRepo.save(course);
    }

    public void delete(Long id) {
        courseRepo.deleteById(id);
    }

    public Course assignLecturerAndDept(Long courseId, Long lecturerId, Long deptId) {
        Course course = courseRepo.findById(courseId).orElseThrow();
        Lecturer lecturer = lecturerRepo.findById(lecturerId).orElseThrow();
        Department dept = departmentRepo.findById(deptId).orElseThrow();

        course.setLecturer(lecturer);
        course.setDepartment(dept);

        return courseRepo.save(course);
    }

    public Course assignDetails(Long courseId, Long lecturerId, Long deptId) {
        Course course = courseRepo.findById(courseId).orElseThrow();
        Lecturer lecturer = lecturerRepo.findById(lecturerId).orElseThrow();
        Department dept = departmentRepo.findById(deptId).orElseThrow();

        course.setLecturer(lecturer);
        course.setDepartment(dept);

        return courseRepo.save(course);
    }
}
