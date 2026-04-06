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

    // POST: /api/v1/enrollments/add-marks
    @PostMapping("/add-marks")
    public ResponseEntity<Enrollment> addMarks(@RequestBody Map<String, Object> data) {
        Long studentId = Long.valueOf(data.get("studentId").toString());
        Long courseId = Long.valueOf(data.get("courseId").toString());
        Double marks = Double.valueOf(data.get("marks").toString());

        return ResponseEntity.ok(enrollmentService.addMarks(studentId, courseId, marks));
    }

    // GET: /api/v1/enrollments/results/1
    @GetMapping("/results/{studentId}")
    public ResponseEntity<List<Enrollment>> getResults(@PathVariable Long studentId) {
        return ResponseEntity.ok(enrollmentService.getStudentResults(studentId));
    }
}
