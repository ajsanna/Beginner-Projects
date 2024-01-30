/*
 * Alexander J Sanna
 * CS3560 OOP Assignment 2
 * Professor Y. Sun
 * Due: June 25th, 2023 
 * 
 * Description: 
 * 		This is the second part in creating a group object. 
 * 	Now that we have a valid id, we can prompt for a groupname. 
 * 
 * In this class, all information is reported to the main registry. 
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

//this implemetns window. THIS IS A WINDOW. 
public class addGroup extends JPanel implements Window
{
	private BufferedImage pic = null;
	boolean userCreated = false;
	private String id;
	// stored local references. 

	//constructor only called by createGroup. 
	public addGroup(String id)
	{
			super(null);
			this.id = id;
			//initializing locals 

			setBorder(BorderFactory.createLineBorder(Color.WHITE));
			setBackground(Color.cyan);
			//basic styling 
			
			HomeButton userView = new HomeButton("Go Back", 380, 340);
			userView.setToolTipText("Return to Admin Page");
			this.add(userView);
			//adds a back button

			JTextField text = new JTextField(5);
			text.setToolTipText("Desired Groupname: ");
			text.setBounds(120,130,150,30);
			//prompts user for a groupname 
			
			//MiniButton create = new MiniButton("Go", 270,150);
			//add(create);
			//could not get to work 
			
			text.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evt) 
					{ 
						String name = text.getText();
						if(name.length() > 10) {
							name = name.substring(0,10);
						}

					boolean valid = Driver.register.checkAvailibility(Integer.parseInt(id));
					if(!valid)
					{
						System.exit(0);
					}
					else
					{
					
						int idNum = Integer.parseInt(id);
						Group x = new Group(idNum, name);
						Driver.register.addGroup(x);
						userCreated = true;
						paintComponent(getGraphics());
						
					}
						
					}
			} );
			/*
			 * attach action listener to the text.
			 * will create the group and add it to the registry
			 * 
			 */
			
			add(text);
			
		} //end HomePanel constructor
		
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
		x4.drawString("ID Number \t" + id, 20, 120);
		x4.drawString("Groupname: ", 20, 150);

		//STYLING ^^

		if(userCreated)
		{

			
			x4.setColor(Color.blue);
			x4.drawString("Group Created. ",20, 220);
			try
			{
				Thread.sleep(3000);
				Driver.startPanel("adminView");
			}
			catch(InterruptedException e)
			{
				Driver.startPanel("adminView");
			}
		}
		//returns to the admin panel when complete. 

		try{
            pic = ImageIO.read(new File("twitterBird.png"));
        }catch(IOException e){};
        x.drawImage(pic,400,20,100,100,this);
		//pic for style
		
		
	
        
    } //end paintComponent



		// method: getPreferredSize
		// purpose: This method sets the dimensions to 600x400
		public Dimension getPreferredSize() {
			return new Dimension(600,400); 
		} //end getPreferredSize
	
}
