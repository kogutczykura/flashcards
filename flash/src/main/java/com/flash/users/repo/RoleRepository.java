package com.flash.users.repo;

import com.flash.users.entity.Role;
import com.flash.users.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRole(RoleType roleType);
}
