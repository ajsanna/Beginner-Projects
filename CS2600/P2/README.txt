HEAD implementation by Alexander Sanna

This program, written entirely in the C programming language is an attempt to replicate the HEAD command in the linux terminal. It takes all input in the form of arguments on the command line. 

To compile- Run: gcc head.c 

Next, run the command ./a.out with the following options: 

-v  :  the program should always print file name headers

-q  :  the program should never print file name headers

-n N :  where N is a positive integer. If specified, the program should print the first N lines of the file, instead of the first ten lines.

-c N :  where N is a positive integer. If specified, the program should print the first N bytes of the file, independent of the number of lines.

 *****Commands can be in any order so long as the N value is following the -c / -n option.*****

**Also: Enter the entire name of the file you wish you conduct this command on in the argument field. 

** testfile.txt and testfile2.txt are included in the zip file for testing purposes ** 

Examples include: 
	
	./a.out testfile.txt -v -n 25 
	./a.out testfile.txt -q -c 30
	./a.out testfile.txt testfile2.txt -q 
	./a.out testfile.txt testfile2.txt -n 20 -q
