/*Project 1: Ivote system
 * Alexander J Sanna
 * 
 * This is the VotingService, and it is incredibly simple.
 * We have two main functions here. count the votes submitted and display the results. 
 * 
 * For security purposes, votes are submitted through STUDENT OBJECTS. This absolutely ensures that 
 * each submission is distinct. The fields are all private as well with zero mutation methods. 
 * 
 * 
 * 
 */

public class VotingService 
{
	private int A; 
	private int B;
	private int C; 
	private int D;

	
	public VotingService(Student[] students)
	{ 
		this.A = 0; 
		this.B = 0; 
		this.C = 0; 
		this.D = 0; 
		for(int i = 0; i < students.length ; i ++)
		{
			//System.out.println(i + students[i].getAnswer());
			if(students[i].getAnswer().equals("A"))
			{
				this.A++;
			}
			else if(students[i].getAnswer().equals("B"))
			{
				this.B++;
			}
			else if(students[i].getAnswer().equals("C"))
			{
				this.C++;
			}
			else if(students[i].getAnswer().equals("D"))
			{
				this.D++;
			}
			else if(students[i].getAnswer().equals("AB"))
			{
				this.A++;
				this.B++;
			}
			else if(students[i].getAnswer().equals("AC"))
			{
				this.A++;
				this.C++;
			}
			else if(students[i].getAnswer().equals("AD"))
			{
				this.A++;
				this.D++;
			}
			else if(students[i].getAnswer().equals("BC"))
			{
				this.C++;
				this.B++;
			}
			else if(students[i].getAnswer().equals("BD"))
			{
				this.D++;
				this.B++;
			}
			else if(students[i].getAnswer().equals("ABC"))
			{
				this.A++;
				this.B++;
				this.C++;
			}
			else if(students[i].getAnswer().equals("ABD"))
			{
				this.A++;
				this.B++;
				this.D++;
			}
			else if(students[i].getAnswer().equals("ACD"))
			{
				this.A++;
				this.D++;
				this.C++;
			}
			else if(students[i].getAnswer().equals("BCD"))
			{
				this.D++;
				this.B++;
				this.C++;
			}
			else if(students[i].getAnswer().equals("ABCD"))
			{
				this.A++;
				this.B++;
				this.C++;
				this.D++;
			}
		}

	}
	/*
	 * As mentioned above, this is the constructor that takes a student object as a parameter. 
	 * This small detail is incredibly important in data integrity as an entire object must be created 
	 * with a unique ID to submit answers to this platform. 
	 */
	
	
	public void showResults()
	{
		System.out.println("Results: ");
		System.out.println("Students that answered A: " + A);
		System.out.println("Students that answered B: " + B);
		System.out.println("Students that answered C: " + C);
		System.out.println("Students that answered D: " + D);
		System.out.println();
	} 

	//simple displayal method for the results of the vote. 

}
