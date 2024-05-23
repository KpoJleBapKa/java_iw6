package com.university.departmentmanagement.repositories;

import com.university.departmentmanagement.models.DepartmentNews;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentNewsRepository extends JpaRepository<DepartmentNews, Long> {
    }
