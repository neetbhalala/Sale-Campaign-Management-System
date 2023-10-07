package com.example.Sale.Campaign.Project.Controller;

import com.example.Sale.Campaign.Project.Model.Campaign;
import com.example.Sale.Campaign.Project.Service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @PostMapping("/addcampaign")
    private Campaign addcampaign(@RequestBody Campaign c) {
        return campaignService.addcampaign(c);
    }

    @GetMapping("/getcampaign")
    private List<Campaign> getcampaign() {
        return campaignService.getcampaign();
    }

    @GetMapping("/pastcampaign")
    private List<Campaign> pastcampaign() {
        return campaignService.pastcampaign();
    }

    @GetMapping("/upcomingcampaign")
    private List<Campaign> upcomingcampaign() {
        return campaignService.upcomingcampaign();
    }

    @GetMapping("/currentcampaign")
    private List<Campaign> currentcampaign() {
        return campaignService.currentcampaign();
    }
}
