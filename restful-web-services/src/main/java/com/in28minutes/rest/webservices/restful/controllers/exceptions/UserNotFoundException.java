package com.in28minutes.rest.webservices.restful.controllers.exceptions;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message) {
    super(message);
  }

  public UserNotFoundException(Integer id){
    super(String.format("Id: %s", id));
  }
}
