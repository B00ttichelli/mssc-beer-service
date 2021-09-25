package com.vovnenko.msscbeerservice.web.mappers;


import com.vovnenko.msscbeerservice.domain.Beer;
import com.vovnenko.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDTo(Beer beer);
    Beer beerDtoToBeer(BeerDto  beerDto );
}
