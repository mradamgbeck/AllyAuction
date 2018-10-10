package com.ally.auction.Services;

import com.ally.auction.AuctionItem;
import com.ally.auction.Repositories.AuctionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class AuctionItemService {
    @Autowired
    AuctionItemRepository auctionItemRepository;

    public long saveAuctionItem(@RequestBody AuctionItem item) {
        return auctionItemRepository.save(item).getId();
    }

    public Iterable<AuctionItem> getAuctionItems() {
        return auctionItemRepository.findAll();
    }

    public Optional<AuctionItem> getAuctionItem(@RequestParam(value = "id") long id) {
        return auctionItemRepository.findById(id);
    }
}
