/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Lakshman
 */
public class Person {
	
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private int age;
	private long socialSecurityNumber;
	private boolean isMarried;
	private double salary;
	private int creditScore;
	private Address homeAddress;
	private Address workAddress;
	
	public Person() {
		homeAddress = new Address();
		workAddress = new Address();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(long socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public boolean isIsMarried() {
		return isMarried;
	}

	public void setIsMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}
	
	public String getHomeAddressLine1() {
		return homeAddress.getAddressLine1();
	}
	
	public void setHomeAddressLine1(String addressLine1) {
		this.homeAddress.setAddressLine1(addressLine1);
	}
	
	public String getHomeAddressLine2() {
		return homeAddress.getAddressLine2();
	}
	
	public void setHomeAddressLine2(String addressLine2) {
		this.homeAddress.setAddressLine2(addressLine2);
	}
	
	public String getHomeUnitNumber() {
		return homeAddress.getUnitNumber();
	}

	public void setHomeUnitNumber(String unitNumber) {
		this.homeAddress.setUnitNumber(unitNumber);
	}

	public String getHomeCity() {
		return homeAddress.getCity();
	}

	public void setHomeCity(String city) {
		this.homeAddress.setCity(city);
	}

	public String getHomeState() {
		return homeAddress.getState();
	}

	public void setHomeState(String state) {
		this.homeAddress.setState(state);
	}

	public String getHomeCountry() {
		return homeAddress.getCountry();
	}

	public void setHomeCountry(String country) {
		this.homeAddress.setCountry(country);
	}

	public String getHomeZipCode() {
		return homeAddress.getZipCode();
	}

	public void setHomeZipCode(String zipCode) {
		this.homeAddress.setZipCode(zipCode);
	}

	public String getHomePhoneNumber() {
		return homeAddress.getPhoneNumber();
	}

	public void setHomePhoneNumber(String phoneNumber) {
		this.homeAddress.setPhoneNumber(phoneNumber);
	}
	
	public String getWorkAddressLine1() {
		return workAddress.getAddressLine1();
	}
	
	public void setWorkAddressLine1(String addressLine1) {
		this.workAddress.setAddressLine1(addressLine1);
	}
	
	public String getWorkAddressLine2() {
		return workAddress.getAddressLine2();
	}
	
	public void setWorkAddressLine2(String addressLine2) {
		this.workAddress.setAddressLine2(addressLine2);
	}
	
	public String getWorkUnitNumber() {
		return workAddress.getUnitNumber();
	}

	public void setWorkUnitNumber(String unitNumber) {
		this.workAddress.setUnitNumber(unitNumber);
	}

	public String getWorkCity() {
		return workAddress.getCity();
	}

	public void setWorkCity(String city) {
		this.workAddress.setCity(city);
	}

	public String getWorkState() {
		return workAddress.getState();
	}

	public void setWorkState(String state) {
		this.workAddress.setState(state);
	}

	public String getWorkCountry() {
		return workAddress.getCountry();
	}

	public void setWorkCountry(String country) {
		this.workAddress.setCountry(country);
	}

	public String getWorkZipCode() {
		return workAddress.getZipCode();
	}

	public void setWorkZipCode(String zipCode) {
		this.workAddress.setZipCode(zipCode);
	}

	public String getWorkPhoneNumber() {
		return workAddress.getPhoneNumber();
	}

	public void setWorkPhoneNumber(String phoneNumber) {
		this.workAddress.setPhoneNumber(phoneNumber);
	}
	
	@Override
	public String toString() {
		return firstName;
	}
}
