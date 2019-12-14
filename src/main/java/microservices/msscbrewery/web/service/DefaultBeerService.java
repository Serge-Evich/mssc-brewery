package microservices.msscbrewery.web.service;

import microservices.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DefaultBeerService implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(beerId)
                .name("beerName")
                .style("beerStyle")
                .build();
    }

    @Override
    public BeerDto save(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .name(beerDto.getName())
                .style(beerDto.getStyle())
                .upc(beerDto.getUpc())
                .build();
    }

    @Override
    public void update(UUID beerId, BeerDto beerDto) {

    }

    @Override
    public void delete(UUID beerId) {

    }
}
