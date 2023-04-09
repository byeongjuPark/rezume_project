package com.example.rezume_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rezume_project.domain.authority.Resume;
import com.example.rezume_project.dto.ResumeDto;
import com.example.rezume_project.service.ResumeService;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/add")
    public ResponseEntity<Resume> addResume(@RequestBody ResumeDto resumeDto) {
        Resume savedResume = resumeService.addResume(resumeDto);
        return new ResponseEntity<>(savedResume, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resume> getResumeById(@PathVariable String id) {
        Resume resume = resumeService.getResumeById(id);
        return new ResponseEntity<>(resume, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resume> updateResume(@PathVariable String id, @RequestBody ResumeDto resumeDto) {
        Resume updatedResume = resumeService.updateResume(id, resumeDto);
        return new ResponseEntity<>(updatedResume, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResume(@PathVariable String id) {
        resumeService.deleteResume(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


