package com.example.Sale.Campaign.Project.Repository;

import com.example.Sale.Campaign.Project.Model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
    List<Campaign> findByEnddateBefore(LocalDate now);

    List<Campaign> findByStartdateAfter(LocalDate now);

    List<Campaign> findByStartdateBeforeAndEnddateAfterOrStartdateEqualsOrEnddateEquals(LocalDate now, LocalDate now1, LocalDate now2, LocalDate now3);
}
