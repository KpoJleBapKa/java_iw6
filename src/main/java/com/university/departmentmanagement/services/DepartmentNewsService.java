package com.university.departmentmanagement.services;

import com.university.departmentmanagement.models.DepartmentNews;
import com.university.departmentmanagement.repositories.DepartmentNewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentNewsService {
    private final DepartmentNewsRepository departmentNewsRepository;

    public List<DepartmentNews> listNews() {
        return departmentNewsRepository.findAll();
    }

    public void addNews(DepartmentNews news) {
        departmentNewsRepository.save(news);
    }
}
