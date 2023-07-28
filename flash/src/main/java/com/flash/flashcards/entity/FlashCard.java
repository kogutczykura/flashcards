package com.flash.flashcards.entity;

import com.flash.flashcardsGroup.entity.FlashCardsGroup;
import com.flash.general.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FlashCard extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String word;
    private String translatedWord;
    private String pronunciation;
    private boolean known;
    private String pictureURL;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Language fromLanguage;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Language toLanguage;
    @ManyToOne
    private FlashCardsGroup flashCardsGroup;
}
