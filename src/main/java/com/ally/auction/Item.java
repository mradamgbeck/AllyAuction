package com.ally.auction;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Builder
public class Item {

    @Getter
    @GeneratedValue(strategy= GenerationType.AUTO)
    private final long id;
    private final String description;

    public Item(long id, String description) {
        this.id = id;
        this.description = description;
    }
}
