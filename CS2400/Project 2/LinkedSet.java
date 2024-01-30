/*
 * 	Name: Alexander J Sanna 
 * 	Project 2
 * 	Due: October 7th, 2022
 * 	Course: cs-2400-02-f22
 * 
 * 
 * Description:
 * 			Linked set is the creator class for the linked list data structure. along with the inner class node.
 */


public final class LinkedSet<T> implements SetInterface<T>
{
	//fields: 
	//size refects the number of items in set 
	//Node denotes the reference to the firstNode in the set currently
	private int size ;
	private Node firstNode;

	//Constructor
	public LinkedSet() 
	{
		firstNode = null;
		size = 0;
	}

	//returns the number of items in set. 
	public int getCurrentSize() 
	{
		return size;
	}


	//returns boolean indicating whether set is empty
	public boolean isEmpty() 
	{
		return size == 0;
	}
	
	//adds a specified data entry into the set in node form 
	public boolean add(T newEntry) 
	{
		boolean success;
		if(this.contains(newEntry))
		{
			success = false;
		}
		else
		{
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;
		firstNode = newNode;
		size++;
		success = true;
		}
		

		return success;
	}
		//removes specified entry from the set. returns boolean indicating success
	public boolean remove(T anEntry) throws IllegalArgumentException 
	{ 
		boolean success;
		if(this.contains(anEntry) == false)
		{
			success = false;
			System.out.println("Error. Illegal Argument");
			throw new IllegalArgumentException("Illegal Argument");
		}
		else
		{
			Node currentNode = firstNode;

			while(currentNode != null)
			{
				if(currentNode.data == anEntry)
				{
					currentNode.data = firstNode.data;
					firstNode = firstNode.next;
				}
				currentNode = currentNode.next;
			}
				
			success = true; 
			
		}
		size--;
		return success;

	}
	//removes firstNode from the set and returns the item removed
	public T remove() 
	{


		T removedNode = firstNode.data;
		firstNode.data = null;
		firstNode = firstNode.next;

		size--;


		return removedNode;


	}
		//sets the entire set to null by setting the first node to null and the size to 0. 
	public void clear()		
	{
		Node current = firstNode;
		while(current != null)
		{
			current.data = null; 
			Node nextNode = current.next;
			current = null; 
			current = nextNode; 
		}

		firstNode = null;
		size = 0;
	}
	//searches the entire set via loop to search for an entry, returns boolean indicating found?
	public boolean contains(T anEntry) //DONE
	{
		Node tempNode;
		tempNode = firstNode;
		boolean found = false;
		
		if(size == 1)
		{
				found = (anEntry == firstNode.data) ? true : false;
		}
		else if(size == 0 )
		{
			found = false;
		}
		else
		{	
			while(tempNode != null )
			{
				if(tempNode.data == anEntry)
				{
					found = true;
					break;
				}
				tempNode = tempNode.next;
			}
		}
		
		return found; 
	}
	//toArray method returns the set in form of an array. 
	public T[] toArray() //DONE
	{

		@SuppressWarnings("Unchecked")
		T[] items = (T[])new Object[size];

		Node tempNode;
		tempNode = firstNode;
		int i = 0; 

		while(tempNode != null)
		{	
			items[i] = tempNode.data;
			
			i++;
			tempNode = tempNode.next;
		}

		return items;

	}
	//loops through a set to indicate whether lhs is a subset of rhs. returns boolean. 
	public boolean subset(SetInterface<T> setB)	//done
	{
		boolean isSubset = true;

			if(this.getCurrentSize()==0)
			{
				isSubset = true;
			}
			else if(this.size > setB.getCurrentSize())
			{
				isSubset = false;
			}
			else if (size == setB.getCurrentSize())
			{
				isSubset = (this.equals(setB)) ? true : false;
			}
			else
			{
				Node temp; 

				temp = this.firstNode;


				while(temp != null)
				{

					isSubset = (setB.contains(temp.data)) ? true : false;

					temp = temp.next;
				}


			}
			

		return isSubset; //STUB
	}
	//equals method compares the 2 sets and if all elements of LHS are *contained in RHS, returns true
	public boolean equals(SetInterface<T> setB)
	{
		boolean equals = true;
		SetInterface<T> set2 = setB;
		if(this.getCurrentSize() != set2.getCurrentSize())
		{
			equals = false; 
		}
		else
		{
			Node current = firstNode;
			while(current != null)
			{
				if(set2.contains(current.data))
				{
					current = current.next;
				}
				else
				{
					equals = false; 
					current = null;
				}	
			}
			
		}
		
		return equals;
		
	}
//takes LHS and RHS and combines them into a single set utilizing the toArray method for both sets. 
	public SetInterface<T> union(SetInterface<T> setB)
	{

		SetInterface<T> combinedSet = new LinkedSet<>();
		T[] array1 = this.toArray();
		T[] array2 = setB.toArray();
		for(T a : array1)
		{
			combinedSet.add(a);
		}
		for(T b : array2)
		{
			combinedSet.add(b);
		}
		
		return combinedSet;

	}
	//takes the entire set and converts it into a single string. utilizes concat method. 
	@Override
	public String toString()
	{
		String returnValue = "{ ";
		String cSpace = ",";
		Node temp; 
			temp = firstNode; 
		if(this.getCurrentSize()== 0){
			returnValue = "{}";
		}
		else if(this.getCurrentSize() == 1)
		{
			returnValue = "{ " + firstNode.data + " }";

		} 
		else
		{
			while(temp != null)
			{
				String data = temp.data.toString();
				
				returnValue = returnValue.concat(data);	
				if(temp.next !=null)
				{
					returnValue = returnValue.concat(cSpace);		
				}	
				
				temp = temp.next;
			}
		}
		String end = "";
		if(size>1){
		end = " }";
		}
		
		returnValue = returnValue.concat(end);
		return returnValue;
	}
		//Node class to create nodes. 
	class Node //DONE
	{
		private T data;
		private Node next;

		private Node(T data)
		{
			this(data, null);
		}
		private Node(T data, Node nextNode)
		{
			this.data = data;
			next = nextNode;
		}
	}

}

