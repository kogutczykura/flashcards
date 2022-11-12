package com.flash.users.service;

import com.flash.users.mapper.UserMapper;
import com.flash.users.entity.User;
import com.flash.users.model.UserDTO;
import com.flash.users.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return UserMapper.toDtoUsers(allUsers);
    }

    public UserDTO getUser(long id) {
        User user = userRepository.getReferenceById(id);
        return UserMapper.toDTO(user);
    }
}
