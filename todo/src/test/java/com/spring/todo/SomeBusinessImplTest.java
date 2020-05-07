package com.spring.todo;

import org.junit.*;
import static org.junit.Assert.*;

public class SomeBusinessImplTest {

	@Test
	public void findRecordsWithUser() {
		SomeBusinessImpl someBusiness = new SomeBusinessImpl(new DataServiceImplStub());
		int maxId = someBusiness.findRecordsWithUser();
		assertEquals(2, maxId);
	}
}

class DataServiceImplStub implements DataService {

	@Override
	public int[] getAllRecords() {
		int[] values =  {1, 2};
		return values;
	}
}