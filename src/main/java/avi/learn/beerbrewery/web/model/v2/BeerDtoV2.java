package avi.learn.beerbrewery.web.model.v2;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeerDtoV2 {
	private UUID beerId;
	private String beerName;
	private BeerStyle beerStyle;
}
