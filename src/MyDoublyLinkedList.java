/*
 * MyDoublyLinkedList.java
 * 
 * Version 7
 * 
 * Copyright Jordan Brown
 * 
 * Course: CSC 172 FALL 2015
 * 
 * Project 2
 * 
 * 
 * Last Revised: October 4, 2015
 */

/**
 * DoublyLinkedList class provides methods to creating a doubly linked list. Methods include deleting and inserting
 * items at the front and end of the list, looking up whether a data item is inside the list, checking if the list is empty, and 
 * printing all the items foward and in reverse.  
 * 
 * @version		7  October 4, 2015
 * @author 		Jordan Brown
 *
 * @param <AnyType> generic type parameter 
 */
public class MyDoublyLinkedList<AnyType> implements DoublyLinkedList<AnyType> {
	
	
	/** Instance variable, head, that is a Node reference to the front of the doubly linked list */
	private DoubleNode<AnyType> head;
	
	/** Instance variable, tail, that is a Node reference to the end of the doubly linked list */
	private DoubleNode<AnyType> tail;
	
	/** Constructor for a doubly linked list, pointing the head and tail to null */
	public MyDoublyLinkedList(){
		
		head = null;
		tail = null;
		
	}//end of constructor

	
	/**
	 * Inserts a data item at the front of the list, and covers the cases for when the list is empty or contains items
	 * O(1) runtime
	 * 
	 * @param data item to be inserted in list
	 */
	@Override
	public void insertFirst(AnyType data) {
		
		DoubleNode<AnyType> newNode = new DoubleNode<AnyType>();
		
		newNode.data = data;
		
		if( isEmpty() == true ){ 
			
			head = newNode;
			
			tail = head;
		}
		
		else{ 
			
			head.prev = newNode;
			
			newNode.next = head;
			
			head = newNode;
		}
		
	}//end of insertFirst method

	
	
	
	/** Deletes the data item at the front of the list and returns that item. Returns null if the list is empty.
	 * 	Also covers the case for when only one item is contained in list. 
	 * 
	 * O(1) runtime
	 * 
	 * @return data item at front of list or null if list is empty
	 */
	@Override
	public AnyType deleteFirst() {
		
		if( isEmpty() == false ){ 
			
			AnyType tempData = head.data;
			
			if( head == tail ){			/* Only one item is contained in list */
				
				head = null;
				
				tail = null;
				
				return tempData;
			}
			
			else{						/* More than one item in list */
				
				head = head.next;
				
				head.prev = null;
				
				return tempData;
			}
			
		}
		
		return null; //No items in the list
	}
	
	
	/** Deletes the data item at the end of the list and returns that item. Returns null if the list is empty.
	 * 	Also covers the case for when only one item is contained in list. 
	 * 
	 * O(1) runtime
	 * 
	 * @return data item at end of list or null if list is empty
	 */
	@Override
	public AnyType deleteLast() {
		
		if( isEmpty() == false ){
			
			AnyType tempData = tail.data;
			
			if( tail == head ){				/* Only one data item in list */
				
				tail = null;
				
				head = null;
				
				return tempData;
			}
			
			else{							/* More than one data item */
			
				tail = tail.prev;
				
				tail.next = null;
				
				return tempData;
			}
		}
		
		return null;
	}//end of method deleteLast

	
	
	/**
	 * Inserts a data item at the end of the list, and covers the cases for when the list is empty or contains items
	 * O(1) runtime
	 * 
	 * @param data item to be inserted in list
	 */
	@Override
	public void insertLast(AnyType data) {
		
		DoubleNode<AnyType> newNode = new DoubleNode<AnyType>();
		
		newNode.data = data;
		
		if( isEmpty() == true ){
			
			head = newNode;
			
			tail = newNode;
			
		}
		
		else{
			
			newNode.prev = tail;
			
			tail.next = newNode;
			
			tail = newNode;
			
		}
		
	}//end of method insertLast



	/**
	 * Checks to see if the list is empty and returns true, otherwise false
	 * 
	 * @return true if list contains no items, otherwise false
	 */
	@Override
	public boolean isEmpty() {
		
		if( head == null ){
			return true;
		}
		
		return false;
	}//end of method isEmpty
	
	

	/**
	 * Verifies that a data item is inside the list and returns true, otherwise false
	 * 
	 * @param data item that we want to check if it's inside the list
	 * @return true if item is in the list, false otherwise
	 */
	@Override
	public boolean lookup(AnyType data) {
		
		DoubleNode<AnyType> current = head; 
		
		while ( current != null ){ 
			
			if ( current.data.equals(data) ){ 
				
				return true;
			}
			
			current = current.next;
		}
		
		return false;	
	}//end of method lookup
	
	
	/** Prints each item in the list starting from the front of the list and moving to the end */
	@Override
	public void printList() {
		
		DoubleNode<AnyType> current = head;
		
		while( current != null ){
			
			System.out.print( current + " " );
			
			current = current.next;
		}	
	}//end of method printList
	

	/** Prints each item in the list starting from the end of the list and moving to the front */
	@Override
	public void printListRev() {
		
		DoubleNode<AnyType> current = tail;
		
		while( current != null ){
			
			System.out.println( current + " " );
			
			current = current.prev;
		}
		
	}//end of method printListRev


}//end of class MyDoublyLinkedList
