package com.group.flash.flashcards.repo;

import com.group.flash.flashcards.entity.FlashCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashCardRepository extends JpaRepository<FlashCard, Long> {
}
