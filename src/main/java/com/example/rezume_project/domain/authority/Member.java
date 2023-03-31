package com.example.rezume_project.domain.authority;

import java.beans.Transient;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Entity(name = "MEMBER")
public class Member {
    @Id
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
