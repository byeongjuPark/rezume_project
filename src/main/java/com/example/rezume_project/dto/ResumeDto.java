package com.example.rezume_project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ResumeDto {

    private String id;
    private String resumeType;


    public ResumeDto(String id, String resumeType) {
        this.id = id;
        this.resumeType = resumeType;
    }

}
