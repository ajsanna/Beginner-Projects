
/*
 * Alexander J Sanna
 * CS3560 OOP Assignment 2
 * Professor Y. Sun
 * Due: June 25th, 2023 
 * 
 * Description: 
 * 
 * This is the Group object. 
 * it is used to keep track of all the members.
 * and respective data such as id#. and groupname.
 * 		
 */

import java.util.ArrayList;

public class Group 
{

	private String groupName;
	private int ID;
	private long creationTime;
	private ArrayList<User> members;
	private int numOfMembers;



	public Group(int ID, String groupName)
	{
		this.groupName = groupName;
		this.ID = ID;
		members = new ArrayList<>();
		numOfMembers =0;
		creationTime = System.currentTimeMillis();
	}

	public long getCreationTime()
	{
		return creationTime;
	}

	public ArrayList<User> getMembers()
	{
		return members;
	}

	public int getID()
	{
		return ID;
	}
	public String getName()
	{
		//System.out.println("Returning" + groupName);
		return groupName;
	}
	public boolean hasMembers()
	{
		return numOfMembers != 0;
	}
	public void addMember(User x)
	{
		if(!hasMembers() && !members.contains(x))
		{
			members.add(x);
			numOfMembers++;
		}
	}

}
