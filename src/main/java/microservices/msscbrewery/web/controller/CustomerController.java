package microservices.msscbrewery.web.controller;

import microservices.msscbrewery.web.model.CustomerDto;
import microservices.msscbrewery.web.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<?> post(@Valid @RequestBody CustomerDto customerDto) {
        return ResponseEntity.created(URI.create(PATH + "/" + customerService.save(customerDto).getId())).build();
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<?> put(@PathVariable UUID customerId, @Valid @RequestBody CustomerDto customerDto) {
        customerService.update(customerId, customerDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<?> delete(@PathVariable UUID customerId) {
        customerService.delete(customerId);
        return ResponseEntity.noContent().build();
    }
}
