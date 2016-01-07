/*
 * Stack.java
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
 * Stack interface provides method declarations to be implemented in a stack class, such as pushing and popping
 * items at the top of the stack, peeking at the current item on the top of the stack, and checking if the stack is empty 
 * 
 * @version		7  October 4, 2015
 * @author 		Jordan Brown
 *
 * @param <AnyType> generic type parameter 
 */
public interface Stack<AnyType> {
	
	public boolean isEmpty();			/* Checks to see if stack is empty */
	
	public void push(AnyType x);		/* Inserts an item at the top of the stack */
	
	public AnyType pop();				/* Deletes an item at the top of the stack and returns it */
	
	public AnyType peek();				/* Returns the item at the top of the stack without deleting it */

}//end of interface Stack
