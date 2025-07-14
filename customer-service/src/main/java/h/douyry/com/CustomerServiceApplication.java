package h.douyry.com;

import h.douyry.com.entities.Customer;
import h.douyry.com.repository.CustomerRepository;
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
        return args -> {
            customerRepository.save(Customer.builder()
                            .name("Hamza").email("h.d@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("ahmed").email("a.d@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("chorouq").email("c.d@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("khadija").email("k.d@gmail.com")
                    .build());
            customerRepository.findAll().forEach(customer -> {
                System.out.println("======================");
                System.out.println(customer.getId());
                System.out.println(customer.getName());
                System.out.println(customer.getEmail());
                System.out.println("======================");
            });
        };
    }
}
