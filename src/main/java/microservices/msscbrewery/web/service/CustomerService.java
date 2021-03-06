package microservices.msscbrewery.web.service;

import microservices.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getById(UUID customerId);

    CustomerDto save(CustomerDto customerDto);

    void update(UUID customerId, CustomerDto customerDto);

    void delete(UUID customerId);
}
