package com.example.SpringProjectTemplate.controller;

import com.example.SpringProjectTemplate.dto.ResponseDto;
import com.example.SpringProjectTemplate.dto.user.UserReqDto;
import com.example.SpringProjectTemplate.dto.user.UserRespDto;
import com.example.SpringProjectTemplate.dto.user.UserRespDto.JoinRespDto;
import com.example.SpringProjectTemplate.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.example.SpringProjectTemplate.dto.user.UserReqDto.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/api/users/join")
    public ResponseEntity<?> join(@RequestBody @Valid JoinReqDto joinReqDto, BindingResult bindingResult){
        JoinRespDto joinRespDto = userService.회원가입(joinReqDto);
        return new ResponseEntity<>(new ResponseDto<>(1, "회원가입 완료", joinRespDto), HttpStatus.OK);
    }

    @Operation(summary = "로그인", description = "바디에 {password, phoneNumber} 을 json 형식으로 보내주세요, 토큰은 Bearer을 포함해주세요")
    @PostMapping("/api/users/login")
    public ResponseEntity<?> login(@RequestBody LoginReqDto loginReqDto) {
        return null;
    }

    @GetMapping("/api/s/users")
    public ResponseEntity<?> checkAuth(){

        return new ResponseEntity<>(new ResponseDto<>(1, "인증성공", null), HttpStatus.OK);
    }
}
