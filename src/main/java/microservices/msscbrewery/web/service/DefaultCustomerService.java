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

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name(customerDto.getName())
                .build();
    }

    @Override
    public void update(UUID customerId, CustomerDto customerDto) {

    }

    @Override
    public void delete(UUID customerId) {

    }
}
