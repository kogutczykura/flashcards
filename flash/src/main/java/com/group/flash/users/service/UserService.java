package com.group.flash.users.service;

import com.group.flash.users.entity.User;
import com.group.flash.users.model.UserDTO;
import com.group.flash.users.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private List<UserDTO> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.
    }
}
