package com.github.xtrot.contactmanager.SortedCircularDoublyLL;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.github.xtrot.contactmanager.SortedList;

public class DoublyLinkedList<E extends Comparable<E>> implements SortedList<E> {
	
	private class Node  {
		private E value;
		private Node next;
		private Node prev;
		
		public E getValue() {
			return value;
		}
		public void setValue(E value) {
			this.value = value;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
		public Node getPrev() {
			return prev;
		}
		public void setPrev(Node prev) {
			this.prev = prev;
		}
		
	}

	private class ListIterator implements Iterator<E>{
		
		private Node nextNode;
		
		public ListIterator(){
			this.nextNode = header.getNext();
		}

		@Override
		public boolean hasNext() {
			return  nextNode!=null && nextNode!=header.getNext();
		}

		@Override
		public E next() {
			if (hasNext()){
				E result = this.nextNode.getValue();
				this.nextNode = this.nextNode.getNext();
				return result;
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
	
	
	private class ReverseListIterator implements ReverseIterator<E>{

		private Node prevNode;
		
		public ReverseListIterator(){
			Node temp = null;
			if (!isEmpty()){
				for (temp = header.getNext(); temp.getNext() != null; temp = temp.getNext());
				prevNode = temp;
			}
			else  {
				prevNode = header.getNext();
			}
		}
		@Override
		public boolean hasPrev() {
			return prevNode != header.getNext();
		}

		@Override
		public E prev() {
			if (hasPrev()){
				E result = prevNode.getValue();
				prevNode = prevNode.getPrev();
				return result;
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
	
	private Node header=null;
	private int currentSize;
	
	public DoublyLinkedList(){
		header = new Node();
		header.setNext(header);
		header.setPrev(header);
		this.currentSize = 0;
	}

	public Iterator<E> iterator() {
		return new ListIterator();
	}

	public ReverseIterator<E> reverseIterator() {
		return new ReverseListIterator();
	}

	@Override
	public void add(E obj) {
		
		if (obj == null){
			throw new IllegalArgumentException("Parameter cannot be null.");
		}
		
		if(header.getNext()==header){
			Node newNode = new Node();
			newNode.setValue(obj);
			newNode.setNext(header);
			newNode.setPrev(header);
			header.setNext(newNode);
			header.setPrev(newNode);
			System.out.println("Add: State #1");
		} else {
			Node back = header.getNext();
			for(int i=0;i<currentSize;i++){
				if(obj.compareTo(back.getValue()) < 0){
					back=back.getPrev();
					Node front   = back.getNext();
					Node newNode = new Node();
					
					newNode.setValue(obj);
					newNode.setNext(front);
					newNode.setPrev(back);
					back.setNext(newNode);
					front.setPrev(newNode);
					
					System.out.println("Add: State #2");
					currentSize++;
					return;
				}
				
				back=back.getNext();
				
			}
			back = header.getPrev();
			Node front = back.getNext();
			Node newNode = new Node();
			newNode.setValue(obj);
			newNode.setNext(front);
			newNode.setPrev(back);
			back.setNext(newNode);
			front.setPrev(newNode);
			System.out.println("Add: State #3");
		}
		currentSize++;
	}

//		Index specific add is not needed in  when using a Sorted Add.
//		
//		private void add(int index, E obj) {
//		if (obj == null){
//			throw new IllegalArgumentException("Parameter cannot be null.");
//		}
//
//		if ((index < 0) || (index > this.size())){
//			throw new IndexOutOfBoundsException();
//		}
//		if (index == this.size()){
//			this.add(obj);
//		}
//		else {
//			Node temp = null; // marks position within the list
//			int counter = 0; // counts positioin within the list
//			for (temp = header.getNext(); counter < index; temp = temp.getNext(), counter++);
//			Node newNode = new Node();
//			newNode.setValue(obj);
//			newNode.setPrev(temp.getPrev());
//			temp.getPrev().setNext(newNode);
//			newNode.setNext(temp);
//			temp.setPrev(newNode);
//			this.currentSize++;
//		}
//	}

	@Override
	public boolean remove(E obj) {
		if (obj == null){
			throw new IllegalArgumentException("Parameter cannot be null.");
		}
		Node temp = null;
		for (temp = header.getNext(); temp != null; temp = temp.getNext()){
			if (temp.getValue().equals(obj)){
				// found first copy
				if (temp.getNext() != null){
					temp.getNext().setPrev(temp.getPrev());
				}
				temp.getPrev().setNext(temp.getNext());
				temp.setValue(null);
				temp.setNext(null);
				temp.setPrev(null);
				this.currentSize--;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean remove(int index) {
		if ((index < 0) || (index >= this.size())){
			throw new IndexOutOfBoundsException();
		}
		
		Node temp = null;
		int counter = 0;
		for (temp = header.getNext(); counter < index; temp = temp.getNext(), counter++);
		if (temp.getNext() != null){
			// i am not at the end of list
			temp.getNext().setPrev(temp.getPrev()); // null if temp is the last one
		}
		temp.getPrev().setNext(temp.getNext());
		temp.setValue(null);
		temp.setNext(null);
		temp.setPrev(null);
		this.currentSize--;
		return true;
	}

	@Override
	public int removeAll(E obj) {
		int counter = 0;
		while(this.remove(obj)){
			counter++;
		}
		return counter;
	}

	@Override
	public E get(int index) {
		if ((index < 0) || (index >= this.size())){
			throw new IndexOutOfBoundsException();
		}
		else {
			int counter = 0;
			Node temp;
			for (temp = header.getNext(); counter < index; temp = temp.getNext(), counter++);
			return temp.getValue();
		}
	}

	@Override
	public E set(int index, E obj) {
		if (obj == null){
			throw new IllegalArgumentException("Parameter cannot be null.");
		}

		if ((index < 0) || (index >= this.size())){
			throw new IndexOutOfBoundsException();
		}
		else {
			int counter = 0;
			Node temp = null;
			for (temp = header.getNext(); counter < index; temp = temp.getNext(), counter++);
			E result = temp.getValue();
			temp.setValue(obj);
			return result;
		}
	}

	@Override
	public E first() {
		if (this.isEmpty()){
			return null;
		}
		else {
			return header.getNext().getValue();
		}
	}

	@Override
	public E last() {
		if (this.isEmpty()){
			return null;
		}
		else {
			Node temp = null;
			for (temp = header.getNext(); temp.getNext() != null; temp = temp.getNext());
			return temp.getValue();
		}


	}

	@Override
	public int firstIndex(E obj) {
		if (obj == null){
			throw new IllegalArgumentException("Parameter cannot be null.");
		}
		else {
			int counter = 0;
			Node temp = null;
			for (temp = header.getNext(); temp != null; temp = temp.getNext(), counter++){
				if (temp.getValue().equals(obj)){
					return counter;
				}
			}
			return -1;
		}
	}

	@Override
	public int lastIndex(E obj) {
		if (obj == null){
			throw new IllegalArgumentException("Parameter cannot be null.");
		}
		else {
			int counter =0, lastSeen = -1;
			Node temp = null;
			for (temp = header.getNext(); temp != null; temp = temp.getNext(), counter++){
				if (temp.getValue().equals(obj)){
					lastSeen = counter;
				}
			}
			return lastSeen;
		}
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
		while (!this.isEmpty()){
			this.remove(0);
		}

	}

}
