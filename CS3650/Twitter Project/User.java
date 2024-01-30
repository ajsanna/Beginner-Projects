
/*
 * Alexander J Sanna
 * CS3560 OOP Assignment 2
 * Professor Y. Sun
 * Due: June 25th, 2023 
 * 
 * This is the user object. 
 * it is used to keep track of all the users tweets, followers, following
 * groups and of course hold its respective data such as id#. and username.
 * 		
 */

import java.util.ArrayList;

public class User 
{
	private long mostRecentUpdate;
	private long creationTime;
	private String username;
	private int ID;
	private ArrayList<User> following;
	private ArrayList<User> followedBy;
	private Group myGroup;
	private boolean inGroup;
	private ArrayList<Tweet> tweets;


	public User(int ID, String username)
	{
		this.username = username;
		this.ID = ID;
		following = new ArrayList<User>();
		followedBy = new ArrayList<User>();
		myGroup = null;
		tweets = new ArrayList<>();
		inGroup = false;
		creationTime = System.currentTimeMillis();
		mostRecentUpdate = creationTime;
	}
	public void addFollowedBy(User x)
	{
		followedBy.add(x);
	}
	public long getCreationTime()
	{
		return creationTime;
	}
	public void update(long time)
	{
		mostRecentUpdate = time;
	}
	public long getRecentUpdateTime()
	{
		return mostRecentUpdate;
	}

	public ArrayList<User> getFollowedBy()
	{
		return followedBy;
	}

	public ArrayList<User> getFollowingList()
	{
		return following;
	}
	public int getID()
	{
		return ID;
	}
	public String getUsername()
	{
	//	System.out.println("Returning" + username);
		return username;
	}
	public int getGroupID()
	{
		if(myGroup != null)
		{
			return myGroup.getID();
		}
		else
		{
			return 0;
		}
	}
	public void addNewFollow(User x)
	{
		//System.out.println("Follower Added");
		following.add(x);
	}
	public void addTweet(Tweet x)
	{
		tweets.add(x);
	}
	public ArrayList<Tweet> getTweets()
	{
		return tweets;
	}
	public void joinGroup(Group x)
	{
		myGroup = x;
		inGroup = true;
	}
	public boolean isInGroup()
	{
		return inGroup;
	}
}
