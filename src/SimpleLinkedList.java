/*
 * SimpleLinkedList.java
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
 * SimpleLinkedList interface provides method declarations to be implemented in a singly linked list, such as deleting and inserting
 * items at the beginning of the list, looking up, checking if the list is empty, and printing the list. 
 * 
 * @version		7  October 4, 2015
 * @author 		Jordan Brown
 *
 * @param <AnyType> generic type parameter 
 */
public interface SimpleLinkedList<AnyType> {
	
	
	public void insert(AnyType x); 						/* inserts a data item at front of list */
	
	public AnyType delete(); 							/* deletes data item at front of list */
	
	public boolean lookup(AnyType x); 					/* verifies that a data item is inside list */
	
	public boolean isEmpty(); 							/* checks to see if the list is empty */
	
	public void printList(); 							/* prints all the list items out */

}//end of interface SimpleLinkedList
