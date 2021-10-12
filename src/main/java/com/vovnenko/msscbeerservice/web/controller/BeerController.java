package com.vovnenko.msscbeerservice.web.controller;


import com.vovnenko.msscbeerservice.services.BeerService;
import com.vovnenko.msscbeerservice.web.model.BeerDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;



    @GetMapping("/{beerId}")
    ResponseEntity<BeerDto> getBeerById (@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerService.geById(beerId),HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity saveNewBeer(@RequestBody @Validated BeerDto beerDto){

        return new ResponseEntity<>(beerService.saveNewBeer(beerDto),HttpStatus.CREATED);
    }


    @PutMapping("/{beerId}")
    public ResponseEntity updateBeer(@PathVariable("beerId") UUID beerId,@RequestBody  @Validated BeerDto beerDto){

        //todo impl
        return new ResponseEntity<>(beerService.updateBeer(beerId,beerDto),HttpStatus.NO_CONTENT);
    }
}
