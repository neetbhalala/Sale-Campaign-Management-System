package com.example.Sale.Campaign.Project.Controller;

import com.example.Sale.Campaign.Project.Model.PriceHistory;
import com.example.Sale.Campaign.Project.Service.PriceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pricehistory")
public class PriceHistoryController {

    @Autowired
    private PriceHistoryService priceHistoryService;

    @PostMapping("/addpricehistory")
    private PriceHistory addpricehistory(@RequestBody PriceHistory ph) {
        return priceHistoryService.addpricehistory(ph);
    }

    @GetMapping("/getpricehistory")
    private List<PriceHistory> getpricehistory() {
        return priceHistoryService.getpricehistory();
    }
}
