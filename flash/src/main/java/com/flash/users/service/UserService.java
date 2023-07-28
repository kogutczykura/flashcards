package com.flash.users.service;

import com.flash.users.entity.Role;
import com.flash.users.entity.RoleType;
import com.flash.users.mapper.UserMapper;
import com.flash.users.entity.User;
import com.flash.users.model.UserDTO;
import com.flash.users.repo.RoleRepository;
import com.flash.users.repo.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<UserDTO> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return UserMapper.toDtoUsers(allUsers);
    }

    public UserDTO getUser(long id) {
        User user = userRepository.getReferenceById(id);
        return UserMapper.toDTO(user);
    }
    public boolean isInRole(RoleType roleType) {
        return getUserRoles().stream()
                .map(Role::getRole)
                .anyMatch(role -> role == roleType);
    }
    public List<Role> getUserRoles() {
        return userRepository.findByMail(getUser().getMail()).getRoles();
    }

    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return userRepository.findByMail(authentication.getName());
    }
}
