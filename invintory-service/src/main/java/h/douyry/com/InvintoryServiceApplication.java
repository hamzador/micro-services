package h.douyry.com;

import h.douyry.com.entities.Product;
import h.douyry.com.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InvintoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InvintoryServiceApplication.class, args);

    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder()
                            .id(UUID.randomUUID().toString())
                            .name("Computer").price(320).quantity(10)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("printer").price(300).quantity(20)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Mouse").price(30).quantity(50)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("smartphone").price(350).quantity(15)
                    .build());
            productRepository.findAll().forEach(product -> {
                System.out.println("======================");
                System.out.println(product.getId());
                System.out.println(product.getName());
                System.out.println(product.getPrice());
                System.out.println(product.getQuantity());
                System.out.println("======================");
            });
        };
    }
}
