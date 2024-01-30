import java.util.NoSuchElementException;

/*
 * 	Name: Alexander J Sanna 
 * 	Project 1
 * 	Due: September 26th, 2022
 * 	Course: cs-2400-02-f22
 * 
 * 
 * Description:
 * 			this is the array bag. the implementation of the bag using the BagInterface interface. it follows the rules 
 * set out by the interface to create a bag data structure utilizing the array data type. 
 */


public final class ArrayBag<T> implements BagInterface<T>
{
	private T[] bag;	//initializes the object array
	private int numberOfEntries;	//initializes the number of objects in the bag. 
	private static final int DEFAULT_CAPACITY = 200; //a default amount for which the bag can hold. 

	/**
	 * Arraybag 
	 * DEFAULT CONSTRUCTOR
	 * implements method overloading to ensure a bag is created whether size is specified or not. 
	 * uses "this" to call the main constructor
	 */
	public ArrayBag()	
	{
		this(DEFAULT_CAPACITY);
	}
	/**
	 * @param int capacity- used to determine the size of the array being created. 
	 * this is the main constructor. 
	 * creates the bag, and sets the number of Entries to 0.
	 */
	public ArrayBag(int capacity)
	{
		@SuppressWarnings("Unchecked")
		T[] tempBag = (T[])new Object[capacity];	//unchecked cast into object array
		bag = tempBag; 
		numberOfEntries = 0; 
	}
/** getCurrentSize
 * @return int;   used to get the amount of elements in the bag at any given time.
 * @param void; 
 * how many items in the bag
 */
	public int getCurrentSize()
	{
		return numberOfEntries; 
	}
/**
 * @return boolean 
 * determines if the bag is empty and returns true if it is in fact. 
 */
	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	}

/**
 * @param T newEntry: an object to add to the bag
 * @return boolean : returns true of false cooresponding on whether the addition was successful or not. 
 */
	public boolean add(T newEntry)
	{
		boolean success = true;
		if(!isArrayFull())
		{
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		}
		else success = false;

		return success;
	}
	/**
	 * @param void
	 * @return T ; the object that is now in the end of the bag array. 
	 * used to remove the last item in the bag array
	 */
	public T remove() throws NoSuchElementException
	{
		 T tempData = bag[numberOfEntries];
			if(numberOfEntries<1) 
			{
				throw new NoSuchElementException();
			}
			bag[numberOfEntries]= null;
			numberOfEntries--;
			return tempData;
		
	}
/**
	 * @param T anEntry: takes in a specific instance of an object. 
	 * @return boolean,  
	 * used to remove the last item in the bag array
	 */
	public boolean remove(T anEntry)throws NoSuchElementException
	{
		boolean success = false;
		int index;
		if(!contains(anEntry))
		{
			
			throw new NoSuchElementException("Does not exist in data");
		}
		else
		{
			for(int i = 0; i < numberOfEntries ; i++)
			{
				if(bag[i].equals(anEntry))
				{
					index = i;
					bag[index] = bag[numberOfEntries];
					remove();
				}
			}
			
		}

		return success;
	}
/**
	 * @param void;
	 * @return void; 
	 * used to remove every item in the bag at once. 
	 */
	public void clear()
	{
		
		for(int i = 0; i < numberOfEntries; i ++)
		{
			bag[i] = null;
		}
		numberOfEntries = 0; 
	}
/**
 * @return int, the frequency of anEntry
 * @param T anEntry: the object we are looking for.
 * 	scans the bag to see if an object t is present and if so, how many times. 
 */
	public int getFrequencyOf(T anEntry)
	{
		int count = 0;

		for(int i = 0; i < numberOfEntries; i ++)
		{
			if(bag[i].equals(anEntry))
			{
				count++;
			}

		}
		return count;
	}

/**
 * @return boolean; if an entry is in the bag
 * @param T anEntry: the object we are looking for.
 * 	scans the bag to see if an object t is present. 
 */
	public boolean contains(T anEntry)
	{
		boolean contains = false;
		for(int i = 0; i < bag.length; i++)
		{
			if(bag[i]==null){
				continue;
			}
			
			if(bag[i].equals(anEntry))
			{
				contains = true;
			}
		}
		return contains;
	}
	/**
 * @return T[] array of the objects in the bag. 
 * @param void, gives the bag in array form. 
 */
	public T[] toArray()
	{
		
		return bag;
	}
	/**
 * @return boolean is the array full?
 * @param void; gives the ArrayBag a notion of whether objects can be added or not. 
 */
	private boolean isArrayFull()
	{
		return numberOfEntries == bag.length;
	}

	

}