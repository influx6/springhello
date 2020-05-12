package com.in28minutes.rest.webservices.restful.controllers.exceptions;

import com.in28minutes.rest.webservices.restful.controllers.users.User;

public class InvalidNewUserDataException extends Exception {
  private User invalidUser;

  public InvalidNewUserDataException(User user) {
  	super();
    this.invalidUser = user;
  }

  public String getMessage() {
    return toString();
  }

  @Override
  public String toString() {
    return "InvalidUserDataException{" +
            "invalidUser=" + invalidUser +
            '}';
  }
}
