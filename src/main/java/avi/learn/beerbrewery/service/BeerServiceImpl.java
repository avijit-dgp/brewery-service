package avi.learn.beerbrewery.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import avi.learn.beerbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
	@Override
	public BeerDto getBeerById(UUID beerId) {
		return BeerDto.builder()
				.beerId(UUID.randomUUID())
				.beerName("Hogarden")
				.beerStyle("Witbier")
				.build();
	}

	@Override
	public BeerDto createNewBeer(BeerDto beerDto) {
		return BeerDto.builder()
				.beerId(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateBeer(UUID beerId, BeerDto beerDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBeerById(UUID beerId) {
		log.debug("Deleting a beer...");
	}

	

}
