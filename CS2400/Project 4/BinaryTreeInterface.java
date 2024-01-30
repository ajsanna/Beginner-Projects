/*
 * Binary Tree Interface
 *  
 * By: 		Sanna, Alex
 * Due: 	December 2nd, 2022
 * Course:	CS-2400-002
 * 
 * Description:
 * 	This is the binary tree interface. It extends the TreeInterface and the TreeIteratorInterface
 * Meaning that a class that implements this interface must also implement those respectively. 
 */
public interface BinaryTreeInterface<T> 
			extends TreeInterface<T>, TreeIteratorInterface<T>
{
	/**
	 * SetTree method 
	 * Allows for a tree to be created with root data T. 
	 * @param rootData
	 */
	void setTree(T rootData);

	/**
	 * setTree method
	 * Allows for a tree to be made with 2 children. 
	 * @param rootData
	 * @param leftTree
	 * @param rightTree
	 */
	void setTree(T rootData, BinaryTreeInterface<T> leftTree,
 					BinaryTreeInterface<T> rightTree);
	
	
}
