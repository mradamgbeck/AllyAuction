package com.ally.auction.Controllers;

import com.ally.auction.AuctionItem;
import com.ally.auction.Item;
import com.ally.auction.Repositories.AuctionItemRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuctionItemControllerTest {

    @Mock
    AuctionItemRepository auctionItemRepository;
    @InjectMocks
    AuctionItemController auctionItemController;
    double reservePrice;
    Item itemToSave;
    AuctionItem auctionItemToSave;
    AuctionItem returnedAuctionItem;

    @Before
    public void setup(){
        reservePrice = 2.00;
        itemToSave = Item.builder()
                .id(1L)
                .description("Something to auction")
                .build();
        auctionItemToSave = AuctionItem.builder()
                .reservePrice(reservePrice)
                .item(itemToSave)
                .build();
        returnedAuctionItem = AuctionItem.builder()
                .id(2L)
                .currentBid(0.00)
                .reservePrice(reservePrice)
                .item(itemToSave)
                .build();
    }

    @Test
    public void postAuctionItemSavesInRepository() {
        when(auctionItemRepository.save(auctionItemToSave)).thenReturn(returnedAuctionItem);
        AuctionItem savedItem = auctionItemController.saveAuctionItem(auctionItemToSave);
        assertSame(returnedAuctionItem, savedItem);
    }

    @Test
    public void getAuctionItemsCallsFindAllOnRepository(){
        when(auctionItemRepository.findAll()).thenReturn(Arrays.asList(returnedAuctionItem));
        Iterable<AuctionItem> auctionItems = auctionItemController.getAuctionItems();
        assertSame(auctionItems.iterator().next(), returnedAuctionItem);
    }
}