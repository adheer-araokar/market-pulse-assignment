package com.marketpulse.core.relationship.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parser {

	public static void main(String[] args) throws IOException {
		
		Relationships relationshipMaps = new Relationships();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String option = "";
		System.out.println("Relationships Tree Parser!");
		String subject = "";
		String father = "";
		String mother = "";
		String son = "";
		String daughter = "";
		String spouse = "";
		do{
			System.out.println("Commands :- Add a Relationship - A, Show Relationship Tree - T, Show Parents - P, Show Children - C, Exit - E");
			System.out.println("Enter command");
			option = br.readLine();
		    switch(option.toUpperCase()) {
		        case "A" :
		        	System.out.println("Add a Relationship Selected.");
		        	System.out.println("Enter The name of the individual for whom a relationship needs to be added.");
		        	subject = br.readLine();
		        	boolean continueOnSameSubject = true;
		        	String innerOption = "";
		        	while(continueOnSameSubject){
		        		System.out.println("Commands :- Add Father - F, Add Mother - M, Add Spouse - Sp, Add Son - So, Add Daughter - D, Exit for current Individual - E");
		        		System.out.println("Enter command");
		        		innerOption = br.readLine();
		        		switch(innerOption.toUpperCase()){
		        			case "F" :
		        				System.out.println("Enter Name of the father :- ");
		        				father = br.readLine();
		        				relationshipMaps.addParent(subject, father, "Male");
		        				break;
		        			case "M" :
		        				System.out.println("Enter Name of the Mother :- ");
		        				mother = br.readLine();
		        				relationshipMaps.addParent(subject, mother, "Female");
		        				break;
		        			case "SP" :
		        				System.out.println("Enter Name of the Spouse :- ");
		        				spouse = br.readLine();
		        				relationshipMaps.addSpouse(subject, spouse);
		        				break;
		        			case "SO" :
		        				System.out.println("Enter Name of the Son :- ");
		        				son = br.readLine();
		        				relationshipMaps.addChild(subject, son, "Male");
		        				break;
		        			case "D" :
		        				System.out.println("Enter Name of the Daughter :- ");
		        				daughter = br.readLine();
		        				relationshipMaps.addChild(subject, daughter, "Female");
		        				break;
		        			case "E" :
		        				System.out.println("Exiting!");
		        				continueOnSameSubject = false;
		     		           	break;
		     		       	default :
		     		       		System.out.println("Invalid Option!");
		        		}
		        	}
		        	break;
		        case "T" :
		        	System.out.println("Show Relationship Tree Selected.");
		        	System.out.println("Enter The name of the individual whose Relationship Tree you want to view.");
		        	subject = br.readLine();
		        	System.out.println("parents = "+relationshipMaps.getParents(subject));
		        	System.out.println("spouse = "+relationshipMaps.getSpouse(subject));
		        	System.out.println("children = "+relationshipMaps.getChildren(subject));
		    	    break;
		        case "P" :
		        	System.out.println("Show Parents Selected.");
		        	System.out.println("Enter The name of the individual whose Parents you want to view.");
		        	subject = br.readLine();
		        	System.out.println(relationshipMaps.getParents(subject));
		        	break;
		        case "C" :
		        	System.out.println("Show Children Selected.");
		        	System.out.println("Enter The name of the individual whose Children you want to view.");
		        	subject = br.readLine();
		        	System.out.println(relationshipMaps.getChildren(subject));
		        	break;
		       case "E" :
		           System.out.println("Exiting!");
		           break;
		       default :
		           System.out.println("Invalid Option!");
		    }
		}while(!option.equalsIgnoreCase("E"));
	
	}

}
