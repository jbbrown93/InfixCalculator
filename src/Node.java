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
 * Node class creates a node for a singly linked list that contains a reference to the next node and a data item
 * 
 * @version		7  October 4, 2015
 * @author 		Jordan Brown
 *
 * @param <AnyType> generic type parameter 
 */
public class Node<AnyType> {
	
	/**Instance variable that represents a reference to the next node */
	public Node<AnyType> next; 
	
	/**Instance variable that represents the data item that the node holds*/
	public AnyType data;
	
	
	/**Returns string representation of a Node*/
	@Override
	public String toString(){
		
		return data + "";
		
	}//end of toString method

}//end of class Node
