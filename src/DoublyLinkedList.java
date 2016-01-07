/*
 * DoublyLinkedList.java
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
 * DoublyLinkedList interface provides method declarations to be implemented in a doubly linked list, such as deleting and inserting
 * items at the front and end of the list, looking up if data items are inside the list, checking if the list is empty, and printing 
 * all the list items out in reverse and front order. 
 * 
 * @version		7  October 4, 2015
 * @author 		Jordan Brown
 *
 * @param <AnyType> generic type parameter 
 */
public interface DoublyLinkedList<AnyType> {

	public void insertFirst(AnyType data); 					/* inserts a data item at front of list */
	
	public AnyType deleteFirst(); 							/* delete data item from the front of list */
	
	public AnyType deleteLast();							/* deletes data item from the end of the list */
	
	public void insertLast( AnyType data );					/* inserts a data item from the end of the list */
	
	public boolean lookup(AnyType x); 						/* verifies that data item is inside list */
	
	public boolean isEmpty(); 								/* checks if list is empty */
	
	public void printList(); 								/* prints the list forward */
	
	public void printListRev(); 							/* prints the list in reverse */
	
}//end of interface DoublyLinkedList
