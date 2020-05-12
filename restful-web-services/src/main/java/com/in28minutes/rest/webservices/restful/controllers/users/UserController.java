package com.in28minutes.rest.webservices.restful.controllers.users;

import com.in28minutes.rest.webservices.restful.controllers.exceptions.InvalidNewUserDataException;
import com.in28minutes.rest.webservices.restful.controllers.exceptions.InvalidUserDataException;
import com.in28minutes.rest.webservices.restful.controllers.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.*;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	UserRepository userRepository;

	public UserController(){}

	@RequestMapping(path="/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		List<User> allUsers = userRepository.findAll();
		return ResponseEntity.ok().body(allUsers);
	}

	@RequestMapping(path="/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<EntityModel<User>> getUser(@PathVariable("id") Integer id) throws Exception {
		User user = userRepository.findById(id);
		if (user == null) {
			throw new UserNotFoundException(String.format("id: %s", id));
		}

		// Transform into a HATEOS response.
		WebMvcLinkBuilder getUsersURL = linkTo(methodOn(this.getClass()).getUsers());
		EntityModel<User> userResource = new EntityModel<User>(user);
		userResource.add(getUsersURL.withRel("all-users"));
		return ResponseEntity.ok(userResource);
	}

	@RequestMapping(path="/users", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws Exception {
		if (!user.hasName() || !user.hasBirthDate()) {
			throw new InvalidNewUserDataException(user);
		}

		User savedUser = userRepository.insertUser(user);
		URI savedUserURI = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(savedUserURI).body(savedUser);
	}

	@RequestMapping(path="/users/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @Valid @RequestBody User user) throws Exception {
		User targetUser = userRepository.findById(id);
		if (targetUser == null) {
			throw new UserNotFoundException(id);
		}

		if (!user.hasName() && !user.hasBirthDate()) {
			throw new InvalidUserDataException(id, user);
		}

		if (user.hasBirthDate()) {
			targetUser.setBirthDate(user.getBirthDate());
		}

		if (user.hasName()) {
			targetUser.setName(user.getName());
		}

		User updatedUser = userRepository.updateUser(targetUser);
		return ResponseEntity.accepted().body(updatedUser);
	}

	@RequestMapping(path="/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteUser(@PathVariable("id") Integer id) throws Exception {
		userRepository.removeUserById(id);
		return ResponseEntity.noContent().build();
	}
}
