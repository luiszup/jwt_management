package br.com.zup.jwt_management.dtos;

import lombok.Data;

@Data
public class LoginDTO {
    private String username;
    private String password;
}
