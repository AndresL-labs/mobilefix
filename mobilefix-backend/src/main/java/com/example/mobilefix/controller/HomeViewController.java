package com.example.mobilefix.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeViewController {
    @GetMapping("/")
    public String index() {
        return "redirect:/auth/login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
