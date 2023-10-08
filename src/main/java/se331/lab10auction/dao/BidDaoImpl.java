package se331.lab10auction.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import se331.lab10auction.entity.Bid;
import se331.lab10auction.repository.BidRepository;

@Repository
@RequiredArgsConstructor
public class BidDaoImpl implements BidDao {
    final BidRepository organizerRepository;
    @Override
    public Page<Bid> getBid(Pageable pageRequest) {
        return organizerRepository.findAll(pageRequest);
    }
    @Override
    public Optional<Bid> findById(Long id) {
        return organizerRepository.findById(id);
    }

}
