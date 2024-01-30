/*
 * Tree Iterator Interface
 *  
 * By: 		Sanna, Alex
 * Due: 	December 2nd, 2022
 * Course:	CS-2400-002
 * 
 * Description:
 * 		This interface specifies the required methods for an iterator class. 
 * 	these iterators would be utilized to traverse the trees in a specified order. 
 */

import java.util.Iterator;

public interface TreeIteratorInterface<T>
{
	 /**
	  * This method will return a preorder iterator to traverse the Tree. 
	  * getPreorderIterator
	  * @return Iterator<T>
	  */
	Iterator<T> getPreorderIterator();
	/**
	 * This method will return a postorder iterator to traverse the Tree. 
	 * getPostorderIterator
	 * @return Iterator<T> 
	 */
	Iterator<T> getPostorderIterator();
	/**
	 * This method will return an inorder iterator to traverse the Tree. 
	 * getInorderIterator
	 * @return Iterator<T>
	 */
	Iterator<T> getInorderIterator();
	/**
	 * This method will return a level order iterator to traverse the Tree. 
	 * getLevelOrderIterator
	 * @return Iterator<T>
	 */
	Iterator<T> getLevelOrderIterator();

}	
