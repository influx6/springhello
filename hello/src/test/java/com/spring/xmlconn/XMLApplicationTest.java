package com.spring.xmlconn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "/testApplicationContext.xml")
public class XMLApplicationTest {

	@Autowired
	XMLPersonDOA personDOA;

	@Test
	public void testBasicApplication() {
		XMLJDBCConnection connection = personDOA.getJDBCConnection();
		assertTrue(connection != null);
	}
}
