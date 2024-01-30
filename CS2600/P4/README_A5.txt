This is my assignment 5, and ill admit its a little bit messy. 

I had a lot of trouble pulling apart the modification time into individual variables such as hour, minute, second, day. 

I had to use StringTok to separate the fields and once I did, I lost the reference to the original time format so I had to do it all again in a while loop. It was complicated, messy and extremely frustrating but EVENTUALLY by some grace of God I got it to work.

*** the only catch to this program is that you must enter the name of the file as the first argument. It will not work if you structure it as follows: -t 20 filename. 

IT MUST BE EITHER: 
	filename -t N
	filename N -t

TO execute this program please use the gcc compiler and run the commands as follows: 

	gcc timeout.c 
	
	./a.out filename -t N 

		WHERE: filename is your file, -t is to specify a value N, N is seconds
	
If no N is specified, the default is 10 seconds. 

The program will compare the modification time after a sleep timer of N seconds. If the modification time changes within those N seconds, the compared time switches and it test again until the last modification time is over N seconds ago. At which point it will terminate the program. 

Alexander Sanna 
015193607 
November 11, 2022