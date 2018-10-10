package com.ally.auction;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@Entity
public class AuctionItem {

    @Getter
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private final long id;
    private final double currentBid;
    private final double reservePrice;
    private final Item item;

    public AuctionItem(long id, double currentBid, double reservePrice, Item item){
        this.id = id;
        this.currentBid = currentBid;
        this.reservePrice = reservePrice;
        this.item = item;
    }
}
