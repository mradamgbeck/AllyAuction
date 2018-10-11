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
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final long id;
    private final long auctionItemId;
    private final double maxAutoBidAmount;
    private final String bidderName;
}
