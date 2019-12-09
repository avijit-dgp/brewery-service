package avi.learn.beerbrewery.service.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import avi.learn.beerbrewery.web.model.v2.BeerDtoV2;

@Service
public class BeerServiceImplV2 implements BeerServiceV2 {
	
	@Override
    public BeerDtoV2 getBeerById(UUID beerId) {
        return null;
    }

    @Override
    public BeerDtoV2 createNewBeer(BeerDtoV2 beerDto) {
        return null;
    }

    @Override
    public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {

    }

    @Override
    public void deleteBeerById(UUID beerId) {

    }
}
