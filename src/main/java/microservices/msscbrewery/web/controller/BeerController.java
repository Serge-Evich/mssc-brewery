package microservices.msscbrewery.web.controller;

import microservices.msscbrewery.web.model.BeerDto;
import microservices.msscbrewery.web.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RequestMapping(BeerController.PATH)
@RestController
public class BeerController {

    public static final String PATH = "/api/v1/beer";

    private final BeerService beerService;

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> get(@PathVariable("beerId") UUID beerId) {
        return ResponseEntity.ok(beerService.get(beerId));
    }

    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody BeerDto beerDto) {
        BeerDto result = beerService.save(beerDto);
        return ResponseEntity.created(URI.create(PATH + "/" + result.getId())).build();
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<?> put(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto) {
        beerService.update(beerId, beerDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity<?> delete(@PathVariable("beerId") UUID beerId) {
        beerService.delete(beerId);
        return ResponseEntity.noContent().build();
    }
}
