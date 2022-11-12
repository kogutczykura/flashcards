package com.flash.flashcards.mapper;

import com.flash.flashcards.entity.FlashCard;
import com.flash.flashcards.model.FlashCardDTO;

import java.util.ArrayList;
import java.util.List;

public class FlashCardMapper {
    public static FlashCardDTO toDto(FlashCard flashCard) {
        FlashCardDTO flashCardDTO = new FlashCardDTO();
        flashCardDTO.setId(flashCard.getId());
        flashCardDTO.setKnown(flashCard.isKnown());
        flashCardDTO.setWord(flashCard.getWord());
        flashCardDTO.setPronunciation(flashCard.getPronunciation());
        flashCardDTO.setPictureURL(flashCard.getPictureURL());
        flashCardDTO.setTranslatedWord(flashCard.getTranslatedWord());
        return flashCardDTO;
    }

    public static List<FlashCardDTO> toDtoList(List<FlashCard> flashCardList) {
        List<FlashCardDTO> flashCardDTOS = new ArrayList<>();
        flashCardList.forEach(flashCard -> {
            flashCardDTOS.add(toDto(flashCard));
        });
        return flashCardDTOS;
    }
}
