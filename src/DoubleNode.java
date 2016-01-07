/*
 * Node.java
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
 * Node class creates a node for a doubly linked list that contains a reference to the next and previous node and a data item
 * 
 * @version		7  October 4, 2015
 * @author 		Jordan Brown
 *
 * @param <AnyType> generic type parameter 
 */
public class DoubleNode<AnyType> {

	/**Instance variable that represents the data item that the node holds*/
	public AnyType data;
	
	/**Instance variable that represents a reference to the next node */
	public DoubleNode<AnyType> next;
	
	/**Instance variable that represents a reference to the previous node */
	public DoubleNode<AnyType> prev;
	
	
	
	/**Returns string representation of a Node*/
	@Override
	public String toString(){
		
		return data + "";
		
	}//end of method toString
	
}//end of class Node
