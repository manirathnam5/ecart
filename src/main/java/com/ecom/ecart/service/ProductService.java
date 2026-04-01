package com.ecom.ecart.service;

import com.ecom.ecart.entity.Product;
import com.ecom.ecart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products;
    }


    public  Map<String, Object> getPagingProduct(int page, int size) {

          Pageable pageable = PageRequest.of(page,size);
          Page<Product> products = productRepository.findAll(pageable);

          Map<String, Object> response = new HashMap<>();

          response.put("products", products.getContent());
          response.put("Total Products " , products.getTotalElements());
          return response;
    }


    public Product getProductId(Long id ){

          return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found "));

    }
}

