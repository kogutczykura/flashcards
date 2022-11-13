package com.flash.flashcardsGroup.entity;

import com.flash.flashcards.entity.FlashCard;
import com.flash.general.entity.BaseEntity;
import com.flash.users.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class FlashCardsGroup extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long createdDate;
    private Long lastUpdatedDate;
    private Long createdBy;
    @OneToMany(mappedBy = "flashCardsGroup")
    private List<FlashCard> flashCardList;
    @ManyToMany
    private List<User> users = new ArrayList<>();
}
