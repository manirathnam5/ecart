package com.ecom.ecart.dataseed;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ecom.ecart.entity.Product;
import com.ecom.ecart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductSeeder  implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository ;

    @Override
    public void run(String... args) throws Exception {

        if(productRepository.count() == 0) {
            List<Product> demoProductList = List.of(new Product(null, "Wireless Bluetooth Headphones", 2499.0,
                            "Over-ear wireless headphones with noise cancellation",
                            4.5, "TechZone", 120, 34),

                    new Product(null, "Smartphone 5G", 18999.0,
                            "6.5-inch display smartphone with 128GB storage",
                            4.3, "MobileHub", 75, 21),

                    new Product(null, "Gaming Mouse", 1299.0,
                            "Ergonomic gaming mouse with RGB lighting",
                            4.6, "GameStore", 200, 5),

                    new Product(null, "Laptop 14-inch", 55999.0,
                            "Intel i5 laptop with 8GB RAM and 512GB SSD",
                            4.4, "CompWorld", 50, 10),

                    new Product(null, "Smart Watch", 3999.0,
                            "Fitness smartwatch with heart rate tracking",
                            4.2, "Wearables Inc", 180, 5));

        productRepository.saveAll(demoProductList);
            System.out.println("Data seeded successfully ");

        }else{
            System.out.println("Products already Exists !! ");
        }

    }
}
