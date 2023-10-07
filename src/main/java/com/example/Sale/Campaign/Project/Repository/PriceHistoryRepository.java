package com.example.Sale.Campaign.Project.Repository;

import com.example.Sale.Campaign.Project.Model.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Integer> {
    PriceHistory findByPid(int pid);
}
