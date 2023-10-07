package com.example.Sale.Campaign.Project.Service;

import com.example.Sale.Campaign.Project.Model.Campaign;
import com.example.Sale.Campaign.Project.Repository.CampaignRepository;
import com.example.Sale.Campaign.Project.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;
    @Autowired
    private ProductRepository productRepository;

    public Campaign addcampaign(Campaign c) {
        c.setCampaigndiscount(productRepository.findAll());
        return campaignRepository.save(c);
    }

    public List<Campaign> getcampaign() {
        return campaignRepository.findAll();
    }

    public List<Campaign> pastcampaign() {
        return campaignRepository.findByEnddateBefore(LocalDate.now());
    }

    public List<Campaign> upcomingcampaign() {
        return campaignRepository.findByStartdateAfter(LocalDate.now());
    }

    public List<Campaign> currentcampaign() {
        return campaignRepository.findByStartdateBeforeAndEnddateAfterOrStartdateEqualsOrEnddateEquals(LocalDate.now(),LocalDate.now(),LocalDate.now(),LocalDate.now());
    }
}
