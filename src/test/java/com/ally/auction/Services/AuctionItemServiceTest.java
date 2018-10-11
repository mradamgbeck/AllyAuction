package com.ally.auction.Services;

import com.ally.auction.AuctionItem;
import com.ally.auction.AuctionItemMessage;
import com.ally.auction.Item;
import com.ally.auction.Repositories.AuctionItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuctionItemServiceTest {

    @Mock
    AuctionItemRepository auctionItemRepository;
    @InjectMocks
    AuctionItemService auctionItemService;
    double reservePrice;
    Item itemToSave;
    AuctionItemMessage auctionItemToSave;
    AuctionItemMessage expectedAuctionItemReturnedFromService;
    AuctionItem auctionItemReturnedByRepo;
    AuctionItem auctionItemBuiltByService;

    @Before
    public void setup() {
        reservePrice = 2.00;
        itemToSave = Item.builder()
                .itemId("asdf")
                .description("Something to auction")
                .build();
        auctionItemToSave = AuctionItemMessage.builder()
                .reservePrice(reservePrice)
                .item(itemToSave)
                .build();
        auctionItemBuiltByService = AuctionItem.builder()
                .currentBid(0.00)
                .reservePrice(reservePrice)
                .item(itemToSave)
                .build();
        auctionItemReturnedByRepo = AuctionItem.builder()
                .id(2L)
                .currentBid(0.00)
                .reservePrice(reservePrice)
                .item(itemToSave)
                .build();
        expectedAuctionItemReturnedFromService = AuctionItemMessage.builder()
                .id(2L)
                .currentBid(0.00)
                .reservePrice(reservePrice)
                .item(itemToSave)
                .build();
    }

    @Test
    public void saveSavesInRepository() {
        when(auctionItemRepository.save(auctionItemBuiltByService)).thenReturn(auctionItemReturnedByRepo);
        long savedItemId = auctionItemService.saveAuctionItem(auctionItemToSave);
        assertSame(expectedAuctionItemReturnedFromService.getId(), savedItemId);
    }

    @Test
    public void getAuctionItemsCallsFindAllOnRepository() {
        when(auctionItemRepository.findAll()).thenReturn(Arrays.asList(auctionItemReturnedByRepo));
        ArrayList<AuctionItemMessage> auctionItems = auctionItemService.getAuctionItems();
        assertEquals(expectedAuctionItemReturnedFromService, auctionItems.get(0));
    }

    @Test
    public void getAuctionItemCallsFindOneOnRepository() {
        when(auctionItemRepository.findById(auctionItemReturnedByRepo.getId())).thenReturn(Optional.of(auctionItemReturnedByRepo));
        AuctionItemMessage auctionItemFromRepo = auctionItemService.getAuctionItem(auctionItemReturnedByRepo.getId());
        assertEquals(expectedAuctionItemReturnedFromService, auctionItemFromRepo);
    }
}
