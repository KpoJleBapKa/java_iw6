package com.university.departmentmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department_SHAKHMATOV")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "title", columnDefinition = "text")
    private String title;

    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Column(name = "classroom", nullable = false, length = 10)
    private String classroom;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Subject> subjects;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<DepartmentNews> news;
}
