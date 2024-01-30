
/*
* 	Name: Alexander J Sanna 
* 	Project 3
* 	Due: October 17th, 2022
* 	Course: cs-2400-02-f22
* 
* 
* Description:
* 			This is the arrayStack. it is an implementation of the StackADT using the array  
*/

import java.util.EmptyStackException;

public class ArrayStack<T> implements StackInterface<T>
{
	private T[] stack; 
	private int top;
	
	private final int FINAL_CAP = 64;

	public ArrayStack()
	{
		@SuppressWarnings("Unchecked Cast")
		T[] tempStack = (T[])new Object[FINAL_CAP];
		stack = tempStack;
		
		
		top = 0; 
	}

	public void push(T newEntry)
	{
		
		stack[top] = newEntry;
		top++;
	}
	public T pop() throws EmptyStackException
	{
		if (isEmpty())
         throw new EmptyStackException();
		top--;
		T result = stack[top];
		stack[top] = null; 
   
		return result;
		
	}
	public T peek() throws EmptyStackException
	{
		if (isEmpty())
         throw new EmptyStackException();

		return stack[top-1]; //stub
	}
	public boolean isEmpty()
	{
		return (top == 0); //stub
	}
	
	public void clear()
	{
		@SuppressWarnings("Unchecked Cast")
		T[] tempStack = (T[])new Object[FINAL_CAP];
		stack = tempStack;
		top = 0; 
		
	}






}
