package com.spring.todo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomeBusinessMockWithAnnotationTest {

	@Test
	public void findRecordsWithUser() {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.getAllRecords()).thenReturn(new int[] {1, 2});

		SomeBusinessImpl someBusiness = new SomeBusinessImpl(dataServiceMock);
		int maxId = someBusiness.findRecordsWithUser();
		assertEquals(2, maxId);
	}
}

