package com.in28minutes.rest.webservices.restful.controllers.versioing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Samples of ways to do versioning
// 1. Using url
// 2. Using parameter
// 3. Using headers
// 4. Using producers
public class VersionController {

	// So send request to url: /v1/person
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Bob Charlie");
	}

	// So send request to url: /v2/person
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	// So send request to url: /person/param?version=1
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Bob Charlie");
	}

	// So send request to url: /person/param?version=2
	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	// So send request to url: /person/header and set header X-API-VERSION=1
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Bob Charlie");
	}

	// So send request to url: /person/header and set header X-API-VERSION=2
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	// So send request to url: /person/produces and set header Accepts=application/vnd.company.app-v1+json
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Bob Charlie");
	}

	// So send request to url: /person/produces and set header Accepts=application/vnd.company.app-v2+json
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

  private class PersonV1 {
    public PersonV1(String bob_charlie) {}
  }

  private class PersonV2 {
    public PersonV2(Name name) {}
  }

  private class Name {
    public Name(String bob, String charlie) {}
  }
}