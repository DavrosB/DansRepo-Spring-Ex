package com.natwest.springexercises.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.natwest.springexercises.domain.Car;
import com.natwest.springexercises.repo.CarRepo;

//------------------------DATABASE SERVICE CLASS-----------------------------//

//VERSION UPDATES:
//               1.0.1 Quick run through checking for obvious errors in UPDATE and general formatting
//             	 1.0.0 Made this class to communicate with and work in conjunction with CarRepo

//TASKS:
//	   1. Need to fix the UPDATE element
//	   2. Clear notes up into instructions / examples etc.
//	   3. Rewatch PROCESS video 8th July and fill in INSTRUCTIONS blanks and try to hunt down FU1

//NOTES: 
//	   We moved the LOGIC from controller into SERVICE as per model.  We spent time learning the first method
//     so it was simple and then got rid of ARRAYS all together when DATABASES are introduced :/
  
//	   This service CarServiceDB is to represent us working with a DATABASE now and REPLACES CarServiceList which USES ARRAYS (AKA WASTE OF TIME)
//	   first thing we do with any SERVICE class... input @Service
//	   @Service depends on REPO, to fit the model we need to implement @Autowired because it links back to CarRepo

//	   We need to set the DEPENDENCY, @Autowired links the two of them together in conjunction with the BEANBAG
//	   state what you are depending on, then use it in the constructor

//	   We need to call the methods which already exist elsewhere, CRUD needs a remodel into here

// 		Short Cut:  You can copy each method over from CAR CONTROLLER to here, removing all the PERSONALISED elements
//					from how it is written in the CAR CONTROLLER class
//		For example:

//			Create
//				public String createCar(Car c) {
//					this.vehicles.add(c);
//					return "Successfully added car";
//				}
//			Read
//				public List<Car> getAllCars() {
//					return this.vehicles;
//				}
//			Update
//				public Car updateCar(int index, Car newCar) {
//					this.vehicles.set(index, newCar);
//					return newCar;
//				}
//			Delete
//				public void removeCar(int index) {
//					this.vehicles.remove(index);
//				}

//GLOSSARY:
//		 @Service will contain the main business logic of the application and falls under CONTROLLERS 

//       INVERSION OF CONTROL CONTAINER : Manages OBJECTS using MAINTAIN, CREATE AND DELETE

//		@AutoWired is implemented into the CONTROLLER class to link the two together

//		Dependency Injection - Something is in the beanbag, i need it, I'm gonna take out	

//		@Id // PRIMARY KEY which is a part of a database, it allows this class to be used in conjunction with MYSQL by identifying a PRIMARY KEY

//		@GeneratedValue(strategy = GenerationType.IDENTITY) // THIS will implement an auto increment feature for each new car entry

//		@Id + @GenerateValue work together to auto increment and tag each entry into this newly created database

//		@Entity is marking this CLASS as a table	

//		@RestController - allocates this as something involving beans and potentially toast

//		@PathVariable - DEFINITION / CONTEXT 

//		@RequestBody - DEFINITION / CONTEXT

//		@Autowired - NEED TO UNDERSTAND BETTERererer

//		@RequestMapping - needs to go in underneath @RESTCONTROLLER
//			if their is a duplication of MAPPING eg. [/test] + [/test]
//			to fix this at the top of the file we need to insert @RequestMapping so it changes
//			the URL and specify the prefix matches ("/Car") for example
//			turns http://localhost:8080/test into http://localhost:8080/Car/test

//		ResponseEntity - 

//		@PatchMapping - 

//EXAMPLES:
//	 

//INSTRUCTIONS: 
//			 @RestController is currently performing more than one function, we need the Car<list> in here
//			 COPY and PASTED this into here from CarController - List<Car> vehicles = new ArrayList<>();
//			 Because of the above we need METHODS TO MANIPULATE THE LIST
//			 We need a method to CREATE A METHOD TO THE LIST IN HERE, and the same following for all CRUD



@Service
public class CarServiceDB {

private CarRepo repo;	
	
@Autowired
public CarServiceDB(CarRepo repo) {
	this.repo = repo;
}
	
// 	C
//  We are changing this here to use a DATABASE and create a method to add
//  Need a definition of saveAndFlush

	public String createCar(Car c) {
		this.repo.saveAndFlush(c);
		return "Successfully added Car to REPO!";
}
//	R
	
	public List<Car> getAllCars() {
		return this.repo.findAll();
	}
	
//  U
//  We need a method to replace an existing entry in the database	
// 	for the second line we need to get the existing vehicle

//	public Car updateCar(Long id, Car newCar) {
//		Car existing = this.repo.findById(id);
//	}

//  D
//  A method to remove a car from the DB 
	
	public void removeCar(long index) {
		this.repo.deleteById(index);
	}


}
