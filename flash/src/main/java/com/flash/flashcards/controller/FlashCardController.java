package com.flash.flashcards.controller;

import com.flash.flashcards.model.FlashCardDTO;
import com.flash.flashcards.service.FlashCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/flashcards")
public class FlashCardController {
    private final FlashCardService flashCardService;

    @GetMapping("/{id}")
    public FlashCardDTO getFlashCard(@PathVariable long id) {
        return flashCardService.getFlashCard(id);
    }
}
