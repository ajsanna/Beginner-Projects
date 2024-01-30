/*
 * Tree Interface
 *  
 * By: 		Sanna, Alex
 * Due: 	December 2nd, 2022
 * Course:	CS-2400-002
 * 
 * Description:
 * 		This is the tree interface, it specifies the required methods to have a tree
 * 		data structure. It can be implemented by other tree interfaces for more specific
 * 		interpretations but this is the most basic, least specific tree you can get.  
 */

public interface TreeInterface<T> 
{
/** getRootData()
 * 	this method will return the reference held within the tree.
 * @return T the data reference held within the tree
 */
	T getRootData();

/**
 * getHeight()
 * returns the number of levels of the tree. 
 * @return int number of levels
 */
	int getHeight();

/**
 * getNumberOfNodes()
 * counts the number of Nodes in the tree. 
 * @return int, number of nodes in tree. 
 */
	int getNumberOfNodes();

/**
 * isEmpty()
 * checks if there is data within the tree. 
 * @return boolean: if the tree contains data. 
 */
	boolean isEmpty();

/**
 * clear()
 * scrubs the tree clean
 */
	void clear();

	
}
