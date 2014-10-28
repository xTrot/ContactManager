package com.github.xtrot.contactmanager.SortedArrayList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.github.xtrot.contactmanager.Address;
import com.github.xtrot.contactmanager.Contact;

public class ContactStore {
	private File f;
	
	public ContactStore(File f) {
		this.f = f;
	}
	
	public SortedArrayList<Contact> read(){
		SortedArrayList<Contact> contacts = new SortedArrayList<Contact>();
		try {
			String ln;
			BufferedReader br = new BufferedReader(new FileReader(f));
			while((ln = br.readLine()) != null)
				contacts.add(readLn(ln));
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contacts;
		
	}
	
	public void write(SortedArrayList<Contact> contacts){
		try {
			PrintWriter w = new PrintWriter(f);
			for(int i=0;i<contacts.size();i++)
				w.println(writeLn(contacts.get(i)));
			w.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private Contact readLn(String s){
		String[] fields=s.split(",");
		String[] addressStrings=fields[fields.length-1].split(";");
		SortedArrayList<Address> addresses = new SortedArrayList<Address>();
		for(int i=0; i<addressStrings.length-1;i++)// Last String will always be "".
			addresses.add(Address.parseFrom(addressStrings[i]));
		return new Contact(fields[0], fields[1],fields[2],fields[3],fields[4], addresses);
	}
	
	private String writeLn(Contact c){
		String temp = c.getFirstName()+","+
				c.getLastName()+","+
				c.getPersonalPhone()+","+
				c.getWorkPhone()+","+
				c.getEmail()+",";
		SortedArrayList<Address> addresses=c.getAdresses();
		for(int i=0; i<addresses.size();i++){
			temp += addresses.get(i).parseTo()+";";
		}
		// TODO Remove SYSO.
		System.out.println(temp);
		return temp;
	}
}
