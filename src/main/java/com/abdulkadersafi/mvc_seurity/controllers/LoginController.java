package com.abdulkadersafi.mvc_seurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class LoginController {
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/403")
    public String forbiddenRequest() {
        return "forbidden-request";
    }
}
