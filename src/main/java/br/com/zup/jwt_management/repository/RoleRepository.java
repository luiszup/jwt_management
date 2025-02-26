package br.com.zup.jwt_management.repository;

import br.com.zup.jwt_management.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
