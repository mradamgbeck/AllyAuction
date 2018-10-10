package com.ally.auction.Controllers;

import com.ally.auction.Bid;
import com.ally.auction.Services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BidController {
    @Autowired
    private BidService bidService;

    @RequestMapping(value = "/bids", method = RequestMethod.POST)
    public long makeBid(@RequestBody Bid bid) {
        return bidService.makeBid(bid);
    }
}
