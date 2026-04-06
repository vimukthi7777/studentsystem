package com.vimukthi.studentsystem.controller;

import com.vimukthi.studentsystem.entity.Enrollment;
import com.vimukthi.studentsystem.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    // POST: http://localhost:8282/api/v1/enrollments/student/1/course/2
    @PostMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Enrollment> enrollOnly(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        return ResponseEntity.ok(enrollmentService.enrollOnly(studentId, courseId));
    }

    // CREATE: Enroll Student and Add Marks
    @PostMapping("/add-marks")
    public ResponseEntity<Enrollment> addMarks(@RequestBody Map<String, Object> data) {
        Long studentId = Long.valueOf(data.get("studentId").toString());
        Long courseId = Long.valueOf(data.get("courseId").toString());
        Double marks = Double.valueOf(data.get("marks").toString());
        return ResponseEntity.ok(enrollmentService.addMarks(studentId, courseId, marks));
    }

    // READ: Get results for a specific student
    @GetMapping("/results/{studentId}")
    public ResponseEntity<List<Enrollment>> getResults(@PathVariable Long studentId) {
        return ResponseEntity.ok(enrollmentService.getStudentResults(studentId));
    }

    // UPDATE: Modify marks for an existing enrollment
    @PutMapping("/update-marks/{enrollmentId}")
    public ResponseEntity<Enrollment> updateMarks(@PathVariable Long enrollmentId, @RequestBody Map<String, Double> data) {
        Double newMarks = data.get("marks");
        return ResponseEntity.ok(enrollmentService.updateMarks(enrollmentId, newMarks));
    }

    // DELETE: Remove a student from a course (Delete enrollment record)
    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable Long enrollmentId) {
        enrollmentService.deleteEnrollment(enrollmentId);
        return ResponseEntity.ok("Enrollment record removed successfully!");
    }
}
