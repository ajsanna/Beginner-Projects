/*
 * Alexander J Sanna
 * CS3560 OOP Assignment 2
 * Professor Y. Sun
 * Due: June 25th, 2023 
 * 
 * Description: 
 * 		This is the tweet object. it stores the tweet and provides access 
 * to see the tweet. however the tweet may not be edited. 
 */


public class Tweet 
{
	 
	private String theTweet;
	
	public Tweet(String theTweet)
	{
		this.theTweet = theTweet;

	}

	public String getTheTweet()
	{
		return theTweet;
	}

	
}
