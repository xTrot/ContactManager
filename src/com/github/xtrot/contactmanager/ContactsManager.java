package com.github.xtrot.contactmanager;

import java.io.File;
import java.io.IOException;

public class ContactsManager {
	
	private static final File file = new File("table.txt");
	private SortedArrayList<Contact> contacts; 
	private ContactStore cs;
	
	//TODO Reevaluate this Access specifier.
	private void readAll(){
		if(file.exists()){
			cs = new ContactStore(file);
			contacts = cs.read();
		}else{
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				contacts = new SortedArrayList<>();
			}
		}
	}
	
	
	
	public ContactsManager() {
		readAll();
	}



	// Assuming SYSO
	public void display(){
		for(int i=0;i<contacts.size();i++){
			System.out.println("Pos: "+i+"; "+contacts.get(i));
		}
	}
	
	public SortedArrayList<Contact> getContacts(){
		return this.contacts;
	}
	
	public void add(Contact c){
		if(c==null)
			throw new NullPointerException();
		contacts.add(c);
	}
	
	public void edit(Contact old_c, Contact new_c) {
		if(old_c==null||new_c==null)
			throw new NullPointerException();
		contacts.set(contacts.firstIndex(old_c), new_c);
	}
	
	public void remove(Contact c) {
		if(c==null)
			throw new NullPointerException();
		contacts.remove(c);
	}
	
	public void addAdress(Contact c, Address a) {
		if(c==null||a==null)
			throw new NullPointerException();
		contacts.get(contacts.firstIndex(c)).addAddress(a);
	}
	
	public void editAdress(Contact c, Address old_a, Address new_a) {
		if(c==null||old_a==null||new_a==null)
			throw new NullPointerException();
		contacts.get(contacts.firstIndex(c)).editAddress(old_a, new_a);
	}
	
	public void removeAdress(Contact c, Address a) {
		if(c==null||a==null)
			throw new NullPointerException();
		contacts.get(contacts.firstIndex(c)).removeAddress(a);
	}
	
	public void saveData(){
		cs.write(contacts);
	}
	
}
