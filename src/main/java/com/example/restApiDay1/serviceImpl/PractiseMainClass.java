package com.example.restApiDay1.serviceImpl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.util.StringUtils;

public class PractiseMainClass {

	public static void main(String[] args) {
	
		LocalTime starttime= LocalTime.now();
		System.out.println(starttime);
		
			  
			    String myStr1 = "HELLO";
			
			    String s = "*hel lO";
			    StringUtils.containsWhitespace(s);
			    System.out.println(StringUtils.containsWhitespace(s));
			    
			    String str = "abc !123";
			    if (str.matches(".*[!@#$%^&*()_+].*")) {
			        System.out.println("String contains special character.");
			    } else {
			        System.out.println("String does not contain special character.");
			    }
			    //else if(  StringUtils.containsWhitespace(loginDto.getPassword()) || !loginDto.getPassword().matches(".*[!@#$%^&*()_+].*")) {
				//return"no special character or space allowed in password";
			    
			    LocalTime endtime= LocalTime.now();
				System.out.println(endtime);
				Long finaltime= (long) (endtime.getNano()-starttime.getNano());
				System.out.println(finaltime);
				
				LocalDate date=LocalDate.now();
				System.out.println(date);
			}
			    
			
			  }
			


	


