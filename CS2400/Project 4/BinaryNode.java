/*
 * Binary Node Class
 *  
 * By: 		Sanna, Alex
 * Due: 	December 2nd, 2022
 * Course:	CS-2400-002
 * 
 * Description:
 * 		This is the implementation of the BinaryTree class. 
 * 		it serves to conduct operations on the data held within the Node.
 * 		BinaryTrees are made of these nodes, with a maximum of 2 children per node. 
 * 		Method and data descriptions specified below
 */


public class BinaryNode<T> 
{
	/*
	 * Data Storage
	 * Holds a reference to the data of this node, as well as a reference to this nodes children if it has any. 
	 */
	private T data;
	private BinaryNode<T> leftChild;
	private BinaryNode<T> rightChild;


	/* 
	 * Default Constructor. calls BinaryNode(T data()); with a null value for data. 
	 */
	public BinaryNode()
	{
		this(null);
	}

	/*
	 * Default Constructor 2. Calls BinaryNode(T data, BN LHS, BN RHS); with null values for LHS and RHS
	 */
	public BinaryNode(T data)
	{
		this(data, null, null);
	}
	/*
	 * Base Constructor. Takes in 3 parameters and sets them to their respective areas. 
	 * T data, LHS and RHS
	 */
	public BinaryNode(T data, BinaryNode<T> LHS, BinaryNode<T> RHS)
	{
		this.data = data; 
		this.leftChild = LHS;
		this.rightChild = RHS;
	}
/*
 * Accessor method. returns the T data reference being stored.
 */
	public T getData()
	{
		return data;
	}

/*
 * Mutator method. allows the T data reference to be changed.
 */
	public void setData(T data)
	{
		this.data = data;
	}

/*
 * Accessor method. returns the left child reference being stored.
 */
	public BinaryNode<T> getLeftChild()
	{
		if(leftChild == null)
		{
			return null; 
		}
		return leftChild;
	}
/*
 * Accessor method. returns the right child reference being stored.
 */
	public BinaryNode<T> getRightChild()
	{
		if(rightChild == null)
		{
			return null; 
		}
		return rightChild;
	}

/*
 * Mutator method. allows the left child reference to be changed.
 */
	public void setLeftChild(BinaryNode<T> left)
	{
		this.leftChild = left;
	}

/*
 * Mutator method. allows the right child reference to be changed.
 */
	public void setRightChild(BinaryNode<T> right)
	{
		this.rightChild = right;
	}

/*
 * Boolean method. indicates whether the node has a left child. 
 */
	public boolean hasLeftChild()
	{
		return leftChild != null;
	}

/*
 * Boolean method. indicates whether the node has any children. 
 */
	public boolean isLeaf()
	{
		return leftChild == null && rightChild == null;
	}

/*
 * Value method. indicates how many nodes are below the respective node. 
 */
	public int getNumberOfNodes()
	{
		if(data == null)
		{
			return 0;
		}
		else return getNumberOfNodes(this);

	}
	private int getNumberOfNodes(BinaryNode<T> root)
	{
		int number = 1; 
		BinaryNode<T> left = root.getLeftChild();
		BinaryNode<T> right = root.getRightChild();

		if(left!=null)
		{
			number += getNumberOfNodes(left);
		}
		if(right!= null)
		{
			number+= getNumberOfNodes(right);
		}
	

		return number; 
	}
	
/*
 * value method. returns the number of levels in the tree. 
 */
	public int getHeight()
	{
		int lHeight = 1;
		int rHeight = 1;
		BinaryNode<T> left = getLeftChild();
		BinaryNode<T> right = getRightChild();
		if(data == null)
		{
			return 0; 
		}
		while(left!= null)
		{
			lHeight++; 
			left = left.getLeftChild();
		}
		while(right != null)
		{
			rHeight++;
			right = right.getRightChild();
		}
		return lHeight > rHeight ? lHeight : rHeight;
	}
	
}
