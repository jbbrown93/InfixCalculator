/*
 * InfixCalculatorTest.java
 * 
 * Version 7
 * 
 * Copyright Jordan Brown
 * 
 * Course: CSC 172 FALL 2015
 * 
 * Project 2
 * 
 * Last Revised: October 24, 2015
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * InfixCalculator class provides methods to take in an infix expression from an input file in the command line, 
 * translate that infix expression to postfix, then evaluate that postfix expression and write the output to a file. 
 */
public class InfixCalculatorTest {

	private String expression; //holds the inputed expression
	
	private String[] expressionArray; //an array to separate the expression by each individual characters in the String
	
	//All possible list of operators
	private String[] operators = {"!", "&", "|", "(", ")", "+", "-", "/", "*", "^", "<", "=", ">", "%"};
	
	//Stack and queue to hold my expressions for translation and evaluation
	private MyStack<String> stack;
	
	private MyQueue<String> queue;

	

	//Constructor to initialize all variables
	public InfixCalculatorTest( String expression ){
		
		this.expression = expression.replaceAll("\\s+","");	//gets rid of unnecessary whitespace in expression
		
		String[] tempArray = (this.expression).split(""); //splits the expression into an array
		
			
		stack = new MyStack<String>();
		queue = new MyQueue<String>();
		
		expressionArray = determineTokens( tempArray );	//separate the operators and the operands to have their own indices in an array
		
		expressionArray = determineIfNegativeOperand( expressionArray ); //determine whether negative operands are present, and put them at their own indices
		
	}//end of constructor
	
	/*
	 * Determines whether their is a negative operand in the expression array, if so, gives the operand its own indices
	 * and returns a string array containing the expresion with negative operands (if present)
	 */
	public String[] determineIfNegativeOperand(String[] array){
		
		String negativeSign = "-";

		String[] tempArray = new String[expressionArray.length]; //holds actual value negative operands, null values for empty spots, and the original operands and operators
		
		String[] finalArray; //an array to hold all the new negative operands and original elements with no null values
		
		int index = 0; //index tracker for the final array
		
		int size = expressionArray.length; //size of the final array
		
		
		for(int i = 0; i < expressionArray.length; i++){	//Loop through every element in expression array
			
			if(i == 0){	//If the first index is a negative, then we have a negative operand
				
				if( expressionArray[i].equals(negativeSign) || (expressionArray[i].equals("(") && expressionArray[i+1].equals(negativeSign))){
					
					if( expressionArray[i].equals(negativeSign) ){
						tempArray[0] = ( expressionArray[0] + expressionArray[1]); //replace the separated minus sign and operand, by concatenating them together
						
						i++;	//increment i to go to the element after the second
						size--;
					}
					else{

						tempArray[0] = expressionArray[0];
						tempArray[1] = expressionArray[1] + expressionArray[2];
						i = i + 2;
						size--;
					}
					
				}
				
				else{ //No negative number present, place 
					tempArray[0] = expressionArray[0];
				}
				
					
			}
			
			else{
			
				//If we have an operator
			if( determineIfOperator(expressionArray[i]) == true ){
				
			
					//If there is two consecutive operators, and the second one is a negative sign, then we have a negative number present
					if( (i != expressionArray.length-1) && expressionArray[i+1].equals(negativeSign) && ( determineIfOperator(expressionArray[i+2]) == false )  ){
						
						//put items in temp array, and merge the operand with the negative sign
						tempArray[i] = expressionArray[i];
						
						tempArray[i+1] = ( expressionArray[i+1] + expressionArray[i+2]);
						
						//increment i by 2 to move on to elements we have not looked at
						i = i + 2;
						size--;
					}
				
					
					
					else{
						//move item to temp array normally, no negative present 
						
						tempArray[i] = expressionArray[i];
					}
					
	
			}
			
			else{
				
				tempArray[i] = expressionArray[i];
			}
			
			
			}
			
			
		}
		

		//set the final array to accurate size 
		finalArray = new String[size];
		
		index = 0;
		
		//move all the temp elements that are not null to the final array
		for(int j = 0; j < tempArray.length; j++){
			
			if(tempArray[j] != null ){
				finalArray[index] = tempArray[j];
				index++;
			}
		}
		
		
		return finalArray;
		
	}//end of method determineIfNegativeOperand
	
	

	/*
	 * Determines whether the token in the expression is an operator or an operand, then returns a string with the
	 * tokens at their own indices
	 */
	public String[] determineTokens(String[] array){
		
		int actualSize = 0; //size of for our expression array 

		int operandAmount = 0; //Needed so if we have a number with more than one digit, we can merge them together
	
		
		MyStack<String> elemStack = new MyStack<String>(); //stack to keep track of the elements
		
		for(int i = 0; i < array.length; i++){ //loop through all the elements in the expression array given
			
			if( determineIfOperator( array[i] ) == true ){ //if an operator, push onto the stack
				
				elemStack.push( array[i] );
				
				actualSize++;
				
				operandAmount = 0;
			
			}
			
			else{
				
				operandAmount++; 
				
				elemStack.push( array[i] );
				
				actualSize++;
				
				
				if( operandAmount > 1 ){ //if an operand appeared more than once consecutively, then we have a number with more than one digit
					
					//remove the previous operand from the stack, then merge that operand with our current element from the expression array
					
					elemStack.pop();
				
					String temp = elemStack.peek();
							
					elemStack.pop();
					
					
					temp = temp + array[i];
					
					
					//place finished operand concatentation back onto the stack
					elemStack.push(temp);
					
					//change the size appropriately
					operandAmount--;
					actualSize--;
				}
				
				
			}
			
			
		}
		
		String[] strings = new String[actualSize]; //an array to hold the new elements with numbers with more than one digit accounted for
		
		for(int i= actualSize - 1; i >= 0; i--){
			
			strings[i] = elemStack.pop(); //place the elements in the stack in the correct order inside array
		}

		return strings;
		
	}//end of method determineTokens
	
	/*
	 * returns true if a given string is an operator, false otherwise
	 */
	public boolean determineIfOperator( String currentExp ){
		
		for( String current: operators){
			
			if( currentExp.equals(current) ){
				return true;
			}
		}
		
		return false;
	}//end of method determineIfOperator

	
	
	/*
	 * Determines the precedence of the operators according to standard rules of precedence
	 */
	public int determinePrecedence( String operator ){
		
		int precedence = -1;
		
		switch( operator ){
		
		case "(":
		case ")":
			precedence = -1;
			break;
		case "^":
			precedence = 7;
			break;
		case "!":
			precedence = 6; 
			break;
		case "*":
		case "/":
		case "%":
			precedence = 5;
			break;
		case "+":
		case "-":
			precedence = 4;
			break;
		case "<":
		case ">":
			precedence = 3;
			break;
		case "=":
			precedence = 2;
			break;
		case "&":
			precedence = 1;
			break;
		case "|":
			precedence = 0;
			break;
		}
		
		return precedence;
	}//end of method determinePrecedence
	
	
	/*
	 * Takes the infix expression and converts it into postfix; the resulting postfix expression is stored in the
	 * class' queue. Steps are taken in accordance with the Shunting-Algorithm
	 */
	public void infixConv(){
		
		for(String currentExp: expressionArray){ //Loop through every element in the expression array
			
			String topOp = ""; //operator at the top of the operator stack
			
			if( determineIfOperator( currentExp ) == false ){ //if token is an operand, enqueue it
				
				
				queue.enqueue(currentExp);
			}
			
			else if( currentExp.equals("(") ){ //if token is an open parenthesis, push it onto the stack
				
				stack.push(currentExp);
			}
			
			/*
			 * if token is a closed parenthesis, pop every token on the stack and enqueue them one by one until
			 * an open parenthesis is found
			 */
			else if( currentExp.equals(")") ){ 
				
				topOp = stack.pop();
				
				while( !(topOp.equals("(")) ){
					
					queue.enqueue(topOp);
					
					topOp = stack.pop();
					
				}
					
			}
			
			else{
				
				if( stack.isEmpty() == true ){ //if stack is empty, push operator onto the stack
					
					stack.push(currentExp);
				}
				
				else{
					
					/*
					 * If the token is an operator, pop every token on the stack and enqueue them one by one until you
					*reach either an operator of lower precedence, or a right-associative operator of equal precedence
					*(e.g. the logical NOT is a right-associative operator). Enqueue the last operator found, and push
					*the original operator onto the stack.
					 */
	
					while( stack.isEmpty() == false ){
						
						topOp = stack.pop();
						
						if( topOp.equals("(") ){

							stack.push(topOp);
							break;
						}
						
						else if( determinePrecedence(topOp) >= determinePrecedence(currentExp) ){
							queue.enqueue(topOp);	
						}
						
						else{
							
							stack.push(topOp);
							break;
						}
						
					}
					
					stack.push(currentExp);
				}
			}
			
			
		}
		
		
		/*
		 * At the end of the input, pop every token that remains on the stack and add them to the queue
		 *	one by one.
		 */
		
		while(stack.isEmpty() == false){
			
			String temp = stack.pop();
			
			queue.enqueue(temp);
		}
		
	}//end of method infixConv
	
	/*
	 * postfix expression algorithm proceeds as follows:
	 1. Get the token at the front of the queue.
		2. If the token is an operand, push it onto the stack.
		3. If the token is an operator, pop the appropriate number of operands from the stack (e.g. 2
		operands for multiplication, 1 for logical NOT). Perform the operation on the popped
		operands, and push the resulting value onto the stack.
		Repeat steps 1-3 until the queue is empty. When it is, there should be a single value in the stack – that
		value is the result of the expression.
	 */
	public String postfixEval(){
		
		while( queue.isEmpty() == false ){
			
			String token = queue.dequeue();
			
			if( determineIfOperator(token) == false ){
				
				stack.push(token);
				
			}
			
			else{
				
				String operand1, operand2, output;
				
				if( token.equals("!") ){ //evaluate logical not separately, since it only takes one operand
					
					operand1 = stack.pop();
					
					output = performNotOperation(operand1);
					
					stack.push(output);
				}
				
				else{
					
					operand2 = stack.pop();
					operand1 = stack.pop();
					
					output = performOperation( operand1, operand2, token );
					
					stack.push(output);
				}
			}
		}
		
		String answer = stack.pop();
		
		return answer;

	}//end of method postfixEval
	
	/*
	 * Takes in two operands and an operator, converts the operands to doubles and performs the correct operation 
	 * according to the operator passed in. Returns the resulting calculation
	 */
	public String performOperation( String operand1, String operand2, String operator){
		
		double op1 = Double.parseDouble(operand1);
		double op2 = Double.parseDouble(operand2);
		
		double result = 0;
		
		switch( operator ){
		
		case "*":
			result = op1 * op2;
			break;
			
		case "/": 
			result = op1 / op2;
			break;
			
		case "+":
			result = op1 + op2;
			break;
			
		case "-":
			result = op1 - op2;
			break;
			
		case "<":
			if( op1 < op2 ){
				result = 1;
			}
			else{
				result = 0;
			}
			break;
			
		case ">":
			if( op1 > op2 ){
				result = 1; 
			}
			else{
				result = 0;
			}
			break;
			
		case "=":
			if( op1 == op2 ){
				result = 1; 
			}
			else{
				result = 0;
			}
			break;
			
		case "^":
			result = Math.pow(op1, op2);
			break;
			
		case "&":
		case "|":
			result = logicalAndOrOperation(op1, op2, operator);
			break;
			
		case "%":
			result = op1 % op2;
			break;
		}
		
		String answer = "" + result;
		
		return answer;
	}//end of method performOperation
	
	/*
	 * Performs the logical AND and OR operation (depending on which operator is passed in) on two operands.
	 * True is represented by 1, and false is represented by 0. Returns the calculation
	 */
	public double logicalAndOrOperation( double op1, double op2, String operator){
		
		if( operator.equals("&")){
			
			if(op1 == 1 && op2 == 1 ){
				return 1;
			}
			else{
				return 0;
			}
		}
		
		else{
			
			if( op1 == 0 && op2 == 0){
				return 0;
			}
			else{
				return 1;
			}
		}
	}//end of method logicalAndOrOperation
	
	/*
	 * Performs the logical NOT operation on an operand. Returns 1 for true and 0 for false
	 */
	public String performNotOperation(String operand){
		
		double op1 = Double.parseDouble(operand);
		
		if(op1 == 1){
			return "0";
		}
		else{
			return "1";
		}
		
	}//end of performNotOperation
		
	//start of main method
	public static void main(String[] args) {
			
		InfixCalculatorTest test; //initialize InfixCalculator Test object
		
		String inputFileName = args[0]; //input file to be taken in
		
	    String outputFileName = args[1]; //output file to write our evaluations to 
	    
		String currentLine = null; //current line from input file
		
		String output = ""; //output for postfix expression
		
		MyQueue<String> outputQueue = new MyQueue<String>(); //queue for our resulting output to be stored
		
		try{
			
			FileReader fileReader = new FileReader(inputFileName);
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
		
			while( ( currentLine = bufferedReader.readLine() ) != null ){ //for each line in the input file
				
				test = new InfixCalculatorTest(currentLine); //take in the infix expression
				
				test.infixConv(); //convert the infix expression to postfix
				
				output = test.postfixEval(); //evaluate the postfix expression
				
				outputQueue.enqueue( output ); //enqueue the calculated answer

			}
			
			bufferedReader.close();
			
		}
		
		catch(FileNotFoundException ex) {
            System.out.println("Unable to open input file " + inputFileName);                
        }
		
        catch(IOException ex) {
            System.out.println("Error reading input file "+ inputFileName);                  
        }
		
		
		//Write to the output file
		
	    try {
	        
	        FileWriter fileWriter = new FileWriter(outputFileName);

	        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	        while( outputQueue.isEmpty() == false ){ //Dequeue all the elements in the queue and write them to the output file one by one
	        	
	        	String current = outputQueue.dequeue();
	        	
	        	bufferedWriter.write(current);
	        	
	        	bufferedWriter.newLine(); //separate by a new line
	        }

	        bufferedWriter.close();
	    }
	    
	    catch(IOException ex) {
	    	System.out.println("Error writing to file " + outputFileName);
	    }
	    
		
	}//end of main method
	
	
}//end of class InfixCalculatorTest
