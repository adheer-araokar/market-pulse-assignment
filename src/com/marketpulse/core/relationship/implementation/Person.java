package com.marketpulse.core.relationship.implementation;

import java.util.ArrayList;

public class Person {
	private String Name;
	private String Gender;
	/*private Person Father;
	private Person Mother;*/
	private ArrayList<Person> Parents;
	private Person Spouse;
	/*private ArrayList<Person> Sons;
	private ArrayList<Person> Daughters;*/
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
	/*public Person getFather() {
		return Father;
	}
	public void setFather(Person father) {
		Father = father;
	}
	public Person getMother() {
		return Mother;
	}
	public void setMother(Person mother) {
		Mother = mother;
	}*/
	public Person getSpouse() {
		return Spouse;
	}
	public void setSpouse(Person spouse) {
		Spouse = spouse;
	}
	/*public ArrayList<Person> getSons() {
		return Sons;
	}
	public void setSons(ArrayList<Person> sons) {
		Sons = sons;
	}
	public void addSon(Person son) {
		Sons.add(son);
	}
	public ArrayList<Person> getDaughters() {
		return Daughters;
	}
	public void setDaughters(ArrayList<Person> daughters) {
		Daughters = daughters;
	}
	public void addDaughter(Person daughter) {
		Daughters.add(daughter);
	}*/
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
		/*Father = null;
		Mother = null;*/
		Spouse = null;
		/*Sons = new ArrayList<Person>();
		Daughters = new ArrayList<Person>();*/
		Parents = new ArrayList<Person>();
		Children = new ArrayList<Person>();
	}
	/*public Person(String name, Person father, Person mother, Person spouse, ArrayList<Person> sons,
			ArrayList<Person> daughters, ArrayList<Person> children) {*/
	/*public Person(String name, Person father, Person mother, Person spouse, ArrayList<Person> children) {*/
	public Person(String name, String gender, Person spouse, ArrayList<Person> parents, ArrayList<Person> children) {
		super();
		Name = name;
		Gender = gender;
		/*Father = father;
		Mother = mother;*/
		Spouse = spouse;
		/*Sons = sons;
		Daughters = daughters;*/
		Parents = parents;
		Children = children;
	}
	
}
