package com.mitar.inventoryservice;

import com.mitar.inventoryservice.entities.Product;
import com.mitar.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return  args -> {
            productRepository.save(Product
                    .builder()
                    .id(UUID.randomUUID().toString())
                    .name("smartphone")
                    .price(5000.6)
                    .quantity(15)
                    .build());

            productRepository.save(Product
                    .builder()
                    .id(UUID.randomUUID().toString())
                    .name("laptop")
                    .price(2500.6)
                    .quantity(42)
                    .build());

            productRepository.save(Product
                    .builder()
                    .id(UUID.randomUUID().toString())
                    .name("mouse")
                    .price(23)
                    .quantity(60)
                    .build());

            productRepository.save(Product
                    .builder()
                    .id(UUID.randomUUID().toString())
                    .name("keyboard")
                    .price(65)
                    .quantity(90)
                    .build());

            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
                /*System.out.println("---------------");
                System.out.println(p.getId());
                System.out.println(p.getName());
                System.out.println(p.getPrice());
                System.out.println(p.getQuantity());
                System.out.println("---------------");*/
            });
        };
    }
}
