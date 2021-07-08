package com.natwest.springexercises.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.springexercises.domain.Car;
import com.natwest.springexercises.service.CarServiceDB;

//---------------CONTROLLER CLASS-------------------------------------------------------------------------------//

//VERSION UPDATES:
//				 1.0.3 //out the UPDATE section as its fucked, it starts unravelling here possibly- added to tasks
//				 1.0.2 Fixed most of the fuck ups and implemented @Autowired, hooking up with REPO
//			     1.0.1 F.U.R, fix as TASK		
//               1.0.0 Updating this to same spec/VERSION as most advanced example				

//TASKS:
//	   X.  CREATE method to add CRUD functions to the new ArrayList
//     X.  We did edits in here moving the LOGIC from controller class into new domain SERVICE class
//    	   a USER doesn't see the difference, a developer does as this is following SOLID principles
//     X.  Update all the examples of domains to utilise the SERVICE model editing all methods and paths
//     X.  Get rid of PATCHMAPPING on update and change to PUTMAPPING to match SAV's examples
//     1.  Get a further breakdown of the RETURN NEW from someone to help with the build
//		   UPDATE journey isn't working, see METHOD as starting point, no working example for comparison and leads to other classes
//	   X.  FIX Update and red lines throughout	
//	   X.  @RequestMapping - needs to go in underneath @RESTCONTROLLER
//		   if their is a duplication of MAPPING eg. [/test] + [/test]
//		   to fix this at the top of the file we need to insert @RequestMapping so it changes
// 		   the URL and specify the prefix matches ("/Car") for example
// 		   turns http://localhost:8080/test into http://localhost:8080/Car/test
//	   X.  When we updated the CarServiceList to DB to implement we replaced all the mentions of LIST in here to DB
//	   2.  Update definitions within this example PROJECT, change definitions to GLOSSARY and update template / future projects
//	   3.  EXAMPLES 2/3/4 give us an option of updating individual elements of Car, they currently have a mash up of 
//		   @PutMapping + @PatchMapping code in there and won't work - worth fixing as a working example
//	   4.  Need to add a better example and description of METHOD CREATION on EXAMPLE 5

//NOTES: 
//   	When implementing AUTOWIRED we move the LIST over to CARSERVICELIST class to follow FEATURE BRANCH MODEL, this is then replaced by CarServiceDB class
//		when we shift to DB use vs. ArrayList (done as part of learning journey, not used again at all- delete all evidence)

//		REMEMBER > PostMapping/GetMapping etc need to be imported to each individual class.  Keep methods and functions together for instantiated objects

//		Still not hosted online fully and only stored within the BEANBAG created through SPRING.  This is running on a http://localhost:8080/h2-console, 
//		so anything created in POSTMAN deletes at end of session.  We will be hooking it up with a permanent DB home soon, hold tight homie
												
												// C - Create
												// R - Read
												// U - Update
												// D - Delete

//		All of these methods can be tested through a combination of POSTMAN and http://localhost.8080/"method name"
//		response entity confirms it is still wanting to return a string
//		return new ResponsEntity<string>("successfully added car",HttpStatus.CREATED);  
//		THIS is part of the RETURNBODY.  it is CREATED 201 as its successful.  There is a body of different HTTP STATUS returns 
//		which must be part of the Request/Return deal between back end user and database model
 
//GLOSSARY:
//		  @RestController - allocates this as something involving beans and potentially toast

//		  @PathVariable - DEFINITION / CONTEXT 

//		  @RequestBody - DEFINITION / CONTEXT

//		  @Autowired - NEED TO UNDERSTAND BETTERererer

//		  @RequestMapping - needs to go in underneath @RESTCONTROLLER
//		   if their is a duplication of MAPPING eg. [/test] + [/test]
//		   to fix this at the top of the file we need to insert @RequestMapping so it changes
//		   the URL and specify the prefix matches ("/Car") for example
//		   turns http://localhost:8080/test into http://localhost:8080/Car/test

//		  ResponseEntity - 

//		  @PatchMapping - 

//EXAMPLES:
// 		1. ALTERNATIVE SOLUTION:  return new ResponseEntity<List<Car>>(this.vehicles, HttpStatus.OK);  
//		which utilises BUILDER principal ie. build on old code, the .ok part is linking back with the BUILDER pattern.  		
//		If you want to do a specific response, anything other than OK then maybe use the longer method

//		2. This method replaces a whole object in a specific INDEX on the Vehicles List	
//		@PatchMapping("/updateCar/{index}")
//			public ResponseEntity updateCar(@PathVariable int index, @RequestBody Car newCar) {
//				return new this.service.updateCar(index, newCar); 
//		}	

//	 	3. ResponseEntity<Car>(this.service.updateCar(index, newCar), HttpStatus.ACCEPTED);

//		4.Second method of update example below, this method needs to be updating each individual aspect as a separate METHOD to follow SOLID 
//		Car oldCar = this.vehicles.get(index);
//			oldCar.setMake(newCar.getMake()); etc rinse and repeat for the different variables 

//      5.  METHOD CREATION: wrap the method in a response entity first, the DATA is going to stay the same
//		then the BODY which i will specify
//		then the status code

//INSTRUCTIONS: 
//          
//	      
//	       
//	

@RestController
@RequestMapping
public class CarController {

	private CarServiceDB service;

@Autowired
	private CarController(CarServiceDB service) {
		this.service = service;
	}

//C - This method below is creating a new instance of Car in the vehicles ArrayList

@PostMapping("/createCar")
	public ResponseEntity<String> createCar(@RequestBody Car c) {
		return new ResponseEntity<String>(this.service.createCar(c),HttpStatus.CREATED);
	}

// R - This method below is reading the data saved, returning all cars
// EXAMPLE 1: Fits here as an alternative in READ function

@GetMapping("/readCars")
	public  ResponseEntity <List<Car>> getAllCars() {
		return ResponseEntity.ok(this.service.getAllCars());
	}

// U - This method below is UPDATING the data saved.  Example of @PatchMapping within NOTES.  // Out at the moment because
// UPDATE: This isn't working across the classes, broken bit starts here potentially?!
//EXAMPLE 2/3/4: Fits in here somehow if I want to update individual aspects of Car 
	
//@PutMapping("/replace/{index}")
//	  public ResponseEntity <Car> updateCar(@PathVariable int index, @RequestBody Car newCar) {
//	  	return new ResponseEntity<Car>(this.service.updateCar(index, newCar), HttpStatus.ACCEPTED);
//	  }

// D - This method below is DELETING using INDEX and INT starting from 0

@DeleteMapping("/removeCar/{index}")
	public ResponseEntity<Car> removeCar(@PathVariable long index) {
		this.service.removeCar(index);
		return new ResponseEntity<Car>(HttpStatus.NO_CONTENT);
							
	}

}
