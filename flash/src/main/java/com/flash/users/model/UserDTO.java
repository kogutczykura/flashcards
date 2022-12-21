package com.flash.users.model;

import com.flash.flashcardsGroup.entity.FlashCardsGroup;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String mail;
    private List<FlashCardsGroup> flashCardsGroup = new ArrayList<>();
}
