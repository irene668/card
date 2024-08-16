package com.jing.card.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Table(name="user")
@Getter @Setter
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    @NotBlank(message = "帳號不可為空")
    @UniqueUsername
    private String username;

    @NotBlank(message = "密碼不可為空")
    @Size(min=8,message = "密碼不可少於8位")
    private String password;

    @Column(unique=true)
    @Email(message = "信箱格式錯誤")
    @NotBlank(message = "信箱不可為空")
    @UniqueEmail
    private String email;

}
