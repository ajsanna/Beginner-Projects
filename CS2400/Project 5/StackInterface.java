/*
* 	Name: Alexander J Sanna 
* 	Project 3
* 	Due: October 17th, 2022
* 	Course: cs-2400-02-f22
* 
* 
* Description:
* 			This is the InterfaceStack. it sets the methods that any implementation should follow. 
*/

public interface StackInterface <T>
{
/**Adds a new entry to the top of this stack.
@param newEntry An object to be added to the stack. */

void push( T newEntry);
/** 
 * Removes and returns this stack's top entry.
@return The object at the top of the stack. 
@throws EmptyStackExceptionif the stack is empty before the operation.
 */
	T pop();
/** Retrieves this stack's top entry.
@return The object at the top of the stack.
@throws EmptyStackExceptionif the stack is empty. */
	T peek();
/** Detects whether this stack is empty.
@return True if the stack is empty. */
	boolean isEmpty();
/** Removes all entries from this stack. */
	void clear();


}