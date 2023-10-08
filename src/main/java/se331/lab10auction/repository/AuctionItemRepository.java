package se331.lab10auction.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import se331.lab10auction.entity.AuctionItem;

public interface AuctionItemRepository extends JpaRepository<AuctionItem,Long> {
    List<AuctionItem> findAll();
    Page<AuctionItem> findByDescriptionIgnoreCaseContainingOrTypeIgnoreCaseContaining(String description, String type, Pageable page);
    Page<AuctionItem> findByDescriptionIgnoreCaseContainingOrTypeIgnoreCaseContainingOrSuccessfulBidAmountLessThan(String description, String type, Long amount, Pageable page);

}
