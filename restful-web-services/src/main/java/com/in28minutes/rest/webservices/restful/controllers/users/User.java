package com.in28minutes.rest.webservices.restful.controllers.users;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@ApiModel(description = "User modal for user accounts")
@NamedQuery(name="find_all_users", query="select u from User u")
public class User {
	public final static String[] uniqueColumns = new String[] {"name"};

	@Id
	@GeneratedValue(generator = "users_id_sequence", strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@NotNull
	@Size(min=2, message = "Name should have atleast 2 characters")
	@Column(unique=true)
	@ApiModelProperty(notes="Name must be atleast 2 characters")
	private String name;

	@Past
	@ApiModelProperty(notes="Birthday can not be in the past")
	private Date birthDate;

	public User(){
		super();
	}

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public boolean hasId() {
		return id != null;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean hasName() {
		return name != "" && name != null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean hasBirthDate() {
		return birthDate != null;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", birthDate=" + birthDate +
				'}';
	}
}
