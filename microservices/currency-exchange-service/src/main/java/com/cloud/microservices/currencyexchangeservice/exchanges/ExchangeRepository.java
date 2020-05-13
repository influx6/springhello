package com.cloud.microservices.currencyexchangeservice.exchanges;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeResult, Integer> {
	Optional<ExchangeResult> findByFromAndTo(String from, String to);
}
