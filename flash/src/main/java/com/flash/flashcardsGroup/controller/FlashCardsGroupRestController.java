package com.flash.flashcardsGroup.controller;

import com.flash.flashcardsGroup.model.FlashCardsGroupDTO;
import com.flash.flashcardsGroup.service.FlashCardsGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/flashcards/rest/groups")
public class FlashCardsGroupRestController {
    private final FlashCardsGroupService flashCardsGroupService;

    @GetMapping("/{id}")
    public FlashCardsGroupDTO getFlashCardsGroup(@PathVariable long id) {
        return flashCardsGroupService.getFlashCardsGroup(id);
    }

    @GetMapping
    public List<FlashCardsGroupDTO> getFlashCardGroup() {
        return flashCardsGroupService.getFlashCardGroups();
    }

}
