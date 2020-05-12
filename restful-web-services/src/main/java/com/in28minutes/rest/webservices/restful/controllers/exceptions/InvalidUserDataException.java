package com.in28minutes.rest.webservices.restful.controllers.exceptions;

import com.in28minutes.rest.webservices.restful.controllers.users.User;

public class InvalidUserDataException extends Exception {
  private Integer id;
  private User invalidUser;

  public InvalidUserDataException(Integer id, User user) {
  	super();
    this.id = id;
    this.invalidUser = user;
  }

  public String getMessage() {
    return toString();
  }

  @Override
  public String toString() {
    return "InvalidUserDataException{" +
            "id=" + id +
            ", invalidUser=" + invalidUser +
            '}';
  }
}
