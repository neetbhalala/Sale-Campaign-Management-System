package com.example.Sale.Campaign.Project.Service;

import com.example.Sale.Campaign.Project.Model.Campaign;
import com.example.Sale.Campaign.Project.Model.PriceHistory;
import com.example.Sale.Campaign.Project.Model.Product;
import com.example.Sale.Campaign.Project.Model.ProductDto;
import com.example.Sale.Campaign.Project.Repository.CampaignRepository;
import com.example.Sale.Campaign.Project.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CampaignService campaignService;

    @Autowired
    private PriceHistoryService priceHistoryService;

    public Product addproduct(Product p) {
        Product product = productRepository.save(p);

        PriceHistory ph = new PriceHistory();

        ph.setActualprice(product.getCurrent_price());
        ph.setPid(product.getPid());

        List<Double> list = new ArrayList<>();
        list.add(product.getCurrent_price());
        ph.setPhistory(list);

        List<LocalDateTime> list1 = new ArrayList<>();
        list1.add(LocalDateTime.now());
        ph.setChangetime(list1);

        priceHistoryService.addpricehistory(ph);

        return productRepository.save(p);
    }

    public List<Product> getproduct() {
        return productRepository.findAll();
    }

    public ProductDto getpage(int pageno, int pagesize) {
        if(pageno > 0) {
            pageno -= 1;
        }
        PageRequest pageRequest = PageRequest.of(pageno,pagesize);

        Page<Product> page = productRepository.findAll(pageRequest);

        ProductDto pd = new ProductDto();
        pd.setProducts(page.getContent());
        pd.setPage(page.getNumber());
        pd.setPagesize(page.getSize());
        pd.setTotalpages(page.getTotalPages());
        return pd;
    }

    public List<Product> sales() {
        List<Campaign> sales = campaignService.currentcampaign();
        List<Product> products = productRepository.findAll();

        if(sales.size() > 0) {
            products.forEach((p)->{
                PriceHistory ph = priceHistoryService.getByPid(p.getPid());
                double currentprice = ph.getActualprice();
                double per = p.getDiscount();

                double discprice = currentprice - ((currentprice * per)/100);
                p.setCurrent_price(discprice);

                List<Double> list = ph.getPhistory();
                list.add(discprice);
                ph.setPhistory(list);

                List<LocalDateTime> list1 = ph.getChangetime();
                list1.add(LocalDateTime.now());
                ph.setChangetime(list1);

                priceHistoryService.addpricehistory(ph);

                productRepository.save(p);
            });
            return products;
        }
        return products;
    }
}
