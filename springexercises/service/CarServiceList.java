package com.natwest.springexercises.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.natwest.springexercises.domain.Car;

//------------------------SERVICE CLASS-----------------------------//

//VERSION UPDATES:
//               THIS TYPE OF LIST IS GOING TO BE OBSOLETE AS WE WERE ONLY USING AN ARRAY LIST - NEVER GONNA HAPPEN
//				 IN THE REAL WORLD ITS ALL DATABASES

//TASKS:
//  

//NOTES: 
//    

//DEFINITIONS:
// 			@Service will contain the main business logic of the application and falls under CONTROLLERS 
//          INVERSION OF CONTROL CONTAINER : Manages OBJECTS using MAINTAIN, CREATE AND DELETE

//			@AutoWired is implemented into the CONTROLLER class to link the two together
//			Dependency Injection - Something is in the beanbag, i need it, I'm gonna take out	

//EXAMPLES:
//	 

//INSTRUCTIONS: 
//  		 @RestController is currently performing more than one function, we need the Car<list> in here
//			 COPY and PASTED this into here from CarController - List<Car> vehicles = new ArrayList<>();
//			 Because of the above we need METHODS TO MANIPULATE THE LIST
//			 We need a method to CREATE A METHOD TO THE LIST IN HERE, and the same following for all CRUD

//           Short Cut:  You can copy each method over from CAR CONTROLLER to here, removing all the PERSONALISED elements
//			 from how it is written in the CAR CONTROLLER class
//			 For example:

// 			 Create
//  			public String createCar(Car c) {
//					this.vehicles.add(c);
//					return "Successfully added car";
//					}
//			 Read
//  			public List<Car> getAllCars() {
//					return this.vehicles;
//					}
//			 Update
//  			public Car updateCar(int index, Car newCar) {
//				this.vehicles.set(index, newCar);
//      		return newCar;
//      		}
//			 Delete
//  			public void removeCar(int index) {
//  			this.vehicles.remove(index);
// 				}
//
//			 We moved the LOGIC from controller into SERVICE as per model.  We spent time learning the first method
//			 so it was simple :/



@Service
public class CarServiceList {

	List<Car> vehicles = new ArrayList<>();

	public String createCar(Car c) {
		this.vehicles.add(c);
		return "Successfully added car";
	}

	public List<Car> getAllCars() {
		return this.vehicles;
	}

	public Car updateCar(int index, Car newCar) {
		this.vehicles.set(index, newCar);
		return newCar;
	}

	public void removeCar(int index) {
		this.vehicles.remove(index);
	}

}
