package com.in28minutes.rest.webservices.restfulwebserviecs.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class UserJPAResource {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		Optional<User> optionalUser = userRepository.findById(id);
		
		if(!optionalUser.isPresent()) {
			throw new UserNotFoundException("id - "+id);
		}
		
		//HATEOAS
		Resource<User> resource = new Resource<User>(optionalUser.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel(("all-users-link")));
		
		return resource;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);
		URI uri = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId())
		.toUri();
		
		return ResponseEntity.created(uri ).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public User deleteUser(@PathVariable int id) {
		User user = userDaoService.deleteById(id);
		if(user==null) {
			throw new UserNotFoundException("id - "+id);
		}
		return user;
	}
	
	
}
