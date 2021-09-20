package com.vovnenko.msscbeerservice.bootstrap;

import com.vovnenko.msscbeerservice.domain.Beer;
import com.vovnenko.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {

        if(beerRepository.count()== 0){
            beerRepository.save(Beer.builder().
                    beerName("Lvivske").
                    beerStyle("Lager").
                    quantityToBrew(200).
                    minQuantityOnHand(12).
                    upc(33700000001L).
                    price(new BigDecimal("1.25")).build());
            beerRepository.save(Beer.builder().
                    beerName("Obolon").
                    beerStyle("Light").
                    quantityToBrew(200).
                    minQuantityOnHand(12).
                    upc(33700000002L).
                    price(new BigDecimal("1.25")).build());
        }


    }
}
