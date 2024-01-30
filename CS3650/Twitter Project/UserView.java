/*
 * Alexander J Sanna
 * CS3560 OOP Assignment 2
 * Professor Y. Sun
 * Due: June 25th, 2023 
 * 
 * Description: 
 * 	This is the UserView Driver for the individual UserView Panels.
 * 		The main purpose of this class is to create the window and window contents of each individual user view
 *	
		THERE IS ALSO A 'VISITOR' DESIGN FEATURE BUILT INTO THIS CLASS TO IMPLEMENT AUTO REFRESH
 */


//IMPORTS
import javax.swing.*;
import java.awt.*;



public class UserView 
{
	JFrame f;
	Component current;
	private User user;
	//we will keep a reference to the user calling this UserView object. 
	//we assume if this class is called, it is this user reference that wants to open the user view. 

	/*
	 * Constructor 
	 * 
	 * This is the only way a userview object can be created. notice that a valid user must be provided
	 * initializes local variables and calls showUserDisplay.
	 */
	public UserView(User user)
	{
		this.user = user;
		f = new JFrame(this.user.getUsername());
		showUserDisplay();
		
	}
	/*
	 * Accessor Method
	 * If a class has the reference to this UserView, it can access a reference to the user as well. 
	 * I could have made this extend User, but i did not want that mess. 
	 */
	public User getLinkedUser()
	{
		return user;
	}

	/*
	 * Open the User View WINDOW. 
	 */
	public void showUserDisplay()
	{
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//see UserViewPage.java to view window styling
        current = new UserViewPage(user);
        f.add(current);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);
		//sets basic window settings and opens. (Sets visible)
        
    } 

	/*
	 * Kill method. 
	 * This is used by the userViewPage window as a function for a close button on the user display. 
	 */
	public void closeWindow()
	{
		f.setVisible(false);
	}


	/*
	 * VISITOR DESIGN FEATURE
	 * 
	 * This method is the autoRefresh method that is called by AdminView.java for every user in a users followers
	 * list. If the window is open, it will automatically call showDisplay as a refresh. 
	 */
	public void refreshView()
	{
		current = new UserViewPage(user);
		if(f.isVisible())
		{
			showUserDisplay();
		}
		
	}


	

}





