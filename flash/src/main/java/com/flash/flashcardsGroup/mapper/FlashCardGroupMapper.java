package com.flash.flashcardsGroup.mapper;

import com.flash.flashcards.mapper.FlashCardMapper;
import com.flash.flashcardsGroup.model.FlashCardsGroupDTO;
import com.flash.users.mapper.UserMapper;
import com.flash.flashcardsGroup.entity.FlashCardsGroup;
import com.flash.users.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class FlashCardGroupMapper {
    public static FlashCardsGroupDTO toDto(FlashCardsGroup flashCardsGroup) {
        FlashCardsGroupDTO flashCardsGroupDTO = new FlashCardsGroupDTO();
        flashCardsGroupDTO.setId(flashCardsGroup.getId());
        flashCardsGroupDTO.setFlashCardDTOS(FlashCardMapper.toDtoList(flashCardsGroup.getFlashCardList()));
        flashCardsGroupDTO.setUserDTO((UserDTO) UserMapper.toDtoUsers(flashCardsGroup.getUsers()));
        return flashCardsGroupDTO;
    }

    public static FlashCardsGroup fromDto(FlashCardsGroupDTO flashCardsGroupDTO) {
        FlashCardsGroup flashCardsGroup = new FlashCardsGroup();
        flashCardsGroup.setId(flashCardsGroupDTO.getId());
//        flashCardsGroup.setFlashCardList(flashCardsGroupDTO.getFlashCardDTOS());
//        flashCardsGroup.setUsers(flashCardsGroupDTO.getUserDTO());
        return flashCardsGroup;
    }

    public static List<FlashCardsGroupDTO> toDtoList(List<FlashCardsGroup> flashCardList) {
        return flashCardList.stream().map(FlashCardGroupMapper::toDto).toList();
    }
}
