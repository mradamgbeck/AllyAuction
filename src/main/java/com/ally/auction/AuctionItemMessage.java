package com.ally.auction;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

@Builder
@Getter
@EqualsAndHashCode
public class AuctionItemMessage {

    private final long id;
    private final double currentBid;
    private final double reservePrice;
    @OneToOne(cascade=CascadeType.PERSIST)
    private final Item item;

    public AuctionItemMessage(long id, double currentBid, double reservePrice, Item item) {
        this.id = id;
        this.currentBid = currentBid;
        this.reservePrice = reservePrice;
        this.item = item;
    }
}
