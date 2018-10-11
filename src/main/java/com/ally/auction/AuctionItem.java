package com.ally.auction;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Data

public class AuctionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double currentBid;
    private double reservePrice;
    @OneToOne(cascade=CascadeType.PERSIST)
    private Item item;
}
