package avi.learn.beerbrewery.web.controller;

import avi.learn.beerbrewery.repository.CustomerRepository;
import avi.learn.beerbrewery.web.model.CustomerDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {
	
	private static final String API_1_0_CUSTOMERS = "/api/1.0/customers";
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Before
	public void cleanDatabase() {
		customerRepository.deleteAll();
	}
	
	@Test
	public void postTest_whenCustomerIsValid_receiveOk() {
		CustomerDto customer = createValidCustomer();
		ResponseEntity<Object> response = testRestTemplate.postForEntity(API_1_0_CUSTOMERS, customer, Object.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	}
	
//	@Test
//	public void postTest_whenCustomerIsValid_saveToDatabase() {
//		CustomerDto customer = createValidCustomer();
//		testRestTemplate.postForEntity(API_1_0_CUSTOMERS, customer, Object.class);
//		List<CustomerDto> customers = customerRepository.findAll();
//		CustomerDto beerInDB = customers.get(0);
//		assertThat(beerInDB.getCustomerName()).isEqualTo("test-customer");
//	}
//	
//	@Test
//	public void postTest_whenCustomerNameIsLessThanRequired_receiveBadRequest() {
//		CustomerDto customer = createValidCustomer();
//		customer.setCustomerName("abc");
//		ResponseEntity<Object> response = testRestTemplate.postForEntity(API_1_0_CUSTOMERS, customer, Object.class);
//		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
//	}
//	
//	@Test
//	public void postTest_whenCustomerEmailIsNull_receiveOk() {
//		CustomerDto customer = createValidCustomer();
//		customer.setEmailId(null);
//		ResponseEntity<Object> response = testRestTemplate.postForEntity(API_1_0_CUSTOMERS, customer, Object.class);
//		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
//	}
//	
//	@Test
//	public void getTest_whenCustomerDoesNotExists_receiveBadRequest() {
//		ResponseEntity<Object> response = testRestTemplate.getForEntity(getURIForFirstRecord(), Object.class);
//		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
//	}
//	
//	@Test
//	public void getTest_whenCustomerExists_receiveOk() {
//		CustomerDto customer = createValidCustomer();
//		testRestTemplate.postForEntity(API_1_0_CUSTOMERS, customer, Object.class);
//		ResponseEntity<Object> response = testRestTemplate.getForEntity(getURIForFirstRecord(), Object.class);
//		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//	}
//	
//	@Test
//	public void deleteTest_whenCustomerExists_receiveOk() {
//		CustomerDto customer = createValidCustomer();
//		testRestTemplate.postForEntity(API_1_0_CUSTOMERS, customer, Object.class);
//		testRestTemplate.delete(getURIForFirstRecord());
//		List<CustomerDto> customers = customerRepository.findAll();
//		assertThat(customers.size()).isEqualTo(0);
//	}
//	
//	@Test
//	public void putTest_whenBeerExists_receiveOk() {
//		CustomerDto customer = createValidCustomer();
//		testRestTemplate.postForEntity(API_1_0_CUSTOMERS, customer, Object.class);
//		customer.setCustomerName("updated-name");
//		testRestTemplate.put(getURIForFirstRecord(), customer);
//		List<CustomerDto> customers = customerRepository.findAll();
//		assertThat(customers.get(0).getCustomerName()).isEqualTo("updated-name");
//	}
//
//	private String getURIForFirstRecord() {
//		return API_1_0_CUSTOMERS + "/" + (customerRepository.findAll().size() == 0 ? 1 : customerRepository.findAll().get(0).getCustomerId());
//	}

	private CustomerDto createValidCustomer() {
		CustomerDto customer = new CustomerDto();
		customer.setCustomerName("test-customer");
		customer.setEmailId("test@test.com");
		return customer;
	}

}
