package com.mitar.customerservice;

import com.mitar.customerservice.entities.Customer;
import com.mitar.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return  args -> {
            customerRepository.save(Customer
                    .builder()
                    .nom("reda")
                    .email("reda@gmail.com").build());

            customerRepository.save(Customer
                    .builder()
                    .nom("ali")
                    .email("ali@gmail.com").build());

            customerRepository.save(Customer
                    .builder()
                    .nom("amina")
                    .email("amina@gmail.com").build());

            customerRepository.save(Customer
                    .builder()
                    .nom("sara")
                    .email("sara@gmail.com").build());

            customerRepository.findAll().forEach(c->{
                System.out.println("---------------");
                System.out.println(c.getId());
                System.out.println(c.getNom());
                System.out.println(c.getEmail());
                System.out.println("---------------");
            });
        };
    }
}
