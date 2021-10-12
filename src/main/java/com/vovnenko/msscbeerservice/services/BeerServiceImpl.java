package com.vovnenko.msscbeerservice.services;

import com.vovnenko.msscbeerservice.domain.Beer;
import com.vovnenko.msscbeerservice.repositories.BeerRepository;
import com.vovnenko.msscbeerservice.web.controller.NotFoundException;
import com.vovnenko.msscbeerservice.web.mappers.BeerMapper;
import com.vovnenko.msscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("beerService")
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private BeerRepository beerRepository;
    private BeerMapper beerMapper;

    @Override
    public BeerDto geById(UUID beerId) {
        return beerMapper.beerToBeerDTo(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {

        return beerMapper.beerToBeerDTo(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDTo(beerRepository.save(beer));


    }
}
