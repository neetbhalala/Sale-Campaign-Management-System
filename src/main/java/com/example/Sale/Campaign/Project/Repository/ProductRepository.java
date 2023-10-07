package com.example.Sale.Campaign.Project.Repository;

import com.example.Sale.Campaign.Project.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
