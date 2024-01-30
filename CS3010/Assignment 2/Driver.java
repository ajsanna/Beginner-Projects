
/*
 * Author: Alexander J Sanna
 * Course: CS3010 Numerical Methods
 * Instructor: A. Raheja
 * Due: June s25th, 2023
 * 
 * Programming Assignment 2: Jacobi & Gauss Elimination Methods
 * Project Description:
 * 		 This is a linear system solver that uses two methods of 
 * 	finding solutions. The Jacobi Iterative approach and the Gauss-
 * 	-Siegell aproach. rather than return a perfect answer, this program
 * 	prompts for a desired stopping error. This error is the desired
 * 	relative error between the L2 norm values of both approaches respectively.
 * 	
 * PLEASE NOTE: 
 * 		This program was designed to be used with optimal 
 * 	inputs. IT IS EXPECTED THAT THE INPUT IS DIAGANALLY DOMINANT. 
 * 	If a zero is detected in the diagonal, the program terminates
 *	to prevent a critical error. 

		With any questions/concerns please contact
			ajsanna@cpp.edu

			-Alex
 * 
 */



//imports
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

/*
 * This is the main class 'Driver'.
 * to run main please use javac Driver.java, followed by java Driver
 */
public class Driver
{	
	//this final int will declare how many iterations before we give up the process.
	private final static int MAXIMUM_ITERATIONS = 50; 

	public static void main(String[] arguments) //start main
	{
		//no arguments permitted. 
		if(arguments.length > 0)
		{
			System.out.println("No arguments permitted, please try again");
			System.exit(0);
		}

		System.out.println("Welcome to the Linear Equation Solver 2.0");
		System.out.println("By: Alexander Sanna");
		System.out.println("________________________________________________");
		System.out.println(); //styling 

		Scanner userInput = new Scanner(System.in);

		System.out.println("How many equations would you like to enter? (Max. 10)");
		System.out.print("# of Equations: "); 
		int numberOfEquations = userInput.nextInt();
		if(numberOfEquations > 10)
		{
			System.out.println("Invalid Entry, please try again.");
			System.exit(0);
		}
		//takes user input for number of equations

		System.out.println("Would you like to use a File for input? y/n");
		System.out.print("File input?: ");
		boolean fileInput = userInput.next().equalsIgnoreCase("y");
		double[][] mainMatrix; 
		if(fileInput)
		{
			mainMatrix = getFileInput(numberOfEquations);
		}
		else
		{
			mainMatrix = getCommandLineInput(numberOfEquations);
		}
		//prompts for file input and calls respective methods to collect input. 
		//we now have the matrix. we must ask user for desired stopping error. 

		System.out.println("\nWhat is the desired stopping error? (ex: .1)");
		double stoppingError = userInput.nextDouble();
		System.out.println("\nStarting Solutions: ");
		double[] startingSolutions = new double[numberOfEquations];
		for(int i = 0; i < numberOfEquations; i ++)
		{
			System.out.print("x" + (i+1) + ": ");
			startingSolutions[i] = userInput.nextDouble();
		}
		//we then collect desired stopping error in decimal format.
		// and we also collect the desired starting solutions. 

		if(checkZeroDiagonals(mainMatrix))
		{
			System.out.println("Zeros detected in diagonal. Please reenter.");
			System.exit(0);
		}
		//diagonal zeros are not permitted. call method to check. 
		
		//System.out.println("Calculating n=" + numberOfEquations + ", error=" + stoppingError + " example:" + mainMatrix[0][1] );

		//call the iterate method to begin the process. 
		int result = iterate(mainMatrix, startingSolutions, stoppingError);

		if(result != 0)
		{
			System.out.println("Result found acceptable after " + result + " iterations.");
		}
		else
		{
			System.out.println("result not found in 50 iterations.");
		}
		//collect result as the iteration number and print. 
		//userInput.close();
	} //end main
/*
 * Used to collect file input from user. 
 */
	public static double[][] getFileInput(int equations)
	{
		Scanner userInput = new Scanner(System.in);
		System.out.println("\nFile input selected, please enter the file name.");
		System.out.print("File Name: ");
		String filename = userInput.next();
		double [][] returnMatrix = new double [equations][equations + 1];
		File inputSource;
		try
		{
			inputSource = new File(filename);
			Scanner scan = new Scanner(inputSource);
			
			for(int i = 0; i < equations; i ++)
			{
				for(int k = 0; k <= equations; k ++)
				{
					
					returnMatrix[i][k] = scan.nextDouble();
				}
			}

			scan.close();

		}	catch(FileNotFoundException e)
		{ 
			System.out.println("ERROR! File: " + filename + " not found. Please try again.");
			System.exit(0);
		}
		//userInput.close();
		return returnMatrix;
	}

	/*
	 * Used to collect input from the command Line. 
	 */
	public static double[][] getCommandLineInput(int equations)
	{
		double [][] matrix = new double [equations][equations + 1];
		Scanner userInput = new Scanner(System.in);
		System.out.println();
		
		for(int i = 0 ; i < equations; i ++)
		{
			System.out.println("Equation: " + (i+1) + ", Please enter the coefficients (One at a time, please)");
			for(int k = 0; k <= equations ; k ++)
			{
				if(k != equations)
				{
					System.out.print("\tCoefficient " +(k+1) +": ");
					matrix[i][k] = userInput.nextDouble();
				}
				else
				{
					System.out.print("\tb value: ");
					matrix[i][k] = userInput.nextDouble();
				}
			}
			
		}
		//userInput.close();
		return matrix;
	}
/*
 * Main iteration method. runs both methods and compares results. if the error is acceptable, we return to main. 
 */
	private static int iterate(double[][] matrix, double[] start, double error)
	{
		int iteration = 1;
		boolean closeEnough = false;
		double[] jacobiPrev = start;
		double[] gaussPrev = start; 

		//while we are below max iterations and were not close enough. 
		while(iteration <= MAXIMUM_ITERATIONS || closeEnough)
		{
			jacobiPrev = jacobiMethod(matrix,jacobiPrev,iteration);
			gaussPrev = gaussSeidelMethod(matrix, gaussPrev, iteration);
			//run the two methods 
			double jacobiL2 = calculateL2Norm(jacobiPrev);
			double gaussL2 = calculateL2Norm(gaussPrev);
			//calculate l2 norms

			double calculatedError = Math.abs((jacobiL2 - gaussL2)/gaussL2);
			System.out.println("Calculated Error at iteration "+ iteration+ " is: " + calculatedError);
			//compare and display Error value
			if(calculatedError<=error)
			{
				closeEnough = true;
				break;
			}
			//check if its close enough. 

			iteration++;
		}

		if(closeEnough)
		{
			return iteration;
		}
		return 0;

	}
	//calculation of the L2 norms, using (sum(x^2))^1/2
	private static double calculateL2Norm(double[] values)
	{
		double result =0;
		for(int i = 0; i < values.length; i ++)
		{
			result+=(values[i]*values[i]);
		}


		return Math.sqrt(result);
	}

	/*
	 * Jacobi Methodology
	 * 		
	 */
	private static double[] jacobiMethod(double[][] matrix, double[] prev, int iteration)
	{

    	int n = matrix.length;
    	double[] newValues = new double[n]; 
    	double[] previousValues = prev; // Prev ^^
    	Arrays.fill(newValues, 0);
    	
      for (int i = 0; i < n; i++) 
	  {
        double sum = matrix[i][n]; 

        for (int j = 0; j < n; j++)
		{
          if (j != i)
		  {
			sum = sum - ( matrix[i][j] * previousValues[j]);
		  }
            
		}
        
        newValues[i] = 1/matrix[i][i] * sum;
      }

      System.out.print("Jacobi X^" + iteration + " = [");
      for (int i = 0; i < n; i++)
      System.out.print(newValues[i] + " ");
      System.out.println("]");
    
	return newValues;
  }

/*
 * Gauss Siedel Methodology
 */
	private static double[] gaussSeidelMethod(double[][] matrix, double[] prev, int iteration)
	{
		double[] newValues;
		int n = matrix.length;
		if(iteration == 1)
		{
			 newValues = new double[n]; 
			Arrays.fill(newValues, 0);
		}
		else
		{
			 newValues = prev; 
		}
		
		  for (int i = 0; i < n; i++) 
		  {
			double sum = matrix[i][n]; 
	
			for (int j = 0; j < n; j++)
			{
				if (j != i)
				{
					sum = sum - ( matrix[i][j] * newValues[j]);
				}
				
			}
			
			// Update x_i to use in the next row calculation
			newValues[i] = 1/matrix[i][i] * sum;   
		  }
	
		  System.out.print("Siegel X^" + iteration + " = [");
		  for (int i = 0; i < n; i++)
			System.out.print(newValues[i] + " ");
		  System.out.println("]");

		return newValues;
	}

	/*
	 * Check for zeros in diagonal to avoid errors
	 */
	private static boolean checkZeroDiagonals(double[][] matrix)
	{
		for(int i = 0; i < matrix.length; i++)
		{
			if(matrix[i][i] == 0)
			{
				return true; //zero detected in diagonal.
			}
		}

		return false;
	}

}