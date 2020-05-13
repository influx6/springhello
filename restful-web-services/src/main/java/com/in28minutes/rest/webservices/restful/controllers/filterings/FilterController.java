package com.in28minutes.rest.webservices.restful.controllers.filterings;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		// Lets do dynamic filtering.
		SomeBean someBean = new SomeBean("name", "address", "phone-password");
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "address");
		FilterProvider filter = new SimpleFilterProvider().addFilter("SomeBean", propertyFilter);
		mapping.setFilters(filter);
		return mapping;
	}

	@GetMapping("/filtering-no-address")
	public MappingJacksonValue retrieveSomeBeanWithNoAddress() {
		// Lets do dynamic filtering.
		SomeBean someBean = new SomeBean("name", "address", "phone-password");
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter propertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "phonePassword");
		FilterProvider filter = new SimpleFilterProvider().addFilter("SomeBean", propertyFilter);
		mapping.setFilters(filter);
		return mapping;
	}

}
