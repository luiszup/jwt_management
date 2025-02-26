package br.com.zup.jwt_management.controller;

import br.com.zup.jwt_management.dtos.AuthResponseDTO;
import br.com.zup.jwt_management.dtos.LoginDTO;
import br.com.zup.jwt_management.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        String token = authService.login(loginDTO);

        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setAccessToken(token);

        return new ResponseEntity<>(authResponseDTO, HttpStatus.OK);
    }
}
