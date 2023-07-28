package com.flash.flashcardsGroup.service;

import com.flash.flashcardsGroup.mapper.FlashCardGroupMapper;
import com.flash.flashcardsGroup.model.FlashCardsGroupDTO;
import com.flash.flashcards.repo.FlashCardRepository;
import com.flash.flashcardsGroup.entity.FlashCardsGroup;
import com.flash.flashcardsGroup.repo.FlashCardsGroupRepo;
import com.flash.users.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.flash.users.mapper.UserMapper.fromDto;
import static com.flash.users.mapper.UserMapper.fromDtoList;

@Service
@Log4j2
@RequiredArgsConstructor
public class FlashCardsGroupService {
    private final FlashCardsGroupRepo flashCardsGroupRepo;
    private final FlashCardRepository flashCardRepository;

    public FlashCardsGroupDTO getFlashCardsGroup(Long id) {
        FlashCardsGroup flashCardsGroup = flashCardsGroupRepo.getById(id);
        return FlashCardGroupMapper.toDto(flashCardsGroup);
    }
    @Transactional
    public List<FlashCardsGroupDTO> getFlashCardGroups() {
        List<FlashCardsGroup> flashCardList = flashCardsGroupRepo.findAll();
        return FlashCardGroupMapper.toDtoList(flashCardList);
    }

    public FlashCardsGroup get(Long id) {
        return flashCardsGroupRepo.getById(id);
    }

    public FlashCardsGroup addOrUpdate(FlashCardsGroupDTO flashCardsGroupDTO) {
        FlashCardsGroup flashCardsGroup = new FlashCardsGroup();
        if(flashCardsGroup.getId() != null) {
            flashCardsGroup = this.get(flashCardsGroupDTO.getId());
        }

        flashCardsGroup.setUsers((List<User>) fromDto(flashCardsGroupDTO.getUserDTO()));
       // flashCardsGroup.setFlashCardList(flashCardsGroupDTO.getFlashCardDTOS());
        flashCardsGroup = flashCardsGroupRepo.save(flashCardsGroup);
        return flashCardsGroup;
    }
}
