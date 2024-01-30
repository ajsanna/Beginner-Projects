/*Project 1: Ivote system
 * Alexander J Sanna
 * 
 * This is the Multiple Choice Question object. 
 * 
 * this implements the general question interface. 
 * 
 * This class holds the necessary data and operations to serve as a question where multiple answers\
 * may be correct. For security purposes there are no mutator methods. Only accessors for integrity. 
 * 
 */

 
import java.util.Random;


public class MultipleChoiceQuestion implements Question 

{
	private String[] answers; 
	private String question; 
	private String[] incorrectAnswers; 
	private String[] answerIndexs; 
	
	//private data fields for each question. 

	public MultipleChoiceQuestion(String question, String[] answers, String[] incorrectAnswers)
	{
		
		this.question = question;
		this.incorrectAnswers = new String[incorrectAnswers.length];
		int index = 0; 
		for(String s : incorrectAnswers)
		{
			this.incorrectAnswers[index] = s;
			index++;
		}

		this.answers = new String[answers.length];
		int index2 = 0; 
		for(String s : answers)
		{
			this.answers[index2] = s;
			index2++;
		}
		
		
	}
	//constructor. the only way to edit information about a question. For security purposes.
	//sets parameter fields to local value holders. 

	public String getQtype()
		{
			return "MC";
		}
	//for streamlining purposes, any client can find out if this specific question is a MC or SC.
	//very useful when holding an array of general Question objects. 

	public String getTheQuestion()
	{
		return question; 
	}
	//returns the question in string format

	public String[] getTheAnswer()
	{
		return answers; 
	}
	//returns the correct answerS in array form. 
	public String [] getTheWrongAnswers()
	{
		return incorrectAnswers; 
	}
	//returns the  wrong answerS in array form. 


	public void displayQuestion()
	{
		int runtime = 0;
		for(int i = 0; i < 4; i ++)
		{
			if(!answers[i].equals("x"))
			{
				runtime++;
			}
		}
		//we first determine how many correct answers this question has.
		//important for the algorithm below. 


		if(runtime == 3)
		{
			answerIndexs = new String[3];
			Random num = new Random(); 
		int number = num.nextInt(4);
		if(number==0)
		{
			System.out.println("A. " + answers[0] + " B. " + answers[1] + " C. " + incorrectAnswers[0]+ " D. " + answers[2]);
			answerIndexs[0] = "A";
			answerIndexs[1] = "B";
			answerIndexs[2] = "D";
		}
		else if(number == 1)
		{
			System.out.println("A. " + incorrectAnswers[0] + " B. " + answers[0] + " C. " + answers[2]+ " D. " + answers[1]);
			answerIndexs[0] = "B";
			answerIndexs[1] = "C";
			answerIndexs[2] = "D";
		}
		else if(number == 2)
		{
			System.out.println("A. " + answers[0] + " B. " + incorrectAnswers[0] + " C. " + answers[1]+ " D. " + answers[2]);
			answerIndexs[0] = "A";
			answerIndexs[1] = "C";
			answerIndexs[2] = "D";
		}
		else if(number == 3)
		{
			System.out.println("A. " + answers[1] + " B. " + answers[0] + " C. " + answers[2]+ " D. " + incorrectAnswers[0]);
			answerIndexs[0] = "A";
			answerIndexs[1] = "B";
			answerIndexs[2] = "C";
		}
		}
		else if(runtime == 2)
		{
			answerIndexs = new String[2];
			Random num = new Random(); 
		int number = num.nextInt(4);
		if(number==0)
		{
			System.out.println("A. " + answers[0] + " B. " + answers[1] + " C. " + incorrectAnswers[0]+ " D. " + incorrectAnswers[1]);
			answerIndexs[0] = "A";
			answerIndexs[1] = "B";
			
		}
		else if(number == 1)
		{
			System.out.println("A. " + incorrectAnswers[0] + " B. " + answers[0] + " C. " + incorrectAnswers[1]+ " D. " + answers[1]);
			answerIndexs[0] = "B";
			answerIndexs[1] = "D";
		}
		else if(number == 2)
		{
			System.out.println("A. " + incorrectAnswers[1] + " B. " + incorrectAnswers[0] + " C. " + answers[1]+ " D. " + answers[0]);
			
			answerIndexs[0] = "C";
			answerIndexs[1] = "D";
		}
		else if(number == 3)
		{
			System.out.println("A. " + incorrectAnswers[0] + " B. " + answers[0] + " C. " + answers[1]+ " D. " + incorrectAnswers[1]);
			
			answerIndexs[0] = "B";
			answerIndexs[1] = "C";
		}
		}
		else
		{
			answerIndexs = new String[1];
			Random num = new Random(); 
		int number = num.nextInt(4);
		if(number==0)
		{
			System.out.println("A. " + incorrectAnswers[0] + " B. " + answers[0] + " C. " + incorrectAnswers[1]+ " D. " + answers[2]);
			
			answerIndexs[0] = "B";
			
		}
		else if(number == 1)
		{
			System.out.println("A. " + incorrectAnswers[1] + " B. " + incorrectAnswers[0] + " C. " + answers[0]+ " D. " + incorrectAnswers[2]);
			
			answerIndexs[0] = "C";
			
		}
		else if(number == 2)
		{
			System.out.println("A. " + answers[0] + " B. " + incorrectAnswers[0] + " C. " + incorrectAnswers[1]+ " D. " + incorrectAnswers[2]);
			answerIndexs[0] = "A";
		
		}
		else if(number == 3)
		{
			System.out.println("A. " + incorrectAnswers[1] + " B. " + incorrectAnswers[0] + " C. " + incorrectAnswers[2]+ " D. " + answers[0]);
			answerIndexs[0] = "D";
			
		}

		}

		


	}
	/* 
	 * this huge portion of code Lines77-197 is my best attempt at randomizing the display process. 
	 * The intent was to have it where the same answers werent displayed in the same fields every time.
	 * This was challenging due to the fact that each question had a different number of correct answers, 
	 * requiring more than one implementation. 
	 */



	public void revealAnswer()
	{
		System.out.print("Correct Answers: ");
		for(int i = 0; i < answerIndexs.length; i ++)
		{
			System.out.print(" " + answerIndexs[i]+ ". " + answers[i]);
		}

		System.out.println();
	}
	//simple display method, prints the correct answers to the questions, inclduing their respective indexes.


}
