package com.example.SpringProjectTemplate.domain.user;

import com.example.SpringProjectTemplate.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@Entity
@Table(name = "user_tb")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 20)
    private String username;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(length = 20)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserEnum role;

    @Builder
    public User(Long id, String username, String password, String email, UserEnum role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
