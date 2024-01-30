//hw5
//Alexander Sanna 


// APOLOGIES THIS IS SUPER MESSY. IT WAS HARD. 

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#include <unistd.h>
#include <time.h>
#include <sys/types.h>
#include <stdio.h>
#include <sys/stat.h>
#include <time.h>


int main(int argc, char** argv)
{
	int option = 0; //boolean for -t option. default false

	char* file; //filename
	int time = 10; //time between checks

	int numOfArgs = argc - 1; 

		if(argc == 1 || argc > 4)
		{
			printf("Error! arguments not valid");
			return -1;
		}

	
	
	file = argv[1]; //always filename
	
	if(argc==3)
	{
		option = 1;
	}
	else if(argc == 4)
	{
		if(strcmp(argv[3],"-t"))
		{
			time = atoi(argv[3]);
		}
		else
		{
			time = atoi(argv[2]);
		}
		option = 1; 
	}

	struct stat filestat;
	
	 stat(file, &filestat);
 
	

    char* ModTime = ctime(&filestat.st_mtime);
	char timeFinal[20];
	


	

	
	
	
	 
   // Extract the first token
   char * token = strtok(ModTime, " ");
   char * relTime; 

   //printf("%s", RELEVANTTIME);
   int day;
   // loop through the string to extract all other tokens
  int  count = 1; 
   while( count < 5 ) {
      token = strtok(NULL, " ");
	  if(count == 2)
	  {
		  day = atoi(token);
	  }
	  if(count == 3 )
	  {
		  relTime = token;
	  }
	  count++;
   }

	
	

 

	//separate the reltime into min hour sec.
int hour; 
int minute; 
int second;

char * element = strtok(relTime, ":");
    hour = atoi(element);
   // loop through the string to extract all other tokens
  int  counter = 0; 
   while( counter < 2 ) {
      element = strtok(NULL, ":");
	  if(counter == 0 )
	  {
		  minute = atoi(element);
	  }
	  if(counter == 1)
	  {
		  second = atoi(element);
	  }
	  counter++;
   }

   


	 

	 //succesfully separated mod date into hour, min, second, day params
	 //now must get current time separated into fields. 

	
	int working = 1; 
	int rotations = 1; 
	while(working == 1)
	{
		
		sleep(time);
		struct stat filestat;
		stat(file, &filestat);
 		char* ModTime = ctime(&filestat.st_mtime);
		 
		 char * token = strtok(ModTime, " ");
   char * relTime; 

   //printf("%s", RELEVANTTIME);
   int day;
   // loop through the string to extract all other tokens
  int  count = 1; 
   while( count < 5 ) {
      token = strtok(NULL, " ");
	  if(count == 2)
	  {
		  day = atoi(token);
	  }
	  if(count == 3 )
	  {
		  relTime = token;
	  }
	  count++;
   }

int hour; 
int minute; 
int second2;

char * element = strtok(relTime, ":");
    hour = atoi(element);
   // loop through the string to extract all other tokens
  int  counter = 0; 
   while( counter < 2 ) {
      element = strtok(NULL, ":");
	  if(counter == 0 )
	  {
		  minute = atoi(element);
	  }
	  if(counter == 1)
	  {
		  second2 = atoi(element);
	  }
	  counter++;
   }
   	
	if(second == second2)
	{
		working++;
	}
	second = second2;
		
	}
	
	


	




	

	
	

	//testing begins below;
	
	
	
	

	



	
		


		

	}


