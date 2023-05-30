package com.example.jwtSecurity.user.dto;

import com.example.jwtSecurity.user.Admin;
import com.example.jwtSecurity.user.Gender;
import lombok.*;

import javax.validation.constraints.Email;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    // email validation 처리
    @Email(message = "이메일 형식으로 입력해 주세요")
    private String userEmail;
    private String userBirth;
    private String userNickname;
    private Gender gender;
    private Admin admin;
    private Long userSequenceId;
}
