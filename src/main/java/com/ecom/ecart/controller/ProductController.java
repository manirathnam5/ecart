package com.ecom.ecart.controller;

import com.ecom.ecart.entity.Product;
import com.ecom.ecart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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


    @GetMapping("/pagination")
    public Map<String, Object> getPagination(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "5") int size) {
        return productService.getPagingProduct(page, size);
        //return productList;
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductId(id);

    }


    @GetMapping("/search")
    public List<Product> searchProduct(@RequestParam(required = false) String category,
                                       @RequestParam(required = false) Double minPrice,
                                       @RequestParam(required = false) Double maxPrice,
                                       @RequestParam(required = false) String keyword) {

        return productService.searchCategory(category, minPrice, maxPrice, keyword);
    }

}
