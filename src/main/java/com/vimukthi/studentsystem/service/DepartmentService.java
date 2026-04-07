package com.vimukthi.studentsystem.service;

import com.vimukthi.studentsystem.entity.Department;
import com.vimukthi.studentsystem.repository.DepartmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepo departmentRepo;

    public Department save(Department department) {
        return departmentRepo.save(department);
    }

    public List<Department> getAll() {
        return departmentRepo.findAll();
    }

    public Department getById(Long id) {
        return departmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + id));
    }

    public Department update(Long id, Department details) {
        Department dept = getById(id);
        dept.setName(details.getName());
        return departmentRepo.save(dept);
    }

    public void delete(Long id) {
        departmentRepo.deleteById(id);
    }
}
