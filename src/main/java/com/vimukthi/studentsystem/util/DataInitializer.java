package com.vimukthi.studentsystem.util;

import com.vimukthi.studentsystem.entity.Admin;
import com.vimukthi.studentsystem.repository.AdminRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final AdminRepo adminRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Create a default Admin if the table is empty
        if (adminRepo.findByUsername("Admin").isEmpty()) {
            String hashedPassword = passwordEncoder.encode("admin@123");
            Admin admin = new Admin("Admin", hashedPassword);
            adminRepo.save(admin);
            System.out.println(">>System Initialized: Admin account created (Admin / admin@123)");
        }
    }
}