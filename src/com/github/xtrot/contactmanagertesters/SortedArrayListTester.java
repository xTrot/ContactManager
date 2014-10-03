package com.github.xtrot.contactmanagertesters;

import com.github.xtrot.contactmanager.Address;
import com.github.xtrot.contactmanager.Contact;
import com.github.xtrot.contactmanager.SortedArrayList;

public class SortedArrayListTester {
	protected static SortedArrayList<Contact> sal;

	public static void main(String[] args) {
		
		sal = new SortedArrayList<Contact>();
		
	}
	
	public static void test1(){
		System.out.println("Adding first three Contacts");
		
		addContact(new Contact("Enddy", "Gonzalez", "125-365-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		addContact(new Contact("Enddo", "Gonzalez", "125-365-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		addContact(new Contact("Enddu", "Gonzalez", "125-365-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		
		displayAll();
		addOneAdressToAll(new Address("Enddo", "Bleh", "123", "Derp", "HerpLand", "00lel"));
	}
	
	public static void test2(){
		System.out.println("Going for nine Contacts");
		
		addContact(new Contact("Endde", "Gonzalez", "125-365-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		addContact(new Contact("Enddi", "Gonzalez", "125-365-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		addContact(new Contact("Endda", "Gonzalez", "125-365-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		addContact(new Contact("Enddr", "Gonzalez", "125-365-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		addContact(new Contact("Enddf", "Gonzalez", "125-365-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		addContact(new Contact("Enddg", "Gonzalez", "125-365-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		addContact(new Contact("Enddy", "Gonzalez", "125-365-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		
		displayAll();
	}

	public static void test3(){
		System.out.println("Breaking the 10 bar Contacts");
		
		addContact(new Contact("Enddr", "Gonzalez", "125-365-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		addContact(new Contact("Enddf", "Gonzalez", "125-365-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		addContact(new Contact("Enddg", "Gonzalez", "125-365-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		addContact(new Contact("Enddy", "Gonzalez", "125-365-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		
		displayAll();
		
		//Sorting Complete!!!!!!!!!!
		
		System.out.println("Sorting has been Completed.");
		System.out.println();
		System.out.println();
		System.out.println("Adding an adress to all Contacts.");
		
		addOneAdressToAll(new Address("Enddy", "Bleh", "123", "Derp", "HerpLand", "00lel"));
	}

	private static void addOneAdressToAll(Address address) {
		for(int i=0;i<sal.size();i++){
			sal.get(i).addAddress(address);
			Address temp = sal.get(i).getAdresses().get(0);
			System.out.println(temp.getName());
		}
	}



	private static void displayAll() {
		for(int i=0;i<sal.size();i++){
			System.out.println("Pos: "+i+"; "+sal.get(i));
		}
	}

	private static void addContact(Contact c) {
		System.out.println("Adding: " + c.getFirstName()+" "+ c.getLastName());
		System.out.println("toString(): " + c);
		
		sal.add(c);
	}

}
