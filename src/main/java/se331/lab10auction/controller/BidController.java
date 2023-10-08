package se331.lab10auction.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import se331.lab10auction.service.BidService;
import se331.lab10auction.util.LabMapper;

@RestController
@RequiredArgsConstructor
public class BidController {
    final BidService bidService;
    @GetMapping("/bids")
    ResponseEntity<?> getBids(){
        return ResponseEntity.ok(LabMapper.INSTANCE.getBidDTOs(bidService.getAllBids()));
    }
}
