package com.api_test_for_hospital.hospital_api.Person;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

import jakarta.annotation.Resource;
@Repository
@SpringBootApplication
public class PersonRegistry {
    //note: registry/repository supposed to have database. but I didn't make it yet.
    //just initializing
    List<Person> ps=new ArrayList<>();
	Person p1=new Person(1193300,"saleh",true,"0527083059","10/11/2000","Kofar Akab");
	public PersonRegistry(){
		ps.add(p1);
	}

}
