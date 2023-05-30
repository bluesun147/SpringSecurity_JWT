package com.example.jwtSecurity.user.service;

import com.example.jwtSecurity.auth.jwt.provider.JwtTokenProvider;
import com.example.jwtSecurity.user.Admin;
import com.example.jwtSecurity.user.Gender;
import com.example.jwtSecurity.user.dto.UserDto;
import com.example.jwtSecurity.user.entity.User;
import com.example.jwtSecurity.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    // 회원가입
    public String join(UserDto userDto) {
        String BIRTH = userDto.getUserBirth();
        String EMAIL = userDto.getUserEmail();
        String NICKNAME = userDto.getUserNickname();
        Long SEQUENCEID = userDto.getUserSequenceId();
        Gender GENDER = userDto.getGender();
        Admin ADMIN = userDto.getAdmin();

        User user = User.builder()
                .userEmail(EMAIL)
                .userBirth(BIRTH)
                .userNickname(NICKNAME)
                .admin(ADMIN)
                .gender(GENDER)
                .userSequenceId(SEQUENCEID)
                .roles(Collections.singletonList("ROLE_USER")) // 최초 가입시 USER 로 설정
                .build();

        userRepository.save(user);

        return user.toString();
    }

    // 로그인
    public String login(Map<String, String> user) {
        User member = userRepository.findByUserEmail(user.get("email"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));

        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }
}
