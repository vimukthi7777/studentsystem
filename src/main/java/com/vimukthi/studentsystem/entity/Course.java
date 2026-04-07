package com.vimukthi.studentsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int duration;
    private int creditCount;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

    // --- CUSTOM GETTERS TO PREVENT NULL IN API ---

    public Department getDepartment() {
        if (this.department == null) {
            Department temp = new Department();
            temp.setName("Not Assigned");
            return temp;
        }
        return this.department;
    }

    public Lecturer getLecturer() {
        if (this.lecturer == null) {
            Lecturer temp = new Lecturer();
            temp.setName("Not Assigned");
            temp.setNic("N/A");
            temp.setPhoneNumber("N/A");
            return temp;
        }
        return this.lecturer;
    }
}