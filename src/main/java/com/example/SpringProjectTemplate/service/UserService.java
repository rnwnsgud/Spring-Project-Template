package com.example.SpringProjectTemplate.service;

import com.example.SpringProjectTemplate.domain.user.User;
import com.example.SpringProjectTemplate.domain.user.UserRepository;
import com.example.SpringProjectTemplate.dto.user.UserReqDto;
import com.example.SpringProjectTemplate.dto.user.UserRespDto;
import com.example.SpringProjectTemplate.handler.ex.CustomApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;


import static com.example.SpringProjectTemplate.dto.user.UserReqDto.*;
import static com.example.SpringProjectTemplate.dto.user.UserRespDto.*;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JoinRespDto 회원가입(JoinReqDto joinReqDto) {

        Optional<User> userOP = userRepository.findByUsername(joinReqDto.getUsername());
        if (userOP.isPresent()) {
            throw new CustomApiException("동일한 사용자명이 존재합니다.");
        }
        User userPS = userRepository.save(joinReqDto.toEntity(bCryptPasswordEncoder));
        return new JoinRespDto(userPS);
    }
}
