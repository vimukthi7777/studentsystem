package com.vimukthi.studentsystem.service;

import com.vimukthi.studentsystem.entity.Admin;
import com.vimukthi.studentsystem.repository.AdminRepo;
import com.vimukthi.studentsystem.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepo adminRepo;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String login(String username, String password) {
        Optional<Admin> adminOpt = adminRepo.findByUsername(username);
        if (adminOpt.isPresent() && passwordEncoder.matches(password, adminOpt.get().getPassword())) {
            return jwtUtil.generateToken(username);
        }
        return null;
    }
}