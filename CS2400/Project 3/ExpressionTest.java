/*
* 	Name: Alexander J Sanna 
* 	Project 3
* 	Due: October 17th, 2022
* 	Course: cs-2400-02-f22
* 
* 
* Description:
* 			the application. runs the main methods of expression. Also incoorperates tests on the main code.
Tests the exceptions in Expression class. 
*/
public class ExpressionTest 
{
	public static void main(String[] args)
	{
		
		String[] arguments = args[0].split(" "); //splits the arguments into a string array
		
		String[] postFix = Expression.convertToPostfix( arguments );
		//converts infix to postfix
		
		double result = Expression.evaluatePostfix(postFix);
			//evaluates the postfix expression
	

		System.out.println(result);	
			//prints result 
		System.out.println();	
		System.out.println("Testing begins below:");
		System.out.println();
		System.out.println("Trying to pop and peek with an empty stack:");
		Expression.testExceptions(); //tests peek and pop with empty stacks.

		System.out.println();
		System.out.println("( ( 2 ^ 2 ) + 5 ) / 3 + 10 " );
		String test = "( ( 2 ^ 2 ) + 5 ) / 3 + 10 ";
		String[] testArgs = test.split(" ");
		String[] toPost = Expression.convertToPostfix(testArgs);
		System.out.println("= " + Expression.evaluatePostfix(toPost)  );




		//double result = Expression.evaluatePostfix(postFix);

		//System.out.println(result);
	}



}
