package com.example.rezume_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "content/user/login";
    }

    @GetMapping("/register")
    public String register() {
        return "content/user/register";
    }
}
