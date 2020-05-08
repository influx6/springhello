package com.spring.aophello.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataDOA2 {
	public String retrieveSomething(){
		return "DOA2";
	}
	public void throwSomeError() throws Error {
		throw new Error();
	}
}
