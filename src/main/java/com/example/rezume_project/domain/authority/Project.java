package com.example.rezume_project.domain.authority;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_uid")
    private Integer projectUid;

    @Column(name = "file")
    private String file;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_content")
    private String projectContent;

    @ManyToOne
    @JoinColumn(name = "portfolio_uid")
    private Portfolio portfolio;

    // getter, setter, constructor
}


