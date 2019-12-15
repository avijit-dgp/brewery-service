package avi.learn.beerbrewery.web.controller.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import avi.learn.beerbrewery.service.v2.BeerServiceV2;
import avi.learn.beerbrewery.web.model.v2.BeerDtoV2;

@RestController
@RequestMapping("/api/2.0/beers")
public class BeerControllerV2 {
	
	@Autowired
	private BeerServiceV2 beerServiceV2;
	
	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDtoV2> getBeer(@PathVariable UUID beerId) {
		return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> createNewBeer(@RequestBody @Valid BeerDtoV2 beer) {
		BeerDtoV2 createdBeer = beerServiceV2.createNewBeer(beer);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Location", "/api/2.0/beers/" + createdBeer.getBeerId());
		return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
	}
	
	@PutMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateBeer(@PathVariable UUID beerId, @RequestBody @Valid BeerDtoV2 beer) {
		beerServiceV2.updateBeer(beerId, beer);
	}
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId) {
		beerServiceV2.deleteBeerById(beerId);
	}
	
//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<?> validationErrorHandler(ConstraintViolationException violationException) {
//		List<String> errors = new ArrayList<>(violationException.getConstraintViolations().size());
//		violationException.getConstraintViolations().forEach(
//				error -> {
//					errors.add(error.getPropertyPath() + " : " + error.getMessage());
//				});
//		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//	}

}
