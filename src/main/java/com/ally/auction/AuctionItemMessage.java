package com.ally.auction;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

@Builder
@Data
@EqualsAndHashCode
public class AuctionItemMessage {
    private final Long id;
    private final double currentBid;
    private final double reservePrice;
    @OneToOne(cascade=CascadeType.PERSIST)
    private final Item item;
}
