/*
 * SingleLinkedList.java
 * 
 * Version 7
 * 
 * Copyright Jordan Brown
 * 
 * Course: CSC 172 FALL 2015
 * 
 * Project 2
 * 
 * Last Revised: October 4, 2015
 */

/**
 * SingleLinkedList class provides methods to creating a singly linked list. Methods include deleting and inserting
 * items at the beginning of the list, looking up whether a data item is inside the list, checking if the list is empty, and printing
 * the entire list. 
 * 
 * @version		7  October 4, 2015
 * @author 		Jordan Brown
 *
 * @param <AnyType> generic type parameter 
 */
public class SingleLinkedList<AnyType> implements SimpleLinkedList<AnyType> {
	
	/** Instance variable, head, that is a Node reference to the front of the linked list */
	private Node<AnyType> head;
	
	/** Constructor for a singly linked list, pointing the head to null */
	public SingleLinkedList(){
		
		head = null;
		
	}//end of constructor
	
	/**
	 * Inserts a data item at the beginning of the list, and covers the cases for when the list is empty or contains items
	 * O(1) runtime
	 * 
	 * @param data item to be inserted in list
	 */
	@Override
	public void insert( AnyType data ){
		
		Node<AnyType> newNode = new Node<AnyType>();
		
		newNode.data = data;
		
		if( isEmpty() == true ){ 		
			
			head = newNode;
		}
		
		else{							
			
			newNode.next = head;
			
			head = newNode;
		}
		
	}//end of insert method
	
	
	
	/** Deletes the data item at the beginning of the list and returns that item. Returns null if the list is empty
	 * O(1) runtime
	 * 
	 * @return data item at front of list or null if list is empty
	 */
	@Override
	public AnyType delete( ){
		
		if( isEmpty() == false ){
			
			AnyType tempData = head.data;
			
			head = head.next;
			
			return tempData;
			
		}
		
		return null;
		
		
	}//end of delete method
	
	
	/**
	 * Verifies that a data item is inside the list and returns true, otherwise false
	 * 
	 * @param data item that we want to check if it's inside the list
	 * @return true if item is in the list, false otherwise
	 */
	@Override
	public boolean lookup( AnyType data ){
		
		Node<AnyType> current = head;
		
		while( current != null ){
			
			if( current.data.equals(data) ){
				
				return true;
			}
			
			current = current.next;
		}
		
		return false;
	}//end of lookup method
	
	
	
	/**
	 * Checks to see if the list is empty and returns true, otherwise false
	 * 
	 * @return true if list contains no items, otherwise false
	 */
	@Override
	public boolean isEmpty(){
		
		if( head == null ){
			
			return true;
		}
		
		return false;
	}//end of isEmpty method
	
	
	/** Starting from the front, prints all the items in the list*/
	@Override 
	public void printList(){
		
		Node<AnyType> current = head;
		
		while( current != null ){
			
			System.out.print( current );
			
			current = current.next;
		}
		
	}//end of printList method

}//end of class SingleLinkedList
