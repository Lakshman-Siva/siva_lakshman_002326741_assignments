/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Lakshman
 */
public class PersonDirectory {
	
	ArrayList<Person> peoples;
	
	public PersonDirectory() {
		peoples = new ArrayList<>();
	}
	
	public Person addPerson() {
		Person person = new Person();
		peoples.add(person);
		return person;
	}
	
	public void removePerson(Person person) {
		peoples.remove(person);
	}
	
	public Person searchPerson(String searchString) {
		// Matching with firstName, lastName or Address
		for(Person person : peoples) {
			if(person.getFirstName().contains(searchString) || person.getLastName().contains(searchString) 
					|| person.getHomeAddressLine1().contains(searchString) || person.getHomeAddressLine2().contains(searchString)
					|| person.getWorkAddressLine1().contains(searchString) || person.getWorkAddressLine2().contains(searchString)) {
				return person;	
			}
		}
		return null;
	}
}
