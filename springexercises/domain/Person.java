package com.natwest.springexercises.domain;

//  Inside of this class we need to build a contructor
//  Variables of PERSON also go in here

public class Person {

// Variables
// These variables are what we input into POSTMATE when you are parsing
// in new entries to the ArrayList

	private String name;
	private int age;
	private String eyeColour;
	private String hairColour;
	private Boolean tattoos;

// Default Constructor - every class needs one, but as soon
// as we introduce the one with variables
// it is overridden.  It's required for the
// JSON / JAVA relationship

	public Person() {

	}

// Constructor with Fields - created through a right click	

	public Person(String name, int age, String eyeColour, String hairColour, Boolean tattoos) {
		super();
		this.name = name;
		this.age = age;
		this.eyeColour = eyeColour;
		this.hairColour = hairColour;
		this.tattoos = tattoos;
	}

// Getters and Setters initiated through right click source	

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

	public String getEyeColour() {
		return eyeColour;
	}

	public void setEyeColour(String eyeColour) {
		this.eyeColour = eyeColour;
	}

	public String getHairColour() {
		return hairColour;
	}

	public void setHairColour(String hairColour) {
		this.hairColour = hairColour;
	}

	public Boolean getTattoos() {
		return tattoos;
	}

	public void setTattoos(Boolean tattoos) {
		this.tattoos = tattoos;
	}

}
