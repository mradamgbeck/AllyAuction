package com.ally.auction;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@Data
public class Item {
    @Id
    private final String itemId;
    private final String description;
}
