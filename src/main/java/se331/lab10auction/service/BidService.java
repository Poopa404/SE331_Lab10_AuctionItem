package se331.lab10auction.service;

import java.util.List;

import org.springframework.data.domain.Page;

import se331.lab10auction.entity.Bid;

public interface BidService {
    List<Bid> getAllBids();
    Page<Bid> getBid(Integer page, Integer pageSize);

}
