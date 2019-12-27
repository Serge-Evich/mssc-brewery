package microservices.msscbrewery.web.service;

import microservices.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto get(UUID beerId);

    BeerDto save(BeerDto beerDto);

    void update(UUID beerId, BeerDto beerDto);

    void delete(UUID beerId);
}
