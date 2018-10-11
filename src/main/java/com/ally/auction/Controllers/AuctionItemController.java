package com.ally.auction.Controllers;

import com.ally.auction.AuctionItem;
import com.ally.auction.AuctionItemMessage;
import com.ally.auction.Services.AuctionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class AuctionItemController {
    @Autowired
    private AuctionItemService auctionItemService;

    @RequestMapping(value = "/auctionItems", method = RequestMethod.POST, consumes = "application/json")
    public long saveAuctionItem(@RequestBody AuctionItemMessage item) {
        return auctionItemService.saveAuctionItem(item);
    }

    @RequestMapping(value = "/auctionItems", method = RequestMethod.GET)
    public ArrayList<AuctionItemMessage> getAuctionItems() {
        return auctionItemService.getAuctionItems();
    }

    @RequestMapping(value = "/auctionItems/{itemId}", method = RequestMethod.GET)
    public AuctionItemMessage getAuctionItem(@PathVariable(value = "itemId") Long id) {
        return auctionItemService.getAuctionItem(id);
    }
}
