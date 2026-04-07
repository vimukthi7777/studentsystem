package com.vimukthi.studentsystem.service;

import com.vimukthi.studentsystem.entity.Lecturer;
import com.vimukthi.studentsystem.repository.LecturerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LecturerService {

    private final LecturerRepo lecturerRepo;

    public Lecturer save(Lecturer lecturer) {
        return lecturerRepo.save(lecturer);
    }

    public List<Lecturer> getAll() {
        return lecturerRepo.findAll();
    }

    public Lecturer getById(Long id) {
        return lecturerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Lecturer not found with id: " + id));
    }

    public Lecturer update(Long id, Lecturer details) {
        Lecturer lecturer = getById(id);
        lecturer.setName(details.getName());
        lecturer.setNic(details.getNic());
        lecturer.setPhoneNumber(details.getPhoneNumber());
        return lecturerRepo.save(lecturer);
    }

    public void delete(Long id) {
        lecturerRepo.deleteById(id);
    }
}