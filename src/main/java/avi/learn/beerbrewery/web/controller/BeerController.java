package avi.learn.beerbrewery.web.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import avi.learn.beerbrewery.service.BeerService;
import avi.learn.beerbrewery.web.model.BeerDto;

@RestController
@RequestMapping("/api/1.0/beers")
public class BeerController {
	
	@Autowired
	private BeerService beerService;
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId) {
		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> createNewBeer(@RequestBody @Valid BeerDto beer) {
		BeerDto createdBeer = beerService.createNewBeer(beer);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", "/api/1.0/beers/" + createdBeer.getBeerId());
		return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateBeer(@PathVariable UUID beerId, @RequestBody @Valid BeerDto beer) {
		beerService.updateBeer(beerId, beer);
	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId) {
		beerService.deleteBeerById(beerId);
	}

}
