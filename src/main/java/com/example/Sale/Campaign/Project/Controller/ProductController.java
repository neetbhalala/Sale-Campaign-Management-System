package com.example.Sale.Campaign.Project.Controller;

import com.example.Sale.Campaign.Project.Model.Product;
import com.example.Sale.Campaign.Project.Model.ProductDto;
import com.example.Sale.Campaign.Project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addproduct")
    private ResponseEntity<Product> addproduct(@RequestBody Product p) {
        return ResponseEntity.ok(productService.addproduct(p));
    }

    @GetMapping("/getproduct")
    private ResponseEntity<List<Product>> getproduct() {
        return ResponseEntity.status(HttpStatus.FOUND).body(productService.getproduct());
    }

    @GetMapping("/getpage")
    private ProductDto getpage(@RequestParam(defaultValue = "0") int pageno, @RequestParam int pagesize) {
        return productService.getpage(pageno,pagesize);
    }

    @GetMapping("/sales")
    private List<Product> sales() {
        return productService.sales();
    }

    // git git git
}
