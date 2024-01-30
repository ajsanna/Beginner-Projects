/*
Head implementation by Alexander Sanna 

Computer Science 2600 
Assignment 3 

*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
int main(int argc, char** argv)
{
	char commands[2][3];
	char files[10][20];
	int number_specified = -1; 
	int number_of_commands_used = 0;
	int number_of_files = 0; 

	int count = 1; 

	while(count < argc)
	{
		if(strcmp(argv[count], "-c")==0)
		{
		
			strcpy( commands[number_of_commands_used], argv[count]);
			number_of_commands_used++;
			number_specified = atoi(argv[count+1]);
			count++;
		}
		else if(strcmp(argv[count], "-n")==0)
		{
			
			strcpy( commands[number_of_commands_used], argv[count]);
			number_of_commands_used++;
			number_specified = atoi(argv[count+1]);
			count++;
		}
		else if(strcmp(argv[count], "-v")==0)
		{
		
			strcpy( commands[number_of_commands_used], argv[count]);
			number_of_commands_used++;
			
		}
		else if(strcmp(argv[count], "-q")==0)
		{
		
			strcpy( commands[number_of_commands_used], argv[count]);
			number_of_commands_used++;
		}
		else
		{
			strcpy( files[number_of_files], argv[count]);
			number_of_files++;
		}
		


	count++;
	}
	
	

	if(number_of_commands_used == 0)	 
	{
			for(int i = 0 ; i < number_of_files; i++)
			{
				if(number_of_files>1)
				{
					printf("%s\n", files[i]);
				}
					char singleLine[150];
   					FILE * theFile;
					
   					theFile = fopen(files[i], "r");
   					int tracker = 0; 
				
				while (!feof(theFile) && tracker < 10)
   			 {
       			fgets(singleLine, 150, theFile);
       			puts(singleLine);
    			tracker++;
   			 }
  			 	fclose(theFile);
			}
	}
	else if(number_of_commands_used== 1  )
	{
		if(strcmp(commands[0], "-v")==0)
		{
			for(int i = 0 ; i < number_of_files; i++)
			{
					printf("%s\n", files[i]);
					char singleLine[150];
   					FILE * theFile;
					
   					theFile = fopen(files[i], "r");
   					int tracker = 0; 
				
				while (!feof(theFile) && tracker < 10)
   			 {
       			fgets(singleLine, 150, theFile);
       			puts(singleLine);
    			tracker++;
   			 }
  			 	fclose(theFile);
			}
		}
		else if(strcmp(commands[0], "-n")==0)
		{
				for (int i = 0; i < number_of_files; i ++)
				{
					if(number_of_files>1)
					{
					printf("%s\n", files[i]);
					}

				char singleLine[150];
   				 FILE * theFile;
    
   				 theFile = fopen(files[i], "r");
   				 int tracker = 0; 
 			  	 while (!feof(theFile) && tracker < number_specified) 
  				 	 {
      				  fgets(singleLine, 150, theFile);
     			 	  puts(singleLine);
  					  tracker++;
  					  }
   					 fclose(theFile);

				}
		}
		else if(strcmp(commands[0], "-c")==0)
		{
				for (int i = 0; i < number_of_files; i ++)
				{
						 FILE * theFile;
    				theFile = fopen(files[i], "r");
					
					if(number_of_files>1)
					{
					printf("%s\n", files[i]);
					}
					char singleLine;
					int tracker = 0; 
						
						
							while (!feof(theFile) && tracker < number_specified)
   							 {
       					      	singleLine=  fgetc(theFile);
       						 printf("%c", singleLine);
    						tracker++;
							}
  							 fclose(theFile);
				}
		}
		else if(strcmp(commands[0], "-q")==0)
		{
			for(int i = 0 ; i < number_of_files; i++)
			{
				
					char singleLine[150];
   					FILE * theFile;
					
   					theFile = fopen(files[i], "r");
   					int tracker = 0; 
				
				while (!feof(theFile) && tracker < 10)
   			 {
       			fgets(singleLine, 150, theFile);
       			puts(singleLine);
    			tracker++;
   			 }
  			 	fclose(theFile);
			}
		}
		
	}
	
	else if(number_of_commands_used == 2 )
	{
		if((strcmp(commands[0], "-n") == 0 && strcmp(commands[1], "-v") == 0) ||(strcmp(commands[0], "-v") == 0 && strcmp(commands[1], "-n") == 0) )
		{
			for (int i = 0; i < number_of_files; i ++)
				{
				
					printf("%s\n", files[i]);
					

				char singleLine[150];
   				 FILE * theFile;
    
   				 theFile = fopen(files[i], "r");
   				 int tracker = 0; 
 			  	 while (!feof(theFile) && tracker < number_specified) 
  				 	 {
      				  fgets(singleLine, 150, theFile);
     			 	  puts(singleLine);
  					  tracker++;
  					  }
   					 fclose(theFile);

				}
		}
		else if((strcmp(commands[0], "-n") == 0 && strcmp(commands[1], "-q") == 0) || (strcmp(commands[0], "-q") == 0 && strcmp(commands[1], "-n") == 0))
		{
			for (int i = 0; i < number_of_files; i ++)
				{
				char singleLine[150];
   				 FILE * theFile;
    
   				 theFile = fopen(files[i], "r");
   				 int tracker = 0; 
 			  	 while (!feof(theFile) && tracker < number_specified) 
  				 	 {
      				  fgets(singleLine, 150, theFile);
     			 	  puts(singleLine);
  					  tracker++;
  					  }
   					 fclose(theFile);

				}
		}
		else if((strcmp(commands[0], "-c") == 0 && strcmp(commands[1], "-q") == 0) || (strcmp(commands[0], "-q") == 0 && strcmp(commands[1], "-c") == 0))
		{
		for (int i = 0; i < number_of_files; i ++)
				{
						 FILE * theFile;
    				theFile = fopen(files[i], "r");
					
					printf("\n");
					char singleLine;
					int tracker = 0; 
						
						
							while (!feof(theFile) && tracker < number_specified)
   							 {
       					      	singleLine=  fgetc(theFile);
       						 printf("%c", singleLine);
    						tracker++;
							}
  							 fclose(theFile);
				}
		}
		else if((strcmp(commands[0], "-c") == 0 && strcmp(commands[1], "-v") == 0) || (strcmp(commands[0], "-v") == 0 && strcmp(commands[1], "-c") == 0))
		{
			for (int i = 0; i < number_of_files; i ++)
				{
						 FILE * theFile;
    				theFile = fopen(files[i], "r");
					
					printf("%s\n", files[i]);
					char singleLine;
					int tracker = 0; 
					
						
							while (!feof(theFile) && tracker < number_specified)
   							 {
       					      	singleLine=  fgetc(theFile);
       						 printf("%c", singleLine);
    						tracker++;
							}
  							 fclose(theFile);
				}
		}

	}


	

	
}

