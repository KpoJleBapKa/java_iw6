package com.university.departmentmanagement.controllers;

import com.university.departmentmanagement.models.Department;
import com.university.departmentmanagement.models.Subject;
import com.university.departmentmanagement.services.DepartmentService;
import com.university.departmentmanagement.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final SubjectService subjectService;

    @GetMapping
    public String listDepartments(Model model) {
        List<Department> departments = departmentService.listDepartments();
        model.addAttribute("departments", departments);
        return "departments";
    }

    @GetMapping("/{id}")
    public String getDepartmentById(@PathVariable Long id, Model model) {
        Department department = departmentService.getDepartmentById(id);
        model.addAttribute("department", department);
        return "department-info";
    }

    @PostMapping
    public String addDepartment(@ModelAttribute Department department) {
        departmentService.addDepartment(department);
        return "redirect:/departments";
    }

    @GetMapping("/{id}/add-subjects")
    public String addSubjectsToDepartmentForm(@PathVariable Long id, Model model) {
        Department department = departmentService.getDepartmentById(id);
        List<Subject> subjects = subjectService.listSubjects();
        model.addAttribute("department", department);
        model.addAttribute("subjects", subjects);
        return "add-subjects-to-department";
    }

    @PostMapping("/{id}/subjects")
    public String addSubjectsToDepartment(@PathVariable Long id, @RequestParam List<Long> subjectIds) {
        departmentService.addSubjectsToDepartment(id, subjectIds);
        return "redirect:/departments/" + id;
    }
}
