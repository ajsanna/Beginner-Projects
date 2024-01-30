/*
 * Alexander J Sanna
 * CS3560 OOP Assignment 2
 * Professor Y. Sun
 * Due: June 25th, 2023 
 * 
 * Description: 
 * 		Interface for the Window Types.
 * 		This interface extends Widget. 
 * 		This is purely for organizational purposes.
 * 		Composite Feature.
 */

import java.awt.*;

public interface Window extends Widget
{
	public void paintComponent(Graphics x);
		/*
		 * Every Window object REQUIRES a paintComponent method. 
		 */
}
