package com.natwest.springexercises.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.springexercises.domain.Dog;

//CONTROLLER CLASS

//VERSION UPDATES:
//                1.0.1  Implementing the framework for CONTROLLER during rework				
//     		 
//		         

//TASKS:
//  1.  Update DogController to have the most up to date features I am able to code
//  2.  Get to the bottom of DEFINITIONS and commit to memory
//  3.  Start getting better at GitHub updates and loads etc
//  4.  Use this example once complete to practice with versionning / branches and experimentation using GitHub
//  5.  Write some code without looking at this to build on it, implement using the correct model

//NOTES: 
// 
//      
//     

//DEFINITIONS:
//
//
//	

//EXAMPLES:
//	 
//	 
//	 

//INSTRUCTIONS: 
//			  Step by Step							
//            1. Set the controller @RestController 
//	          2. Create an array for us with this exercise, its a placeholder for a real database
//	          3. Test the system with a message through localhost web address
//	          4.  


@RestController	
public class DogController {
	
	List<Dog> dogs = new ArrayList<>();

@GetMapping("/test2")
	public String dogTest() {
	return "This dog is here!";
}

//  Step 4: C of CRUD - Create
//  When we import a @RequestBody it is used as a mechanism to help with language
//  translation from JSON to JAVA and locates the relevant article

@PostMapping("/createDog")
	public String createDog(@RequestBody Dog doggo) {
		this.dogs.add(doggo);
		return "Succesfully added a dog!";
	}

//  Step 5: R of CRUD - Read
//  @GetMapping to retrieve the data, we want to return the same as we request so its LIST LIST

@GetMapping("/readDogs")
	public List<Dog> readDogs() {
		return this.dogs;
	}

//  Step 6: U of CRUD - Update		
//  @PutMapping is to replace completely

@PatchMapping("/replace1/{index}")
	public Dog updateDog(@PathVariable int index, @RequestBody Dog newDog) { 
		 this.dogs.set(index, newDog);
		 return newDog;	
	}
	
//  Step 7: D of CRUD - Delete
//  Index is the bit which changes each time the method is used and updates the URL

@DeleteMapping("/removeDog/{index}") 
public Dog removeDog(@PathVariable int index) {
	return this.dogs.remove(index);

	}
}
