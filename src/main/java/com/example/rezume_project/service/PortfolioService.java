package com.example.rezume_project.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.rezume_project.domain.authority.Portfolio;

import java.util.List;

public interface PortfolioService {

    List<Portfolio> getAllPortfolios();
    
    void addPortfolio(String name, String description, String date, MultipartFile file);
    
    void deletePortfolio(Long id);
}

