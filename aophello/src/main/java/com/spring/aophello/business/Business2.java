package com.spring.aophello.business;

import com.spring.aophello.data.DataDOA2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Business2 {
	@Autowired
	DataDOA2 doa2;

	public void handleThrowOfSomething(){
		try {
			doa2.throwSomeError();
		}catch(Error e){
			// do nothing
			return;
		}
	}

	public String calculateDOA(){
		return doa2.retrieveSomething();
	}
}
