package avi.learn.beerbrewery.service.v2;

import java.util.UUID;

import avi.learn.beerbrewery.web.model.v2.BeerDtoV2;

public interface BeerServiceV2 {
	BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 createNewBeer(BeerDtoV2 beerDto);

    void updateBeer(UUID beerId, BeerDtoV2 beerDto);

    void deleteBeerById(UUID beerId);
}
