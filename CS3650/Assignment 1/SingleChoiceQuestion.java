/*Project 1: Ivote system
 * Alexander J Sanna
 * 
 * This is the Single Choice Question object. 
 * 
 * This class implements the general question interface. 
 * It holds appropriate fields as well as accessor methods. 
 * For security purposes, there are no mutator methods. 
 * The only way to edit fields is to create a new question.
 * 
 */

import java.util.Random;

public class SingleChoiceQuestion implements Question
{
	private String[] answer; 
	private String question; 
	private String[] incorrectAnswers; 
	private String correctAnswerIndex;

	//private fields for stored values. 

	public SingleChoiceQuestion(String question, String answer[], String[] incorrectAnswers)
	{
		this.answer = answer;
		this.question = question;
		this. incorrectAnswers = new String[incorrectAnswers.length];
		int index = 0; 
		for(String s : incorrectAnswers)
		{
			this.incorrectAnswers[index] = s;
			index++;
		}
		
	}
	//constructor. Creates the Single choice question with given parameters. 

	public String getQtype()
	{
		return "SC";
	}
	//accessor. returns SC for other programs to determine what type of question this is. 

	public String getTheQuestion()
	{
		return question; 
	}
	//accessor. returns the question. 
	public String[] getTheAnswer()
	{
		return answer; 
	}
	//accesssor. returns all correct answers
	public String getAnswerIndex()
	{
		return correctAnswerIndex;
	}
	//accessor. returns linked indexes for correct answers based at random. DISPLAY MUST BE RUN FIRST.
	public String [] getTheWrongAnswers()
	{
		return incorrectAnswers; 
	}
	//accessor. returns list of incorrect answers. 

	public void displayQuestion()
	{
		Random num = new Random(); 
		int number = num.nextInt(4);
		if(number==0)
		{
			System.out.println("A. " + answer[0] + " B. " + incorrectAnswers[0] + " C. " + incorrectAnswers[1]+ " D. " + incorrectAnswers[2]);
			correctAnswerIndex = "A";
		}
		else if(number == 1)
		{
			System.out.println("A. " + incorrectAnswers[1] + " B. " + answer[0] + " C. " + incorrectAnswers[2]+ " D. " + incorrectAnswers[0]);
			correctAnswerIndex = "B";
		}
		else if(number == 2)
		{
			System.out.println("A. " + incorrectAnswers[1] + " B. " + incorrectAnswers[0] + " C. " + answer[0]+ " D. " + incorrectAnswers[0]);
			correctAnswerIndex = "C";
		}
		else if(number == 3)
		{
			System.out.println("A. " + incorrectAnswers[1] + " B. " + incorrectAnswers[0] + " C. " + incorrectAnswers[2]+ " D. " + answer[0]);
			correctAnswerIndex = "D";
		}

	}
	//display funcion. prints answer choices to the screen and links answers to letters at random 

	public void revealAnswer()
	{
		System.out.println("Correct Answer: " + correctAnswerIndex + ": " +answer[0]);
	}
	//prints the answer. cannot transfer the answer. 
	
}
