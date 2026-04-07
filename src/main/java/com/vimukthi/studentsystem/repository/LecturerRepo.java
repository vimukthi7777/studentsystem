package com.vimukthi.studentsystem.repository;

import com.vimukthi.studentsystem.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LecturerRepo extends JpaRepository<Lecturer, Long> {
    // Find a lecturer by their unique NIC number
    Optional<Lecturer> findByNic(String nic);
}
