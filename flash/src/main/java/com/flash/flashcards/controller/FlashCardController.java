package com.flash.flashcards.controller;

import com.flash.flashcards.model.FlashCardDTO;
import com.flash.flashcards.service.FlashCardService;
import com.flash.flashcardsGroup.service.FlashCardsGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/flashcards")
public class FlashCardController {
    private final FlashCardService flashCardService;
    private final FlashCardsGroupService flashCardsGroupService;

    @GetMapping("/{id}")
    public String getFlashCard(@PathVariable long id, Model model) {
        model.addAttribute("flashCard", flashCardService.getFlashCard(id));
        return "";
    }

    @PostMapping
    public String create(Model model, FlashCardDTO flashCardDTO) {
        model.addAttribute("flashCardGroup", flashCardsGroupService.getFlashCardsGroup(flashCardDTO.getFlashCardsGroup().getId()));
        return "";
    }
}
