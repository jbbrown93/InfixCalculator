/*
 * MyStack.java
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
 * MyStack class provides methods for creating a stack with a singly linked list implementation. The stack, a last-in-first-out abstract data 
 * structure, can push (insert), pop (delete), and peek (return the item at the top of the stack without removing it).
 * 
 * @version		7  October 4, 2015
 * @author 		Jordan Brown
 *
 * @param <AnyType> generic type parameter 
 */
public class MyStack<AnyType> implements Stack<AnyType> {
	
	/**Declare singly linked list instance variable for stack implementation*/
	private SingleLinkedList<AnyType> list;
	
	/**Constructor that instantiates a singly linked list to be used to implement our Abstract Data Type stack*/
	public MyStack(){
		
		list = new SingleLinkedList<AnyType>();
		
	}//end of constructor


	
	/**
	 * isEmpty method checks if the stack is currently empty and returns true, otherwise returns false
	 * 
	 * @return true if stack is empty, otherwise false
	 */
	@Override
	public boolean isEmpty() {
		
		if( list.isEmpty() == true ){
			
			return true;
		}
		return false;
	}//end of method isEmpty

	
	
	/**
	 * push method inserts an item at the top of the stack
	 * 
	 * @param data item to be inserted onto the stack
	 */
	@Override
	public void push( AnyType data ) {
		
		list.insert(data);
		
	}//end of method push

	
	
	/**
	 * pop method deletes a data item at the top of the stack and returns it
	 * 
	 * @return data item that has been deleted
	 */
	@Override
	public AnyType pop() {
		
		if( isEmpty() == true ){ 
			
			return null;
		}
		
		else{ 
				
			AnyType item = list.delete();
			
			return item;	
		}
			
	}//end of method pop

	
	
	
	/**
	 * peek method returns the data item at the top of the stack without removing it, otherwise, stack is empty and returns null
	 * 
	 * @return data item currently at the top of the stack or null if nothing is inside the stack
	 */
	@Override
	public AnyType peek() {
		
		if( isEmpty() == false ){ 
			
			AnyType item = list.delete(); 			/* Delete the node at beginning of list and store data item */
			
			list.insert(item);						/* Insert a new node with the same data item back at the beginning of the list */
			
			return item;
		}
		
		
		return null; 
	}//end of method peek
	
	

}//end of class MyStack
