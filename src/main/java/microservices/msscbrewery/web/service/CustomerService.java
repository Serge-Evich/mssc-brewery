package microservices.msscbrewery.web.service;

import microservices.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getById(UUID customerId);
}
