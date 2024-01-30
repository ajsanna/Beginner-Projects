/*
*	Made by: Alexander Sanna
*	Personal iteration of "Tee" command
*	Created 11/30,2022
*	all inquiries please email ajsanna@cpp.edu

*	
*/

#include <stdio.h>
#include <string.h>

int main(int argc, char** argv )
{
	char filenames [10][10];
	char* filename;
	int numberofFiles = argc; 
	int indexOfOption = -1; 

	if(argc < 2 )
	{
		printf("Please input the data you would like to enter \n");
		printf(" type q, followed by enter key to exit \n\n");
		int runBoolean = 0; 
		while(runBoolean == 0)
		{
			char inputBuffer [1000]; 
			scanf("%[^\n]%*c", inputBuffer);

			runBoolean = strcmp(inputBuffer, "q") ? 0 : 1;
		
			if(runBoolean == 0)
			{
 				printf("%s", inputBuffer);
			}
		 
			printf("\n");
	}
	
	return 0; 

}

	char ** files = argv;
	int numberOfFiles = argc - 1; 

	while(numberOfFiles > 0)
	{
		if(strcmp(argv[numberOfFiles], "-a")==0)
		{
			indexOfOption = numberOfFiles;

			//printf("Option SPEC. %d", indexOfOption);
		}
		numberOfFiles--; 
	}

	//now we have argv, which is a list of all files, 
	//index of the -a recorded as well to avoid. 



if(indexOfOption > 0) //appending
{
	int runBoolean = 0; 
	FILE * fptr; 

	printf("\n");

	printf("Please input the data you would like to enter \n");
	printf(" type q, followed by enter key to exit \n\n");
	
	while (runBoolean == 0)
	{
		char inputBuffer [1000]; 
		scanf("%[^\n]%*c", inputBuffer);
		runBoolean = strcmp(inputBuffer, "q") ? 0 : 1;
		 
		if(runBoolean == 0)
		{
			for(int i = 1; i < argc; i ++)
			{
				if(i == indexOfOption)
				{
					continue;
				}
				char* filename = argv[i];

				fptr = fopen(filename, "a");	
			
				if(runBoolean == 0)
				{
					fprintf(fptr,"%s", inputBuffer);
				}

				fprintf(fptr,"\n");
			
			}
			printf("%s\n", inputBuffer);
		}
	}
}


//working!
else	//overwriting
{


	for(int i = 1; i < argc; i ++)
	{
		fopen(argv[i], "w");
	}
	int runBoolean = 0; 
	FILE * fptr; 

	printf("\n");

	printf("Please input the data you would like to enter \n");
	printf(" type q, followed by enter key to exit \n\n");
	
	while (runBoolean == 0)
	{
		char inputBuffer [1000]; 
		scanf("%[^\n]%*c", inputBuffer);
		runBoolean = strcmp(inputBuffer, "q") ? 0 : 1;
		 
		if(runBoolean == 0)
		{
			for(int i = 1; i < argc; i ++)
			{
				char* filename = argv[i];

				fptr = fopen(filename, "a");	
			
				if(runBoolean == 0)
				{
					fprintf(fptr,"%s", inputBuffer);
				
				}

				fprintf(fptr,"\n");
			
			}
			printf("%s\n", inputBuffer);
		}
	}
}
}
	

