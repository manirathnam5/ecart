package com.ecom.ecart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/product")
public class ProductController {



    @GetMapping("/list")
    public String getProductList(){
        return "Product Lists";
    }
}
