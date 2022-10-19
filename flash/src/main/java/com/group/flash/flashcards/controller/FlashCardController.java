package com.group.flash.flashcards.controller;

import com.group.flash.flashcards.service.FlashCardService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlashCardController {
    private final FlashCardService flashCardService;

    public FlashCardController(FlashCardService flashCardService) {
        this.flashCardService = flashCardService;
    }
}
