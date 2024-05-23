package com.university.departmentmanagement.repositories;

import com.university.departmentmanagement.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
