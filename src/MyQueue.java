/*
 * MyQueue.java
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
 * MyQueue class provides methods for creating a queue with a doubly linked list implementation. The queue, a first-in-first-out abstract data 
 * structure, can enqueue (insert), dequeue (delete), and peek (return the item at the front of the queue without removing it).
 * 
 * @version		7  October 4, 2015
 * @author 		Jordan Brown
 *
 * @param <AnyType> generic type parameter 
 */
public class MyQueue<AnyType> implements Queue<AnyType> {
	
	/**Declare doubly linked list instance variable for queue implementation*/
	private MyDoublyLinkedList<AnyType> list;
	
	/**Constructor that instantiates a doubly linked list to be used to implement our Abstract Data Type queue*/
	public MyQueue(){
		
		list = new MyDoublyLinkedList<AnyType>();
		
	}//end of constructor

	
	/**
	 * isEmpty method checks if the queue is currently empty and returns true, otherwise returns false
	 * 
	 * @return true if queue is empty, otherwise false
	 */
	@Override
	public boolean isEmpty() {
		
		if( list.isEmpty() == true ){
			
			return true;
		}
		
		return false;
	}//end of method isEmpty

	
	
	
	/**
	 * enqueue method inserts an item at the end of the queue
	 * 
	 * @param data item to be inserted onto the queue
	 */
	@Override
	public void enqueue(AnyType data) {
		
		list.insertLast( data );
		
	}//end of method enqueue

	
	/**
	 * dequeue method deletes a data item at the front of the queue and returns it
	 * 
	 * @return data item that has been deleted
	 */
	@Override
	public AnyType dequeue() {
		
		if( isEmpty() == false ){
			
			AnyType data = list.deleteFirst();
			
			return data;	
		}
	
		return null; 
	}//end of method dequeue

	
	/**
	 * peek method returns the data item at the front of the queue without removing it, otherwise, queue is empty and returns null
	 * 
	 * @return data item currently at the front of the queue or null if nothing is inside the queue
	 */
	@Override
	public AnyType peek() {

		if( isEmpty() == false ){
			
			AnyType tempData = list.deleteFirst();			/* Delete the node at beginning of list and store data item */
			
			list.insertFirst(tempData);						/* Insert a new node with the same data item back at the beginning of the list */
			
			return tempData;
			
		}
		
		return null;
	}//end of method peek
	

}//end of class MyQueue
