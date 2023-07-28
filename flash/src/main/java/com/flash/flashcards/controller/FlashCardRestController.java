package com.flash.flashcards.controller;

import com.flash.flashcards.model.FlashCardDTO;
import com.flash.flashcards.service.FlashCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/flashcards")
public class FlashCardRestController {
    private final FlashCardService flashCardService;

    @GetMapping("/{id}")
    public FlashCardDTO getFlashCard(@PathVariable long id) {
        return flashCardService.getFlashCard(id);
    }

}
