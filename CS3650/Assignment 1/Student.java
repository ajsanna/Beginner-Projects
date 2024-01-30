/*Project 1: Ivote system
 * Alexander J Sanna
 * 
 * This is the student object class. 
 * To ensure data security, all fields are private and there are no mutation methods. 
 * The only way to edit data would be creating a new student object, with a new ID. 
 * 
 * ****to make this extremely secure, we could link the idNumbers to an external file and check
 * in the constuctor whether those id numbers have been used already; that would make it to where each 
 * student was truly distinct.
 * 
 * rather that, i decided to simply iterate through a for loop and use the index as the IDnumber paramter.
 * a simple yet elegant way of making sure all the idNumbers were unique in my simulation. 
 * 
 */

public class Student 
{
	private int idNumber; 
	private String answer; 

	//private fields for security. 
	
	public Student(int idNumber, String answer)
	{
		this.idNumber = idNumber;
		this.answer = answer;
	}

	//constructor. sets parameters to local object fields. 

	public int getIdNumber()
	{
		return idNumber;
	}
	//checking IDnumber accessor for external security fields. 

	public String getAnswer()
	{
		return answer; 
	}
	//the most controversial part of this project in my opinion. Accessor to students answer.
	//from an incredibly nitpicky pov this could be exploited by fellow classmates that have a reference
	//to this student's object. However, the unique id number would make it to where you would have no
	//idea whos answer is whos. This was neccesary to send to the voting service. 
	
}
