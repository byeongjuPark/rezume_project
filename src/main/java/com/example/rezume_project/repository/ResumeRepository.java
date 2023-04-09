package com.example.rezume_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rezume_project.domain.authority.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, String> {
}

