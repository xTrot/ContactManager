package com.github.xtrot.contactmanager.SortedArrayList.contactmanagertesters;

import com.github.xtrot.contactmanager.Address;
import com.github.xtrot.contactmanager.Contact;
import com.github.xtrot.contactmanager.SortedArrayList.ContactsManager;
import com.github.xtrot.contactmanager.SortedArrayList.SortedArrayList;

public class ContactManagerTester {
	private static ContactsManager cm;
	private static SortedArrayList<Contact> c;

	public static void main(String[] args) {
		
		SortedArrayListTester.main(null);
		SortedArrayListTester.test1();
		SortedArrayListTester.test2();
		SortedArrayListTester.test3();
		System.out.println("First Test Completed.");
		
		System.out.println();
		System.out.println();
		
		cm = new ContactsManager();
		
		test1();
		c = cm.getContacts();
		addOneAdressToAll(new Address("Enddo", "Bleh", "123", "Derp", "HerpLand", "00lel"));
		test2();
		test3();
		addOneAdressToAll(new Address("Enddy", "Bleh", "123", "Derp", "HerpLand", "00lel"));
		
		cm.saveData();
		
	}
	
	public static void test1(){
		System.out.println("Adding first three Contacts");
		
		cm.add(new Contact("Enddy", "Gonzalez", "124-356-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		cm.add(new Contact("Enddo", "Gonzalez", "124-356-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		cm.add(new Contact("Enddu", "Gonzalez", "124-356-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		
		cm.display();
	}
	
	public static void test2(){
		System.out.println("Going for nine Contacts");
		
		cm.add(new Contact("Endde", "Gonzalez", "124-356-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		cm.add(new Contact("Enddi", "Gonzalez", "124-356-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		cm.add(new Contact("Endda", "Gonzalez", "124-356-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		cm.add(new Contact("Enddr", "Gonzalez", "124-356-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		cm.add(new Contact("Enddf", "Gonzalez", "124-356-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		cm.add(new Contact("Enddg", "Gonzalez", "124-356-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		cm.add(new Contact("Enddy", "Gonzalez", "124-356-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		
		cm.display();
	}

	public static void test3(){
		System.out.println("Breaking the 10 bar Contacts");
		
		cm.add(new Contact("Enddr", "Gonzalez", "124-356-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		cm.add(new Contact("Enddf", "Gonzalez", "124-356-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		cm.add(new Contact("Enddg", "Gonzalez", "124-356-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		cm.add(new Contact("Enddy", "Gonzalez", "124-356-6985"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>()));
		
		cm.display();
		
		//Sorting Complete!!!!!!!!!!
		
		System.out.println("Sorting has been Completed.");
		System.out.println();
		System.out.println();
	}
	
	private static void addOneAdressToAll(Address address) {
		for(int i=0;i<c.size();i++){
			c.get(i).addAddress(address);
			Address temp = c.get(i).getAdresses().get(0);
			System.out.println(temp.getName());
		}
	}

}
