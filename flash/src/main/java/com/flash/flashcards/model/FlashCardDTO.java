package com.flash.flashcards.model;

import lombok.*;

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
}
