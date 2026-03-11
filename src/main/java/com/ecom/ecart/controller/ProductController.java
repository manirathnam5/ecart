package com.ecom.ecart.controller;

import com.ecom.ecart.entity.Product;
import com.ecom.ecart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product/")
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<Product>> getProductList() {
        List<Product> productList = productService.getAllProducts();
        return ResponseEntity.ok(productList);
    }

}
