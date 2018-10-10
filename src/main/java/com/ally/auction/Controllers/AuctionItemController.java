package com.ally.auction.Controllers;
import com.ally.auction.AuctionItem;
import com.ally.auction.Item;
import com.ally.auction.Repositories.AuctionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AuctionItemController {
    @Autowired
    private AuctionItemRepository repository;

    @RequestMapping(value="/auctionItems", method=RequestMethod.POST)
    public AuctionItem saveAuctionItem(@RequestBody AuctionItem item){
        return repository.save(item);
    }

    @RequestMapping(value="/auctionItems", method=RequestMethod.GET)
    public Iterable<AuctionItem> getAuctionItems() {
        return repository.findAll();
    }
}
