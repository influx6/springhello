package com.spring.xmlconn;

import com.spring.xmlconn.XMLJDBCConnection;

public class XMLPersonDOA {
	private XMLJDBCConnection xmlJDBCConnection;

	public XMLJDBCConnection getJDBCConnection() {
		return xmlJDBCConnection;
	}

	public void setXMLJDBCConnection(XMLJDBCConnection xmlJDBCConnection) {
		this.xmlJDBCConnection = xmlJDBCConnection;
	}
}
