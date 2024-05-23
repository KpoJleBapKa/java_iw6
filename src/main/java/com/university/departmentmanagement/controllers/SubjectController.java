package com.university.departmentmanagement.controllers;

import com.university.departmentmanagement.models.Subject;
import com.university.departmentmanagement.models.Department;
import com.university.departmentmanagement.services.SubjectService;
import com.university.departmentmanagement.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;
    private final DepartmentService departmentService;

    @GetMapping
    public String listSubjects(Model model) {
        List<Subject> subjects = subjectService.listSubjects();
        List<Department> departments = departmentService.listDepartments();
        model.addAttribute("subjects", subjects);
        model.addAttribute("departments", departments); // Додаємо кафедри до моделі
        return "subjects";
    }

    @GetMapping("/new")
    public String showAddSubjectForm(Model model) {
        List<Department> departments = departmentService.listDepartments();
        model.addAttribute("departments", departments);
        model.addAttribute("subject", new Subject());
        return "add-subject";
    }

    @PostMapping
    public String addSubject(@ModelAttribute Subject subject, @RequestParam Long departmentId) {
        Department department = departmentService.getDepartmentById(departmentId);
        if (department != null) {
            subject.setDepartment(department);
            subjectService.addSubject(subject);
        }
        return "redirect:/subjects";
    }
}
