package com.blog.mouctar.demoMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HelloController
{
    @GetMapping({"/", "/hello"})
    public String showWelcomePage() {
        System.out.println("Passe par HelloController");
        return "hello";
    }
}
