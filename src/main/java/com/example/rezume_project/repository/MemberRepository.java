package com.example.rezume_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rezume_project.domain.authority.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

}
