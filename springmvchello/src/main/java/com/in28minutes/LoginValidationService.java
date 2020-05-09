package com.in28minutes;

import org.springframework.stereotype.Service;

@Service
public class LoginValidationService {
	public boolean validateUsernameAndPassword(String user, String password) {
		if (user.equals("alex") && password.equals("dummy")) {
			return false;
		}
		return true;
	}
}
