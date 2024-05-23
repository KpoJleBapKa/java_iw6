package com.university.departmentmanagement.services;

import com.university.departmentmanagement.models.Subject;
import com.university.departmentmanagement.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public List<Subject> listSubjects() {
        return subjectRepository.findAll();
    }

    public void addSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
