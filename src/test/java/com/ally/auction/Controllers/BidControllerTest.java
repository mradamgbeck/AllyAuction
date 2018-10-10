package com.ally.auction.Controllers;

import com.ally.auction.Bid;
import com.ally.auction.Services.BidService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BidControllerTest {

    @Mock
    BidService bidService;
    @InjectMocks
    BidController bidController;
    Bid bidToSave;

    @Before
    public void setup() {
        long auctionItemId = 123L;
        bidToSave = Bid.builder()
                .auctionItemId(auctionItemId)
                .bidderName("Bidder McBidderson")
                .maxAutoBidAmount(123.05)
                .build();
    }

    @Test
    public void makeBidCallsMakeBidOnBidService() {
        bidController.makeBid(bidToSave);
        verify(bidService).makeBid(bidToSave);
    }
}
