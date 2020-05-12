package com.in28minutes.rest.webservices.restful.controllers.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<User, Integer>{}

