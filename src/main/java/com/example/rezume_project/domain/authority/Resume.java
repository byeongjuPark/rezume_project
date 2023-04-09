package com.example.rezume_project.domain.authority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "resume")
@Getter
@Setter
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resume_uid")
    private Integer resume_uid;

    @Column(name = "id")
    private String id;

    @Column(name = "resume_type")
    private String resume_type;

    public void setResume_type(String resume_type) {
        this.resume_type = resume_type;
    }

    public Resume(String id, String resume_type) {
        this.id = id;
        this.resume_type = resume_type;
    }
    
}
