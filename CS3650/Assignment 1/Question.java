/*Project 1: Ivote system
 * Alexander J Sanna
 * 
 * This is the general question interface. 
 * it specifys the most general requirements a class must hold to be considered a "question"
 * 
 * 
 */


public interface Question 
{
	String theQuestion = "";
	//we need to store the question in string form 
	//could present problems for long/wordy questions
	String theAnswer = ""; 
	//absolutely must store answers. likely a private variable 
	

	String getTheQuestion();
	//accessor method to return the question.
	String[] getTheAnswer();
	//accessor method to return a list of answers
	String[] getTheWrongAnswers();
	//accessor method to return a list of incorrect answers
	String getQtype();
	//accessor method for ease of use. 
	void displayQuestion();
	//displayal method to print the question options 
	void revealAnswer();
	//IMPORTANT: The only way to see the answer is from within the class. NO RETURN. 


}
