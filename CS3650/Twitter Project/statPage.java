/*
 * Alexander J Sanna
 * CS3560 OOP Assignment 2
 * Professor Y. Sun
 * Due: June 25th, 2023 
 * 
 * Description: 
 * 		This is the stat page. it displays all relevent statistics. 
 */

 
//imports
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

	//this implemetns window. IT IS A WINDOW
public class statPage extends JPanel implements Window
{
	private BufferedImage pic = null;
    
   
    public statPage() 
	{
        super(null);
        setBorder(BorderFactory.createLineBorder(Color.WHITE));
        setBackground(Color.cyan);
        HomeButton userView = new HomeButton("Go Back", 380, 340);
        userView.setToolTipText("Return to Admin Page");
        this.add(userView);
		//creates a back button to return
    } 
    
	public void paintComponent(Graphics x) 
	{
		super.paintComponent(x);
		Font font1 = new Font("MonoSpaced", Font.BOLD, 40);
       	//Font font2 = new Font("Monospaced", Font.BOLD,30);
		Font font3 = new Font("Dialog", Font.BOLD,15);

		Graphics2D x2 = (Graphics2D) x;
		x2.setFont(font1);
        x2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x2.setColor(Color.black);
        x2.drawString("Statistics",20, 70);

		Graphics2D x4 = (Graphics2D) x;
		x4.setFont(font3);
		x4.setColor(Color.white);
		x4.drawString("Total Users: " + Driver.register.getNumOfUsers(),20, 120);
		x4.drawString("Total Groups: " + Driver.register.getNumOfGroups(), 20, 150);
		x4.drawString("Total Tweets: " + TweetCenter.center.getTotalTweets(), 20, 180);
		x4.drawString("Percentage Positive: " + TweetCenter.center.getPercentage(), 20, 210);
		
		//style and displays statistics. 

		try{
            pic = ImageIO.read(new File("twitterBird.png"));
        }catch(IOException e){};

        x.drawImage(pic,400,20,100,100,this);
		//pic for style

	}

    // method: getPreferredSize
    // purpose: This method sets the dimensions to 600x400
    public Dimension getPreferredSize() {
        return new Dimension(600,400); 
    } //end getPreferredSize
    
    
   
	
}
