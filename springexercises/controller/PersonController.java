package com.natwest.springexercises.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.natwest.springexercises.domain.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//VERSION UPDATES:
//               ver1.1.2 7th JULY:  Formatted notes, tested full system   				
//       		 ver1.1.1 7th JULY:  Implement ResponseEntity into the PersonController Class
//		         ver1.1.0 6th JULY:  Create instructions + Create the Class / Model

//TASKS:
//		1.  Get to the bottom of the {index} duplication / global thing SAV mentioned, you don't understand it
//		2.  Complete definitions
//      3.  Improve notes formatting 
//      4.  Replicate across other controllers within this Project
//      5.  Get to the bottom of PUBLIC / PRIVATE bits at the start of CLASS' and INSTANCES and update code + definitions

//NOTES: 
//     Follow Structure of Setup Guide and Controller Notes 
//     To import everything requiring an import - CTRL+ SHIFT+ O
//     If you duplicate MAPPING eg. /test between TestController and PersonController
//     the CONSOLE will show you the issue, SPRING doesn't like it so change the name to (n1)
//	   C of CRUD - Create
//     When we import a @RequestBody it is used as a mechanism to help with language
//	   translation from JSON to JAVA and locates the relevant article
//	   R of CRUD - Read
//	   @GetMapping to retrieve the data, we want to return the same as we request so its LIST LIST
//     Instructions to implement a ResponseEntity in the correct format
//	   		1.  wrap the method in a response entity first, the DATA is going to stay the same
//	   		2.  then the BODY which i will specify
//			3.  then the status code
//     D of CRUD - Delete
//	   {Index} is the bit which changes each time the method is used and updates the URL
//	   @DeleteMapping("/removePerson/{index}") 

//DEFINITIONS:
//	   @RestController
//	   @RequestBody
//	   @GetMapping
//     @PostMapping
//     @PutMapping is to replace completely
//	   @PatchMapping is a partial update and works just about the same

//EXAMPLES:
//		  1.  The example below of @PutMapping is an alternative to @PatchMapping which I used within U of CRUD in this class
//		  @PutMapping("/replace/{index}")
// 		  public Person updateReplace(@Path Variable int index, @RequestBody Person newHuman)
//        	this.people.set(index, newHuman);
// 			return newHuman;

//INSTRUCTIONS: 
//            1.  We need to create a list - List<Person> people = new ArrayList<>(); Named Person
//			  2.  Always set @RestController above public class
//			  3.  Go through CRUD functionality
//			  4.  Update the code with ResponseEntity and change methods to suit

@RestController
public class PersonController {

	List<Person> people = new ArrayList<>();

	@GetMapping("/persontest")
	public String personTest() {
		return "This person is here!";
	}

// C of CRUD - Create

	@PostMapping("/createPerson")
	public ResponseEntity<String> createPerson(@RequestBody Person human) {
		this.people.add(human);
		return new ResponseEntity<String>("Succesfully added a human", HttpStatus.CREATED);
	}

// R of CRUD - Read

	@GetMapping("/readPeople")
	public ResponseEntity<List<Person>> readPeople() {
		return ResponseEntity.ok(this.people);
	}

// U of CRUD - Update	

	@PatchMapping("/updatePerson/{index}")
	public ResponseEntity<Person> updatePerson(@PathVariable int index, @RequestBody Person newPerson) {
		this.people.set(index, newPerson);
		return new ResponseEntity<Person>(this.people.set(index, newPerson), HttpStatus.ACCEPTED);

	}

//  D of CRUD - Delete	

	@DeleteMapping("/removePerson/{index}")
	public ResponseEntity<Person> removePerson(@PathVariable int index) {
		return new ResponseEntity<Person>(this.people.remove(index), HttpStatus.NO_CONTENT);

	}

}
