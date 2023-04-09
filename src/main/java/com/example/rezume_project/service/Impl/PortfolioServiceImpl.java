package com.example.rezume_project.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.rezume_project.domain.authority.Member;
import com.example.rezume_project.domain.authority.Portfolio;
import com.example.rezume_project.repository.PortfolioRepository;
import com.example.rezume_project.service.PortfolioService;

import java.io.IOException;
import java.util.List;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    @Override
    public void addPortfolio(String name, String description, String date, MultipartFile file) {
        Portfolio portfolio = new Portfolio();
    
        portfolio.setPortfolioUid(null);
        portfolio.setProjectType(date);
        portfolio.setProjects(null);

        // if (file != null && !StringUtils.isEmpty(file.getOriginalFilename())) {
        //     try {
        //         portfolio.setFile(file.getBytes());
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // }

        portfolioRepository.save(portfolio);
    }

    @Override
    public void deletePortfolio(Long id) {
        portfolioRepository.deleteById(id);
    }
}

