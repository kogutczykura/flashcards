package com.flash;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flash.flashcards.controller.FlashCardRestController;
import com.flash.flashcards.entity.Language;
import com.flash.flashcards.mapper.FlashCardMapper;
import com.flash.flashcards.model.FlashCardDTO;
import com.flash.flashcards.repo.FlashCardRepository;
import com.flash.flashcardsGroup.entity.FlashCardsGroup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FlashCardRestController.class)
public class FlashControllerTest {
    @MockBean
    private FlashCardRepository flashCardRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FlashCardMapper flashCardMapper;

    @Autowired
    private ObjectMapper objectMapper;

    FlashCardsGroup flashCardsGroup = new FlashCardsGroup();

    @Test
    void shouldCreateFlashCard() throws Exception {
        FlashCardDTO flashCard = new FlashCardDTO(1L, "auto", "car", "kar", false, null, Language.POLISH, Language.ENGLISH, flashCardsGroup);
        mockMvc.perform(post("/flashcards").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(flashCard)))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
