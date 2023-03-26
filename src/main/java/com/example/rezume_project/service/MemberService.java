package com.example.rezume_project.service;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.rezume_project.domain.authority.Member;
import com.example.rezume_project.repository.MemberRepository;

@Service
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(Member.SaveRequest member) {
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        memberRepository.save(member.toEntity());
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findById(username)
            .orElseThrow(() -> new UsernameNotFoundException("username"));

        return toUserDetails(member);
    }

    private UserDetails toUserDetails(Member member) {
        return User.builder()
            .username(member.getId())
            .password(member.getPassword())
            .authorities(new SimpleGrantedAuthority(member.getAuthority().getName()))
        .build();
    }
}
