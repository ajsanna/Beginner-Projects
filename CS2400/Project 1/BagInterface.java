
/*
 * 	Name: Alexander J Sanna 
 * 	Project 1
 * 	Due: September 26th, 2022
 * 	Course: cs-2400-02-f22
 * 
 * 
 * Description:
 * 			Interface for th creation of arraybag. these are the required methods to have a bag.
 * The arraybag class will implement this to make a bag using the array data type. 
 */

public interface BagInterface <T>
{
	
	int getCurrentSize();

	boolean isEmpty();

	boolean add(T newEntry);

	T remove();

	boolean remove(T anEntry);

	void clear();

	int getFrequencyOf(T anEntry);

	boolean contains(T anEntry);

	T[] toArray();

	

}