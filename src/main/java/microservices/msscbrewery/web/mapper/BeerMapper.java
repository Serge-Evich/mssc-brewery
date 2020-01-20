package microservices.msscbrewery.web.mapper;

import microservices.msscbrewery.domain.Beer;
import microservices.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDto map(Beer beer);
    Beer map(BeerDto beerDto);
}
