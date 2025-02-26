package br.com.zup.jwt_management.service;

import br.com.zup.jwt_management.dtos.RegisterUserDTO;
import br.com.zup.jwt_management.model.User;
import br.com.zup.jwt_management.model.Role;
import br.com.zup.jwt_management.repository.RoleRepository;
import br.com.zup.jwt_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void registerUser(RegisterUserDTO registerUserDTO) {
        if (userRepository.existsByUsername(registerUserDTO.getUsername())){
            throw new RuntimeException("Unprocess entity");
        }

        User user = new User();
        user.setUsername(registerUserDTO.getUsername());
        user.setEmail(registerUserDTO.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(registerUserDTO.getPassword()));
        user.setName(registerUserDTO.getName());

        Set<Role> roles = registerUserDTO.getRoles().stream()
                .map(r -> new Role(r.name()))
                .collect(Collectors.toSet());
        roleRepository.saveAll(roles);

        user.setRoles(roles);
        userRepository.save(user);
    }
}
