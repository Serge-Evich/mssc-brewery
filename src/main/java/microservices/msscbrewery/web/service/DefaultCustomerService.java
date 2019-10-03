package microservices.msscbrewery.web.service;

import microservices.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefaultCustomerService implements CustomerService {
    @Override
    public CustomerDto getById(UUID customerId) {
        return CustomerDto.builder().id(customerId).name("customerName").build();
    }
}
