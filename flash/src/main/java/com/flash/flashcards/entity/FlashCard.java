package com.flash.flashcards.entity;

import com.flash.flashcardsGroup.entity.FlashCardsGroup;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FlashCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
