/*
 * Alexander J Sanna
 * CS3560 OOP Assignment 2
 * Professor Y. Sun
 * Due: June 25th, 2023 
 * 
 * Description: 
 * 		This is a singleton class. 
 * 
 * There is only one reference to this class allowed in the entire program
 * because we only want one tweetcenter. 
 */

public class TweetCenter
{
	public static TweetCenter center= new TweetCenter();
	private int counter = 0; 
	private int numOfPosWords;
	private int totalWords;
	public  int totalTweets; 
	public double percentage;
	//these are all statistics fields 

	private TweetCenter()
	{
		if(counter == 0)
		{
		//	System.out.println("Creating instnace");
			numOfPosWords = 0;
			totalWords = 0; 
			totalTweets = 0; 
			percentage = 0; 
			counter++;
		}
		else
		{
			throw new RuntimeException();
		}
	}
//used for stat page
	public int getTotalTweets()
	{
		return totalTweets;
	}
	//used for stat page
	public double getPercentage()
	{
		
		if(totalWords != 0)
		{
			double x = (double)numOfPosWords/(double)totalWords;
			 return x ;
		}
		return 0; 
	}
	//used for stat page
	public Tweet postTweet(String tweet)
	{
		totalTweets++;
		String[] words = new String[10];
		Tweet newTweet = new Tweet(tweet);
		words = newTweet.getTheTweet().split(" ", 10);
		System.out.println(words[0]);
		for(String x : words)
		{
			totalWords++;
			if(x.equalsIgnoreCase("great"))
			{
				numOfPosWords++;
				
			}
			if(x.equalsIgnoreCase("good"))
			{
				numOfPosWords++;

			}
			if(x.equalsIgnoreCase("awesome"))
			{
				numOfPosWords++;

			}
			if(x.equalsIgnoreCase("happy"))
			{
				numOfPosWords++;

			}
			if(x.equalsIgnoreCase("positive"))
			{
				numOfPosWords++;

			}
			if(x.equalsIgnoreCase("win"))
			{
				numOfPosWords++;

			}
			if(x.equalsIgnoreCase("love"))
			{
				numOfPosWords++;
			}
			
		}
		
		
		
		return newTweet;
	}
}
