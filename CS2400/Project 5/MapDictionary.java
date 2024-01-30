/*
 * Name: Alex Sanna
 * Homework:  # 1
 * Due Nov 9th 2022
 * Course: CS2400-002
 * 
 * This is the Map Dictionary. it is a virtual dictionary to store data based on 
 * key values. it provides the methods below. It implements dictionary interface.
 * ADT***
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class MapDictionary<K,V> implements DictionaryInterface<K, V>
{
	
	Map<K,V> directory;
	int entriesInDirectory; 
	public MapDictionary()
	{
		directory = new HashMap<>();
		entriesInDirectory = 0; 
	}

	public V add(K key, V value)
	{
		V replaceValue = null;
		
		if(directory.containsKey(key))
		{
			replaceValue = directory.get(key);
		}
		else
		{
			entriesInDirectory++; 
		}
		directory.put(key,value);
		
		return replaceValue; 
	}

	public V remove(K key)
	{
		V removedValue = null; 
		if(directory.containsKey(key))
		{
			removedValue = directory.get(key);
			directory.remove(key);
			entriesInDirectory--;
		}
		return removedValue; 
	}

	public V getValue(K key)
	{
		V returnValue = null; 
		if(directory.containsKey(key))
		{
			returnValue = directory.get(key);
		}
		return returnValue; 
	}

	public boolean contains(K key)
	{
		return directory.containsKey(key);
	}

	public Iterator<K> getKeyIterator()
	{
		Set<K> keys = directory.keySet();
		Iterator<K> value = keys.iterator();
		return value; 
	}

	public 	Iterator<V> getValueIterator() throws UnsupportedOperationException
	{
		
		throw new UnsupportedOperationException();
	}

	public boolean isEmpty()
	{

		return entriesInDirectory == 0; 
	}

	public int getSize()
	{
		return entriesInDirectory;
	}

	public void clear()
	{
		directory.clear();
		entriesInDirectory = 0; 

	}

}
