package com.ecom.ecart.service;

import com.ecom.ecart.entity.Product;
import com.ecom.ecart.repository.ProductRepository;
import com.ecom.ecart.spec.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;


    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }


    public Map<String, Object> getPagingProduct(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productRepository.findAll(pageable);

        Map<String, Object> response = new HashMap<>();

        response.put("products", products.getContent());
        response.put("Total Products ", products.getTotalElements());
        return response;
    }


    public Product getProductId(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found "));
    }


    public List<Product> searchCategory(String category, Double minPrice, Double maxPrice, String keyword) {

        Specification<Product> spec = Specification.where(ProductSpecification.hasCategory(category))
                .and(ProductSpecification.priceBetween(minPrice, maxPrice))
                .and(ProductSpecification.hasNameOrDescription(keyword));
        return productRepository.findAll(spec);
    }
}

