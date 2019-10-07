package microservices.msscbrewery.web.controller.v2;

import microservices.msscbrewery.web.model.v2.BeerDto;
import microservices.msscbrewery.web.service.v2.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RequestMapping("/api/v2/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    @Autowired
    public BeerController(@Qualifier("defaultBeerServiceV2") BeerService beerService) {
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

    @PutMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
        beerService.update(beerId, beerDto);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteById(beerId);
    }
}
