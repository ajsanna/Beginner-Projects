/*
 * Binary Tree Class
 *  
 * By: 		Sanna, Alex
 * Due: 	December 2nd, 2022
 * Course:	CS-2400-002
 * 
 * Description:
 * 		Binary Tree Class
 *	This class implements the methods specified in the BinaryTreeInterface. 
 * it serves to create BinaryTree objects that can be used to represent numbers in an expression. 
 * The implementation consists of the BinaryNode. 
 * The BinaryTreeInterface implements TreeInterface and TreeIteratorInterface, making their respective 
 * methods neccessary in the implementation of BinaryTree. 
 * 
 *	*** ALL METHOD DESCRIPTIONS SPECIFIED IN THE BINARY TREE INTERFACE ***
 */

import java.util.Iterator;

public class BinaryTree<T> implements BinaryTreeInterface<T>
{
	private BinaryNode<T> node;
		// this is how the data is stored for the BinaryTree object. 
	
//BASIC TREE FUNCTIONS

	protected BinaryNode<T> getRootNode()	//protected so that any classes that extend this have access.
	{
		return node; 
	}
	protected void setRootNode(BinaryNode<T> node) //protected so that any classes that extend this have access.
	{
		this.node = node; 
	}

	public BinaryTree()	// default constructor. creates the binaryNode with null data. 
	{
		node = new BinaryNode<>();
	}

	public BinaryTree(T data)	// constructor. creates binaryNode with T data. 
	{
		node = new BinaryNode<>(data);
	}
	
	public T getRootData()
	{
		return node.getData(); 
	}

	public int getHeight()
	{
		return node.getHeight(); 
	}

	public int getNumberOfNodes()
	{
		
	return node.getNumberOfNodes();

	}

	public boolean isEmpty()
	{
		return node.getData() == null; 
	}

	public void clear()
	{
		clear(getRootNode());
	}
	private void clear(BinaryNode<T> root)
	{
		BinaryNode<T> leftChild = root.getLeftChild();
		BinaryNode<T> rightChild = root.getRightChild();
		if(getRootData()== null)
		{
			return;	//empty tree.
		}
		if(leftChild != null)
		{
			clear(leftChild);
		}
		if(rightChild != null)
		{
			clear(rightChild);
		}

		root.setData(null);
		root.setLeftChild(null);
		root.setRightChild(null);
		root = null;
	}

//BINARY TREE SPECIFIC

	public void setTree(T rootData)	
	{
		node.setData(rootData);
	}

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
	{
		node.setData(rootData);
		// to create the left and right children in BinaryNode, we must convert the BinaryTreeInterfaces
		// to BinaryTree<T> utilizing a cast. 
		BinaryTree<T> leftSide = (BinaryTree<T>)(leftTree);
		BinaryTree<T> rightSide = (BinaryTree<T>)(rightTree);
		BinaryNode<T> left = leftSide.getRootNode();
		BinaryNode<T> right = rightSide.getRootNode();
		node.setRightChild(right);
		node.setLeftChild(left);
	}
	

//ITERATORS
	
	public Iterator<T> getPreorderIterator() 
	{
		System.out.println("Not yet implemented");
		return null; //stub
	}

	public Iterator<T> getPostorderIterator()
	{
		System.out.println("Not yet implemented");
		return null; //stub
	}

	public Iterator<T> getInorderIterator()
	{		
		System.out.println("Not yet implemented");
		return null; //stub
	}
	public Iterator<T> getLevelOrderIterator()
	{
		System.out.println("Not yet implemented");
		return null; //stub
	}

}
