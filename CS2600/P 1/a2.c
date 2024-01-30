
/* 
*
*	Alexander J Sanna
*	Bronco ID: 015193607 BN: ajsanna
*	CS2600 Fall 2022
*	Assignment 2
*	
*	Takes input from user and dictates commands
*/


#include <stdio.h>

int main()
{
		printf("\n\nWelcome to the program!!! \n \n"); /*welcome message, displayed once at the beginning*/
		
		
		/*numerical placeholders for values attributed*/
		int age = 0; 
		float points = 0;
		char displayName[20]; /* char array used to store name entered by user*/
		char nullName[20]= "Unknown"; /*if no name is entered*/
		char* ptr = nullName; /*sets name pointer to unknown by default*/
		int run = 1; /* run conditional see line 40*/
		char command = '0'; 

	
	 	while(run!=0) 
		{
			
			command = '0';
			 /*command variable. directional variable. most important part of this program...*/
			/*determines which action is being taken by the user. */
			
				if(command == '0')
				{
				/*
					this is the menu for selection, given to the user after every successful command
					it will display once and program will not continue until an input is recieved. 
				*/
				printf("\n\nEnter the number coorolated with your request \n \n");
				printf("1. Enter the name \n2. Enter the age\n");
				printf("3. Enter the points \n4. Display data\n");
				printf("5. Clear Data\n6. Quit \n ");
				
				/*This is the scanner that records the command input. it takes in a char and stores it in the command address.*/
				scanf(" %c", &command);
				}
			
			
				/*this is the menu that will print every excecution*/
	


				if(command=='6') /*Quit selection*/
				{
					run = 0;/*kills the program, put first for maximum efficiency (Exit command)*/
					printf("Quit succesful");  /*exit message. last line of code for the loop*/
				}
		
				else if(command == '5')/*Reset Data selection*/
				{	
					age = 0;	/*sets age equal to zero. Later linked with the "unknown" output*/
					points = 0; /*sets points equal to zero as well. linked with "Unknown below"*/
					ptr = nullName; /*sets the name pointer to point at a null valued address.*/
			 		printf("Data Cleared\n\n");	/*clears all data thresholds*/
				}
		
		else if(command == '4')/* prints out all data held*/
			{
				printf("\n\nname: %s\n", ptr);
					if(age==0)
					{
						printf("age: Unknown \n"); /*if age is unknown*/
					}
					else
					{printf("age: %d \n", age); /*if age is known*/}
			
					if(points==0)
					{
						printf("points: Unknown \n"); /*if points is unknown*/
					}
					else
					{printf("points: %.2f \n", points); /*if age is known*/}
			} 	

		else if(command == '3')/*alters the point amount*/
		{
			
			printf("Enter the points\n "); 
			scanf("%f", &points); /*asks for the points and stores it in the address for points variable*/
			

		}
		else if(command == '2')/*alters the age amount*/
		{

			printf("Enter the Age\n ");
			scanf("%d", &age);/*asks for age and stores it in the address linked with the age variable*/
			

		}
		else if(command == '1')	/*Alters the name value and point*/
		{
			ptr = displayName; /*points to the valid name*/
			printf("Enter the name\n ");
			scanf("%s" , &displayName);
		}	
		
		
		else{printf("invalid, try again!");} /*if any unexpected input is recieved this line will handle it.  */
		
		
		}

	return 0;
}

