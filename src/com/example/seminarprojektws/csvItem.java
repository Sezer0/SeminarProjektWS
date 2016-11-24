package com.example.seminarprojektws;

public class csvItem {

	private String dN;
	private String employeeNr;
	private String givenName;
	private String lastName;
	private String location;
	private String employeeType;
	private String function;
	private String validUntil;
	private String eMail;
	
	
	
	public csvItem(String dN, String employeeNr, String givenName, String lastName, String location, String employeeType, String function, String validUntil, String eMail ){
		
		this.dN = dN;
		this.employeeNr = employeeNr;
		this.givenName = givenName;
		this.lastName =lastName;
		this.location = location;
		this.employeeType = employeeType;
		this.function = function;
		this.validUntil = validUntil;
		this.eMail =eMail;
		
	}
	
	public String getDn(){
		
		return dN;
		
	}
	
	public String getEmployeeNr(){
		
		return employeeNr;
		
	}
	
	public String getGivenName(){
			
			return givenName;
			
		}
	
	public String getLastName(){
		
		return lastName;
		
	}

	public String getLocation() {
		return location;
	}
	
	public String getEmployeeType(){
		
		return employeeType;
		
	}
	
	public String getFunction(){
		
		return function;
		
	}
	
	public String getValidUntil(){
		
		return validUntil;
		
	}
	
	public String getEMail(){
		
		return eMail;
		
	}
	
	
	
	
	
}

