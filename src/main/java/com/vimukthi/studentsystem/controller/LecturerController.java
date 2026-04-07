package com.vimukthi.studentsystem.controller;

import com.vimukthi.studentsystem.entity.Lecturer;
import com.vimukthi.studentsystem.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lecturers")
@RequiredArgsConstructor
public class LecturerController {

    private final LecturerService lecturerService;

    @PostMapping("/add")
    public ResponseEntity<Lecturer> add(@RequestBody Lecturer lecturer) {
        return ResponseEntity.ok(lecturerService.save(lecturer));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Lecturer>> getAll() {
        return ResponseEntity.ok(lecturerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lecturer> getById(@PathVariable Long id) {
        return ResponseEntity.ok(lecturerService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lecturer> update(@PathVariable Long id, @RequestBody Lecturer lecturerDetails) {
        return ResponseEntity.ok(lecturerService.update(id, lecturerDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        lecturerService.delete(id);
        return ResponseEntity.ok("Lecturer deleted successfully!");
    }
}
