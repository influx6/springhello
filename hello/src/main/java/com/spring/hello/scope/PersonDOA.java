package com.spring.hello.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PersonDOA {
	@Autowired
	private XMLJDBCConnection XMLJDBCConnection;

	public XMLJDBCConnection getJDBCConnection() {
		return XMLJDBCConnection;
	}

	public void setJDBCConnection(XMLJDBCConnection XMLJDBCConnection) {
		this.XMLJDBCConnection = XMLJDBCConnection;
	}
}
