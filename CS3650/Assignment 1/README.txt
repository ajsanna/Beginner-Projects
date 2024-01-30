

CS3560 OOP Summer 2023
Project 1: iVote Simulation

Created by: Alexander J Sanna

How to run this project: 
	1. Download files to desktop and unzip if necessary. 
	2. In the command line: 
		# cd desktop
		# javac SimulationDriver.java
		# java SimulationDriver
	3. Follow instructions prompted by the program. 

	With any difficulties or questions please contact alexsannaschool@yahoo.com.

General Project Description: 
	Contrary to any of my prior coding experience, for this project I felt the directions were very loose; it really fueled my creativity, resulting in this incredibly overbuilt result. This is my take on the popular internet platform MentiMeter.
The program provides two functional options: Take the survey on your own, and simulate the survey with randomly generate student responses. The questions are mostly car related, as I couldn’t think of anything else. If you choose to complete the survey on your own, (not simulated), it will pause and let you answer prior to revealing the correct answer(s).

My Process: 
	To begin with, the first thing I gathered from reading the project description was that I was going to need a Student object and a general Question object. As I read further into it, 
I realized that I could use a basic question interface and have the two different types of questions implement it for overall organization. This simple decision made it incredibly helpful when it came
Time to ask the questions. Rather than having two separate arrays with two separate types, I was able to consolidate into ONE Question[] array that held both types. Once the ground work was laid out 
With the creation of the objects and the production of the voting service class, it was time to simulate. 

The Ideology Behind the Simulation: 
	The simulation was the area I spent the most amount of time on overall, honestly because I felt so driven to make this product truly accurate to real life. EVERYTHING, and I mean EVERYTHING is randomized. 
If I saw an opportunity to make something random, even if it took an extra hour to code, I did it. From the question selection, to the determination as to how many MC vs SC questions, to the PLACEMENT OF THE ANSWERS ON THE STREEN…
EVERYTHING IS RANDOM. I was even able to simulate students answering more than once-> I will explain more below. In basic terms, the simulation generates a user specified number of questions at random for a user specified amount of students who 
Answer at random. These answers are held in an array where they are then linked with unique ID’s to respective student objects to be passed into the voting service. The voting service then takes each distinct students vote and stores the totals to be called later with a printScores method. This was the absolute most effective way of doing a simulation at true random. 

The Thing I am most proud of: 
	I was able to simulate RANDOM students changing their answer in a relatively time effective manor. See lines 213-227 of SimulationDriver. 
				To accurately test the features of the iVote software, we must make the student input 100% random.
                 * We must simulate the possibility of a/multiple student(s) changing their answer. We cannot simply
                 * iterate through an array of students because that is not true random. For an accurate simulation, 
                 * I decided to create a String array labeled VOTES. This array will hold the answer from each respective
                 * student with the student ID being the array index. It is very important that the length of this array
                 * is that of how many students we are trying to simulate. We then create a countdown incrementor that
                 * initially has the length of how many students there are. 
                 * While the countdown is not ZER0:
                 *  we select a random number between 0 and how many students there are. (This is effectively picking a student
                 * at random.) We then check if the value in the VOTES array at that student's index is null. if it is, it means
                 * we have selected a student that has not voted yet. We decrement the counter. if the value at the index is not null
                 * it means we have selected a studnet that has already voted. in both cases, we generate a new random vote to be 
                 * entered in the VOTES array. but only if it is a unique studnet that has not yet voted to we decrement the counter
                 * 
                 * This is an effective way at getting random votes in random order while still ensuring some students can vote 
                 * more than one time. 

Thank you for taking the time to read, have a nice day!



