package com.in28minutes.rest.webservices.restfulwebserviecs.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	//dynamic filtering: field1 & field2
	@GetMapping("/filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBean someBean = new SomeBean("valeue1", "value2","value3");

		FilterProvider filters = extracted("field1", "field2");
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	//dynamic filtering : field2 & field3
	@GetMapping("/filtering-list")
	public MappingJacksonValue retrieveListOfSomeBeans() {
		List<SomeBean> list = Arrays.asList(new SomeBean("valeue1", "value2","value3"),
				new SomeBean("valeue11", "value22","value33"));

		FilterProvider filters = extracted("field2", "field3");

		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		
		return mapping;
	}

	private FilterProvider extracted(String string1, String string2) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(string1, string2);
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		return filters;
	}
}
