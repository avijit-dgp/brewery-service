package avi.learn.beerbrewery.service;

import java.util.UUID;

import avi.learn.beerbrewery.web.model.BeerDto;

public interface BeerService {
	BeerDto getBeerById(UUID beerId);

	BeerDto createNewBeer(BeerDto beerDto);

	void updateBeer(UUID beerId, BeerDto beerDto);

	void deleteBeerById(UUID beerId);
}
