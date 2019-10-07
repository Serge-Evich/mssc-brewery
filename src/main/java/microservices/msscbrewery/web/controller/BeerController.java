package microservices.msscbrewery.web.controller;

import microservices.msscbrewery.web.model.BeerDto;
import microservices.msscbrewery.web.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    @Autowired
    public BeerController(@Qualifier("defaultBeerService") BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return ResponseEntity.ok(beerService.getBeerById(beerId));
    }

    @PostMapping("/beer")
    public ResponseEntity postBeer(@RequestBody BeerDto beerDto) {
        BeerDto result = beerService.save(beerDto);
        return ResponseEntity.created(URI.create("/api/customer/" + result.getId().toString())).build();
    }
}
