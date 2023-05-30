package com.example.jwtSecurity.user.controller;

import com.example.jwtSecurity.user.dto.UserDto;
import com.example.jwtSecurity.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // 회원가입
    @PostMapping("/join")
    // validation 처리
    public String join(@RequestBody @Valid UserDto userDto){
        log.info("회원가입 시도됨");

        return userService.join(userDto);
    }

    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        log.info("user email = {}", user.get("email"));

        return userService.login(user);
    }
}