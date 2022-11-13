package com.flash.users.entity;

import com.flash.flashcardsGroup.entity.FlashCardsGroup;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String mail;
    private Long createdDate;
    private Long lastUpdatedDate;
    private Long createdBy;
    @Fetch(value = FetchMode.SUBSELECT)
    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FlashCardsGroup> flashCardsGroup = new ArrayList<>();
}
