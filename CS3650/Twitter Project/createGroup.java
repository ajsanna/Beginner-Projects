/*
 * Alexander J Sanna
 * CS3560 OOP Assignment 2
 * Professor Y. Sun
 * Due: June 25th, 2023 
 * 
 * Description: 
 * 		This is one of two panels used to display information to admins
 * 	when trying to create a group. The other being addGroup.java
 * 
 * This class simply validates that the desired ID is not taken
 * and then progresses to the next page, addGroup.java.
 */

 
//imports
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

//this implements window, it is a WINDOW
public class createGroup extends JPanel implements Window
{
	private boolean validUser = true; 
	private BufferedImage pic = null;
	private boolean userJoined = false;
    //stored booleans and references. 

	//CONTRUCTOR
	//creates the createGroup page to be displayed. 
    public createGroup() 
	{
        super(null);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setBackground(Color.cyan);
		//basic style

        HomeButton userView = new HomeButton("Go Back", 380, 340);
        userView.setToolTipText("Return to Admin Page");
		//back button to return to admin page
       
		JTextField text = new JTextField(5);
        text.setToolTipText("Enter your desired 5 digit ID.");
        text.setBounds(120,100,150,30);
        
        //MiniButton create = new MiniButton("Go", 270,100);
		//add(create);
		//i couldnt figure out how to link my mini buttons. 
	
        text.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) 
                { 
                    String name = text.getText();
                    if(name.length() > 10) {
                        name = name.substring(0,5);
                    }

					boolean valid = Driver.register.checkAvailibility(Integer.parseInt(name));
					
					if(!valid)
					{
						validUser = false; 
						paintComponent(getGraphics());
					}
					else
					{
						Driver.startPanel("addGroup",name);
					}
                }
        } );
		/*
		 * Lines 55-75 set up an actionlistener on the text to record the entry
		 * figured this was a fancier way rather than JDialog. 
		 */

		JButton addMember = new HomeButton("Add Member to Group", 20, 290);
		final JFrame parent = new JFrame();

		addMember.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				
                String groupName = JOptionPane.showInputDialog(parent,"What is the Groups ID Number?", null);
				String userName = JOptionPane.showInputDialog(parent,"What is the desired User's ID Number?", null);
				
				int groupID = Integer.parseInt(groupName);
				int userID = Integer.parseInt(userName);
				
				
				if(!Driver.register.checkAvailibility(groupID) || !Driver.register.checkAvailibility(groupID))
				{
					User x = Driver.register.getUserObject(userID);
					Group z = Driver.register.getGroupObject(groupID);
					z.addMember(x);
					x.joinGroup(z);
					userJoined = true;
					paintComponent(getGraphics());
				//	System.out.println("Follower Added");
				}
				else
				{
					System.out.println("Invalid user or group id ");
				}
				
            }
        });
		/*
		 * Lines 81 -113 add a button and set up an action listener to implement 
		 * an add user to group feature. this is a fancy way of filling groups. 
		 * it will then prompt the user for the respective id's and if all is valid
		 * it will add the member to the group. 
		 */


		this.add(text);
        this.add(userView);
		this.add(addMember);
		//add to the window. 
        
        
        
    } 
    
    // method: getPreferredSize
    // purpose: This method sets the dimensions to 600x400
    public Dimension getPreferredSize() {
        return new Dimension(600,400); 
    } //end getPreferredSize
    

	public void paintComponent(Graphics x) 
	{
        super.paintComponent(x);
        Font font1 = new Font("MonoSpaced", Font.BOLD, 35);
		Font font3 = new Font("Dialog", Font.BOLD,15);
		
		Graphics2D x2 = (Graphics2D) x;
        x2.setFont(font1);
        x2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x2.setColor(Color.black);
        x2.drawString("Create New Group",20, 70);

		Graphics2D x4 = (Graphics2D) x;
		x4.setFont(font3);
		x4.setColor(Color.white);
		x4.drawString("ID Number: ",20, 120);
		//This is all styling code ^ 

		if(!validUser)
		{
			validUser = true;
			x4.setColor(Color.red);
			x4.drawString("Invalid, that ID is taken.\nPlease try again. ",20, 220);
			try
			{
				Thread.sleep(3000);
				Driver.startPanel("createGroup");
			}
			catch(InterruptedException e)
			{
				Driver.startPanel("createGroup");
			}

		}
		if(userJoined)
		{
			userJoined = false;
			x4.setColor(Color.green);
			x4.drawString("User successfully added to group. ",20, 220);
			try
			{
				Thread.sleep(3000);
				Driver.startPanel("adminView");
			}
			catch(InterruptedException e)
			{
				Driver.startPanel("createGroup");
			}

		}
		
		//the if statements above are set to pickup on any invalid inputs
		//and to display a success statement if all went well. 



		try{
            pic = ImageIO.read(new File("twitterBird.png"));
        }catch(IOException e){};
        x.drawImage(pic,400,20,100,100,this);
		//picture for #style lol
	
        
    } //end paintComponent
    
   
}

