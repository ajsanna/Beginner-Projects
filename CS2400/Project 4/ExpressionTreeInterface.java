/*
 * Binary Tree Interface
 *  
 * By: 		Sanna, Alex
 * Due: 	December 2nd, 2022
 * Course:	CS-2400-002
 * 
 * Description:
 * 		This is the expressiontree interface. IMPORTANT:
 * 		THIS IS A BINARY TREE. 	this extends binary tree interface!
 */

public interface ExpressionTreeInterface 
		extends BinaryTreeInterface<String> 
{
	/**
	 * This is the evaluate method. every expression tree can evaluate to a final answer
	 * @return the value of evaluation
	 */
	double evaluate();
	
}
