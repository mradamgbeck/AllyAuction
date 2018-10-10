package com.ally.auction.Controllers;

import com.ally.auction.AuctionItem;
import com.ally.auction.Services.AuctionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AuctionItemController {
    @Autowired
    private AuctionItemService auctionItemService;

    @RequestMapping(value = "/auctionItems", method = RequestMethod.POST)
    public long saveAuctionItem(@RequestBody AuctionItem item) {
        return auctionItemService.saveAuctionItem(item);
    }

    @RequestMapping(value = "/auctionItems", method = RequestMethod.GET)
    public Iterable<AuctionItem> getAuctionItems() {
        return auctionItemService.getAuctionItems();
    }

    @RequestMapping(value = "/auctionItems", method = RequestMethod.GET)
    public Optional<AuctionItem> getAuctionItem(@RequestParam(value = "id") long id) {
        return auctionItemService.getAuctionItem(id);
    }
}
