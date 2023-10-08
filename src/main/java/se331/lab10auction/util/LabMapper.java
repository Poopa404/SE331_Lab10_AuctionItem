package se331.lab10auction.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import se331.lab10auction.entity.AuctionItem;
import se331.lab10auction.entity.AuctionItemDTO;
import se331.lab10auction.entity.Bid;
import se331.lab10auction.entity.BidDTO;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    AuctionItemDTO getAuctionItemDTO(AuctionItem event);
    List<AuctionItemDTO> getAuctionItemDTOs(List<AuctionItem> events);
    BidDTO getBidDTO(Bid organizer);
    List<BidDTO> getBidDTOs(List<Bid> organizers);

}
