/*
 * Alexander J Sanna
 * CS3560 OOP Assignment 2
 * Professor Y. Sun
 * Due: June 25th, 2023 
 * 
 * Description: 
 * 		This is the main registry in the program. 
 *		This class alone keeps track of all of the users, groups, IDs and UV's
 */


//import
import java.util.ArrayList;

public class Registry 
{

	private static ArrayList<Integer> takenIDs; 
	private static ArrayList<User> userReferences;
	private static ArrayList<Group> groups; 
	private static ArrayList<UserView> userViewObjects;
	//private fields

	//constructor. Creates the registry with ArrayLists.
	public Registry(ArrayList<Integer> x, ArrayList<User> y, ArrayList<Group> z)
	{
		takenIDs = x;
		userReferences = y;
		groups = z;
		userViewObjects = new ArrayList<>();
	}
	
	/*
		How to add a user to the registry 
	 * This is the addition of a user. 
	 */
	public void addUser(User x)
	{
		
		int z = x.getID();
		Integer y = (Integer)z;
		takenIDs.add(y);
		userReferences.add(x);

	}
/*
		How to add a group to the registry 
	 * This is the addition of a group. 
	 */
	public void addGroup(Group x)
	{
		
		int z = x.getID();
		Integer y = (Integer)z;
		takenIDs.add(y);
		groups.add(x);

	}
	public int getMostRecentUpdatedUser()
	{
		int target = 0; 
		if(userReferences.size() == 0)
		{
			return 0000;
		}
		if(userReferences.size() == 1)
		{
			return userReferences.get(0).getID();
		}
		target = userReferences.get(0).getID();
		for(int i = 0; i < userReferences.size()-1; i ++)
		{
			if(userReferences.get(i).getRecentUpdateTime()<userReferences.get(i+1).getRecentUpdateTime())
			{
				target = userReferences.get(i+1).getID();
			}
		}
		
		return target;

	}

	public boolean checkValidity()
	{
		ArrayList<Integer> processedIds = new ArrayList<>();
		for(User x : userReferences)
		{
			if(!takenIDs.contains(x.getID()))
			{
				return false;
			}
			if(processedIds.contains(x.getID()))
			{
				return false;
			}
			processedIds.add(x.getID());
		}
		for(Group z : groups)
		{
			if(!takenIDs.contains(z.getID()))
			{
				return false;
			}
			if(processedIds.contains(z.getID()))
			{
				return false;
			}
			processedIds.add(z.getID());
		}
		
		return true; 
	}

	//this is the addition of a iserView object. 
	public void addUV(UserView x)
	{
		userViewObjects.add(x);
	}

	//accessor for the uv object provided an id
	public UserView getUVObject(User x)
	{
		for(UserView z : userViewObjects)
		{
			if(z.getLinkedUser().getID() == x.getID())
			{
				//System.out.println("Refreshing page for: " + z.getLinkedUser().getID());
				return z;
			}
		}
		//System.out.println("Returning null" );
		return null;
	}

	//checks if an ID is availible 
	public boolean checkAvailibility(int ID)
	{
		//System.out.println(!takenIDs.contains((Integer)ID));
		return !(takenIDs.contains((Integer)ID));
	}

	//returns number of users for stats. 
	public int getNumOfUsers()
	{
		return userReferences.size();
	}
	//returns number of groups for stats. 
	public int getNumOfGroups()
	{
		return groups.size();
	}
	
	//testing method. not used in implementation 
	public void test()
	{
		for(Group x : groups)
		{
			System.out.println(x.getName());
		}
		for(User x : userReferences)
		{
			System.out.println(x.getUsername());
		}
	}

	//group name accessors. used for admin view 
	public String[] getGroupNames()
	{
		String[] groupNames = new String[groups.size()];
		int counter = 0;
		for( Group x : groups)
		{
			groupNames[counter] = x.getName();
			//System.out.println(groupNames[counter]);
			counter++;
		}
		return groupNames;
	}

	//user name accessors. used for admin view 
	public String[] getUserNames()
	{
		String[] userNames = new String[userReferences.size()];
		int counter = 0;
		for( User x : userReferences )
		{
			userNames[counter] = x.getUsername();
			counter++;
		}
		return userNames;
	}

	//returns all id numberes being used 
	public int[] getIDnumbers()
	{
		int[] userNames = new int[userReferences.size()];
		int counter = 0;
		for( User x : userReferences )
		{
			userNames[counter] = x.getID();
			counter++;
		}
		return userNames;
	}

	//returns a reference to a user object provided ID. 
	public User getUserObject(int idNum)
	{
		User target = null;
		for(User x : userReferences)
		{
			if(x.getID() == idNum)
			{
				target = x;
				break;
			}
		}

		return target;

	}

	//returns a reference to a group object provided ID. 
	public Group getGroupObject(int idNum)
	{
		Group target = null;
		for(Group x : groups)
		{
			if(x.getID() == idNum)
			{
				target = x;
				break;
			}
		}

		return target;
	}
}