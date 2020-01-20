package microservices.msscbrewery.web.mapper;

import microservices.msscbrewery.domain.Customer;
import microservices.msscbrewery.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    CustomerDto map(Customer customer);
    Customer map(CustomerDto customerDto);
}
