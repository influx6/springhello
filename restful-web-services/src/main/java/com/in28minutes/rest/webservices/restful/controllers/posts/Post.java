package com.in28minutes.rest.webservices.restful.controllers.posts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.in28minutes.rest.webservices.restful.controllers.users.User;
import io.swagger.annotations.ApiModel;
import lombok.Generated;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@ApiModel(description = "Post modal for user's posts")
public class Post {
	@Id
	@GeneratedValue(generator = "posts_id_sequence", strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;

	@Size(min=3, message = "Content should have atleast 2 characters")
	private String content;

	public Post(){}

	public Post(Integer id, Date postDate, String content){
		this.id = id;
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Post{" +
				"id=" + id +
				", content='" + content + '\'' +
				'}';
	}

	@JsonIgnore
	public boolean isValid() {
		return content != null && !content.isEmpty();
	}
}
