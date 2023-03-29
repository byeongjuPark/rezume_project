package com.example.rezume_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping({"/home", "", "/"})
  public String home() {
    return "content/home";
  }
  
    @GetMapping({"/resume"})
    public String resume() {
      return "content/resume";
    }

  @GetMapping({"/project"})
  public String project() {
    return "content/project";
  }

  @GetMapping({"/contact"})
  public String contact() {
    return "content/contact";
  }

}
