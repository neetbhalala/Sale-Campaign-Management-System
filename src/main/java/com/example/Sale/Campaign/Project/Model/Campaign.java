package com.example.Sale.Campaign.Project.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;

    private LocalDate startdate;
    private LocalDate enddate;
    private String title;

    @ManyToMany
    private List<Product> campaigndiscount;
}
