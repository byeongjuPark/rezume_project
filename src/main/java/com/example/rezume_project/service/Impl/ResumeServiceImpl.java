package com.example.rezume_project.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rezume_project.domain.authority.Resume;
import com.example.rezume_project.dto.ResumeDto;
import com.example.rezume_project.repository.ResumeRepository;
import com.example.rezume_project.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public Resume addResume(ResumeDto resumeDto) {
        Resume resume = new Resume(resumeDto.getId(), resumeDto.getResumeType());
        return resumeRepository.save(resume);
    }

    @Override
    public Resume getResumeById(String id) {
        return resumeRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Resume", "id", id));
    }

    // orElseThrow() 메소드는 Optional 객체가 비어있는 경우, 해당 예외를 발생시키는 Supplier를 인자로 받아 처리함
    // 따라서, 해당 오류는 orElseThrow() 메소드를 호출할 때, 예외를 발생시키는 Supplier를 추가해야함

    @Override
    public Resume updateResume(String id, ResumeDto resumeDto) {
        Resume resume = resumeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resume", "id", id));
        resume.setResumeType(resumeDto.getResumeType());
        return resumeRepository.save(resume);
    }

    @Override
    public void deleteResume(String id) {
        Resume resume = resumeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resume", "id", id));
        resumeRepository.delete(resume);
    }
}

