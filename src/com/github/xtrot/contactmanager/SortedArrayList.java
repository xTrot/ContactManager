package com.github.xtrot.contactmanager;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SortedArrayList<E>  implements Iterable<E>, SortedList<E> {

	// private fields
	public static final int INITCAP=10;

	private int currentSize;

	private E elements[];

	private class ListIterator<E> implements Iterator<E>{

		private int currentPosition;

		public ListIterator(){
			this.currentPosition = 0;
		}

		@Override
		public boolean hasNext() {
			return this.currentPosition < size();
		}
		@Override
		public E next() {
			if (this.hasNext()){
				return (E) elements[this.currentPosition++];
			}
			else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	public SortedArrayList(int initialCapacity){
		if (initialCapacity < 1){
			throw new IllegalArgumentException("Capacity must be at least 1.");
		}
		this.currentSize = 0;
		this.elements = (E[]) new Object[initialCapacity];
	}

	@Override
	public void add(E obj) {
		if (obj == null){
			throw new IllegalArgumentException("Argument object cannot be null.");
		}
		else {
			if(obj instanceof Contact||obj instanceof Address){
				String contender = obj.toString();
				if(currentSize==0){
					this.add(0,obj);
					return;
				}
				String holder = elements[0].toString();
				if(contender.compareTo(holder)<0){
					this.add(0,obj);
					return;
				}
				for(int i=0;i<currentSize-1;i++){
					holder = elements[i].toString();
					boolean biggerThanHolder0 = contender.compareTo(holder)>=0;

					holder = elements[i+1].toString();
					boolean smallerThanHolder1 = contender.compareTo(holder)<0;

					if(biggerThanHolder0&&smallerThanHolder1){
						this.add(i+1, obj);
						return;
					}
				}
				holder = elements[currentSize-1].toString();
				if(contender.compareTo(holder)<0){
					this.add(this.currentSize-1,obj);
					return;
				}
				this.add(this.currentSize,obj);
				return;
			}else{
				//TODO Implement for other stuff.
			}
		}
	}

	private void reAllocate() {
		// create a new array with the twice the size
		E newElements[] = (E[]) new Object[2*this.elements.length];
		// copy all values into the new array
		for (int i=0; i < this.currentSize; ++i){
			newElements[i] = this.elements[i];
		}
		// replace old elements with newElements
		this.elements = newElements;
	}

	private void add(int index, E obj) {
		if (obj == null){
			throw new IllegalArgumentException("Argument object cannot be null.");
		}
		if (index >= 0 && index <= this.currentSize){
			if (this.currentSize == this.elements.length){
				reAllocate();
			}
			// move everybody one spot to the back
			for (int i=this.currentSize; i > index; --i){
				this.elements[i] = this.elements[i-1];
			}
			// add element at position index
			this.elements[index] = obj;
			this.currentSize++;
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	@Override
	public boolean remove(E obj) {
		if (obj == null){
			throw new IllegalArgumentException("Argument object cannot be null.");
		}
		// first find obj in the array
		int target = -1;
		for (int i=0; i < this.currentSize; ++i){
			if (this.elements[i].equals(obj)){
				// found it
				target = i;
				break;
			}
		}
		if (target == -1){
			return false;
		}
		else {
			for (int i= target; i < this.currentSize - 1; ++i){
				this.elements[i] = this.elements[i+1];
			}
			// reduce size of list and remove extra last reference
			this.elements[--this.currentSize] = null;
			return true;
		}
	}

	@Override
	public boolean remove(int index) {
		if (index >= 0 && index < this.currentSize){
			for (int i= index; i < this.currentSize - 1; ++i){
				this.elements[i] = this.elements[i+1];
			}
			// reduce size of list and remove extra last reference
			this.elements[--this.currentSize] = null;
			return true;

		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	@Override
	public int removeAll(E obj) {
		int counter = 0;
		while (this.remove(obj)){
			counter++;
		}
		return counter;
	}

	@Override
	public E get(int index) {
		if (index>=0 && index < this.size()){
			return this.elements[index];
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	@Override
	public E set(int index, E obj) {
		if (obj == null){
			throw new IllegalArgumentException("Object cannot be null");
		}
		if (index>=0 && index < this.size()){
			E temp = this.elements[index];
			this.elements[index] = obj;
			return temp;
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	@Override
	public E first() {
		if (this.isEmpty()){
			return null;
		}
		else {
			return this.elements[0];
		}
	}

	@Override
	public E last() {
		if (this.isEmpty()){
			return null;
		}
		else {
			return this.elements[this.currentSize-1];
		}
	}

	@Override
	public int firstIndex(E obj) {
		for (int i=0; i < this.currentSize; ++i){
			if (this.elements[i].equals(obj)){
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndex(E obj) {
		for (int i= this.currentSize-1; i >= 0; --i){
			if (this.elements[i].equals(obj)){
				return i;
			}
		}
		return -1;
	}

	@Override
	public int size() {
		return this.currentSize;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public boolean contains(E obj) {
		return this.firstIndex(obj) >= 0;
	}

	@Override
	public void clear() {
		for (int i=0; i < this.currentSize; ++i){
			this.elements[i] = null;
		}
		this.currentSize = 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
