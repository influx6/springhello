package com.in28minutes.rest.webservices.restful.controllers.users;

import com.in28minutes.rest.webservices.restful.controllers.exceptions.InvalidNewUserDataException;
import com.in28minutes.rest.webservices.restful.controllers.exceptions.InvalidPostDataException;
import com.in28minutes.rest.webservices.restful.controllers.exceptions.InvalidUserDataException;
import com.in28minutes.rest.webservices.restful.controllers.exceptions.UserNotFoundException;
import com.in28minutes.rest.webservices.restful.controllers.posts.Post;
import com.in28minutes.rest.webservices.restful.controllers.posts.PostRepository;
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
import java.util.Optional;

@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PostRepository postRepository;

	@RequestMapping(path="/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		List<User> allUsers = userRepository.findAll();
		return ResponseEntity.ok().body(allUsers);
	}

	@RequestMapping(path="/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<EntityModel<User>> getUser(@PathVariable("id") Integer id) throws Exception {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException(String.format("id: %s", id));
		}

		// Transform into a HATEOS response.
		WebMvcLinkBuilder getUsersURL = linkTo(methodOn(this.getClass()).getUsers());
		WebMvcLinkBuilder getPostsURL = linkTo(methodOn(this.getClass()).getUserPosts(id));
		EntityModel<User> userResource = new EntityModel<User>(user.get());
		userResource.add(getUsersURL.withRel("all-users"));
		userResource.add(getPostsURL.withRel("user-posts"));
		return ResponseEntity.ok(userResource);
	}

	@RequestMapping(path="/users/posts/{id}", method = RequestMethod.GET)
	public ResponseEntity<EntityModel<Post>> getPost(@PathVariable("id") Integer id) throws Exception {
		Optional<Post> post = postRepository.findById(id);
		if (!post.isPresent()) {
			throw new UserNotFoundException(String.format("id: %s", id));
		}

		// Transform into a HATEOS response.
		WebMvcLinkBuilder getPostsURL = linkTo(methodOn(this.getClass()).getUserPosts(id));
		EntityModel<Post> postResource = new EntityModel<Post>(post.get());
		postResource.add(getPostsURL.withRel("posts"));
		return ResponseEntity.ok(postResource);
	}

	@RequestMapping(path="/users/{id}/posts", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> getUserPosts(@PathVariable("id") Integer id) throws Exception {
		Optional<User> retrievedUser = userRepository.findById(id);
		if (!retrievedUser.isPresent()) {
			throw new UserNotFoundException(String.format("id: %s", id));
		}

		User user = retrievedUser.get();
		return ResponseEntity.ok(user.getPosts());
	}

	@RequestMapping(path="/users", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws Exception {
		if (!user.isValid()) {
			throw new InvalidNewUserDataException(user);
		}

		User savedUser = userRepository.save(user);
		URI savedUserURI = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(savedUserURI).body(savedUser);
	}

	@RequestMapping(path="/users/{id}/posts", method = RequestMethod.POST)
	public ResponseEntity<Post> createPost(@PathVariable("id") Integer id, @Valid @RequestBody Post post) throws Exception {
		Optional<User> retrievedUser = userRepository.findById(id);
		if (!retrievedUser.isPresent()) {
			throw new UserNotFoundException(String.format("id: %s", id));
		}

		User user = retrievedUser.get();
		if (!post.isValid()) {
			throw new InvalidPostDataException(post);
		}

		post.setUser(user);

		Post savedPost = postRepository.save(post);
		URI savedUserURI = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/posts/{id}")
				.buildAndExpand(post.getId())
				.toUri();
		return ResponseEntity.created(savedUserURI).body(savedPost);
	}

	@RequestMapping(path="/users/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @Valid @RequestBody User user) throws Exception {
		Optional<User> targetUser = userRepository.findById(id);
		if (!targetUser.isPresent()) {
			throw new UserNotFoundException(id);
		}

		if (!user.hasName() && !user.hasBirthDate()) {
			throw new InvalidUserDataException(id, user);
		}

		User userToBeUpdated = targetUser.get();
		if (user.hasBirthDate()) {
			userToBeUpdated.setBirthDate(user.getBirthDate());
		}

		if (user.hasName()) {
			userToBeUpdated.setName(user.getName());
		}

		User updatedUser = userRepository.save(userToBeUpdated);
		return ResponseEntity.accepted().body(updatedUser);
	}

	@RequestMapping(path="/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteUser(@PathVariable("id") Integer id) throws Exception {
		Optional<User> targetUser = userRepository.findById(id);
		if (!targetUser.isPresent()) {
			throw new UserNotFoundException(id);
		}

		userRepository.delete(targetUser.get());
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(path="/users/posts/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deletePost(@PathVariable("id") Integer id) throws Exception {
		Optional<Post> targetPost = postRepository.findById(id);
		if (!targetPost.isPresent()) {
			throw new UserNotFoundException(id);
		}

		postRepository.delete(targetPost.get());
		return ResponseEntity.noContent().build();
	}
}
