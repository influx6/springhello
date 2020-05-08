package com.spring.hello.basics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = HelloApplication.class)
public class BinarySearchImplTest {
	// Load Spring Context.
	@Autowired
	BinarySearchImpl binarySearch;

	@Test
	public void testBasicScenario(){
		// call method on binarySearch
		// check if the value is correct
		int result = binarySearch.binarySearch(new int[]{}, 3);
		assertEquals(3, result);
	}
}
