package com.api_test_for_hospital.hospital_api.Person;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Service
@SpringBootApplication
public class PersonServices {
	private final PersonRegistry personRegistry; 
	@Autowired
    public PersonServices(PersonRegistry personRegistry){
        this.personRegistry=personRegistry;
    }
    public List<Person> getPersons(){
		//get all
		return personRegistry.ps;
	}
	public void addPerson(Person px){
		//add if info is right (try and catch before checks)
		personRegistry.ps.add(px);
	}
	public void deletePerson(int id){
		//remove if object exists (try and catch before checks)
		personRegistry.ps.removeIf(p -> p.getId() == id);
	}
	public Optional<Person> getPersonById(int id){
		//find by id if exists
		Optional<Person> p=personRegistry.ps.stream().filter(person -> person.getId() == id).findAny();
		return p;
	}
	public void changeName(int id,String name){
		Optional<Person> po=personRegistry.ps.stream().filter(person -> person.getId() == id).findAny();
		Person p=po.orElse(null);
		p.setName(name);
	}

	
}
