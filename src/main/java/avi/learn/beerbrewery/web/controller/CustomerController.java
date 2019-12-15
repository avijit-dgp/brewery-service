package avi.learn.beerbrewery.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

import avi.learn.beerbrewery.service.CustomerService;
import avi.learn.beerbrewery.web.model.CustomerDto;

@RestController
@RequestMapping("/api/1.0/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId) {
		return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> createNewCustomer(@RequestBody @Valid CustomerDto customer) {
		CustomerDto createdCustomer = customerService.createNewCustomer(customer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location" , "/api/1.0/customers/" + createdCustomer.getCustomerId());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCustomer(@PathVariable UUID customerId, @RequestBody @Valid CustomerDto customer) {
		customerService.updateCustomer(customerId, customer);
	}
	
	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable UUID customerId) {
		customerService.deleteCustomerById(customerId);
	}
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<?> validationExceptionHandler(MethodArgumentNotValidException exception) {
//		List<String> errors = new ArrayList<>();
//		exception.getBindingResult().getFieldErrors().forEach(
//				fieldError -> {
//					errors.add(fieldError.getField() + " : " + fieldError.getDefaultMessage());
//				});
//		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//	}

}
