package com.in28minutes.rest.webservices.restful.controllers.filterings;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeBean")
class SomeBean {
	private String name;
	private String address;

	// Only use below annotation if you want to set a static filter
	// @JsonIgnore
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
