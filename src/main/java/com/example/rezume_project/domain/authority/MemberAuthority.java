package com.example.rezume_project.domain.authority;

public enum MemberAuthority {
    USER("USER"), ADMIN("ADMIN");

    private String name;

    private MemberAuthority(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}