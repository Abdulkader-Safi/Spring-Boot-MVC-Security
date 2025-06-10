package com.abdulkadersafi.mvc_seurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/leaders")
    public String showLeadersPage() {
        return "leaders";
    }

    @GetMapping("/systems")
    public String showSystemsPage() {
        return "systems";
    }
}
