package com.natwest.springexercises;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


//   The "@SpringBootApplication" annotation here tells SPRING that this is where the MAIN class
// 	 lives it is auto created and comes with APPLICATION printed at the end from the opening process.

//	 Running this line "SpringApplication.run..." creates the "BEAN BAG" aka Application Context

@SpringBootApplication    											
public class SpringExercisesApplication {								 

	public static void main(String[] args) {
	ApplicationContext beanbag = SpringApplication.run(SpringExercisesApplication.class, args);  
	
	System.out.println(beanbag.containsBean("greeting"));
	System.out.println(beanbag.containsBean("clock"));
	System.out.println(beanbag.containsBean("date"));
	System.out.println(beanbag.getBean("clock"));
	System.out.println(beanbag.getBean("date"));
	
	}
	
//  The 1st sysout above is a test to see if there is a bean(method) called "greeting" returns true
//  The 2nd sysout above is a test to see if there is a bean(method) called "clock" returns true
//  The 3rd sysout above is a test to see if the bean(method) called "date"  returns true
//  The 4th sysout above is a test to see if the bean(method) called "clock"  runs in terminal
//  The 5th sysout above is a test to see if the bean(method) called "date" runs in terminal
	
//  @Bean - creates the bean to be put in the beanbag, needs to be input once the rest of
//	the method is complete with TYPE String NAME "greeting" and return in FORMAT 
	
@Bean
	public String greeting() {
		return "Hey loser!";
	}

//  Create a method which returns the local time (see if there is one for Date?)
//  LocalTime is the DATA TYPE
//  .now is just the method which is built in to LocalTime

@Bean
	public LocalTime clock() {
		return LocalTime.now();
}

@Bean
	public LocalDate date() {
	return LocalDate.now();
}

}
