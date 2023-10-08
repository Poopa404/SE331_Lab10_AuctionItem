package se331.lab10auction.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import se331.lab10auction.entity.AuctionItem;
import se331.lab10auction.entity.Bid;
import se331.lab10auction.repository.AuctionItemRepository;
import se331.lab10auction.repository.BidRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final AuctionItemRepository auctionItemRepository;
    final BidRepository bidRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        AuctionItem auc1, auc2, auc3, auc4, auc5;
        auc1 = auctionItemRepository.save(AuctionItem.builder()
            .description("a1")
            .type("type1")
            .build());
        auc2 = auctionItemRepository.save(AuctionItem.builder()
            .description("a2")
            .type("type1")
            .build());
        auc3 = auctionItemRepository.save(AuctionItem.builder()
            .description("a3")
            .type("type3")
            .build());
        auc4 = auctionItemRepository.save(AuctionItem.builder()
            .description("a4")
            .type("type2")
            .build());
        auc5 = auctionItemRepository.save(AuctionItem.builder()
            .description("a5")
            .type("type3")
            .build());

        Bid tempBid;
        //auc1
        tempBid = bidRepository.save(Bid.builder()
            .amount(582L)
            .dateTime("2022-01-15")
            .build());
        tempBid.setAuctionItem(auc1);
        auc1.getBids().add(tempBid);
        tempBid = bidRepository.save(Bid.builder()
            .amount(383L)
            .dateTime("2022-02-04")
            .build());
        tempBid.setAuctionItem(auc1);
        auc1.getBids().add(tempBid);
        tempBid = bidRepository.save(Bid.builder()
            .amount(920L)
            .dateTime("2022-05-03")
            .build());
        tempBid.setAuctionItem(auc1);
        auc1.getBids().add(tempBid);
        auc1.setSuccessfulBid(tempBid);
        
        //auc2
        tempBid = bidRepository.save(Bid.builder()
            .amount(828L)
            .dateTime("2022-11-20")
            .build());
        tempBid.setAuctionItem(auc2);
        auc2.getBids().add(tempBid);
        auc2.setSuccessfulBid(tempBid);
        tempBid = bidRepository.save(Bid.builder()
            .amount(571L)
            .dateTime("2022-12-24")
            .build());
        tempBid.setAuctionItem(auc2);
        auc2.getBids().add(tempBid);
        tempBid = bidRepository.save(Bid.builder()
            .amount(109L)
            .dateTime("2022-01-03")
            .build());
        tempBid.setAuctionItem(auc2);
        auc2.getBids().add(tempBid);

        //auc3
        tempBid = bidRepository.save(Bid.builder()
            .amount(407L)
            .dateTime("2023-05-01")
            .build());
        tempBid.setAuctionItem(auc3);
        auc3.getBids().add(tempBid);
        tempBid = bidRepository.save(Bid.builder()
            .amount(823L)
            .dateTime("2023-05-20")
            .build());
        tempBid.setAuctionItem(auc3);
        auc3.getBids().add(tempBid);
        auc3.setSuccessfulBid(tempBid);
        tempBid = bidRepository.save(Bid.builder()
            .amount(174L)
            .dateTime("2023-06-02")
            .build());
        tempBid.setAuctionItem(auc3);
        auc3.getBids().add(tempBid);

        //auc4
        tempBid = bidRepository.save(Bid.builder()
            .amount(542L)
            .dateTime("2023-06-12")
            .build());
        tempBid.setAuctionItem(auc4);
        auc4.getBids().add(tempBid);
        tempBid = bidRepository.save(Bid.builder()
            .amount(479L)
            .dateTime("2023-06-24")
            .build());
        tempBid.setAuctionItem(auc4);
        auc4.getBids().add(tempBid);
        tempBid = bidRepository.save(Bid.builder()
            .amount(341L)
            .dateTime("2023-07-14")
            .build());
        tempBid.setAuctionItem(auc4);
        auc4.getBids().add(tempBid);

        //auc5
        tempBid = bidRepository.save(Bid.builder()
            .amount(430L)
            .dateTime("2023-07-30")
            .build());
        tempBid.setAuctionItem(auc5);
        auc5.getBids().add(tempBid);
        tempBid = bidRepository.save(Bid.builder()
            .amount(884L)
            .dateTime("2023-09-13")
            .build());
        tempBid.setAuctionItem(auc5);
        auc5.getBids().add(tempBid);
        tempBid = bidRepository.save(Bid.builder()
            .amount(892L)
            .dateTime("2023-12-18")
            .build());
        tempBid.setAuctionItem(auc5);
        auc5.getBids().add(tempBid);
    }

}

