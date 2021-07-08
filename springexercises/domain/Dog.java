package com.natwest.springexercises.domain;

//3.	Create associated classes off DOMAIN  package called car / dog ETC
//4.	Start in the car class with variables / methods / getters and setters
//5.	Variables:  private String Manufacturer; private String Model; private double  engine; private boolean neons; <- remember the returns and then add getters and setters!
//6.	Right click source getters and setters, select all fields
//7.	Next is the constructor: public Car(String manufacturer String model, int engine, boolean spoiler)
//8.	this.make = make; etc

public class Dog {

	private String breed;
	private String name;
	private int age;
	private String owner;
	private boolean radgie;

//  Created default contructor from variables set above - right click, source, set	

	public Dog(String breed, String name, int age, String owner, boolean radgie) {
		super();
		this.breed = breed;
		this.name = name;
		this.age = age;
		this.owner = owner;
		this.radgie = radgie;
	}

//  Created default class	

	public Dog() {

	}

//  Create Getters and Setters	
	
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public boolean isRadgie() {
		return radgie;
	}

	public void setRadgie(boolean radgie) {
		this.radgie = radgie;
	}



}
