package com.ally.auction.Services;

import com.ally.auction.Bid;
import com.ally.auction.Repositories.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BidService {
    @Autowired
    AuctionItemService auctionItemService;
    @Autowired
    BidRepository bidRepository;

    public long makeBid(Bid bidToSave) {
        return bidRepository.save(bidToSave).getId();
    }
}
