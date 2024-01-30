/*
 * Alexander J Sanna
 * CS3560 OOP Assignment 2
 * Professor Y. Sun
 * Due: June 25th, 2023 
 * 
 * Description: 
 * 		This is the UserViewPage. Pretty self explanatory... LOL
 * 
 * 			This class is the WINDOW that is displayed for each indivual USER object that requests. 
 * 		is is displayed in a frame that is created by UserView.java- The effective driver of this window.
 * 
 *		This is one of the most intricate classes in this project. it allows user objects to create tweets, 
		follow other users, and has an AUTOUPDATING news feed and follower list. 

		All Tweets are recorded to the TWEETCENTER for statistics purposes. 
 */



	//imports
import java.util.Date;
import java.text.SimpleDateFormat;
  import javax.swing.*;
  import java.awt.*;
  import javax.imageio.*;
  import java.awt.image.*;
  import java.io.*;
  import java.io.File;
  import java.util.ArrayList;
  
/*
 * IMPORTANT NOTE: 
 * 		For organization purposes, this class implements WINDOW. it is a WINDOW. 
 * 	Composite design funcionality
 */
public class UserViewPage extends JPanel implements Window
{
	private User user; 
	private TweetCenter tweetCenter = TweetCenter.center;
	private BufferedImage pic = null;
	//stored references, including the SINGLETON tweetcenter object. 
    
    /*
	 * Constructor
	 * 	This is the only way to create a UserViewPage, we use the user as a parameter for other programs
	 * 	to keep track of whos page is whos. 
	 */
    public UserViewPage(User x) 
	{
        super(null);
		this.user = x;
		
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setBackground(Color.cyan);
		//basic styling. 

        JButton userView = new HomeButton("Follow New Users", 20, 290);
		JButton makeTweet = new HomeButton("Make New Tweet", 20, 340);
		JButton close = new HomeButton("Close", 380, 340);
		final JFrame parent = new JFrame();
		//Three button functions on this page. FOLLOW NEW USERS. MAKE TWEET. CLOSE

		userView.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				int k =0;
                String name = JOptionPane.showInputDialog(parent,"What is the User's ID number?", null);
				k = Integer.parseInt(name);
				if(!Driver.register.checkAvailibility(k))
				{
					User z = Driver.register.getUserObject(k);
					user.addNewFollow(z);
					z.addFollowedBy(user);
					paintComponent(getGraphics());
				}
				else
				{
					System.out.println("Invalid user: " + k);
				}
				
            }
        });
		/*
		 * Lines 62 through 82 attatch an action listener to the follow users button. 
		 * 	IF THE BUTTON IS PUSHED: 
		 * 		we prompt the user for the ID number of the desired new follow
		 * 		Check if the id is valid. 
		 * 		*** WE ACCESS THE USER THROUGH THE SINGLETON REGISTRY ***
		 * 		add the followers respeectively. and refresh screen with paint component.
		 */

		makeTweet.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				
                String name = JOptionPane.showInputDialog(parent,"Enter your \"Tweet\"", null);
				if(!name.equals(""))
				{
					Tweet newTweet = tweetCenter.postTweet(name);
					user.addTweet(newTweet);
					ArrayList<User> refreshers = user.getFollowedBy();
					long time = System.currentTimeMillis();
					user.update(time);
					Driver.startPanel("adminView");
					for(User x : refreshers)
					{
						x.update(time);
						Driver.register.getUVObject(x).refreshView();
					}
					
					paintComponent(getGraphics());
				}
				else
				{
					//... invalid
				}
				

            }
        });

		/*
		 * Lines 92 through 117 attatch an action listener to the MAKE TWEET button. 
		 * 	IF THE BUTTON IS PUSHED: 
		 * 		WE prompt the user to type their tweet.
		 * 		We add it to their respective tweets field held in their user object. 
		 * 		We call the SINGLETON Tweet Center to post the tweet. 
		 * 		WE THEN UTILIZE THE VISITOR DESIGN FEATURE
		 * 			We update every one of the followers timelines with this new tweet. 
		 */


		close.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				UserView a = Driver.register.getUVObject(user);
				a.closeWindow();
            }
        });
		/*
		 * Action listener for close button 
		 * 
		 * if the button is pushed: we close only this window. 
		 */

        userView.setToolTipText("Follow new users");
		makeTweet.setToolTipText("Create a new tweet");
		close.setToolTipText("Close Window");
		//basic tooltips for style

		this.add(makeTweet);
        this.add(userView);
        this.add(close);
		// add three buttons to the window.
        
        
    } 
    
	public void paintComponent(Graphics x) 
	{
		super.paintComponent(x);

		/* 
		 * the following lines are all style related. ie fonts, sizes, placement. 
		 */

		Font font1 = new Font("MonoSpaced", Font.BOLD, 30);
        Font font2 = new Font("Dialog", Font.PLAIN, 12);
		Font font3 = new Font("Dialog", Font.ITALIC,15);
		Font font4 = new Font("MonoSpaced",Font.ITALIC, 10); 
		Graphics2D x1 = (Graphics2D) x;
        
		x1.setFont(font1);
        x1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x1.setColor(Color.black);
        x1.drawString("Welcome, " + user.getUsername() ,20, 70);

		Graphics2D x2 = (Graphics2D)x;
		x2.setFont(font3);
		x1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x1.setColor(Color.black);
        x1.drawString("Recent Tweets",20, 100);
		x2.drawLine(20, 105, 150, 105);
		x1.drawString("Following",420, 150);
		x2.drawLine(420, 155, 490, 155);
		
		ArrayList<Tweet> myTweets = user.getTweets();

		int factor = 10; 
		int lowestYVal = 160;
		ArrayList<User> following = user.getFollowingList();
		x2.setFont(font2);
		for(int i = 0; i < following.size(); i++)
		{
			lowestYVal = (lowestYVal + ((i+1)*factor));
			x2.drawString(following.get(i).getUsername(),420, lowestYVal);
		}

		//displays the users following list. 



		int lowestYVal2 = 120;
		int spaceCount = 1; 

		for(User human : following)
		{
			ArrayList<Tweet> friendTweets = human.getTweets();
			
			if(friendTweets.size()>0)
			{
				for(Tweet words : friendTweets)
				{
					x2.drawString(human.getUsername() + ": " + words.getTheTweet(),20, lowestYVal2 );
					lowestYVal2 = (lowestYVal2 + ((spaceCount)*factor));
					spaceCount++;
				}
			}

		}
		//cycles through following tweets to display to the timeline. 

		for(Tweet word : myTweets)
		{
			x2.drawString(user.getUsername() + ": " + word.getTheTweet(),20, lowestYVal2 );
					lowestYVal2 = (lowestYVal2 + ((spaceCount)*factor));
					spaceCount++;
		}
		//adds the users own tweets to their timeline, at the bottom for less precedence. 

		Graphics2D x4 = (Graphics2D) x;
        
		x4.setFont(font4);
        x4.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x4.setColor(Color.black);
		long time = user.getCreationTime();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");    
		Date resultdate = new Date(time);
		x4.drawString("User Created: " + sdf.format(resultdate),10,10);
		long updateTime = user.getRecentUpdateTime();
		SimpleDateFormat df = new SimpleDateFormat("MMM dd,yyyy HH:mm");    
		Date updateDate = new Date(updateTime);
		x4.drawString("Last Update: " + df.format(updateDate),10,21);


		try
		{
            pic = ImageIO.read(new File("twitterBird.png"));
        }catch(IOException e){};
        x.drawImage(pic,400,20,100,100,this);
		// adds an image for style. 
	}

    // method: getPreferredSize
    // purpose: This method sets the dimensions to 600x400
    public Dimension getPreferredSize() {
        return new Dimension(600,400); 
    } //end getPreferredSize
    
    
   
}
