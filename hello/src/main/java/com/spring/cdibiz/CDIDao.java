package com.spring.cdibiz;

import javax.inject.Named;

@Named
public class CDIDao {
	public int[] getData() {
		return new int[] { 10, 20, 30};
	}
}
