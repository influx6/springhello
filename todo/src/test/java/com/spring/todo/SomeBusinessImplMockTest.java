package com.spring.todo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessImplMockTest {
	@Mock
	DataService dataService;

	@InjectMocks
	SomeBusinessImpl someBusiness;

	@Test
	public void findRecordsWithUser() {
		when(dataService.getAllRecords()).thenReturn(new int[] {1, 2});

		int maxId = someBusiness.findRecordsWithUser();
		assertEquals(2, maxId);
	}
}

