package com.flash.flashcards.model;

import com.flash.flashcards.entity.Language;
import com.flash.flashcardsGroup.entity.FlashCardsGroup;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlashCardDTO {
    private Long id;
    private String word;
    private String translatedWord;
    private String pronunciation;
    private boolean known;
    private String pictureURL;
    private Language fromLanguage;
    private Language toLanguage;
    @ManyToOne
    private FlashCardsGroup flashCardsGroup;
}
