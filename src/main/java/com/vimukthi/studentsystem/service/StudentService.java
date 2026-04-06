package com.vimukthi.studentsystem.service;

import com.vimukthi.studentsystem.entity.Student;
import com.vimukthi.studentsystem.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;

    public Student save(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    public Student getById(Long id) {
        return studentRepo.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        studentRepo.deleteById(id);
    }
}

