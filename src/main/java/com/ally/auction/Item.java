package com.ally.auction;

import lombok.Builder;
import lombok.Getter;

public class Item {

    @Getter
    private final long id;
    private final String description;

    @Builder
    public Item(long id, String description){
        this.id = id;
        this.description = description;
    }
}
