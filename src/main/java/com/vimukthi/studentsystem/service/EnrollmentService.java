package com.vimukthi.studentsystem.service;

import com.vimukthi.studentsystem.entity.Course;
import com.vimukthi.studentsystem.entity.Enrollment;
import com.vimukthi.studentsystem.entity.Student;
import com.vimukthi.studentsystem.repository.CourseRepo;
import com.vimukthi.studentsystem.repository.EnrollmentRepo;
import com.vimukthi.studentsystem.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepo enrollmentRepo;
    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;

    public Enrollment addMarks(Long studentId, Long courseId, Double marks) {
        Student student = studentRepo.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setMarks(marks);

        // Automatic Grade Logic
        enrollment.setGrade(calculateGrade(marks));

        return enrollmentRepo.save(enrollment);
    }

    public List<Enrollment> getStudentResults(Long studentId) {
        return enrollmentRepo.findByStudentId(studentId);
    }

    private String calculateGrade(Double marks) {
        if (marks >= 75) return "A";
        if (marks >= 65) return "B";
        if (marks >= 55) return "C";
        if (marks >= 45) return "S";
        return "F";
    }
}