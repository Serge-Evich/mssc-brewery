package microservices.msscbrewery.web.service.v2;

import lombok.extern.slf4j.Slf4j;
import microservices.msscbrewery.web.model.v2.BeerDto;
import microservices.msscbrewery.web.model.v2.BeerStyle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Slf4j
@Service
@Qualifier("defaultBeerServiceV2")
public class DefaultBeerService implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder()
                .id(beerId)
                .name("beerName")
                .style(BeerStyle.IPA)
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
    public BeerDto update(UUID beerId, BeerDto beerDto) {
        return null;
    }

    @Override
    public void deleteById(UUID beerId) {
        return;
    }
}
