package microservices.msscbrewery.web.controller;

import microservices.msscbrewery.web.model.BeerDto;
import microservices.msscbrewery.web.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<BeerDto> get(@PathVariable("beerId") UUID beerId) {
        return ResponseEntity.ok(beerService.getBeerById(beerId));
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody BeerDto beerDto) {
        BeerDto result = beerService.save(beerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", result.getId().toString());
        return ResponseEntity.created(URI.create("/api/v1/beer/" + result.getId().toString())).body(httpHeaders);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<?> put(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
        beerService.update(beerId, beerDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity<?> delete(@PathVariable("beerId") UUID beerId) {
        beerService.delete(beerId);
        return ResponseEntity.noContent().build();
    }
}
