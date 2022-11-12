package com.flash.flashcardsGroup.service;

import com.flash.flashcardsGroup.mapper.FlashCardGroupMapper;
import com.flash.flashcardsGroup.model.FlashCardsGroupDTO;
import com.flash.flashcards.repo.FlashCardRepository;
import com.flash.flashcardsGroup.entity.FlashCardsGroup;
import com.flash.flashcardsGroup.repo.FlashCardsGroupRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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


}
