
/*
 * Alexander J Sanna
 * CS3560 OOP Assignment 2
 * Professor Y. Sun
 * Due: June 25th, 2023 
 * 
 * Description: 
 * 		This is the loading screen you see when first booting up the software
 */

 //imports
import javax.swing.*;
import java.awt.*;

//this is a window. it implements window
public class LoadingPage extends JPanel implements Window
{
	// method: WelcomePanel constructor
    // purpose: This method sets the specifications for the WelcomePanel
    public LoadingPage() 
	{
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBackground(Color.CYAN);
        
    } //end WelcomePanel constructor
    
    // method: getPreferredSize
    // purpose: This method sets the dimensions to 600x400
    public Dimension getPreferredSize() 
	{
        return new Dimension(600,200);
    } //end getPreferredSize
    
    // method: paintComponent
    // purpose: This method creates the welcome screen title 
    public void paintComponent(Graphics x) 
	{
        super.paintComponent(x);
        Font font1 = new Font("Serif", Font.BOLD, 90);
        Font font2 = new Font("Monospaced", Font.BOLD,30);
		Font font3 = new Font("Dialog", Font.BOLD,18);
        Graphics2D x2 = (Graphics2D) x;
        
        x2.setFont(font1);
        x2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x2.setColor(Color.white);
        x2.drawString("Twitter",100, 100);
        
        Graphics2D x3 = (Graphics2D) x;
        x3.setFont(font2);
        x3.setColor(Color.black);
        x3.drawString("MINI", 300, 130);

		Graphics2D x4 = (Graphics2D) x;
		x4.setFont(font3);
		x4.setColor(Color.white);
		x4.drawString("By: Alexander Sanna", 390, 190);

        
    } //end paintComponent



}
