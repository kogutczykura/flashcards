package com.flash.flashcardsGroup.model;

import com.flash.flashcards.model.FlashCardDTO;
import com.flash.users.model.UserDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlashCardsGroupDTO {
    private Long id;
    private List<FlashCardDTO> flashCardDTOS;
    private UserDTO userDTO;
    private Long pointsScored;
    private Long allPoints;
}
