package com.spring.aophello.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataDOA1 {
	public String retrieveSomething(){
		return "DOA1";
	}
	public void throwSomeError() throws Error {
		throw new Error();
	}
}
