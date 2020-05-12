package com.in28minutes.rest.webservices.restful.controllers.filterings;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("name", "address", "phone-password");
	}

  private class SomeBean {
	  private String name;
	  private String address;

	  @JsonIgnore
	  private String phonePassword;

	  public SomeBean(String name, String address, String phonePassword) {
		  this.name = name;
		  this.address = address;
		  this.phonePassword = phonePassword;
	  }

	  public String getName() {
		  return name;
	  }

	  public String getAddress() {
		  return address;
	  }

	  public String getPhonePassword() {
		  return phonePassword;
	  }

	  public void setName(String name) {
		  this.name = name;
	  }

	  public void setAddress(String address) {
		  this.address = address;
	  }

	  public void setPhonePassword(String phonePassword) {
		  this.phonePassword = phonePassword;
	  }

  }
}
