package com.vovnenko.msscbeerservice.repositories;

import com.vovnenko.msscbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository <Beer, UUID>{


}
