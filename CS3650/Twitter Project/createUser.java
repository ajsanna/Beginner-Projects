/*
 * Alexander J Sanna
 * CS3560 OOP Assignment 2
 * Professor Y. Sun
 * Due: June 25th, 2023 
 * 
 * Description: 
 * this is the create user page. it is the first step in creating and registering 
 * a user to the registry. 
 * 
 * This class simply asks for a desired id and checks if it is valid. 
 * if it is: it will forward you to addUser.java where a username is declared
 * and all is reported to the registry. 
 * 		
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
public class createUser extends JPanel implements Window
{
	private boolean validUser = true; 
	private BufferedImage pic = null;
  //references and booleans 
	
/*
 * Constructor: 
 * 	creating the page to display in window. 
 */
    public createUser() 
	{
        super(null);
		
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setBackground(Color.cyan);
		//basic style 

        HomeButton userView = new HomeButton("Go Back", 380, 340);
        userView.setToolTipText("Return to Admin Page");
		//back button. 
       
		JTextField text = new JTextField(5);
        text.setToolTipText("Enter your desired 5 digit ID.");
        text.setBounds(120,100,150,30);
        //text field to accept desired ID #
        // MiniButton create = new MiniButton("Go", 270,100);
		//add(create);
		// couldnt get my mini buttons working ):


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
						Driver.startPanel("addUser",name);
					}
                }
        } );
		/* 
		 * we add an action listener to the text box. 
		 * this ensures that if a valid desired id is entered it 
		 * will switch over to addUser to prompt for a username. 
		 */


		this.add(text);
        this.add(userView);
		//adds the buttons and text to the window. 
        
        
        
    } 
    
    // method: getPreferredSize
    // purpose: This method sets the dimensions to 600x400
    public Dimension getPreferredSize() {
        return new Dimension(600,400); 
    } //end getPreferredSize
    
	public void paintComponent(Graphics x) 
	{
		
        super.paintComponent(x);
        Font font1 = new Font("MonoSpaced", Font.BOLD, 40);
		Font font3 = new Font("Dialog", Font.BOLD,15);
       
		Graphics2D x2 = (Graphics2D) x;
        x2.setFont(font1);
        x2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x2.setColor(Color.black);
        x2.drawString("Create New User",20, 70);

		Graphics2D x4 = (Graphics2D) x;
		x4.setFont(font3);
		x4.setColor(Color.white);
		x4.drawString("ID Number: ",20, 120);

		// above is all styling ^^^

		if(!validUser)
		{
			validUser = true;
			x4.setColor(Color.red);
			x4.drawString("Invalid, that ID is taken.\nPlease try again. ",20, 220);
			try
			{
				Thread.sleep(3000);
				Driver.startPanel("createUser");
			}
			catch(InterruptedException e)
			{
				Driver.startPanel("createUser");
			}

		}
		/* 
		 * signaled boolean if an invalid id is entered this will run. 
		 */


		try{
            pic = ImageIO.read(new File("twitterBird.png"));
        }catch(IOException e){};
        x.drawImage(pic,400,20,100,100,this);
		//pic for style lol 
	
        
    } //end paintComponent
    
   
	
}

