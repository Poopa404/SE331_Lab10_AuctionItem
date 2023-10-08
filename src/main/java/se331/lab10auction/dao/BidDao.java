package se331.lab10auction.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.lab10auction.entity.Bid;

public interface BidDao {
    Page<Bid> getBid(Pageable pageRequest);
    Optional<Bid> findById(Long id);
}
