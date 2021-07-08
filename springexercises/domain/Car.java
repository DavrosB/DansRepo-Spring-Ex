package com.natwest.springexercises.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//----------------Entity Class--------------------------------------------------------------------------------------------------------------//

//VERSION UPDATES:
//				1.0.3 Updated Notes, checked through for any missing parts leading to FU1
//				1.0.2 ADDED THE GENERIC PUBLIC DEFAULT CLASS, no idea why i left it out but it stopped stuff working on H2 CONSOLE output test FU1
//				1.0.1 Tidied up and added TASK 2
//				1.0.0 Created and added notes 	               				

//TASKS:
//	  1. 8TH JULY - we are going to be converting this DOMAIN class into an entity
//    2. Research SERVER SIDE constraints within BEAN VALIDATION module on SPRING BEAN VALIDATION - will help with next week

//NOTES: 
//    As we have changed from an ARRAYList environment to a Database the entries start at 1 not 0 from now on

//GLOSSARY:
//			@Id // PRIMARY KEY which is a part of a database, it allows this class to be used in conjunction with MYSQL by identifying a PRIMARY KEY

//			@GeneratedValue(strategy = GenerationType.IDENTITY) // THIS will implement an auto increment feature for each new car entry

//			@Id + @GenerateValue work together to auto increment and tag each entry into this newly created database

//			@Entity is marking this CLASS as a table	

//			@RestController - allocates this as something involving beans and potentially toast

//			@PathVariable - DEFINITION / CONTEXT 

//			@RequestBody - DEFINITION / CONTEXT

//			@Autowired - NEED TO UNDERSTAND BETTERererer

//			@RequestMapping - needs to go in underneath @RESTCONTROLLER
// 				if their is a duplication of MAPPING eg. [/test] + [/test]
// 				to fix this at the top of the file we need to insert @RequestMapping so it changes
// 				the URL and specify the prefix matches ("/Car") for example
// 				turns http://localhost:8080/test into http://localhost:8080/Car/test

//			ResponseEntity - 

//			@PatchMapping - 

//EXAMPLES:
//	 

//INSTRUCTIONS: 
        
//			1. Create associated classes off DOMAIN package called CAR
//			2. Start in the car class with variables / methods / getters and setters
//			3. Variables:  private String Manufacturer; private String Model; private double  engine; private boolean neons; <- remember the returns and then add getters and setters!
//			4. Right click source getters and setters, select all fields
//			5. Next is the constructor: public Car(String manufacturer String model, int engine, boolean spoiler)
//	        6. this.make = make; etc
// 			7. need to import from javax.persistence and select it manually from the first choice

@Entity
public class Car {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String make;
	private String model;
	private double engine;
	private int funRating;

	public Car() {
		
	}
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getEngine() {
		return engine;
	}

	public void setEngine(double engine) {
		this.engine = engine;
	}

	public int isFunRating() {
		return funRating;
	}

	public void setFunRating(int funRating) {
		this.funRating = funRating;
	}

	public Car(String make, String model, double engine, int funRating) {
		super();
		this.make = make;
		this.model = model;
		this.engine = engine;
		this.funRating = funRating;
	}
		
}
