
/*
 * 	Name: Alexander J Sanna 
 * 	Project 1
 * 	Due: September 26th, 2022
 * 	Course: cs-2400-02-f22
 * 
 * 
 * Description:
 * 	this is the application of the arraybag adt. methods and such are tested and implemented here. 
 * 			
 */
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class JavaKeywords 
{

	/**
	 * @param String[] args, used in the command line to provide the program with searchables
	 * @return void, 
	 * 
	 * @throws IOException, used for the input output file reading features. If an error arises, 
	 * the program will handle the error. I have not implemented any error catching. 
	 * 
	 */
	public static void main(String[] args) throws IOException
	{
		System.out.println("Java Keywords By A. Sanna");	//introductory statement
		System.out.println();
		System.out.println();	//spacing
		System.out.println();
		
		int count;		//count serves as the initial size of the bag. This can be altered to accomadate for a resizable bag.
		count = 256;
		BagInterface<String> keywords = new ArrayBag<>(count);	//this statement creates the bag. Initializes the Array with count
		
		File myFile =  new File("javakeywords.txt");	//creates the file object from the folder. 
		Scanner list = new Scanner(myFile);	//scans the file so the program can use its contents. 

		while(list.hasNextLine())	//while loop goes through the entire document so long as next line is not null
		{
			String temp = list.nextLine();	//stores the string from the file into the temp String variable
			keywords.add(temp);	//utilizes the add method to add the String to the bag
		}
		list.close();
		System.out.println(keywords.getCurrentSize()+ " Java Keywords Loaded.");	//line that prints how many words loaded. 
		System.out.println();	

		for (String s : args)	//enhanced for loop to go through all of the arguments. 
		{
			String st; 
			st = keywords.contains(s) ? "" : "not ";
			System.out.println(s + " is "+st+"a keyword" ); //determines and prints whether the argument is a listed keyword or not.

		}
		
		System.out.println();
		System.out.println();	//spacing
		System.out.println();
		System.out.println("Below is the test of all bag features:");	//labeling
		System.out.println();	
		 

		System.out.println("The current size of the bag is: " +keywords.getCurrentSize());	//getCurrentSize test
		
		String s;
		s = keywords.isEmpty() ? "" : " not"; //conditional operation to test the isEmpty method
		System.out.println("The bag is"+s+" empty" );

		Object[] words;	
		words = keywords.toArray();	//tesing of the toArray method
		System.out.println("The 20th entry in the array is: " + words[20]);

		
		String example = (String)words[keywords.getCurrentSize()-1];	//getcurrentsize method test. 
		System.out.println("the last word in the bag is: "+ example);
		keywords.remove();	//remove testing
		String example2 = (String)words[keywords.getCurrentSize()-1];
		System.out.println("After the removal method is used, the new last word is " + example2);
		
		keywords.remove("void");	//remove a specific test


		
		System.out.println("from here, if we remove 'void' from the bag, the new count is "+ keywords.getCurrentSize());	

		System.out.println("The keyword 'public' has a frequency of " + keywords.getFrequencyOf("public"));
		//testing of the methods after a clear method is invoked. 
		keywords.clear();
		System.out.println("after clearing the array, the number of items in the bag is " + keywords.getCurrentSize());
		System.out.println("The keyword 'public' has a frequency of " + keywords.getFrequencyOf("public"));
		s = keywords.isEmpty() ? "" : " not"; 
		System.out.println("The bag is"+s+" empty" );
		//end class
	}

	
}

