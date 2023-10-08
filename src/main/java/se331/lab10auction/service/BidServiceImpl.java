package se331.lab10auction.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import se331.lab10auction.dao.BidDao;
import se331.lab10auction.entity.Bid;

@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService{
    final BidDao bidDao;
    @Override
    public List<Bid> getAllBids() {
        return bidDao.getBid(Pageable.unpaged()).getContent();
    }

    @Override
    public Page<Bid> getBid(Integer page, Integer pageSize) {
        return bidDao.getBid(PageRequest.of(page,pageSize));
    }
}

