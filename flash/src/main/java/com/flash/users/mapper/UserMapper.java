package com.flash.users.mapper;

import com.flash.users.entity.User;
import com.flash.users.model.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        allUsers.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
        return userDTOS;
    }

    public static User fromDto(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setMail(userDTO.getMail());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setFlashCardsGroup(userDTO.getFlashCardsGroup());
        return user;
    }

    public static List<User> fromDtoList(List<UserDTO> userDTOS) {
        return userDTOS.stream().map(UserMapper::fromDto).toList();
    }
}
