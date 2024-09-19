/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lakshman
 */
public class DeveloperProfile {
	// Attributes given in assigment.
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String phone;
	private String driversLicenseNumber;
	private String driversLicenseState;
	private String socialSecurityNumber;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zip;
	private String telephoneNumber;
	private String faxNumber;
	
	// Additional Attributes related to a Developer.
	private Date dateOfBirth;
	private String linkedInProfile;
	private List<String> technicalSkills;
	private int[] technicalSkillsIndices;
	private List<String> areaOfInterest;
	private int[] areaOfInterestIndices;
	
	public DeveloperProfile(){
		technicalSkills = new ArrayList<>();
		technicalSkillsIndices = new int[15];
		areaOfInterest = new ArrayList<>();
		areaOfInterestIndices = new int[15];
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int[] getTechnicalSkillsIndices() {
		return technicalSkillsIndices;
	}

	public void setTechnicalSkillsIndices(int[] technicalSkillsIndices) {
		this.technicalSkillsIndices = technicalSkillsIndices;
	}

	public int[] getAreaOfInterestIndices() {
		return areaOfInterestIndices;
	}

	public void setAreaOfInterestIndices(int[] areaOfInterestIndices) {
		this.areaOfInterestIndices = areaOfInterestIndices;
	}
	private int yearsOfExperience;
	private String professionalSummary;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDriversLicenseNumber() {
		return driversLicenseNumber;
	}

	public void setDriversLicenseNumber(String driversLicenseNumber) {
		this.driversLicenseNumber = driversLicenseNumber;
	}

	public String getDriversLicenseState() {
		return driversLicenseState;
	}

	public void setDriversLicenseState(String driversLicenseState) {
		this.driversLicenseState = driversLicenseState;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLinkedInProfile() {
		return linkedInProfile;
	}

	public void setLinkedInProfile(String linkedInProfile) {
		this.linkedInProfile = linkedInProfile;
	}

	public List<String> getTechnicalSkills() {
		return technicalSkills;
	}

	public void setTechnicalSkills(List<String> technicalSkills) {
		this.technicalSkills = technicalSkills;
	}

	public List<String> getAreaOfInterest() {
		return areaOfInterest;
	}

	public void setAreaOfInterest(List<String> areaOfInterest) {
		this.areaOfInterest = areaOfInterest;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getProfessionalSummary() {
		return professionalSummary;
	}

	public void setProfessionalSummary(String professionalSummary) {
		this.professionalSummary = professionalSummary;
	}

}
