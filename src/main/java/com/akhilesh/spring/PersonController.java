package com.akhilesh.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@Autowired
	private Person person;
	
	@RequestMapping("/")
	public String healthCheck() {
		return "Welcome Spring Boot Rest Application";
	}
	
	@RequestMapping("/person/get")
	public Person getPerson(@RequestParam(name="name", required=false, defaultValue="Unknown") String name) {
		person.setName(name);
		return person;
	}
	

	@RequestMapping(value="/person/update", method=RequestMethod.POST, consumes = "application/json")
	public Person updatePerson(@RequestBody Person p) {
		person.setName(p.getName());
		return person;
	}
}
