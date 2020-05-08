package com.spring.cdibiz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CDIBusinessTest {
	@Mock
	CDIDao dao;

	@InjectMocks
	CDIBusiness business;

	@Test
	public void testFindLatestCD(){
		when(dao.getData()).thenReturn(new int[]{10,20});

		int latestCD = business.findLatestCD();
		assertEquals(10, latestCD);
	}
}
