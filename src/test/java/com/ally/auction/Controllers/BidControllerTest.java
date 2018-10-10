package com.ally.auction.Controllers;

import com.ally.auction.Bid;
import com.ally.auction.Repositories.BidRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BidControllerTest {

    @Mock
    BidRepository bidRepository;
    @InjectMocks
    BidController bidController;
    Bid bidToSave;
    Bid returnedBid;

    @Before
    public void setup() {
        bidToSave = Bid.builder()
                .auctionItemId(123L)
                .bidderName("Bidder McBidderson")
                .maxAutoBidAmount(123.05)
                .build();
        returnedBid = Bid.builder()
                .auctionItemId(123L)
                .bidderName("Bidder McBidderson")
                .maxAutoBidAmount(123.05)
                .build();
    }

    @Test
    public void postBidSavesInRepository() {
        when(bidRepository.save(bidToSave)).thenReturn(returnedBid);
        long savedItemId = bidController.saveBid(bidToSave);
        assertSame(returnedBid.getId(), savedItemId);
    }

    @Test
    public void getBidsCallsFindAllOnRepository() {
        when(bidRepository.findAll()).thenReturn(Arrays.asList(returnedBid));
        Iterable<Bid> bidsFromRepo = bidController.getBids();
        assertSame(returnedBid, bidsFromRepo.iterator().next());
    }

    @Test
    public void getBidCallsFindOneOnRepository() {
        when(bidRepository.findById(returnedBid.getId())).thenReturn(Optional.of(returnedBid));
        Optional<Bid> bidFromRepo = bidController.getBid(returnedBid.getId());
        assertSame(returnedBid, bidFromRepo.get());
    }
}
