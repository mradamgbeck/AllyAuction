package com.ally.auction.Controllers;

import com.ally.auction.AuctionItem;
import com.ally.auction.AuctionItemMessage;
import com.ally.auction.Item;
import com.ally.auction.Services.AuctionItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuctionItemControllerTest {

    @Mock
    AuctionItemService auctionItemService;
    @InjectMocks
    AuctionItemController auctionItemController;
    double reservePrice;
    Item itemToSave;
    AuctionItemMessage auctionItemToSave;
    AuctionItemMessage returnedAuctionItem;

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
        returnedAuctionItem = AuctionItemMessage.builder()
                .id(2L)
                .currentBid(0.00)
                .reservePrice(reservePrice)
                .item(itemToSave)
                .build();
    }

    @Test
    public void postAuctionItemSavesInRepository() {
        when(auctionItemService.saveAuctionItem(auctionItemToSave)).thenReturn(returnedAuctionItem.getId());
        long savedItemId = auctionItemController.saveAuctionItem(auctionItemToSave);
        assertSame(returnedAuctionItem.getId(), savedItemId);
    }

    @Test
    public void getAuctionItemsCallsFindAllOnRepository() {
        ArrayList<AuctionItemMessage> returnedList = new ArrayList<>();
        returnedList.add(returnedAuctionItem);
        when(auctionItemService.getAuctionItems()).thenReturn(returnedList);
        ArrayList<AuctionItemMessage> auctionItems = auctionItemController.getAuctionItems();
        assertSame(returnedAuctionItem, auctionItems.iterator().next());
    }

    @Test
    public void getAuctionItemCallsFindOneOnRepository() {
        when(auctionItemService.getAuctionItem(returnedAuctionItem.getId())).thenReturn(returnedAuctionItem);
        AuctionItemMessage auctionItemFromRepo = auctionItemController.getAuctionItem(returnedAuctionItem.getId());
        assertSame(returnedAuctionItem, auctionItemFromRepo);
    }
}
