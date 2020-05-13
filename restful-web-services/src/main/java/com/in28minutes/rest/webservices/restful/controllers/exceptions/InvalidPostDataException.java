package com.in28minutes.rest.webservices.restful.controllers.exceptions;

import com.in28minutes.rest.webservices.restful.controllers.posts.Post;
import com.in28minutes.rest.webservices.restful.controllers.users.User;

public class InvalidPostDataException extends Exception {
  private Post post;

  public InvalidPostDataException(Post post) {
  	super();
    this.post = post;
  }

  public String getMessage() {
    return toString();
  }

  @Override
  public String toString() {
    return "InvalidUserDataException{" +
            ", post=" + post +
            '}';
  }
}
