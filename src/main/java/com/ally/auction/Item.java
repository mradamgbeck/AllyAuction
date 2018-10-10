package com.ally.auction;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Builder
@Getter
public class Item {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private final long id;
    private final String description;

    public Item(long id, String description) {
        this.id = id;
        this.description = description;
    }
}
