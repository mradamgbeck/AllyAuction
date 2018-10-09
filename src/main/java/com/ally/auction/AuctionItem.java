package com.ally.auction;

import lombok.Builder;
import lombok.Getter;

public class AuctionItem {

    @Getter
    private final long id;
    private final double currentBid;
    private final double reservePrice;
    private final Item item;

    @Builder
    public AuctionItem(long id, double currentBid, double reservePrice, Item item){
        this.id = id;
        this.currentBid = currentBid;
        this.reservePrice = reservePrice;
        this.item = item;
    }
}
