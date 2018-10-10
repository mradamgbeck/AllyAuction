package com.ally.auction;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Builder
public class Bid {

    @Getter
    @GeneratedValue(strategy= GenerationType.AUTO)
    private final long id;
    private final long auctionItemId;
    private final double maxAutoBidAmount;
    private final String bidderName;

    public Bid(long id, long auctionItemId, double maxAutoBidAmount, String bidderName) {
        this.id = id;
        this.auctionItemId = auctionItemId;
        this.maxAutoBidAmount = maxAutoBidAmount;
        this.bidderName = bidderName;
    }
}
