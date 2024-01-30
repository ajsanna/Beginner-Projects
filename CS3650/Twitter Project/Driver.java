

/*
 * Alexander J Sanna
 * AJSANNA@CPP.EDU
 * CS3560 OOP Assignment 2
 * Professor Y. Sun
 * Due: June 25th, 2023 
 * 
 * Description: 
 * 		This is the main driver of the entire Twitter MINI application. 
 * 	*** THIS CLASS CONTAINS THE MAIN METHOD.
 * 		This is the absolute heart of this software, as it calls the shots on where to go at any given time. 
 * 	Based off signals it receives from the other classes, it will switch the main panel of the application. 
 * This class contains 3 main methods: which will be explained in greater detail below. 
 * 
 */	
 
  
  //necessary imports
  import javax.swing.*;
  import java.awt.*;
  import java.awt.event.*;
  import java.util.ArrayList;
  


public class Driver
{
	//these are the main frame and component for the application home page
	private static JFrame f;
    private static Component current;
	
	//these are fields that are passed to the registry class.
	/*
	 * *** TO AVOID ERRORS: 
	 * 			We initialize these ArrayLists before anything else. (See Below)
	 * 			The registry Object will hold all three of these ArrayLists.
	 */			
	private static ArrayList<Integer> takenIDs; 
	private static ArrayList<User> userReferences;
	private static ArrayList<Group> groups; 
	public static Registry register;

	//MAIN METHOD
	public static void main(String[] args)
	{
		//our first step is to initialize these ArrayLists to pass to our Register Object. 
		loadUsers();
		register = new Registry(takenIDs, userReferences, groups);

		//This is where this mess kicks off. We begin by calling the createAndShowGUI method. See more below LINE 67
		SwingUtilities.invokeLater(
			new Runnable() 
						{
            			public void run() 
						{				
               				createAndShowGUI();
           				}
        				}
								);

	}
/*
 * This is our first createAndShowGUI() method. It is called by main ^ to kick off the window. 
 */
	private static void createAndShowGUI() 
	{
        //Message to confirm to the terminal that the window has launched.
        System.out.println("Created GUI on EDT? " + SwingUtilities.isEventDispatchThread());

        f = new JFrame("MiniTwitter 1.0");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        current = new LoadingPage();
        f.add(current);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.setVisible(true);
		//Lines 72:79 set basic settings of our window and open the loading page. 
		//the loading page is pure aesthetic. It serves no purpose other than style. 
		


        Timer tmr = new Timer(3000,new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
			{
                startPanel("adminView");
            }   
        });
        tmr.start();
        tmr.setRepeats(false);
        //Lines 85:93 are in place so that the loading screen displays for exactly 3 seconds before we switch
		// WE automatically call startPanel with adminView as a parameter to specify thats where we want to go.

        Action removeInfo = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        f.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"),"removeInfo");
        f.getRootPane().getActionMap().put("removeInfo", removeInfo);
        //LINES 97: 103 is a very simple action map to ensure the escape key will kill the window and program.
		//this was extremely helpful in speeding up dev tests. I will leave it in as a feature. 
        
    } //end createAndShowGUI


	/*
	 * This is an insanely important method in this program as a whole. 
	 * Think of this as the brain controling which display is being shown in the main window. 
	 * based on commands it receives in the form of string parameters, it can switch to a specified display instantly.
	 * 
	 */
	public static void startPanel(String panel) 
	{
        f.remove(current);
		//we first remove the current component inhabiting the window. 
        switch(panel) 
		{
            case "adminView":
                current = AdminView.reference;
                break;
			
            case "createUser":
                current = new createUser();
                break;
			
            case "statistics":
                current = new statPage();
                break;
	
            case "createGroup":
                current = new createGroup();
                break;
			
        } //end switch Lines 120:138
		// Very basic switch statement utilized to change the component in the window. 

        f.add(current);
        f.setLocationRelativeTo(null);
        redraw();
		//Lines 141:143 these will refresh the user view.
        
    } //end startPanel

	/*
	 * Very basic case of method overloading. This is a special case where we require 
	 * an ID number to speicfy which user/group is requesting to be added. That way we can forward that number 
	 * to the next step in adding it to the system.
	 */
	public static void startPanel(String panel, String ID) 
	{
		
        f.remove(current);
        switch(panel) 
		{
			case "addUser":
			current = new AddUser(ID);
			break;
			case "addGroup":
			current = new addGroup(ID);
			break;
		}
		// 156:165basic switch to ensure correct navigation
		f.add(current);
        f.setLocationRelativeTo(null);
        redraw();
		//Lines 167:169 these will refresh the user view.
	}

	public static void redraw() 
	{
        f.pack();
        f.repaint();
    } //end redraw
	//Simple redraw method to avoid escessive amounts of code in one method. pure organizational purposes. 

	//The very first method called by main. 
	//initializes the arraylists to prevent errors when starting the window. 
	public static void loadUsers() 
	{
		takenIDs = new ArrayList<>();
		userReferences = new ArrayList<>();
		groups = new ArrayList<>();
	}

}
