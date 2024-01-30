/*
*	Made by: Alex Sanna 
*	Assignment 4
*	Computer Science 2600
*	Yunsheng Wang
*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>
#define MAX_BUF 100

int main(int argc, char** args)
{
	//argc is the number of args
char* command = "null";
char* name = "null";
int containsP = 0; //false
int containsSlash = 0 ; //false
int count = argc; 
int names = 0; 
int indexOfSlash = -1; 
while(count-1 > 0)
{
	if(strcmp(args[count-1], "mkdir") == 0)
		{
			command = args[count-1];
		}
	else if(strcmp(args[count-1], "-p") ==0)
		{
			containsP = 1;
		}
	else
	{
		if (names == 0)
		{
			name = args[count-1];
			names++;
		}
		else
		{
			printf("invalid input! please try again");
			exit(0);
		}
	}
	count--; 
}
if(strcmp(command, "null")==0)
{
	printf("invalid input! No command detected. please try again");
			exit(0);
}
if(strcmp(name, "null")==0)
{
	printf("invalid input! No name detected. please try again");
			exit(0);
}

//-----------

char DirectoryName[10]; //cuts the name to 10 chars
strcpy(DirectoryName, name);


for(int i = 0; i < 9; i++)
{
	if(DirectoryName[i]=='/')
	{
		indexOfSlash = i; 
		containsSlash = 1; 
		
	}	
}

//----------

if(containsSlash == 0)
{
	int k =	mkdir(DirectoryName, 0777 );
	if(k == -1)
	{
		printf("Error Occurred!\n");
		exit(0);
	}
	else
	{
		printf("Directory Created");
		exit(0);
	}
}	//works! do not touch. 
else if(containsP == 0 && containsSlash==1)
{
	char keyword[20];
	for(int i = 0 ; i < indexOfSlash ; i ++)
	{
		keyword[i] = DirectoryName[i];
	}
	

	
    char path[MAX_BUF];
	getcwd(path, MAX_BUF);
	
	
	
	
	int d = MAX_BUF;
	int L = 0; 
	char workingD[20];
	while(path[d] != '/')
	{
	
		 d--;
	}
	d++;
	for(int i = 0; i < 20; i ++)
	{
		workingD[i] = path[d+i];
	}

	
	int J = indexOfSlash+1;
	if(strcasecmp(workingD, keyword)==0)
	{
		char newName[10]; 
		for (int i = 0 ; i < 9 ; i ++)
		{
			newName[i]= DirectoryName[J+i];
		}
	
		int k =	mkdir(newName, 0777 );
	if(k == -1)
	{
		printf("Error Occurred!\n");
		exit(0);
	}
	else
	{
		printf("Directory Created");
		exit(0);
	}
	}
	else
	{
		printf("Error: Not in correct Directory!");
	}

}
else if (containsP == 1)
{
	//makes multiple directories.
	char keyword[20];
	for(int i = 0 ; i < indexOfSlash ; i ++)
	{
		keyword[i] = DirectoryName[i];
	}

	 char path[MAX_BUF];
	getcwd(path, MAX_BUF);

	int d = MAX_BUF;
	int L = 0; 
	char workingD[20];
	while(path[d] != '/')
	{
	
		 d--;
	}
	d++;
	for(int i = 0; i < 20; i ++)
	{
		workingD[i] = path[d+i];
	}

	int J = indexOfSlash+1;
	if(strcasecmp(workingD, keyword)==0)
	{
		char newName[10]; 
		for (int i = 0 ; i < 9 ; i ++)
		{
			newName[i]= DirectoryName[J+i];
		}
	
		int k =	mkdir(newName, 0777 );
	if(k == -1)
	{
		printf("Error Occurred!\n");
		exit(0);
	}
	}
	else
	{
			int k =	mkdir(keyword, 0777 );
	if(k == -1)
	{
		printf("Error Occurred!\n");
		exit(0);
	}
	else
	{
		int J = indexOfSlash+1;
			char newName[10]; 
		for (int i = 0 ; i < 9 ; i ++)
		{
			newName[i]= DirectoryName[J+i];
		}

		chdir(keyword);
			int k =	mkdir(newName, 0777 );
	if(k == -1)
	{
		printf("Error Occurred!\n");
		exit(0);
	}
	

		
	}
	}


}


}