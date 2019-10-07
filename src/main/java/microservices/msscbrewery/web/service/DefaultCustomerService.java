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
                .name(customerDto.getName())
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public CustomerDto update(UUID customerId, CustomerDto customerDto) {
        return CustomerDto.builder().name(customerDto.getName()).id(customerId).build();
    }

    @Override
    public void deleteById(UUID customerId) {

    }
}
