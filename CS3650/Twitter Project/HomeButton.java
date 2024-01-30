
/*
 * Alexander J Sanna
 * CS3560 OOP Assignment 2
 * Professor Y. Sun
 * Due: June 25th, 2023 
 * 
 * Description: 
 * 		This is my button class. it is a widget that extends JButton
 * 
 * 
 */
//imports
import javax.swing.*;
import java.awt.event.*;

public class HomeButton extends JButton implements Widget
{
	// method: HomeButton constructor
    // purpose: This method controls the specification and function of the home buttons
    public HomeButton(String title, int x, int y) {
        super(title);
    
        this.setBounds(x,y,200,50);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e)
			{
                 switch (title) 
				 {
                    case "Create User":
                        Driver.startPanel("createUser");
                        break;
                    case "Create Group":
                        Driver.startPanel("createGroup");
                        break;
                    case "Show Statistics":
                        Driver.startPanel("statistics");
                        break;
                    /*case "Show User View":
                        Driver.startPanel("userView");
                        break;
					*/
					case "Go Back":
						Driver.startPanel("adminView");
						setBounds(x,y,100,50);
						break;
					
                    default:
                        break;
                }  //end switch
            } //end actionPerformed
        }); //end ActionListener & this.addActionListener
    } //end HomeButton constructor

}
