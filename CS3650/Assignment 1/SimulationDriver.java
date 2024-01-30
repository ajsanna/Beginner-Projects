
// Project 1: iVote Simulator 
// By Alexander J Sanna 
// Professor Yu Sun, CS3560 Summer 2023
// Due June 11th, 2023



//	Hello! thank you for taking the time to view this code, overall this project in its entirety took me just
//	over 20 hours to complete so I really apreciate your time taken to overlook it. 

/*
//	This file: SimulationDriver is the application that makes use of the Question object, the Student Object,
//	and the Voting Service platform. In each of these files respectively, you will find in depth details as
//	to what each file is and what each function does. From this file, the Application, we control everything
//	that has to relate to the other objects/platforms; think of it as a central command station. 
//
//Comment Style: All descriptive comments will be stated underneath code segments to which theyre coorolated. 
// Example: 	***Code***
//  		//adkfjdlkjfa	(comment linked to code above) ^ 
*/


import java.util.Scanner; 
import java.util.Random;
//imports


public class SimulationDriver
{
	public static void main(String[] args)
	{	//main
		
		Scanner userInput = new Scanner(System.in);
		System.out.println("");
		System.out.println("Welcome to the iVote simulator, created by Alexander Sanna");
		System.out.println("________________________________________________");
		//introductory screen for style purposes


		boolean running = true; 
		while(running)
		{
			System.out.println("");
			System.out.println("1) To participate in the iVote platform test, please press '1'");
			System.out.print("2) To simulate the process with a randomly generated pool, ");
			System.out.println("please press '2'");
			System.out.println("3) To exit the application, please press '3'");
			System.out.print("Your entry: ");
			String selection = userInput.nextLine();

			//Above is the option menu that will list out everytime the while loop is restarted.
			//input is taken at line 50 as a selection by the user. 

			if (selection.equals("1"))
			{
				System.out.print("How many questions would you like? (Ten maximum)" );
				int questions = userInput.nextInt();
				Question[] totalQuestions = getRandomQuestions(questions);

				for(int i = 0 ; i < questions ; i ++)
				{
					askQuestion(totalQuestions[i]);
				}
				

				System.out.println("");
				System.out.println("");
				System.out.println("Test complete. To return to menu, please press '1'.");
				System.out.println("To exit, enter any key.");
				System.out.print("Your entry: ");
				String continuationOption = userInput.nextLine();
			
				if(!continuationOption.equals("1")){running=false;}
			}

			/* 
			 * The if statement above is true if the user selected '1': corrolating to the take the test
			 * option. After the test completes, the user is prompted to return to the menu, if they do not,
			 * the while loop boolean is set to false and the program terminates. 
			 */

			else if(selection.equals("2"))
			{
				generateSimulation();
				

				System.out.println("");
				System.out.println("");
				System.out.println("Simulation complete. To return to menu, please press '1'.");
				System.out.println("To exit, enter any key.");
				System.out.print("Your entry: ");
				String continuationOption = userInput.nextLine();
			
				if(!continuationOption.equals("1")){running=false;}
			}

			/* 
			 * The elseIf statement is activated only if the user input is detected as '2'.
			 * This signals the program to begin a simulation. JUMPTO line ___
			 * after the simulation concludes, the user is prompted to return to the main menu.
			 * if not selected, the while loop boolean is set to false and the program terminates. 
			 */

			else if(selection.equals("3"))
			{
				System.out.println("Exit selected, have a nice day!");
				running = false; 
			}

			/*
			 * When the conditional statements receive a 3, the while loop boolean is set to false
			 *  and the program terminates.
			 */

			else
			{
				System.out.println("");
				System.out.println("\t*** Invalid entry, please try again ***");
				System.out.println("");
				System.out.println("");
				System.out.println("");
			}

			/* all other input is considered a user error, the loop repeats. */
		
		}

		System.out.println("");
		System.out.println("");
		userInput.close();
		//styling 
		//end main
	}
	




	private static void generateSimulation()
	{
		
		Random number = new Random();
		int numberOfStudents = 0; 
		int numberOfQuestions = 0; 
		int acceptableAnswers = 0; 
		//Question objects and important interger values are initialized. 

	
		System.out.println("Welcome to the iVote automated Random Simulation");
		
		System.out.println("");

		Scanner input = new Scanner(System.in);
		System.out.println("How many students would you like to simulate? ");
		System.out.print("Students: ");
		numberOfStudents = input.nextInt();
		System.out.println("How many Questions would you like to be asked? (Maximum 10) ");
		System.out.print("Number Of Questions: ");
		numberOfQuestions = input.nextInt();
		
		//general prompt questions

		if(numberOfQuestions>10)
		{
			boolean err = true; 
			while(err)
			{
			System.out.println("Error! please enter a value 10 or lower!");
			System.out.print("Number Of Questions: ");
			numberOfQuestions = input.nextInt();
			if(numberOfQuestions < 11)
			{
				err = false;
			}
			}
			
		}
		
		Question[] totalQuestions = getRandomQuestions(numberOfQuestions);
		

		//the section above shows a breif introductory description and prompts the user to enter values.
		//also generates the questions via getRandomQuestions. see more below
		int[] questionsUsed = new int[numberOfQuestions];
		int incrementor = numberOfQuestions;
		while(incrementor > 0)
		{
			int selection = number.nextInt(numberOfQuestions);
			if(questionsUsed[selection] == 1 )
			{
				//do nothing, question has already been asked. 
			}
			else
			{
				//select question. specify # of answers. 
				Question currentQuestion = totalQuestions[selection];
				questionsUsed[selection] = 1;
				System.out.println("Question: " + currentQuestion.getTheQuestion());
				
				
				if(currentQuestion.getQtype().equals("MC"))
				{
					acceptableAnswers = 14;
					currentQuestion.displayQuestion();
				}
				else
				{
					acceptableAnswers = 3; 
					currentQuestion.displayQuestion();
				}
				
				Random num = new Random();
				String[] votes = new String[numberOfStudents];
	
				int countdown = numberOfStudents;
				while(countdown > 0)
				{
					int number1 = num.nextInt(numberOfStudents);
					if(votes[number1] == null)
					{
						countdown--;
						
					}
						votes[number1] = generateAnswer(acceptableAnswers);
						//JUMP TO Line ____
				}
				/*
				 * The section above may seem very confusing at first glance but I will do my best to explain. 
				 * 
				 * To accurately test the features of the iVote software, we must make the student input 100% random.
				 * We must simulate the possibility of a/multiple student(s) changing their answer. We cannot simply
				 * iterate through an array of students because that is not true random. For an accurate simulation, 
				 * I decided to create a String array labeled VOTES. This array will hold the answer from each respective
				 * student with the student ID being the array index. It is very important that the length of this array
				 * is that of how many students we are trying to simulate. We then create a countdown incrementor that
				 * initially has the length of how many students there are. 
				 * While the countdown is not ZER0:
				 * 	we select a random number between 0 and how many students there are. (This is effectively picking a student
				 * at random.) We then check if the value in the VOTES array at that student's index is null. if it is, it means
				 * we have selected a student that has not voted yet. We decrement the counter. if the value at the index is not null
				 * it means we have selected a studnet that has already voted. in both cases, we generate a new random vote to be 
				 * entered in the VOTES array. but only if it is a unique studnet that has not yet voted to we decrement the counter
				 * 
				 * This is an effective way at getting random votes in random order while still ensuring some students can vote 
				 * more than one time. 
				 * 
				 */
	
				Student [] students = new Student[numberOfStudents];
	
				// an array of students is created with the appropriate size specified by the user. 
	
				for(int i = 0; i < numberOfStudents; i ++)
				{
					students[i] = new Student(i, votes[i]);
				}
				/* 
				 * This is the most secure way of creating student objects. it ensures that the vote remains secure.
				 * while still making it so that there are distinct ID numbers. 
				 */
			
				currentQuestion.revealAnswer();
				VotingService service = new VotingService(students);
				service.showResults();
				incrementor--;
				//Voting service is created. Results are printed 

			}

			
		}
		//end while loop. repeats for however many quesetions are specified by the user. 

	}
	public static Question[] getRandomQuestions(int numberOfQuestions)
	{
		Random number = new Random();
		Question[] totalQuestions = new Question[numberOfQuestions];
		int numOfMC = number.nextInt(numberOfQuestions);
		Question[] MCQuestions = getMCQuestions(numOfMC);
		Question [] SCQuestions = getSCQuestions(numberOfQuestions - numOfMC);
		

		int tracker = 0; 
			for(int i = 0; i < numOfMC ; i ++)
			{
				totalQuestions[tracker] = MCQuestions[i];
				tracker ++;
			}
			
			for(int j = 0; j < totalQuestions.length-numOfMC; j++)
			{
				totalQuestions[tracker] = SCQuestions[j];
				tracker++;
			}
		return totalQuestions;
	}
	//the method above mixes a random amount of MC and SC questions 

	public static Question[] getSCQuestions(int howMany)
	{
		Question[] scQuestions = new SingleChoiceQuestion[howMany];
		String[] questions = new String[10];
		String[][] answers = new String[10][1];
		String[][] wrongAnswers = new String[10][3];

		questions[0] = "What is the capital of California?";
		questions[1] = "How many bits are in a byte?";
		questions[2] = "What size engine does the Lamborghini Murcielago LP640 have?";
		questions[3] = "What company made the first mass produced automobile?";
		questions[4] = "Where was starbucks founded?";
		questions[5] = "What year was the first Ford Mustang announced?";
		questions[6] = "Which of the following is NOT a 'Supercar'";
		questions[7] = "What was the first Lamborghini Supercar called?";
		questions[8] = "Which of the following offered a manual from factory?";
		questions[9] = "Which of the following is NOT a porsche model?";

		answers[0][0] = "Sacramento";
		answers[1][0] = "8";
		answers[2][0] = "6.5L V12";
		answers[3][0] = "Ford";
		answers[4][0] = "Seattle";
		answers[5][0] = "1964";
		answers[6][0] = "Ferrari Sf90 Stradale";
		answers[7][0] = "Muira";
		answers[8][0] = "2022 Porsche 911 GT3";
		answers[9][0] = "R8";

		String [] a = {"San Francisco", "San Diego", "Eureka"};
		wrongAnswers[0] = a ;
		String [] b = {"4", "16", "32"};
		wrongAnswers[1] = b ;
		String [] c = {"4.0L V8", "6.2L V12", "Its electric!"};
		wrongAnswers[2] = c ;
		String [] d = {"Chevy", "Mercedes", "Bentley"};
		wrongAnswers[3] = d ;
		String [] e = {"San Francisco", "New York City", "London"};
		wrongAnswers[4] = e ;
		String [] f = {"1965", "1950", "1969"};
		wrongAnswers[5] = f ;
		String [] g = {"Ferrari F50", "Ferrari LaFerrari", "Ferrari ENZO"};
		wrongAnswers[6] = g ;
		String [] h = {"Testarossa", "Countach", "GT40"};
		wrongAnswers[7] = h ;
		String [] i = {"2009 Ferrari 612 Scagletti", "2014 Lamborghini Aventador", "2019 Ferrari 812 Superfast"};
		wrongAnswers[8] = i ;
		String [] j = {"912", "Cayman GT4", "Taycan"};
		wrongAnswers[9] = j ;

		Random num = new Random();
		int[] alreadyUsed = new int[howMany];
		int z = 0;
		while(z < howMany)
		{
			int index = num.nextInt(howMany );
			if(alreadyUsed[index]==0)
			{
				
				alreadyUsed[index] =1;

				scQuestions[z] = new SingleChoiceQuestion(questions[z], answers[z], wrongAnswers[z]);
				z++;
			}
		}
		
		return scQuestions;
	}
	
	//SCQuestions repository. this has a built in algorithm to ensure no repeat questions.
	public static Question[] getMCQuestions(int howMany)
	{
		Question[] mcQuestions = new MultipleChoiceQuestion[howMany];
		String[] questions = new String[10];
		String[][] answers = new String[10][4];
		String[][] wrongAnswers = new String[10][4];

		questions[0] = "Which are citys in Arizona?";
		questions[1] = "Which are Italian companies?";
		questions[2] = "What countries are in Europe?";
		questions[3] = "Who are the best professors at CPP?";
		questions[4] = "How was American Independence achieved?";
		questions[5] = "Who were the allies in WW2?";
		questions[6] = "Who did Ferrari inspire?";
		questions[7] = "Which are British?";
		questions[8] = "Which have a V12?";
		questions[9] = "Which is most expensive?";

		String [] a1 = {"Pheonix", "Flagstaff", "Williams", "x"};
		answers[0] = a1 ;
		String [] b1 = {"Alfa Romeo", "Lamborghini", "Ferrari", "x"};
		answers[1] = b1 ;
		String [] c1 = {"France", "Spain", "x", "x"};
		answers[2] = c1 ;
		String [] d1 = {"Yu Sun", "Keivan Navi", "Yunsheng Wang", "x"};
		answers[3] = d1 ;
		String [] e1 = {"blood", "sweat", "tears", "x"};
		answers[4] = e1 ;
		String [] f1 = {"USA", "France", "Britan", "x"};
		answers[5] = f1 ;
		String [] g1 = {"Pagani", "Lamborghini", "x", "x"};
		answers[6] = g1 ;
		String [] h1 = {"Aston Martin", "Lotus", "Jaguar", "x"};
		answers[7] = h1 ;
		String [] i1 = {"LaFerrari", "Maserati MC12", "", ""};
		answers[8] = i1 ;
		String [] j1 = {"Mercedes G63 AMG", "", "", ""};
		answers[9] = j1 ;

		

		String [] a = {"San Antonio", "x","x","x"};
		wrongAnswers[0] = a ;
		String [] b = {"Lotus", "x", "x", "x"};
		wrongAnswers[1] = b ;
		String [] c =  {"Russia", "Taiwan","x","x"};
		wrongAnswers[2] = c ;
		String [] d = {"Everyone Else", "x", "x", "x"};
		wrongAnswers[3] = d ;
		String [] e = {"the french helped", "x", "x", "x"};
		wrongAnswers[4] = e ;
		String [] f = {"Germany", "x", "x", "x"};
		wrongAnswers[5] = f ;
		String [] g = {"Ford", "Volvo", "x", "x"};
		wrongAnswers[6] = g ;
		String [] h = {"BMW", "x", "x", "x"};
		wrongAnswers[7] = h ;
		String [] i = {"Lexus LFA", "Lamborghini Gallardo", "x", "x"};
		wrongAnswers[8] = i ;
		String [] j = {"Ford Bronco Raptor", "Jeep Gladiator ", "Land Rover Defender", "x"};
		wrongAnswers[9] = j ;

		Random num = new Random();
		int[] alreadyUsed = new int[howMany];
		int z = 0;
		while(z < howMany)
		{
			int index = num.nextInt(howMany );
			if(alreadyUsed[index]==0)
			{
				
				alreadyUsed[index] =1;

				mcQuestions[z] = new MultipleChoiceQuestion(questions[z], answers[z], wrongAnswers[z]);
				z++;
			}
		}
		
		return mcQuestions;
	}
		//MCQuestions repository. this has a built in algorithm to ensure no repeat questions.


	public static void askQuestion(Question q)
	{
					Scanner s = new Scanner(System.in);
					System.out.println(q.getTheQuestion());
					q.displayQuestion();
					System.out.println("");
					System.out.print("Your Answer: ");
					String answer = s.nextLine();

					q.revealAnswer();
	}
	//the method above is for testing purposes. allows the question to be asked to the user.
	

	public static String generateAnswer(int choices)
	{
		String studentAnswer = "";
		Random number = new Random(); 
		int num = number.nextInt(choices+1);
		if(num == 0)
		{
			studentAnswer = "A";
		}
		else if(num == 1)
		{
			studentAnswer = "B";
		}
		else if(num == 2)
		{
			studentAnswer = "C";
		}
		else if(num == 3)
		{
			studentAnswer = "D";
		}
		else if(num == 4)
		{
			studentAnswer = "AB";
		}
		else if(num == 5)
		{
			studentAnswer = "AC";
		}
		else if(num == 6)
		{
			studentAnswer = "AD";
		}
		else if(num == 7)
		{
			studentAnswer = "BC";
		}
		else if(num == 8)
		{
			studentAnswer = "BD";
		}
		else if(num == 9)
		{
			studentAnswer = "CD";
		}
		else if(num == 10)
		{
			studentAnswer = "ABC";
		}
		else if(num == 11)
		{
			studentAnswer = "ABD";
		}
		else if(num == 12)
		{
			studentAnswer = "ACD";
		}
		else if(num == 13)
		{
			studentAnswer = "BCD";
		}
		else if(num == 14)
		{
			studentAnswer = "ABCD";
		}
		

		return studentAnswer;
		
	}

	//the method above ensures a random answer every single time from each student. 
	
	


}	// end SimulationDriver