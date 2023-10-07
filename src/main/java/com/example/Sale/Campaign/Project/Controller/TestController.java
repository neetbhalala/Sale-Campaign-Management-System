package com.example.Sale.Campaign.Project.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("test")
public class TestController {

    @GetMapping("hello")
    public String hello() {
        return "Hello World";
    }
}
