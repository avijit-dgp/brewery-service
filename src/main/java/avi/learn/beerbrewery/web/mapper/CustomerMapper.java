package avi.learn.beerbrewery.web.mapper;

import org.mapstruct.Mapper;

import avi.learn.beerbrewery.domain.Customer;
import avi.learn.beerbrewery.web.model.CustomerDto;

@Mapper
public interface CustomerMapper {
	
	Customer customerDtoToCustomer(CustomerDto dto);
	
	CustomerDto customerToCustomerDto(Customer customer);

}
