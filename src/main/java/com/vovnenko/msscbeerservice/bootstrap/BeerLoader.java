package com.vovnenko.msscbeerservice.bootstrap;

import com.vovnenko.msscbeerservice.domain.Beer;
import com.vovnenko.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    public  static  final  String BEER_1_UPC = "0631234200036";
    public  static  final  String BEER_2_UPC = "0631234300019";
    public  static  final  String BEER_3_UPC = "0083783375213";


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
                    upc(BEER_1_UPC).
                    price(new BigDecimal("1.25")).build());
            beerRepository.save(Beer.builder().
                    beerName("Obolon").
                    beerStyle("Light").
                    quantityToBrew(200).
                    minQuantityOnHand(12).
                    upc(BEER_2_UPC).
                    price(new BigDecimal("1.25")).build());

            beerRepository.save(Beer.builder().
                    beerName("Chernigivske").
                    beerStyle("Dark").
                    quantityToBrew(200).
                    minQuantityOnHand(12).
                    upc(BEER_3_UPC).
                    price(new BigDecimal("1.25")).build());
        }


    }
}
