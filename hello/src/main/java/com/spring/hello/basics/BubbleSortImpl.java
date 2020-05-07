package com.spring.hello.basics;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Qualifier("bubble")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)  // ensure a new bean is created all every request to get this bean
public class BubbleSortImpl implements NumberSortingAlgorithm {
	public int[] sort(int[] numbersToSort) {
		System.out.println("Using bubble sort");
		// We are supposed to sort this numbers with BubbleSort.
		return numbersToSort;
	}
}
