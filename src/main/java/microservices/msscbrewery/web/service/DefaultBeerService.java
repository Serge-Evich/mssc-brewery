package microservices.msscbrewery.web.service;

import lombok.extern.slf4j.Slf4j;
import microservices.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
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
}
