package com.example.rezume_project.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PortfolioDto {
    private Integer portfolioUid;
    private Integer memberUid;
    private String projectType;
    // private List<ProjectDto> projects;

}

