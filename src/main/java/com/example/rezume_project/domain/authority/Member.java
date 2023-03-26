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
	// id 컬럼을 MEMBER 테이블의 기본키로 설정
    @Id
    private String id;
    private String password;
    private MemberAuthority authority;

    @Builder
    public Member(String id, String password, MemberAuthority authority) {
        this.id = id;
        this.password = password;
        this.authority = authority;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    public static class SaveRequest {
        private String id;
        private String password;
        private MemberAuthority authority;

        @Transient
        public Member toEntity() {
            return Member.builder()
                        .id(this.id)
                        .password(this.password)
                        .authority(this.authority)
                    .build();
        }
    }
}
