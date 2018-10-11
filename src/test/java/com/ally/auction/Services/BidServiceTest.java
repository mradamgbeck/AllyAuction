package com.ally.auction.Services;

import com.ally.auction.Bid;
import com.ally.auction.Repositories.BidRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BidServiceTest {

    @Mock
    BidRepository bidRepository;
    @InjectMocks
    BidService bidService;
    private String bidderName;
    private long auctionItemId;

    @Before
    public void setup() {
        bidderName = "Biddy McBidderson";
        auctionItemId = 123L;
    }

    @Test
    public void makeBidCallsSaveOnRepository() {
        Bid bidToMake = Bid.builder()
                .build();
        Bid bidReturnedFromRepo = Bid.builder()
                .id(1L)
                .build();
        when(bidRepository.save(bidToMake)).thenReturn(bidReturnedFromRepo);
        long savedBidId = bidService.makeBid(bidToMake);
        assertSame(bidReturnedFromRepo.getId(), savedBidId);
    }

    @Test
    public void makeBidSetsCurrentBidOfAuctionItemToMaxOfCurrentBidOrAutoBidAmount_IfReservePriceHasNotBeenMet(){

    }
}