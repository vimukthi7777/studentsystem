package com.vimukthi.studentsystem.repository;

import com.vimukthi.studentsystem.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {
    // This allows us to get all marks/grades for one specific student
    List<Enrollment> findByStudentId(Long studentId);

    // 1. For "Who are the students in a specific course"
    List<Enrollment> findByCourseId(Long courseId);
}
