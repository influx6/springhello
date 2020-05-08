package com.spring.aophello.data;

import com.spring.aophello.aspects.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataDOA2 {

	@TrackTime
	public String retrieveSomething(){
		return "DOA2";
	}
	public void throwSomeError() throws Error {
		throw new Error();
	}
}
