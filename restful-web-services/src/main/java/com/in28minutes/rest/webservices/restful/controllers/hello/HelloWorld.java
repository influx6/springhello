package com.in28minutes.rest.webservices.restful.controllers.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorld {

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method= RequestMethod.GET, path="/hello-world")
	public String Hello(){
		return "Hello World!";
	}

	@RequestMapping(method= RequestMethod.GET, path="/hello-world-intl")
	public String HelloIntl(){
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}

	@RequestMapping(method= RequestMethod.GET, path="/hello-world-bean")
	public HelloWorldBean HelloBean(){
		return new HelloWorldBean("Welcome to bean world!");
	}

	@RequestMapping(method= RequestMethod.GET, path="/hello-world-bean/{name}")
	public HelloWorldBean HelloBean(@PathVariable String name){
		return new HelloWorldBean(String.format("Welcome to bean world %s!", name));
	}
}

class HelloWorldBean  {
	private String message;

	HelloWorldBean(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean{" +
				"message='" + message + '\'' +
				'}';
	}

}