package com.university.departmentmanagement.controllers;

import com.university.departmentmanagement.models.Department;
import com.university.departmentmanagement.models.DepartmentNews;
import com.university.departmentmanagement.services.DepartmentNewsService;
import com.university.departmentmanagement.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/news")
public class DepartmentNewsController {
    private final DepartmentNewsService departmentNewsService;
    private final DepartmentService departmentService;
    private static final Logger logger = LoggerFactory.getLogger(DepartmentNewsController.class);

    @GetMapping
    public String listNews(Model model) {
        List<DepartmentNews> newsList = departmentNewsService.listNews();
        List<Department> departments = departmentService.listDepartments();
        model.addAttribute("newsList", newsList);
        model.addAttribute("departments", departments);
        model.addAttribute("news", new DepartmentNews());
        return "news";
    }

    @PostMapping
    public String addNews(@ModelAttribute DepartmentNews news, @RequestParam Long departmentId) {
        logger.info("Adding news for department ID: {}", departmentId);
        Department department = departmentService.getDepartmentById(departmentId);
        if (department != null) {
            logger.info("Department found: {}", department.getName());
            news.setDepartment(department);
            departmentNewsService.addNews(news);
            logger.info("News added successfully for department: {}", department.getName());
        } else {
            logger.warn("Department not found for ID: {}", departmentId);
        }
        return "redirect:/news";
    }
}
