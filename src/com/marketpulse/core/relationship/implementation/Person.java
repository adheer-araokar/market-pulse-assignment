package com.marketpulse.core.relationship.implementation;

import java.util.ArrayList;

public class Person {
	private String Name;
	private String Gender;
	private ArrayList<Person> Parents;
	private Person Spouse;
	private ArrayList<Person> Children;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Person getSpouse() {
		return Spouse;
	}
	public void setSpouse(Person spouse) {
		Spouse = spouse;
	}
	public ArrayList<Person> getParents() {
		return Parents;
	}
	public void setParents(ArrayList<Person> parents) {
		Parents = parents;
	}
	public void addParent(Person parent) {
		Parents.add(parent);
	}
	public ArrayList<Person> getChildren() {
		return Children;
	}
	public void setChildren(ArrayList<Person> children) {
		Children = children;
	}
	public void addChildren(Person child) {
		Children.add(child);
	}
	public Person() {
		super();
		Name = "";
		Gender = "";
		Spouse = null;
		Parents = new ArrayList<Person>();
		Children = new ArrayList<Person>();
	}
	public Person(String name, String gender, Person spouse, ArrayList<Person> parents, ArrayList<Person> children) {
		super();
		Name = name;
		Gender = gender;
		Spouse = spouse;
		Parents = parents;
		Children = children;
	}
	
}
