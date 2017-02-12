package com.marketpulse.core.relationship.implementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Relationships {
	
	private static HashMap<String, Person> People;
	
	public static HashMap<String, Person> getPeople() {
		return People;
	}

	public Relationships() {
		super();
		People = new HashMap<String, Person>();
	}
	
	public void addParent(String subject, String parent, String sex){
		Person Parent = People.get(parent);
		Person individual = People.get(subject);
		if(Parent == null){
			Parent = new Person();
			Parent.setName(parent);
		}
		Parent.setGender(sex);
		if(individual == null){
			individual = new Person();
			individual.setName(subject);
		}
		boolean exists = false;
		if(individual.getParents().size() > 0){
			exists = false;
			for(int i=0;i<individual.getParents().size();i++){
				if(individual.getParents().get(i) == Parent){
					exists = true;
					break;
				}
			}
			if(!exists){
				individual.getParents().get(0).setSpouse(Parent);
				Parent.setSpouse(individual.getParents().get(0));
			}
		}
		if(!exists)
			individual.addParent(Parent);
		exists = false;
		for(int i=0;i<Parent.getChildren().size();i++){
			if(Parent.getChildren().get(i) == individual){
				exists = true;
				break;
			}
		}
		if(!exists)
			Parent.addChildren(individual);
		People.put(subject, individual);
		People.put(parent, Parent);
	}
	public void addChild(String subject, String child, String sex){
		Person individual = People.get(subject);
		Person Child = People.get(child);
		if(Child == null){
			Child = new Person();
			Child.setName(child);
		}
		Child.setGender(sex);
		if(individual == null){
			individual = new Person();
			individual.setName(subject);
		}
		boolean exists = false;
		if(individual.getChildren().size() > 0){
			exists = false;
			for(int i=0;i<individual.getChildren().size();i++){
				if(individual.getChildren().get(i) == Child){
					exists = true;
					break;
				}
			}
		}
		if(!exists)
			individual.addChildren(Child);
		if(Child.getParents().size() > 0){
			exists = false;
			for(int i=0;i<Child.getParents().size();i++){
				if(Child.getParents().get(i) == individual){
					exists = true;
					break;
				}
			}
		}
		if(!exists)
			Child.addParent(individual);
		if(individual.getSpouse() != null){
			exists = false;
			for(int i=0;i<Child.getParents().size();i++){
				if(Child.getParents().get(i) == individual.getSpouse()){
					exists = true;
					break;
				}
			}
			if(!exists){
				Child.addParent(individual.getSpouse());
			}
		}
		if(Child.getParents().size() > 1){
			Person spouse1 = Child.getParents().get(0);
			Person spouse2 = Child.getParents().get(1);
			spouse1.setSpouse(spouse2);
			spouse2.setSpouse(spouse1);
		}
		People.put(subject, individual);
		People.put(child, Child);
	}
	public void addSpouse(String subject, String spouse){
		Person individual = People.get(subject);
		Person partner = People.get(spouse);
		if(partner == null){
			partner = new Person();
			partner.setName(spouse);
		}
		if(individual == null){
			individual = new Person();
			individual.setName(subject);
		}
		boolean exists = false;
		if(individual.getChildren().size() > 0){
			exists = false;
			for(int i=0;i<individual.getChildren().size();i++){
				if(individual.getChildren().get(i).getParents().size() > 0){
					for(int j=0;j<individual.getChildren().get(i).getParents().size();j++){
						if(individual.getChildren().get(i).getParents().get(j) == partner){
							exists = true;
							break;
						}
					}
				}
				if(!exists)
					individual.getChildren().get(i).addParent(partner);
			}
		}
		if(partner.getChildren().size() > 0){
			exists = false;
			for(int i=0;i<partner.getChildren().size();i++){
				if(partner.getChildren().get(i).getParents().size() > 0){
					for(int j=0;j<partner.getChildren().get(i).getParents().size();j++){
						if(partner.getChildren().get(i).getParents().get(j) == individual){
							exists = true;
							break;
						}
					}
				}
				if(!exists)
					partner.getChildren().get(i).addParent(individual);
			}
		}
		individual.setSpouse(partner);
		partner.setSpouse(individual);
		People.put(subject, individual);
		People.put(spouse, partner);
	}
	public String getParents(String subject){
		String parents = "";
		Person Subject = People.get(subject);
		if(Subject != null){
			for(int i = 0;i<Subject.getParents().size();i++){
				if(i==0){
					parents+=Subject.getParents().get(i).getName();
				}
				else{
					parents+=", "+Subject.getParents().get(i).getName();
				}
			}
		}
		return parents;
	}
	public String getSpouse(String subject){
		String spouse = "";
		Person Subject = People.get(subject);
		if(Subject != null && Subject.getSpouse() != null)
			return Subject.getSpouse().getName();
		return spouse;
	}
	public String getChildren(String subject){
		String children = "";
		Person Subject = People.get(subject);
		if(Subject != null){
			HashSet<String> childrenList = new HashSet<String>();
			for(int i = 0;i<Subject.getChildren().size();i++){
				childrenList.add(Subject.getChildren().get(i).getName());
			}
			for(int i = 0;i<Subject.getSpouse().getChildren().size();i++){
				childrenList.add(Subject.getSpouse().getChildren().get(i).getName());
			}
			Iterator<String> it = childrenList.iterator();
			int j = 0;
			while(it.hasNext()){
				if(j==0)
					children+=it.next().toString();
				else
					children+=", "+it.next().toString();
				j++;
			}
		}
		return children;
	}

}
