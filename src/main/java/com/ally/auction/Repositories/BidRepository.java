package com.ally.auction.Repositories;

import com.ally.auction.AuctionItem;
import com.ally.auction.Bid;
import org.springframework.data.repository.CrudRepository;

public interface BidRepository extends CrudRepository<Bid, Long> {
}