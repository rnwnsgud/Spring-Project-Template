package com.example.SpringProjectTemplate.dto.user;


import com.example.SpringProjectTemplate.domain.user.User;
import com.example.SpringProjectTemplate.domain.user.UserEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class UserReqDto {

    @Getter
    @Setter
    public static class JoinReqDto {

        @Schema(example = "ssar")
        @Pattern(regexp = "^[a-zA-Z0-9가-힣]{2,10}$", message = "영문/숫자/한글 2~10자 이내로 작성해주세요.")
        @NotEmpty
        private String username;


        @Schema(example = "1234")
        @NotEmpty
        @Size(min = 4, max = 20)
        private String password;

        public User toEntity(BCryptPasswordEncoder bcryptPasswordEncoder) {

            return User.builder()
                    .username(username)
                    .password(bcryptPasswordEncoder.encode(password))
                    .role(UserEnum.USER)
//                    .role(UserEnum.ADMIN)
                    .build();
        }
    }

    // 당근 마켓 로그인은 전화번호로
    @Getter
    @Setter
    public static class LoginReqDto {
        @Schema(example = "ssar")
        private String username;
        @Schema(example = "1234")
        private String password;
    }


}
