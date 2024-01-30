/*
 * Alexander J Sanna
 * CS2400 - 002 
 * Decemeber 2nd, 2022
 * 
 * 
 * Description: The airport info 
 * 
 * This is my own homemade data structure designed to hold the information about the 
 * airports stored. it also has a print method that will print out the info 
 * about each one. 
 */

public class AirportInformation 
{
	//data fields for the airport object. 
	//holds the name, city and state. 
	String name; 
	String city; 
	String state; 
	/*
	 * Constructor. Sets the class variables
	 */
	public AirportInformation(String name, String city, String state)
	{
		this.name = name;
		this.city = city; 
		this.state = state; 
	}
	/*
	 * Print method. called to display info about an airport. 
	 */
	public void printInfo()
	{
		System.out.println(name + " " + city + " " + state);
	}


}
