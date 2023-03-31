package com.example.rezume_project.domain.authority;

import java.beans.Transient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Entity(name = "MEMBER")
public class Member {
    // id 컬럼을 MEMBER 테이블의 기본키로 설정
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "USER_SEQ_GENERATOR"
                        , sequenceName = "USER_SEQ"
                        , initialValue = 1
                        , allocationSize = 1)
    private int member_uid;
    private String id;
    private String password;
    private MemberAuthority authority;
    private String name;
    private String name_en;
    private String phone;
    private String email;


    @Builder
    public Member(String id, String password, MemberAuthority authority, String name, String name_en, String phone,
            String email) {
        this.id = id;
        this.password = password;
        this.authority = authority;
        this.name = name;
        this.name_en = name_en;
        this.phone = phone;
        this.email = email;

    }
    @Getter
    @Setter
    @NoArgsConstructor
    public static class SaveRequest {
        private int member_uid;
        private String id;
        private String password;
        private MemberAuthority authority;
        private String name;
        private String name_en;
        private String phone;
        private String email;

        @Transient
        public Member toEntity() {
            return Member.builder()
                        .id(this.id)
                        .password(this.password)
                        .authority(this.authority)
                        .name(this.name)
                        .name_en(this.name_en)
                        .phone(this.phone)
                        .email(this.email)
                    .build();
        }
    }
}
