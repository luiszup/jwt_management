package br.com.zup.jwt_management.controller;

import br.com.zup.jwt_management.dtos.RegisterUserDTO;
import br.com.zup.jwt_management.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/admin")
    public Map<String, String> admin() {
        return Map.of("message", "Bem-vindo, administrador!");
    }

    @GetMapping("user")
    public Map<String, String> user(Authentication authentication) {
        Claims claims = (Claims) authentication.getDetails();
        String department = claims.get("department", String.class);
        return Map.of(
                "message", "Bem-vindo, " + authentication.getName() + "!",
                "department", department
        );
    }
}
