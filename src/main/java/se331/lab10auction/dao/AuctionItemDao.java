package se331.lab10auction.dao;

import se331.lab10auction.entity.AuctionItem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuctionItemDao {
    Integer getAuctionItemSize();
    Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page);
    AuctionItem getAuctionItem(Long id);
    AuctionItem save(AuctionItem auctionItem);
    Page<AuctionItem> getAuctionItems(String name, Pageable page);
}
