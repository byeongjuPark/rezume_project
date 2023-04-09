package com.example.rezume_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.rezume_project.domain.authority.Portfolio;
import com.example.rezume_project.service.PortfolioService;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/list")
    public List<Portfolio> getAllPortfolios() {
        return portfolioService.getAllPortfolios();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPortfolio(@RequestParam("name") String name, 
                                                @RequestParam("description") String description, 
                                                @RequestParam("date") String date, 
                                                @RequestParam("file") MultipartFile file) {
        portfolioService.addPortfolio(name, description, date, file);
        return new ResponseEntity<>("Portfolio added successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePortfolio(@PathVariable("id") Long id) {
        portfolioService.deletePortfolio(id);
        return new ResponseEntity<>("Portfolio deleted successfully.", HttpStatus.OK);
    }
}
