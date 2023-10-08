package se331.lab10auction.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import se331.lab10auction.dao.AuctionItemDao;
import se331.lab10auction.entity.AuctionItem;


@Service
@RequiredArgsConstructor
public class AuctionItemServiceImpl implements AuctionItemService{
    final AuctionItemDao AuctionItemDao;
    @Override
    public Integer getAuctionItemSize() {
        return AuctionItemDao.getAuctionItemSize();
    }
    
    @Override
    public Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page) {
        return AuctionItemDao.getAuctionItems(pageSize, page);
    }

    @Override
    public AuctionItem getAuctionItem(Long id) {
        return AuctionItemDao.getAuctionItem(id);
    }

    @Override
    @Transactional
    public AuctionItem save(AuctionItem AuctionItem) {
        // Organizer organizer = organizerDao.findById(AuctionItem.getOrganizer().getId()).orElse(null);
        // AuctionItem.setOrganizer(organizer);
        // organizer.getOwnAuctionItems().add(AuctionItem);
        return AuctionItemDao.save(AuctionItem);
    }

    @Override
    public Page<AuctionItem> getAuctionItems(String title, Pageable pageable) {
        return AuctionItemDao.getAuctionItems(title,pageable);
    }

}