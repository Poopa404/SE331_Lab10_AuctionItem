package se331.lab10auction.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.lab10auction.entity.AuctionItem;

public interface AuctionItemService {
    Integer getAuctionItemSize();
    Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page);
    AuctionItem getAuctionItem(Long id);
    AuctionItem save(AuctionItem AuctionItem);
    Page<AuctionItem> getAuctionItems(String title, Pageable pageable);
}
