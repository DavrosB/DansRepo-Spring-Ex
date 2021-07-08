package com.natwest.springexercises.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//		When you first type "@RestController", you need to hover
//		over it and press IMPORT.  It allows EXTERNAL access
//		to our APPLICATION (SpringExercises) via	
//		HTTPRequests.  This controller class will always be hit first	
//		"@GetMapping is me using the built in functions to ASK for something
//		or retrieve a resource.  You need to hover over to import as usual +
//		it will appear at the top ^^^ with other imports
//      @GetMapping Breakdown - @TypeOfRequest("location of object")


@RestController								
public class TestController {					
	
	@GetMapping("/test")
	public String thisMethod() {
		return "First bit of Spring";
	}
	
	
	
}										
