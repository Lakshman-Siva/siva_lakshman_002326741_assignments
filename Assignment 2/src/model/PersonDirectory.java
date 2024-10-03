/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Lakshman
 */
public class PersonDirectory {
	
	private ArrayList<Person> peoples;
	
	public PersonDirectory() {
		peoples = new ArrayList<>();
		generateDemoData();
	}
	
	private void generateDemoData() {
		Random random = new Random();
		String[][] names = {
			{"John", "Doe"},
			{"Jane", "Smith"},
			{"Michael", "Johnson"},
			{"Emily", "Davis"},
			{"David", "Wilson"},
			{"Sarah", "Brown"},
			{"James", "Garcia"},
			{"Laura", "Martinez"},
			{"Robert", "Hernandez"},
			{"Jessica", "Lopez"},
			{"William", "Nguyen"},
			{"Megan", "Clark"},
			{"Daniel", "Taylor"},
			{"Samantha", "Anderson"},
			{"Christopher", "Thomas"}
		};

		Date[] birthDates = {
			new Date(1990 - 1900, 0, 1),  // January 1, 1990
			new Date(1985 - 1900, 4, 15), // May 15, 1985
			new Date(1975 - 1900, 7, 30), // August 30, 1975
			new Date(2000 - 1900, 10, 20), // November 20, 2000
			new Date(1995 - 1900, 2, 10), // March 10, 1995
			new Date(1982 - 1900, 6, 25), // July 25, 1982
			new Date(1998 - 1900, 11, 5),  // December 5, 1998
			new Date(1993 - 1900, 3, 22),  // April 22, 1993
			new Date(1988 - 1900, 6, 11),  // July 11, 1988
			new Date(1991 - 1900, 9, 30),  // October 30, 1991
			new Date(1978 - 1900, 1, 14),  // February 14, 1978
			new Date(1994 - 1900, 5, 19),  // June 19, 1994
			new Date(1980 - 1900, 8, 7),   // September 7, 1980
			new Date(1992 - 1900, 11, 2),  // December 2, 1992
			new Date(1984 - 1900, 3, 5)    // April 5, 1984
		};

		boolean[] isMarriedStatus = {false, true, true, false, false, true, false, true, false, true, true, false, false, true, false};
		double[] salaries = {50000, 75000, 60000, 45000, 90000, 30000, 100000, 80000, 55000, 62000, 72000, 48000, 37000, 95000, 54000};
		int[] creditScores = {650, 700, 800, 720, 600, 740, 580, 690, 750, 710, 680, 620, 770, 640, 590};

		String[] streets = {
			"Main St", "2nd St", "3rd Ave", "4th Ave", "5th Ave",
			"Elm St", "Oak St", "Pine St", "Maple St", "Cedar St",
			"Birch St", "Willow Rd", "Spruce Ln", "Ash Dr", "Hickory Pl"
		};

		String[] cities = {
			"New York", "Los Angeles", "Chicago", "Houston", "Phoenix",
			"Philadelphia", "San Antonio", "San Diego", "Dallas", "San Jose",
			"Austin", "Jacksonville", "San Francisco", "Columbus", "Fort Worth"
		};

		String[] states = {
			"CA", "TX", "NY", "FL", "WA",
			"IL", "OH", "PA", "AZ", "NV"
		};

		String[] zipCodes = {
			"90001", "10001", "73301", "33101", "98001",
			"60601", "43215", "75201", "95101", "84101"
		};

		String[] countries = {
			"USA", "Canada", "UK", "Australia", "Germany",
			"France", "India", "Brazil", "Mexico", "Japan"
		};

		for (int i = 0; i < names.length; i++) {
			Person person = addPerson();
			person.setFirstName(names[i][0]);
			person.setLastName(names[i][1]);
			person.setDateOfBirth(birthDates[i]);
			person.setIsMarried(isMarriedStatus[i]);
			person.setSalary(salaries[i]);
			person.setCreditScore(creditScores[i]);

			// Set random home address
			person.setHomeAddressLine1((random.nextInt(9999) + 1) + " " + streets[random.nextInt(streets.length)]);
			person.setHomeCity(cities[random.nextInt(cities.length)]);
			person.setHomeState(states[random.nextInt(states.length)]);
			person.setHomeZipCode(zipCodes[random.nextInt(zipCodes.length)]);
			person.setHomePhoneNumber("555-" + String.format("%04d", random.nextInt(10000)));
			person.setHomeCountry(countries[random.nextInt(countries.length)]);

			// Set random work address
			person.setWorkAddressLine1((random.nextInt(9999) + 1) + " " + streets[random.nextInt(streets.length)]);
			person.setWorkCity(cities[random.nextInt(cities.length)]);
			person.setWorkState(states[random.nextInt(states.length)]);
			person.setWorkZipCode(zipCodes[random.nextInt(zipCodes.length)]);
			person.setWorkPhoneNumber("555-" + String.format("%04d", random.nextInt(10000)));
			person.setWorkCountry(countries[random.nextInt(countries.length)]);
		}
	}
	
	public Person addPerson() {
		Person person = new Person();
		peoples.add(person);
		return person;
	}
	
	public void removePerson(Person person) {
		peoples.remove(person);
	}
	
	public ArrayList<Person> getPersons() {
		return peoples;
	}
	
	public Person searchPerson(String searchString) {
		// Matching with firstName, lastName or Address
		for(Person person : peoples) {
			if(person.getFirstName().toLowerCase().contains(searchString) || person.getLastName().toLowerCase().contains(searchString) 
					|| person.getHomeAddressLine1().toLowerCase().contains(searchString) || person.getHomeAddressLine2().toLowerCase().contains(searchString)
					|| person.getWorkAddressLine1().toLowerCase().contains(searchString) || person.getWorkAddressLine2().toLowerCase().contains(searchString)) {
				return person;	
			}
		}
		return null;
	}
}
