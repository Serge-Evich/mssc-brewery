package microservices.msscbrewery.web.service.v2;


import microservices.msscbrewery.web.model.v2.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto save(BeerDto beerDto);

    BeerDto update(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);
}
