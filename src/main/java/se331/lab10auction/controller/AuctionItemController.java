package se331.lab10auction.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import se331.lab10auction.entity.AuctionItem;
import se331.lab10auction.service.AuctionItemService;
import se331.lab10auction.util.LabMapper;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AuctionItemController {
    List<AuctionItem> auctionItemList;
    final AuctionItemService auctionItemService;
    @GetMapping("auction_items")
    public ResponseEntity<?> getAuctionItemLists(@RequestParam(value ="_limit", required = false) Integer perPage,
                                            @RequestParam(value = "_page", required = false) Integer page,
                                            @RequestParam(value = "title", required = false) String title) {
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<AuctionItem> pageOutput;
        if (title == null) {
            pageOutput = auctionItemService.getAuctionItems(perPage,page);
        }else{
            pageOutput = auctionItemService.getAuctionItems(title,PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getAuctionItemDTOs(pageOutput.getContent()),responseHeader,HttpStatus.OK);

    }

    @GetMapping("auction_items/{id}")
    public ResponseEntity<?> getAuctionItem(@PathVariable("id") Long id) {
        AuctionItem output = auctionItemService.getAuctionItem(id);
        if (output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getAuctionItemDTO(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/auction_items")
    public ResponseEntity<?> addAuctionItem(@RequestBody AuctionItem AuctionItem){
        AuctionItem output = auctionItemService.save(AuctionItem);
        return ResponseEntity.ok(LabMapper.INSTANCE.getAuctionItemDTO(output));
    }

}
