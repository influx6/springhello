package com.spring.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentDOA {
	@Autowired
	private ComponentJDBCConnection jdbcConnection;

	public ComponentJDBCConnection getJDBCConnection() {
		return jdbcConnection;
	}

	public void setJDBCConnection(ComponentJDBCConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}
}
