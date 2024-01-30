/*
* 	Name: Alexander J Sanna 
* 	Project 3
* 	Due: October 17th, 2022
* 	Course: cs-2400-02-f22
* 
* 
* Description:
* 			This is the Expression. it has 2 main methods. convert to postfix, evaluate postfix.
* 			It also has methods checkIsDouble and CheckPrec
*/

import java.util.ArrayList;
import java.util.EmptyStackException;
public class Expression 
{


	/**
	 * Takes in a infix expression in the form of a string array. returns the same expression in postfix form
	 * @param infixExpression 
	 * @return the infix expression in postfix form 
	 */
	public static String[] convertToPostfix(String[] infixExpression)
	{
		InterfaceStack<String> operatorStack = new ArrayStack<>();
		ArrayList<String> postfix = new ArrayList<>();
		int count = 0; 

			while (count < infixExpression.length) 
			{ 		
				String nextString = infixExpression[count];
				
				if (nextString.compareTo("+") ==0 ||nextString.compareTo("-") ==0 || nextString.compareTo("x") ==0 ||nextString.compareTo("/") ==0)
				{	// + - x / 
					while(!operatorStack.isEmpty() && checkPrec(nextString, operatorStack))
					{
						postfix.add(operatorStack.pop());
						
					}
					
					operatorStack.push(nextString);
					
				} 
				else if(nextString.compareTo("^")==0) //power operator 
				{ 
					operatorStack.push(nextString);

				}
				else if(nextString.compareTo("(")==0) //open p
				{
					operatorStack.push(nextString);
				
				}
				else if(nextString.compareTo(")")==0) // close p 
				{
					String topOperator = operatorStack.pop();
					
					while(!topOperator.equals("("))
					{
						
							postfix.add(topOperator);
							topOperator = operatorStack.pop();
						
					}
				}
				else
				{
					if(checkIsDouble(nextString))
					{
						postfix.add(nextString);
					}
					else
					{
						//do nothing 
					}
				}
				count++;
			}
			while(!operatorStack.isEmpty())
			{
				String topOperator = operatorStack.pop();;
			
				
				
				postfix.add(topOperator);
			}
				String[] officialPostfix = postfix.toArray(new String[0]);
			
		return officialPostfix;
	}




	/**
 	*  evaluates the postfix expression after it is converted
 	* @param postfixExpression
 	* @return the result of the evaluation in double form
 	*/
	public static double evaluatePostfix (String[] postfixExpression)
	{
		InterfaceStack<Double> valueStack = new ArrayStack<>();
		int count = 0; 
		while(count < postfixExpression.length)
		{
			String nextString = postfixExpression[count];
				if(checkIsDouble(nextString))
				{ //is a double
					Double number = Double.parseDouble(nextString);
					valueStack.push(number);
				
				}
				else
				{
					double result = 0; 
					double rhs = valueStack.pop();
					double lhs = valueStack.pop();
					if(nextString.equals("+"))
					{
						result = rhs + lhs; 
					}
					else if(nextString.equals("-"))
					{
						result = lhs - rhs; 
					}
					else if(nextString.equals("x"))
					{
						result = rhs * lhs; 
					}
					else if(nextString.equals("/"))
					{
						result = lhs / rhs; 
					}
					else if(nextString.equals("^"))
					{
						result = Math.pow(lhs,rhs); 
					}

					valueStack.push(result);
					

				}

			count++;

		}

		
		return valueStack.peek();
	}




	/**
 	*  Checks to see if an argument is a valid double. utilizes try catch
 	* @param s the string being passed in 
 	* @return boolean stating whether the string is a double or not
 	*/
	public static boolean checkIsDouble(String s)
	{
		boolean valid = true;
		try{
				String str = s;
         		Double doub = Double.parseDouble(str);
				 doub++;
      }
	  catch (NumberFormatException ex) {
        
		 valid = false;
      }
	  return valid;
	}




	/**
 	*  Checks the precedent of the operations 
 	* @param s operator being compared
 	* @param OP stack of operations
	 * @return boolean stating wheter the operation takes precendence over those in the stack
	 */

	public static boolean checkPrec(String s, InterfaceStack<String> OP)
	{
		InterfaceStack<String> operatorStack = OP;
		boolean hasPrec = false; 
		if(s.equals("+")|| s.equals("-"))
		{
			if(operatorStack.peek().equals("x")||operatorStack.peek().equals("/")||operatorStack.peek().equals("^")||operatorStack.peek().equals("+")||operatorStack.peek().equals("-"))
			{
				hasPrec = true; 
			}
		}
		else if(s.equals("x") || s.equals("/"))
		{
			if(operatorStack.peek().equals("-")||operatorStack.peek().equals("+"))
			{
				hasPrec = false; 
			}
			else if(operatorStack.peek().equals("^")||operatorStack.peek().equals("x")||operatorStack.peek().equals("/"))
			{
				hasPrec = true; 
			}
	
		}

		
		

		return hasPrec; 
	}
		public static void testExceptions()
		{	
			InterfaceStack<String> testStack = new ArrayStack<>();
			try{
				testStack.pop();
			}catch(Exception EmptyStackException)
			{
				System.out.println("\tPop unsuccessful, Empty Stack!");
			};

			try{
				testStack.peek();
			}catch(Exception EmptyStackException)
			{
				System.out.println("\tPeek unsuccessful, Empty Stack!");
			};
			
		}
}
