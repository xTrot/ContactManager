package com.github.xtrot.contactmanagertesters;

import com.github.xtrot.contactmanager.Address;
import com.github.xtrot.contactmanager.Contact;
import com.github.xtrot.contactmanager.ContactsManager;
import com.github.xtrot.contactmanager.SortedArrayList;

public class ContactManagerTester {
	protected static final int INITCAP=10;
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
		
		cm.add(new Contact("Enddy", "Gonzalez", "787-271-9885"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>(INITCAP)));
		cm.add(new Contact("Enddo", "Gonzalez", "787-271-9885"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>(INITCAP)));
		cm.add(new Contact("Enddu", "Gonzalez", "787-271-9885"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>(INITCAP)));
		
		cm.display();
	}
	
	public static void test2(){
		System.out.println("Going for nine Contacts");
		
		cm.add(new Contact("Endde", "Gonzalez", "787-271-9885"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>(INITCAP)));
		cm.add(new Contact("Enddi", "Gonzalez", "787-271-9885"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>(INITCAP)));
		cm.add(new Contact("Endda", "Gonzalez", "787-271-9885"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>(INITCAP)));
		cm.add(new Contact("Enddr", "Gonzalez", "787-271-9885"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>(INITCAP)));
		cm.add(new Contact("Enddf", "Gonzalez", "787-271-9885"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>(INITCAP)));
		cm.add(new Contact("Enddg", "Gonzalez", "787-271-9885"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>(INITCAP)));
		cm.add(new Contact("Enddy", "Gonzalez", "787-271-9885"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>(INITCAP)));
		
		cm.display();
	}

	public static void test3(){
		System.out.println("Breaking the 10 bar Contacts");
		
		cm.add(new Contact("Enddr", "Gonzalez", "787-271-9885"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>(INITCAP)));
		cm.add(new Contact("Enddf", "Gonzalez", "787-271-9885"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>(INITCAP)));
		cm.add(new Contact("Enddg", "Gonzalez", "787-271-9885"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>(INITCAP)));
		cm.add(new Contact("Enddy", "Gonzalez", "787-271-9885"
				, " ", "enddy.gonzalez@upr.edu",
				new SortedArrayList<Address>(INITCAP)));
		
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
