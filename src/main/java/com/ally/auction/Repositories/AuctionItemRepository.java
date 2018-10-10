package com.ally.auction.Repositories;

import com.ally.auction.AuctionItem;
import org.springframework.data.repository.CrudRepository;

public interface AuctionItemRepository extends CrudRepository<AuctionItem, Long> {
}