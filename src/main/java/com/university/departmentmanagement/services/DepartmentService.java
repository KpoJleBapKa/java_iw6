package com.university.departmentmanagement.services;

import com.university.departmentmanagement.models.Department;
import com.university.departmentmanagement.models.Subject;
import com.university.departmentmanagement.repositories.DepartmentRepository;
import com.university.departmentmanagement.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class    DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final SubjectRepository subjectRepository;

    public List<Department> listDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public void addSubjectsToDepartment(Long departmentId, List<Long> subjectIds) {
        Department department = getDepartmentById(departmentId);
        if (department != null) {
            List<Subject> subjects = subjectRepository.findAllById(subjectIds);
            for (Subject subject : subjects) {
                subject.setDepartment(department);
                subjectRepository.save(subject);
            }
        }
    }
}
