package com.flash.flashcardsGroup.controller;

import com.flash.flashcardsGroup.entity.FlashCardsGroup;
import com.flash.flashcardsGroup.model.FlashCardsGroupDTO;
import com.flash.flashcardsGroup.service.FlashCardsGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/flashcards/groups")
public class FlashCardsGroupController {
    private final FlashCardsGroupService flashCardsGroupService;

    @GetMapping("/{id}")
    public String getFlashCardsGroup(Model model, @PathVariable long id) {
        model.addAttribute("flashCardGroup", flashCardsGroupService.getFlashCardsGroup(id));
        return "group/group";
    }

    @GetMapping
    public String getFlashCardGroup(Model model) {
        model.addAttribute("flashCardGroups", flashCardsGroupService.getFlashCardGroups());
        return "group/groups";
    }

    @PostMapping
    public String create(Model model, @ModelAttribute FlashCardsGroupDTO flashCardsGroupDTO) {
        FlashCardsGroup flashCardsGroup;
        flashCardsGroup = flashCardsGroupService.addOrUpdate(flashCardsGroupDTO);
        model.addAttribute("flashCardGroup", flashCardsGroup);
        return "group/groups";
    }
}
