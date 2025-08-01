package h.douyry.com.billing_service.feign;

import h.douyry.com.billing_service.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customer-service" )
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerServiceCB", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);


    @GetMapping("/customers")
    @CircuitBreaker(name = "customerServiceCB", fallbackMethod = "getAllDefaultCustomer")
    PagedModel<Customer> getAllCustomers();

    default Customer getDefaultCustomer(Long id, Exception e){
        return  Customer.builder()
                .id(id)
                .email("default Email")
                .name("default Name")
                .build();
    }

    default PagedModel<Customer> getAllDefaultCustomer(Exception e) {
        return  PagedModel.empty();
    }
}
