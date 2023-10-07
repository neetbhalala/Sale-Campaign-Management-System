package com.example.Sale.Campaign.Project.Model;

import jdk.dynalink.linker.LinkerServices;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {

    private List<Product> products;
    private int page;
    private int pagesize;
    private int totalpages;
}
