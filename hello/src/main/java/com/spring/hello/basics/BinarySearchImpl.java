package com.spring.hello.basics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)  // ensure the same bean is created once and returned on every request to get this bean
public class BinarySearchImpl {
	@Autowired
	@Qualifier("bubble")
	private NumberSortingAlgorithm algorithm;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public int binarySearch(int[] numbers, int numberToSearchFor) {
		int[] sortedNumbers = this.algorithm.sort(numbers);
		return 3;
	}

	@PostConstruct
	public void onPostConstruct() {
		this.logger.info("Done constructing");
	}

	@PreDestroy
	public void onPreDestroy() {
		this.logger.info("About destroying");
	}
}
