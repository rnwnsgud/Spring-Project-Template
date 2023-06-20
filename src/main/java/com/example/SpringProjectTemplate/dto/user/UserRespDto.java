package com.example.SpringProjectTemplate.dto.user;

import com.example.SpringProjectTemplate.domain.user.User;
import com.example.SpringProjectTemplate.util.CustomDateUtil;
import lombok.Getter;
import lombok.Setter;

public class UserRespDto {

    @Getter
    @Setter
    public static class JoinRespDto {
        private Long id;
        private String username;

        public JoinRespDto(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
        }
    }

    @Getter
    @Setter
    public static class LoginRespDto {
        private Long id;
        private String username;
        private String createdAt;
        private String jwtToken;

        public LoginRespDto(User user, String jwtToken) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.createdAt = CustomDateUtil.toStringFormat(user.getCreateDate());
            this.jwtToken = jwtToken;
        }
    }
}
