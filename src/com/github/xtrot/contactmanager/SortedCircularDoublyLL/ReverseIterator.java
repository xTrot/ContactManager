package com.github.xtrot.contactmanager.SortedCircularDoublyLL;

public interface ReverseIterator<E> {
	
	public boolean hasPrev();
	
	public E prev();
	
	public void remove();

}
