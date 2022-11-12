package com.flash.users.mapper;

import com.flash.users.entity.User;
import com.flash.users.model.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {
    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setMail(user.getMail());
        return userDTO;
    }

    public static List<UserDTO> toDtoUsers(List<User> allUsers) {
        List<UserDTO> userDTOS = new ArrayList<>();
        allUsers.forEach(user -> {
            userDTOS.add(toDTO(user));
        });
        return userDTOS;
    }
}
