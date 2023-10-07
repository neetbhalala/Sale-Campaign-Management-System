package com.example.Sale.Campaign.Project.Service;

import com.example.Sale.Campaign.Project.Model.PriceHistory;
import com.example.Sale.Campaign.Project.Repository.PriceHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceHistoryService {

    @Autowired
    private PriceHistoryRepository priceHistoryRepository;

    public PriceHistory addpricehistory(PriceHistory ph) {
        return priceHistoryRepository.save(ph);
    }

    public List<PriceHistory> getpricehistory() {
        return priceHistoryRepository.findAll();
    }

    public PriceHistory getByPid(int pid) {
        return priceHistoryRepository.findByPid(pid);
    }
}
