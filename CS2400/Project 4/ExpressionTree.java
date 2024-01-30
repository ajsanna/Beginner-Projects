/*
 * Expression Test Class
 *  
 * By: 		Sanna, Alex
 * Due: 	December 2nd, 2022
 * Course:	CS-2400-002
 * 
 * Description:
 * 		This class is the implementation of the ExpressionTreeInterface, however is not generic. 
 * 		This class is utilized with the assumption that all data inputted can be represented in string
 * 		format. This means that it implements a String specific Expression Tree Interface. 
 * 		It creates the tree with the constructor and provides the evaluate method that will return a 
 * 		value for the entire tree. Also has a postorder method, specified by the project description. 
 * 
 * 		*** This class also extends BinaryTree, allowing it access to all public and protected methods. 	
 */

import java.util.Stack;

public class ExpressionTree extends BinaryTree<String> implements ExpressionTreeInterface
{
	
	/*	ExpressionTree constructor
	 * 	@param: String [] postfix, the postfix expression to be represented
	 * 	Description: 
	 * 		This constructor takes in a String Array titled postfix that this method serves to convert to a Binary tree
	 * 		It first does a simple check to ensure there are more than 3 arguments in the expression.
	 * 		It then creates a stack data structure to temporarily store data for the intent of ordering the 
	 * 		operations correctly. for every argument in the array being passed in, the method checks if it is an operator: + - x / 
	 * 		if the argument is not an operator, a Binary Tree Interface is created and the data is set to that of the argument. 
	 * 		this BTI is then pushed on the stack and represents an operand. If the argument is an operator, a BTI is created, 
	 * 		the operator is set as the data, the 2 most recent BTI's on the stack are popped off, a new tree is created with the 
	 * 		operator as the root and the 2 operands as the children. This is then pushed back on the stack. Eventually, the only
	 * 		BTI on the stack will be the complete tree. At which point the root node is set to the root node of this ExpressionTree. 
	 */
	public ExpressionTree(String[] postfix)
	{
		if(postfix.length < 3 )	//inproper input.
		{
			System.out.println("An error has occurred, inproper input. please try again.");
			System.exit(0);
		}

		Stack<BinaryTree<String>> theStack = new Stack<>();	//storing the portions of the tree as its created.

		for(String argument : postfix)
		{	
			if(argument.equals("+")||argument.equals("-")||argument.equals("/") || argument.equals("x"))
			{
				BinaryTreeInterface<String> rhs = theStack.pop();
				BinaryTreeInterface<String> lhs = theStack.pop();
				BinaryTree<String> exp = new BinaryTree<>();

				exp.setTree(argument, lhs, rhs);
				theStack.push(exp);
				//this is an operator, pop the most recent 2 off the stack, create new Binarytree and push back on. 
			}
			else
			{
				//assume this is a operand, push it onto the stack.
				BinaryTree<String> operand = new BinaryTree<>();

				operand.setTree(argument);
				theStack.push(operand);
			}
		}	//end for loop, going through all arguments
		
		this.setRootNode(theStack.pop().getRootNode());
		// this line specifically takes the BinaryTree at the top of the stack, gets its rootNode and sets
		// 		the root node of the ExpressionTree to such. thereby finalizing the creation of this tree.
	}

	/*
	 * Evaluate Methods
	 * @param: None
	 * @return: double, the final evaluated value of the tree. 
	 * 
	 * Description: 
	 * 		The public evaluate method: calls the private evaluate method with the root node as a parameter.
	 * 		The private evaluate method: This is a method designed to incoorperate a recursive aspect in order 
	 * 		to go through every single subtree that may exist. 
	 * 
	 * 		Starting out, to organize the process, two BinaryNodes are created to represent the left and right 
	 * 		children of the root node. the root node being the current parameter being passed in. 
	 * 		if the left and right child are null, the value of the root is returned. this means we have
	 * 		reached a node. all nodes are operands. if the node being passed in is not a leaf,
	 * 		we call evaluate again with the node's children as the parameter, thereby going down a level in the tree. 
	 * 		after the method is processed, the operation is conducted. a .equals is incoorperated to determine which 
	 * 		operation is to be conducted. 
	 */
	public double evaluate()
	{
		 BinaryNode<String> root = getRootNode();
		double result = evaluate(root);
//calls the recursive method with the root node. 
		return result;
	}

//this is the recursively designed private method
	private double evaluate(BinaryNode<String> root)	//root is the node being processed. 
	{
		BinaryNode<String> leftChild = root.getLeftChild();	//root's left child
		BinaryNode<String> rightChild = root.getRightChild();	//root's right child
		if(root.isLeaf()) //checks if the node "ROOT" has children
		{
//if the node "ROOT" has no children, it is a leaf, therefor an operand. 
//the value associated with the "ROOT" node is returned.
			return Double.parseDouble(root.getData());
		}

		// the following code will only run if the node "root" is not a leaf. 

		double left = evaluate(leftChild);
//calls this method again with the leftChild to determine if there are any subtrees. 
// the method will return the value of the evaluation of the subtree if one exists.
		double right = evaluate(rightChild);
//calls this method again with the rightChild to determine if there are any subtrees. 
// the method will return the value of the evaluation of the subtree if one exists.

		if(root.getData().equals("x"))
        {
            return left * right; 
        }
        if(root.getData().equals("-"))
        {
            return left - right; 
        }
        if(root.getData().equals("+"))
        {
            return left + right; 
        }
        else
		{
            return left / right; 
		}	
	}
	
/*	postorder method (public)
 * 	no return, no parameters
 * 	**** debugging method ****
 * 
 * Description: 
 * 		calls the private method with the root node as a parameter. 
 * 		it must be done this way because the client classes do not have access to the root node. 
 */
	public void postorder()
	{
		postorder(getRootNode());
	}

/* 	postorder method (private)
 * 	parameter: a BinaryNode
 * 
 * 	Description: Prints the tree by LEFT, RIGHT, NODE format.
 * 		This is a recursively designed method that serves to print out a depiction of what the ExpressionTree looks like.
 * 	it first sets references to the children of the BinaryNode "root" being passed in.
 * 	this is a very simple method. it checks if the left node is null, if it isnt, the method calls itself but this time 
 * 	it passes in the left node as the new "root." This allows us to go through every node until we reach the bottom left. 
 * 	once we reach the bottom left, we first print the left node, using line 175. then the right with line 172.
 * 	if the Node "root" has two children it is printed using the format on line 173.
 */
	private void postorder(BinaryNode<String> root)
	{	
		
		BinaryNode<String> left = root.getLeftChild();
		BinaryNode<String> right = root.getRightChild();

		if(left!=null)
		{
			postorder(left);
		}
		if(right!=null && left !=null)
		{
		System.out.println(right.getData());
		System.out.println(left.getData() + " : " + root.getData() + " : " + right.getData());
		}
		else	{	System.out.println( root.getData() );	}
		
	}
}
