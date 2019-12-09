package avi.learn.beerbrewery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import avi.learn.beerbrewery.domain.Beer;

public interface BeerRepository extends JpaRepository<Beer, Long>{

}
