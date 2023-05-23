package com.api_test_for_hospital.hospital_api.Person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@SpringBootApplication
public class PersonController {
	private final PersonServices personServices; 

	@Autowired
    public PersonController(PersonServices personServices){
        this.personServices=personServices;
    }
	//get all
	@GetMapping("api/getPersons")
	public List<Person> getPersons(){
		return personServices.getPersons();
		
	}
	//adding
	@PostMapping("api/addPerson")
	public String addPerson(@RequestBody Person person){
		try{
		personServices.addPerson(person);
		return ("Added Person Succefully");
		}catch(Exception e){
		return "There was error adding that person";
		}
	}
	//deleting
	@DeleteMapping("api/deletePerson/{id}")
	public String deletePerson(@PathVariable("id") int id){
		try{
		personServices.deletePerson(id);
		return "person deleted succefully";
		}catch(Exception e){
			return "There was error deleting that person";
		}
	}
	//get specific by id
	@GetMapping("api/getPerson/{id}")
		public Optional<Person> getPersonById(@PathVariable("id") int id){
		return personServices.getPersonById(id);
	}
	//changing name
	@PutMapping("api/changeName/{id}/{name}")
	public String changeName(@PathVariable("id") int id,@PathVariable("name") String name){
		try{
			personServices.changeName(id,name);
		return ("Name changed Succefully");
		}catch(Exception e){
			return ("There's no such ID");
		}
	}
}
