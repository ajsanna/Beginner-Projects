/*
 * Alexander J Sanna
 * CS2400 - 002 
 * Decemeber 2nd, 2022
 * 
 * 
 * Description: The Airport App
 * This application will prompt the user for a command and will run so long as not terminated
 * it directs the user to the appropriate code to complete the request
 * It will print error messages if input is not applicable. 
 */



import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;


public class AirportApp 
{

	
	public static void main(String[] args) throws FileNotFoundException
	{
		
		//we also open the files first thing. they are scanned only once. 

		File airports = new File("airports.csv");
		File distances = new File("distances.csv");
		
		/*
		 * a basic graph interface is created first thing
		 * dictionary is also created to hold airport objects with the key set to their codes 
		 * I hold an arraylist of codes so that input is unlimited and that we always have reference to the
		 * 	keys in the dictionary
		 */

		BasicGraphInterface<String> theMap = new DiGraph<>();
		DictionaryInterface<String, AirportInformation> informationStorage = new MapDictionary<>();
		ArrayList<String> codes = new ArrayList<>();
		
		
		//SCANNERS TO READ THE FILES INTO DATA STORAGE.
		Scanner fileScanner1  = new Scanner(airports);
		Scanner fileScanner2 = new Scanner(distances);


		/*
		 * this while loop reads through the first file and stores the codes in the array list
		 * it creates an entry in the dictionary with the airport info object. 
		 * it also creates a vertex on the map. 
		 */
		while(fileScanner1.hasNext())
		{
			String[] input = fileScanner1.nextLine().split(",");
			codes.add(input[0]);
			informationStorage.add(input[0], new AirportInformation(input[2], input[1], input[3]));
			theMap.addVertex(input[0]);
		}

		/*
		 * This loop goes through the second file and adds the edges to the graph where necessary.
		 */
		while(fileScanner2.hasNext())
		{
			String[] input = fileScanner2.nextLine().split(",");
			theMap.addEdge(input[0], input[1], Double.parseDouble(input[2]));
		}
		
		//DisplayOptions is a method in this class that displays the initial option panel. 
		displayOptions();

		//Scanner to take input from the user. 
		Scanner input = new Scanner(System.in);
		
		boolean running = true; 
		/* 
		 * This while loop ensures that the program will continue to run unless the exit command is entered. 
		 * It prompts the user for command
		 * reads the input 
		 * directs program on where to go based on the command entered. 
		 */
		while(running)
		{
			//stores command and splits it into parameters. 
			// if the string[] entered has an e at value 0, the program terminates. 
			System.out.print("command? " );
			String[] command = input.nextLine().split(" ");



			System.out.println();
			//Q command. returns information about the requested airport. 
			if(command[0].equalsIgnoreCase("Q") )
			{
				if( command.length <= 1)
				{
					System.out.println("Airport Code Unknown");
				}
				else
				{
					for(int i = 1; i < command.length; i ++)
					{
						String requestedAirport = command[i].toUpperCase();
						if(codes.contains(requestedAirport))
						{
							AirportInformation x = informationStorage.getValue(requestedAirport);
							System.out.print(requestedAirport + " - ");
							x.printInfo();
						}
						else
						{
							System.out.println("Airport Code Unknown");
						}

					}
				}
			}
			//D command, gives shortest distance between 2 airports, as well as the route. 
			else if(command[0].equalsIgnoreCase("D"))
			{
				if( command.length != 3)
				{
					System.out.println("Airport Code Unknown");
				}
				else
				{
					StackInterface<String> path = new ArrayStack<>();
					if(codes.contains(command[1].toUpperCase()) && codes.contains(command[2].toUpperCase()))
					{
					double cost = theMap.getCheapestPath(command[1].toUpperCase(), command[2].toUpperCase(), path);
					
					if(cost == 0)
					{
						System.out.println("Airports not connected");
					}
					else
					{
					System.out.println(command[1].toUpperCase() + " to " + command[2].toUpperCase() + " is " + cost + " through the route:");
					
					while(!path.isEmpty())
					{
						String word = path.pop();
						AirportInformation current = informationStorage.getValue(word);
						System.out.print(word + " - ");
						current.printInfo();
					}
					
					
					}
				}
					else
					{
						System.out.println("Airport Code Unknown");
					}
				}
					
					


			}
			//I command adds an edge. 
			else if(command[0].equalsIgnoreCase("I"))
			{
				if( command.length != 4)
				{
					System.out.println("Airport Code Unknown");
				}
				else
				{
					boolean success = false;
					if(informationStorage.contains(command[1].toUpperCase()) && informationStorage.contains(command[2].toUpperCase()))
					{
						success = theMap.addEdge(command[1].toUpperCase(), command[2].toUpperCase(), Double.parseDouble(command[3]));
					}
					if(success)
					{
						System.out.println(command[1].toUpperCase() + " to " + command[2].toUpperCase() +" with a distance of " + command[3] + " added.");
					}
					else
					{
						System.out.println("Invalid Command");
					}
				}


			}
			//remove connection command.
			else if(command[0].equalsIgnoreCase("R"))
			{
				
			}
			//e command is to terminate. 
			else if(!command[0].equalsIgnoreCase("e"))
			{
				System.out.println("Invalid Command");
			}
			
			running = command[0].equalsIgnoreCase("e") ? false : true ;
			System.out.println();
		}
		
		fileScanner1.close();
		fileScanner2.close();
		input.close();

	}

	

	

	public static void displayOptions()
	{
		System.out.println("Airports v0.1 by A. Sanna");
		System.out.println();
		System.out.println("Command?:_");
		System.out.println("Q Query the airport information by entering the airport code.");
		System.out.println("D Find the minimum distance between two airports.");
		System.out.println("I Insert a connection between two airports ");
		System.out.println("E Exit.");
	}

	
}
