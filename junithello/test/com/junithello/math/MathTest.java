package com.junithello.math;

import org.junit.*;

import static org.junit.Assert.*;

public class MathTest {
	Math math = new Math();

	@BeforeClass
	public static void beforeAll() {
		System.out.println("Running Before all test");
	}

	@AfterClass
	public static void afterAll() {
		System.out.println("Running after all test");
	}

	@Before
	public void beforeEach() {
		System.out.println("Running Before each test");
	}

	@After
	public void afterEach() {
		System.out.println("Running after each test");
	}

	// MyMath.sumWithZeroList
	// with Int Arrays: []
	// returns => 0
	@Test
	public void sumWithZeroList() {
		assertEquals(0, math.sum(new int[]{}));
	}

	// MyMath.sum
	// with Int Arrays: 1, 3, 3, 4
	// returns => 11
	@Test
	public void sum() {
		assertEquals(11, math.sum(new int[]{1, 3, 3, 4}));
	}
}
