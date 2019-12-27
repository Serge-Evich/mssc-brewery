package microservices.msscbrewery.web.controller;

import microservices.msscbrewery.web.model.CustomerDto;
import microservices.msscbrewery.web.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

import static microservices.msscbrewery.web.controller.CustomerController.PATH;

@RequestMapping(PATH)
@RestController
public class CustomerController {
    public static final String PATH = "/api/v1/customer";
    private final CustomerService customerService;

    @Autowired
    public CustomerController(@Qualifier("defaultCustomerService") CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> get(@PathVariable("customerId") UUID customerId) {
        return ResponseEntity.ok(customerService.getById(customerId));
    }

    @PostMapping()
    public ResponseEntity<?> post(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.created(URI.create(PATH + "/" + customerService.save(customerDto).getId())).build();
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<?> put(@PathVariable UUID customerId, @RequestBody CustomerDto customerDto) {
        customerService.update(customerId, customerDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<?> delete(@PathVariable UUID customerId) {
        customerService.delete(customerId);
        return ResponseEntity.noContent().build();
    }
}
