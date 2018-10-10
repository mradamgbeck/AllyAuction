package com.ally.auction.Controllers;

import com.ally.auction.AuctionItem;
import com.ally.auction.Repositories.AuctionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AuctionItemController {
    @Autowired
    private AuctionItemRepository repository;

    @RequestMapping(value = "/auctionItems", method = RequestMethod.POST)
    public long saveAuctionItem(@RequestBody AuctionItem item) {
        return repository.save(item).getId();
    }

    @RequestMapping(value = "/auctionItems", method = RequestMethod.GET)
    public Iterable<AuctionItem> getAuctionItems() {
        return repository.findAll();
    }

    @RequestMapping(value = "/auctionItems", method = RequestMethod.GET)
    public Optional<AuctionItem> getAuctionItem(@RequestParam(value = "id") long id) {
        return repository.findById(id);
    }
}
