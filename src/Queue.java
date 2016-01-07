/*
 * Queue.java
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
 * Queue interface provides method declarations to be implemented in a queue class, such as enqueue (insert) and dequeue (delete)
 * items at the front of the queue, peeking at the current item at the front of the queue, and checking if the queue is empty 
 * 
 * @version		7  October 4, 2015
 * @author 		Jordan Brown
 *
 * @param <AnyType> generic type parameter 
 */
public interface Queue<AnyType> {
	
	public boolean isEmpty();					/* Checks if the queue is empty */
	
	public void enqueue(AnyType data);			/* Inserts an item at the front of the queue */
	
	public AnyType dequeue();					/* Deletes an item at the front of the queue and returns it */
	
	public AnyType peek();						/* Returns an item at the front of the queue without deleting it */

}//end of interface Queue
