package com.flash.users.controller;

import com.flash.users.service.UserService;
import com.flash.users.model.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {
    private final UserService userService;

    @GetMapping("/{id}")
    public UserDTO getRestUserDto(@PathVariable long id) {
        return userService.getUser(id);
    }

    @GetMapping
    public List<UserDTO> getRestUsers() {
        return userService.getAllUsers();
    }
}
