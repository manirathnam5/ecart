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
                            "Over-ear wireless headphones with noise cancellation","Electronics",
                            4.5, "TechZone", 120, 34),

                    new Product(null, "Smartphone 5G", 18999.0,
                            "6.5-inch display smartphone with 128GB storage","Phone ",
                            4.3, "MobileHub", 75, 21),

                    new Product(null, "Gaming Mouse", 1299.0,
                            "Ergonomic gaming mouse with RGB lighting","Computer ",
                            4.6, "GameStore", 200, 5),
                    new Product(null, "Laptop 14-inch", 55999.0,
                            "Intel i5 laptop with 8GB RAM and 512GB SSD","Computer",
                            4.4, "CompWorld", 50, 10),

                    new Product(null, "Smart Watch", 3999.0,
                            "Fitness smartwatch with heart rate tracking","Electronics",
                            4.2, "Wearables Inc", 180, 5),

                    new Product(null, "Noise Cancelling Earbuds", 3499.0,
                            "Compact earbuds with active noise cancellation and fast charging","Electronics",
                            4.4, "SoundMax", 140, 220),

                    new Product(null, "4K Smart TV 43-inch", 28999.0,
                            "Ultra HD smart TV with HDR and built-in streaming apps","TV",
                            4.6, "VisionElectronics", 35, 180),

                    new Product(null, "Mechanical Keyboard", 4599.0,
                            "RGB mechanical keyboard with blue switches for tactile feedback","Computer",
                            4.5, "KeyPro", 90, 310),

                    new Product(null, "External Hard Drive 1TB", 3799.0,
                            "Portable USB 3.0 external hard drive with fast data transfer","Computer",
                            4.3, "StorageHub", 160, 145),

                    new Product(null, "Bluetooth Speaker", 1999.0,
                            "Portable speaker with deep bass and 12-hour playback","Electronics",
                            4.2, "AudioBlast", 210, 400),

                    new Product(null, "Tablet 10-inch", 15999.0,
                            "Android tablet with 64GB storage and HD display","Electronics",
                            4.1, "TabWorld", 60, 95),

                    new Product(null, "DSLR Camera", 45999.0,
                            "24MP DSLR camera with interchangeable lenses","Camera",
                            4.7, "CamZone", 25, 130),

                    new Product(null, "Power Bank 20000mAh", 1499.0,
                            "High-capacity power bank with fast charging support","Electronics",
                            4.4, "ChargeIt", 300, 520),

                    new Product(null, "Air Purifier", 8999.0,
                            "HEPA air purifier for home with real-time air quality indicator","Home Appliance",
                            4.3, "PureAir", 70, 175),

                    new Product(null, "Office Chair Ergonomic", 6999.0,
                            "Adjustable ergonomic chair with lumbar support","Home Appliance",
                            4.5, "FurniFlex", 45, 260)

            );


        productRepository.saveAll(demoProductList);
            System.out.println("Data seeded successfully ");

        }else{
            System.out.println("Products already Exists !! ");
        }

    }
}
