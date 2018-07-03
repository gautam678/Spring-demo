package com.example.demo.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	@Autowired
	UserDAO userservice;

	@GetMapping("/users")
	public List<User> getUsers() {
		return userservice.getusers();
	}

	@GetMapping("/users/{id}")
	public User getOneUsers(@PathVariable int id) {
		return userservice.getOneUser(id);
	}

	@DeleteMapping("/users/{id}")
	public User getUsers(@PathVariable int id) {
		return userservice.deleteUser(id);
	}

	@PostMapping("/users")
	public ResponseEntity<Object> postUser(@RequestBody User user) {
		User savedUser = userservice.setUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

}
