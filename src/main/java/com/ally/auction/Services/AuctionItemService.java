package com.ally.auction.Services;

import com.ally.auction.AuctionItem;
import com.ally.auction.AuctionItemMessage;
import com.ally.auction.Repositories.AuctionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class AuctionItemService {
    @Autowired
    private AuctionItemRepository auctionItemRepository;

    public long saveAuctionItem(@RequestBody AuctionItemMessage requestItem) {
        AuctionItem itemToSave = AuctionItem.builder()
                .currentBid(0.00)
                .reservePrice(requestItem.getReservePrice())
                .item(requestItem.getItem())
                .build();
        return auctionItemRepository.save(itemToSave).getId();
    }

    public ArrayList<AuctionItemMessage> getAuctionItems() {
        ArrayList<AuctionItemMessage> itemsToReturn = new ArrayList<>();
        Iterable<AuctionItem> auctionItemsFromRepo = auctionItemRepository.findAll();
        auctionItemsFromRepo.forEach(repoAuctionItem -> itemsToReturn.add(
                buildAuctionItemMessage(repoAuctionItem)
        ));
        return itemsToReturn;
    }

    public AuctionItemMessage getAuctionItem(@RequestParam(value = "itemId") long id) {
        AuctionItem itemFromRepo = auctionItemRepository.findById(id).get();
        AuctionItemMessage itemToReturn = buildAuctionItemMessage(itemFromRepo);
        return itemToReturn;
    }

    private AuctionItemMessage buildAuctionItemMessage(AuctionItem itemFromRepo) {
        return AuctionItemMessage.builder()
                .id(itemFromRepo.getId())
                .currentBid(itemFromRepo.getCurrentBid())
                .reservePrice(itemFromRepo.getReservePrice())
                .item(itemFromRepo.getItem())
                .build();
    }
}
