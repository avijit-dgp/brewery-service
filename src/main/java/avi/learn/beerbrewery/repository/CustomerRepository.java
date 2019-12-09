package avi.learn.beerbrewery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import avi.learn.beerbrewery.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
