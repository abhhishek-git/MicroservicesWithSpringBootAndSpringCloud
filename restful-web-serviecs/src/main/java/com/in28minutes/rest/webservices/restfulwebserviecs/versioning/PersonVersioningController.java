package com.in28minutes.rest.webservices.restfulwebserviecs.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	
	
	@GetMapping("v1/person")
	public PersonV1  personV1() {
		return new PersonV1("Rahul Dravid");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("Brian", "Lara"));
	}
	
	@GetMapping(value="person/param", params = "version=1")
	public PersonV1  paramV1() {
		return new PersonV1("Rahul Dravid");
	}
	
	@GetMapping(value="person/param", params ="version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("Brian", "Lara"));
	}
	
	
	@GetMapping(value="person/header", headers = "X-API-VERSION=1")
	public PersonV1  headerV1() {
		return new PersonV1("Rahul Dravid");
	}
	
	@GetMapping(value="person/header", headers  ="X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("Brian", "Lara"));
	}

	
	@GetMapping(value="person/produces", produces = "application/vnd.company.appV1+json")
	public PersonV1  producesV1() {
		return new PersonV1("Rahul Dravid");
	}
	
	@GetMapping(value="person/produces", produces  ="application/vnd.company.appV2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("Brian", "Lara"));
	}
}
