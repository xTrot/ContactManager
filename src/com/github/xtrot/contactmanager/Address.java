package com.github.xtrot.contactmanager;

public class Address {
	private String name;
	private String street;
	private String number;
	private String city;
	private String state;
	private String zipcode;
	
	
	
	public Address(String name, String street, String number, String city,
			String state, String zipcode) {
		this.name = name;
		this.street = street;
		this.number = number;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String parseTo() {
		return this.name+":"+this.street+":"+this.number+":"+this.city+":"+this.state+":"+this.zipcode;
	}

	public static Address parseFrom(String string) {
		String[] fields = string.split(":");
		return new Address(fields[0],fields[1],fields[2],fields[3],fields[4],fields[5]);
	}
	
	
}
