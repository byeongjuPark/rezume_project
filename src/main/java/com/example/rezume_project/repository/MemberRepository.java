package com.example.rezume_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rezume_project.domain.authority.Member;

// JpaRepository 인터페이스는 Spring Data JPA에서 제공하는 인터페이스 중 하나로, CRUD(Create, Read, Update, Delete) 기능을 제공
// JpaRepository 인터페이스를 상속받는 인터페이스는 JpaRepository 인터페이스에서 제공하는 기본적인 CRUD 메소드를 상속받아 사용할 수 있음
public interface MemberRepository extends JpaRepository<Member, String> {

}
