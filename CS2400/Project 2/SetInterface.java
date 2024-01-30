/*
 * 	Name: Alexander J Sanna 
 * 	Project 2
 * 	Due: October 7th, 2022
 * 	Course: cs-2400-02-f22
 * 
 * 
 * Description:
 * 			Interface for the creation of Set. these are the required methods to have a set.
 * The LinkedSet class will implement this to make a set using the linkedlist data structure. 
 */


 /**
  * @author Alex_Sanna
  */
public interface SetInterface <T>
{
	/**
	 * returns the size of the SetInterface
	 * @return int ; 
	 */
	int getCurrentSize();
	/**
	 * returns whether the setInterface is empty
	 * @return boolean ; 
	 */
	boolean isEmpty(); 
	/**
	 * takes data as a param and adds to the set. returns boolean indicating whether the add is success
 	* @param newEntry the data to be added to the SetInterface
	 * @return	
	 */
	boolean add(T newEntry);
	/**		
	 * takes in data as a parameter and removes s it from the set. 
	 * returns boolean to indicate whether the removal was sucessful 
	 * 
	 * @param anEntry the data to be remvoed from the set
	 * @return  boolean to indicate whether the add was sucessful 
	 *  */ 
	boolean remove(T anEntry);
	/**
	 * removes the first entry of the set
	 * @return the object removed from the setInterface
	 */
	T remove();
	/**
	 * clears the entire set. 
	 * @return void
	 *
	 */
	void clear();
	/**
	 * scans the entire set to see if the parameter is present
	 * @param anEntry the data to be scanned for in the set 
	 * @return boolean indicating whether T was found 
	 */
	boolean contains(T anEntry);
	/**
	 * converts the set into an array and returns the array
	 * @return object array. 
	 * converts this set into an array type
	 */
	T[] toArray();
	/**
	 * scans 2 sets and returns boolean indicating whether the set calling this method is a subset of the parameter
	 * @param setB a set that is being compared
	 * @return boolean indicating whether this is a subset of param
	 */
	boolean subset(SetInterface<T> setB);
	/**
	 * scans 2 sets and returns boolean indicating whether the set calling this method is equal to the parameter
	 * @param setB a set that is being compared
	 * @return	boolean indicating whether the sets are equal or not
	 */
	boolean equals(SetInterface<T> setB);
	/**
	 * takes a setInterface as a paramter and adds it to the beginning of the set calling the method. returns a new setInterface.
	 * @param setB a set that is being added to THIS
	 * @return	SetInterface<T> the set that is the 2 sets union
	 */
	SetInterface<T> union(SetInterface<T> setB);
	/**
	 * 	returns the string of whatever state the SetInterface is in 
	 * @return String in the format of the set. 
	 */
	String toString();

}	