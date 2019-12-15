package avi.learn.beerbrewery.web.mapper;

import org.mapstruct.Mapper;

import avi.learn.beerbrewery.domain.Beer;
import avi.learn.beerbrewery.web.model.BeerDto;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {
	
	Beer beerDtoToBeer(BeerDto dto);
	
	BeerDto beerToBeerDto(Beer beer);

}
