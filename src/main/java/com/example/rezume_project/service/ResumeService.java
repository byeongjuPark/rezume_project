package com.example.rezume_project.service;

import com.example.rezume_project.domain.authority.Resume;
import com.example.rezume_project.dto.ResumeDto;

public interface ResumeService {
    Resume addResume(ResumeDto resumeDto);
    Resume getResumeById(String id);
    Resume updateResume(String id, ResumeDto resumeDto);
    void deleteResume(String id);
}
