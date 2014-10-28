package com.github.xtrot.contactmanager;

import com.github.xtrot.contactmanager.SortedArrayList.SortedArrayList;

public class Contact implements Comparable<Contact> {
	private String firstName;
	private String lastName;
	private String personalPhone;
	private String workPhone;
	private String email;
	private SortedArrayList<Address> addresses;
	
	public Contact(String fn,String ln,String pp,
			String wp,String e, SortedArrayList<Address> address) {
		this.firstName = fn;
		this.lastName = ln;
		this.personalPhone = pp;
		this.workPhone = wp;
		this.email = e;
		this.addresses = address;
		
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
	public String getPersonalPhone() {
		return personalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public SortedArrayList<Address> getAdresses() {
		return addresses;
	}
	public void addAddress(Address a){
		addresses.add(a);
	}
	
	public void editAddress(Address old_a,Address new_a){
		addresses.remove(old_a);
		addresses.add(new_a);
	}
	
	public void removeAddress(Address a) {
		addresses.remove(a);
	}
	
	@Override
	public String toString(){
		return (firstName+" "+lastName).toLowerCase();
	}

	@Override
	public int compareTo(Contact contender) {
		return (firstName+" "+lastName).compareToIgnoreCase(contender.firstName+" "+contender.lastName);
	}
	
}
