package com.in28minutes.rest.webservices.restfulwebserviecs.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.rest.webservices.restfulwebserviecs.helloworld.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	@GetMapping( path ="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	//hello world bean
	@GetMapping( path ="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World Bean");
	}
	
	@GetMapping( path ="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}

}
