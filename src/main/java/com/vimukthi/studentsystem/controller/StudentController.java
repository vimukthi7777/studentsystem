package com.vimukthi.studentsystem.controller;

import com.vimukthi.studentsystem.entity.Student;
import com.vimukthi.studentsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Student> add(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.save(student));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }
}
