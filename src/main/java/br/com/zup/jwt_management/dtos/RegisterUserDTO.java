package br.com.zup.jwt_management.dtos;

import br.com.zup.jwt_management.model.Role;
import lombok.Data;

import java.util.Set;

@Data
public class RegisterUserDTO {
    private String name;
    private String username;
    private String email;
    private String password;
    private Set<Roles> roles;
}
