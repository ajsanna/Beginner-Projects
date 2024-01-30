/*
 * Expression Test Class
 *  
 * By: 		Sanna, Alex
 * Due: 	December 2nd, 2022
 * Course:	CS-2400-002
 * 
 * Description:
 * 		This class contains the main method in the Expression tree project. 
 * 		It takes the first argument in the argument string array and passes it
 * 		to the ExpressionTree Constructor. For the algorithm to work, the argument must
 * 		be in postfix form. No error handling is incoorperated to handle an inproper 
 * 		argument. This main method also calls the postorder method to display the 
 * 		expression tree postorder traversal with the provided argument. 	
 */

 public class ExpressionTest 
{	public static void main( String[] args)
	{
		if(args.length == 0 )
		{
			System.out.println("An error has occurred, inproper input. please try again.");
			System.exit(0);
		}
	//	^ this code will deal with a null input. 

		String[] arguments = args[0].split(" ");
	//	^ arguments represents the postfix expression being passed in. 
	// this is done using a String.split on the first argument. 
	// the input to the program must be incased in quotes for this to work. 

		ExpressionTreeInterface theOperationTree = new ExpressionTree(arguments);
		ExpressionTree theTree = (ExpressionTree)(theOperationTree);
	// 	Lines 25 and 26 represent the creation of the ExpressionTree data structure.
	// theTree is used to cast theOperationTree into a ExpressionTree type, rather
	// than a ExpressionTreeInterface<T> type so that the postfix method can be called.


	// The Code below is the structured output specifed by the project description
		System.out.println("Expression Tree by A. Sanna");
		System.out.println();
		System.out.println("Input: " + args[0]);
		System.out.println("Value: " + theOperationTree.evaluate());
		System.out.println();
		System.out.println("Postorder Traversal:");
		theTree.postorder();
		
		testingMethod(theOperationTree);
		//may comment out this line above to prevent testing to display. 
	}


	/*
	 * This is my testing method. 
	 * 
	 * It tests all functions of the BinaryTree not previously used. 
	 */
	public static void testingMethod(ExpressionTreeInterface theOperationTree)
	{


		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Demo of Testing begins below");
		System.out.println("height of tree = " + theOperationTree.getHeight());
		System.out.println("number of Nodes = " + theOperationTree.getNumberOfNodes());
		System.out.println("the root node is " + theOperationTree.getRootData());
		
		System.out.println("Clear test:");
		theOperationTree.clear();
		System.out.println("the root node is now: " + theOperationTree.getRootData());
	}
}
