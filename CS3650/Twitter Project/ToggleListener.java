/*
 * Alexander J Sanna
 * CS3560 OOP Assignment 2
 * Professor Y. Sun
 * Due: June 25th, 2023 
 * 
 * Description: 
 * 		This is a widget that has a built in action listener for buttons. 
 */

import java.awt.event.*;

public class ToggleListener implements ActionListener 
{
    
    MiniButton button;
    String buttonTitle;
    
    // method: ToggleListner constructor
    // purpose: This method sets the default values for the Toggle Listner
    public ToggleListener(MiniButton button) {
       this.button = button;
       buttonTitle = button.getTitle();
    } //end ToggleListener constructor
    
    // method: actionPerformed
    // purpose: This method disables a button when it is clicked
    public void actionPerformed(ActionEvent e) {
       button.setEnabled(false);
    
    } //end actionPerformed
} //end ToggleListener
