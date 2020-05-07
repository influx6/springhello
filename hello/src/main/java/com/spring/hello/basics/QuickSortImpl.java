package com.spring.hello.basics;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Qualifier("quick")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)  // ensure the same bean is created once and returned on every request to get this bean
public class QuickSortImpl implements NumberSortingAlgorithm {
	public int[] sort(int[] numbersToSort) {
		System.out.println("Using quick sort");
		// We are supposed to sort this numbers with QuickSort.
		return numbersToSort;
	}
}
