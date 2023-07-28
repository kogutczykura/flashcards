package com.flash.flashcardsGroup.repo;

import com.flash.flashcardsGroup.entity.FlashCardsGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlashCardsGroupRepo extends JpaRepository<FlashCardsGroup, Long> {
}
