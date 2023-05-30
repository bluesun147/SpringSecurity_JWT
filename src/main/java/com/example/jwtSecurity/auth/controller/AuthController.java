package com.example.jwtSecurity.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

// https://velog.io/@jkijki12/Spirng-Security-Jwt-로그인-적용하기

@RestController
public class AuthController {

    @PostMapping("/test")
    public String test(){

        return "통과!!";
    }
}