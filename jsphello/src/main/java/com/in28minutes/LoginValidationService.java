package com.in28minutes;

public class LoginValidationService {
	public boolean isValid(String user, String password) {
		if (user.equals("alex") && password.equals("who")) {
			return true;
		}
		return false;
	}
}
