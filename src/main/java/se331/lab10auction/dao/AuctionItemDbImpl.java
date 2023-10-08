package se331.lab10auction.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import se331.lab10auction.repository.AuctionItemRepository;
import se331.lab10auction.entity.AuctionItem;


@Repository
@RequiredArgsConstructor
@Profile("db")
public class AuctionItemDbImpl implements AuctionItemDao{
    final AuctionItemRepository auctionItemRepository;
    @Override
    public Integer getAuctionItemSize() {
        return Math.toIntExact(auctionItemRepository.count());
    }

    @Override
    public Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page) {
        return auctionItemRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public AuctionItem getAuctionItem(Long id) {
        return auctionItemRepository.findById(id).orElse(null);
    }

    @Override
    public AuctionItem save(AuctionItem auctionItem) {
        return auctionItemRepository.save(auctionItem);
    }

    @Override
    public Page<AuctionItem> getAuctionItems(String title, Pageable page) {
        try{
            return auctionItemRepository.findByDescriptionIgnoreCaseContainingOrTypeIgnoreCaseContainingOrSuccessfulBidAmountLessThan(title,title,Long.parseLong(title),page);
        }catch (NumberFormatException e) {
            return auctionItemRepository.findByDescriptionIgnoreCaseContainingOrTypeIgnoreCaseContaining(title,title,page);
        }
    }

}
