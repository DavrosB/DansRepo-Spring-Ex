package com.natwest.springexercises.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natwest.springexercises.domain.Car;

//---------------REPO CLASS--------------------------------------------------------------------//

//VERSION UPDATES:
//				 1.0.1 Cleaned up NOTES added GLOSSARY and looked for FU1 errors
//               1.0.0 Created this class and added Notes discovered FU1			

//TASKS:
//				1. Everything is up to date and now we just need to hook it up to a database apparently :D

//NOTES: 
//   

//GLOSSARY:
//		  @Service will contain the main business logic of the application and falls under CONTROLLERS 

//		  INVERSION OF CONTROL CONTAINER : Manages OBJECTS using MAINTAIN, CREATE AND DELETE

//		  @AutoWired is implemented into the CONTROLLER class to link the two together

//		  Dependency Injection - Something is in the beanbag, i need it, I'm gonna take out	

//		  @Id // PRIMARY KEY which is a part of a database, it allows this class to be used in conjunction with MYSQL by identifying a PRIMARY KEY

//		  @GeneratedValue(strategy = GenerationType.IDENTITY) // THIS will implement an auto increment feature for each new car entry

//		  @Id + @GenerateValue work together to auto increment and tag each entry into this newly created database

//		  @Entity is marking this CLASS as a table	

//		  @RestController - allocates this as something involving beans and potentially toast

//		  @PathVariable - DEFINITION / CONTEXT 

//		  @RequestBody - DEFINITION / CONTEXT

//		  @Autowired - NEED TO UNDERSTAND BETTERererer

//		  @RequestMapping - needs to go in underneath @RESTCONTROLLER
//		  if their is a duplication of MAPPING eg. [/test] + [/test]
//		  to fix this at the top of the file we need to insert @RequestMapping so it changes
//		  the URL and specify the prefix matches ("/Car") for example
//		  turns http://localhost:8080/test into http://localhost:8080/Car/test

//		  ResponseEntity - 

//		  @PatchMapping - 

//		  JpaRepository is full of all the functions we ever need, it inherits all the basic CRUD functionality

//EXAMPLES:
//	 

//INSTRUCTIONS: 
//  		  1. Implement the REPO as an interface to work with the database
//            2. REPO needs to be EXTENDED from 
// 				 JpaRpository<Car, Long>{
//				}

//  		  3. These bits happen as part of the REPO, but in the CAR (entity) class above the variables
//					@Id
//					@GeneratedValue(strategy = GenerationType.IDENTITY)
//
//					private Long id;

//  		  4. We use a file within srcmainresources and a file called application.properties within package manager

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {

}
