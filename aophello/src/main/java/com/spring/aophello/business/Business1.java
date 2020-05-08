package com.spring.aophello.business;

import com.spring.aophello.data.DataDOA1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business1 {
	@Autowired
	DataDOA1 doa1;

	public String calculateDOA(){
		return doa1.retrieveSomething();
	}

	public void handleThrowOfSomething(){
		try {
			doa1.throwSomeError();
		}catch(Error e){
			// do nothing
		}
	}
}
