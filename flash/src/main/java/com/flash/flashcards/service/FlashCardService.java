package com.flash.flashcards.service;

import com.flash.flashcards.entity.FlashCard;
import com.flash.flashcards.model.FlashCardDTO;
import com.flash.flashcards.repo.FlashCardRepository;
import com.flash.flashcardsGroup.entity.FlashCardsGroup;
import com.flash.flashcardsGroup.model.FlashCardsGroupDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

import static com.flash.flashcards.mapper.FlashCardMapper.toDto;

@Service
@RequiredArgsConstructor
public class FlashCardService {
    private final FlashCardRepository flashCardRepository;

    @Transactional
    public FlashCardDTO getFlashCard(long id) {
        FlashCard flashCard = flashCardRepository.getReferenceById(id);
        return toDto(flashCard);
    }

}
