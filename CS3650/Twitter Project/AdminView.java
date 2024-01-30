/*
 * Alexander J Sanna
 * CS3560 OOP Assignment 2
 * Professor Y. Sun
 * Due: June 25th, 2023 
 * 
 * Description: 
 * 		This is the most important page of them all. the admin page. 
 * 
 * This is a singleton class because we only want one adminview to be active at 
 * any given time. forming this as singleton ensures us of this. 
 */

//imports
import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

//this is a window. 
public class AdminView extends JPanel implements Window
{
	private BufferedImage pic = null;
	private static int counter = 0; 
	public static AdminView reference = new AdminView();
	private UserView uV; 
	
	//private fields 

	
    //constructor is private. singleton design. 
    private AdminView() 
	{
		super(null);
		if(counter == 0)
		{
		//	System.out.println("Creating instnace");
			counter++;
		}
		else
		{
			throw new RuntimeException();
		}
        
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setBackground(Color.cyan);
		//styling
        
        HomeButton createUser = new HomeButton("Create User",350,140);
        createUser.setToolTipText("Create an account");
        HomeButton createGroup = new HomeButton("Create Group",350,200);
        createGroup.setToolTipText("Create a user group");
        HomeButton statistics = new HomeButton("Show Statistics", 350, 260);
        statistics.setToolTipText("Open Statistics Menu");
        JButton userView = new HomeButton("Show User View", 350, 320);
        userView.setToolTipText("Switch to user perspective");
		JButton checkValid = new HomeButton("Check Validity", 180, 20);
        userView.setToolTipText("Validate distinct IDs");
		// these are all buttons being displayed to the screen. 

		final JFrame parent = new JFrame();

        userView.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				int k =0;
                String name = JOptionPane.showInputDialog(parent,"What is your ID number?", null);
				
					 k = Integer.parseInt(name);
				
				
				if(!Driver.register.checkAvailibility(k))
				{
					uV = new UserView(Driver.register.getUserObject(k));
					Driver.register.addUV(uV);
					//uV.showUserDisplay();
				}
				else
				{
					System.out.println("No such user");
				}

            }
        });
		/* 
		 * Action listener on the userview to prompt for an ID. 
		 */
		

		checkValid.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				if(Driver.register.checkValidity())
				{
					JOptionPane.showMessageDialog(parent,
                "All users are valid.");
				}
				else
				{
					JOptionPane.showMessageDialog(parent,
                "Error! Repeat ID detected!");
				}
            }
        });

		


       
        this.add(createUser);
        this.add(createGroup);
        this.add(statistics);
        this.add(userView);
		this.add(checkValid);
		//add everything to the screen.
        
        
        
    } //end HomePanel constructor
    public UserView getUVObject()
	{
		return uV;
	}
	//accessor 
    
    // method: getPreferredSize
    // purpose: This method sets the dimensions to 600x400
    public Dimension getPreferredSize() {
        return new Dimension(600,400); 
    } //end getPreferredSize
    
    // method: paintComponent
    // purpose: This method draws the team logo in the home screen
    public void paintComponent(Graphics x) {
        super.paintComponent(x);

		Font font1 = new Font("MonoSpaced", Font.BOLD, 20);
		Graphics2D x2 = (Graphics2D) x;
		x2.setFont(font1);
        x2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x2.setColor(Color.black);
        x2.drawString("Tree View",20, 70);
		x2.drawLine(20, 75, 150, 75);

		Font font2 = new Font("MonoSpaced", Font.PLAIN, 18);
		Graphics2D x1 = (Graphics2D) x;
		x1.setFont(font2);
        x1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x1.setColor(Color.black);
        x1.drawString("Root",20, 100);

		Font font3 = new Font("MonoSpaced", Font.PLAIN, 18);
		Graphics2D x3 = (Graphics2D) x;
		x3.setFont(font3);
        x3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x3.setColor(Color.blue);
		//all above is styling


		int[] idNums = Driver.register.getIDnumbers();
		String[] groups = Driver.register.getGroupNames();
		String[] usernames = Driver.register.getUserNames();


		int factor = 20; 
		int lowestYVal = 120;
		for(int i = 0; i < groups.length; i++)
		{
			lowestYVal = (lowestYVal + ((i+1)*factor));
			x3.drawString(groups[i],25, lowestYVal);
		}

		for(int i = 0; i < usernames.length; i++)
		{
			lowestYVal = (lowestYVal + ((i+1)*factor));
			x1.setColor(Color.black);
			x1.drawString(usernames[i]+": " +idNums[i],25, lowestYVal);
		}
		
	//this code is for the tree view. 
		Font font4 = new Font("MonoSpaced",Font.ITALIC, 10); 
		Graphics2D x4 = (Graphics2D) x;
        
		x4.setFont(font4);
        x4.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x4.setColor(Color.black);
		int idNum = Driver.register.getMostRecentUpdatedUser();
		if(idNum != 0)
		{
			x4.drawString("Most Recently Updated: " + idNum,10,10);
		}
		


		//Driver.test();
        
        try{
            pic = ImageIO.read(new File("twitterBird.png"));
        }catch(IOException e){};
        x.drawImage(pic,400,20,100,100,this);

		//pic for style 
    } //end paintComponent

	
	
}
