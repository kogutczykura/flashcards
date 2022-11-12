package com.flash.flashcardsGroup.controller;

import com.flash.flashcardsGroup.model.FlashCardsGroupDTO;
import com.flash.flashcardsGroup.service.FlashCardsGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/flashcards/groups")
public class FlashCardsGroupController {
    private final FlashCardsGroupService flashCardsGroupService;

    @GetMapping("/{id}")
    public FlashCardsGroupDTO getFlashCardsGroup(@PathVariable long id) {
        return flashCardsGroupService.getFlashCardsGroup(id);
    }
}
