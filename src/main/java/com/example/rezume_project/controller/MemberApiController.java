package com.example.rezume_project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.rezume_project.domain.authority.Member;
import com.example.rezume_project.service.MemberService;

@RestController
public class MemberApiController {
    private final MemberService memberService;

    public MemberApiController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/api/member")
    public void save(@RequestBody Member.SaveRequest member) {
        memberService.save(member);
    }
}