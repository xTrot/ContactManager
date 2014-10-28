package com.github.xtrot.contactmanager;

import java.util.Iterator;

public interface SortedList<E extends Comparable<E>> extends Iterable<E>{
	
	/*
	 * I will be implementing the sorting within the add(E e)
	 * method, with that implementation to avoid sorting mistakes
	 * I'll eliminate add(int index, E obj) instead I set it as
	 * private to ensure proper use of this method.
	 */
	
	public void add(E obj);
	
//	public void add(int index, E obj);
	
	public boolean remove(E obj);
	
	public boolean remove(int index);
	
	public int removeAll(E obj);
	
	public E get(int index);
	
	public E set(int index, E obj);
	
	public E first();
	
	public E last();
	
	public int firstIndex(E obj);
	
	public int lastIndex(E obj);

	public int size();
	
	public boolean isEmpty();
	
	public boolean contains(E obj);
	
	public void clear();

	public Iterator<E> iterator();
}
