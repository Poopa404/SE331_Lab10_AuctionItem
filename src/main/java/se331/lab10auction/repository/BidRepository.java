package se331.lab10auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import se331.lab10auction.entity.Bid;

public interface BidRepository extends JpaRepository<Bid,Long> {
    List<Bid> findAll();

}
