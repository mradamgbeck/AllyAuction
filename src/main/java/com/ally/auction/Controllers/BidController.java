package com.ally.auction.Controllers;

import com.ally.auction.Bid;
import com.ally.auction.Repositories.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BidController {
    @Autowired
    private BidRepository repository;

    @RequestMapping(value = "/bids", method = RequestMethod.POST)
    public long saveBid(@RequestBody Bid bid) {
        return repository.save(bid).getId();
    }

    @RequestMapping(value = "/bids", method = RequestMethod.GET)
    public Iterable<Bid> getBids() {
        return repository.findAll();
    }

    @RequestMapping(value = "/bids", method = RequestMethod.GET)
    public Optional<Bid> getBid(@RequestParam(value = "id") long id) {
        return repository.findById(id);
    }
}
