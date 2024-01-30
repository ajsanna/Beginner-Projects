
/*
 * 	Programming Project 1 
 * By: Sanna, Alexander 
 * 
 * Computer Science 3010 
 * Professor A. Raheja, CS3010.E01
 * Due: June 18th, 2023
 * *** Description:
 * 		This program is a tool to calculate the solutions of a set of linear equations. 
 * 	With a maximum of 10 linear equations as input, it will go through the gaussian elimination process
 * to return the correct values to satisfy the system as true. There are two input options, from the terminal
 * directly, or through a file input. See descriptions for individual methods below. 
 */

 import java.util.Scanner;
 import java.io.*;
 import java.io.FileNotFoundException;
 //necessary imports

public class LinearEquationSolver
{
	public static void main(String[] args)
	{
		double [][] augmentedMatrix; 
		Scanner userInput = new Scanner(System.in);
		System.out.println();
		System.out.println("Welcome to the Linear Equation Solver, By Alexander Sanna");
		System.out.print("Please enter the number of Linear Equations to solve: (10 MAX) ");
		int numberOfEquations = userInput.nextInt();

		System.out.println();
		System.out.print("Entries from file? (y/n)");
		boolean fileInput = (userInput.next()).equalsIgnoreCase("y");

		/*
		 * This is where the user decides what style input they would like to provide. 
		 */
		if(fileInput)
		{
			System.out.print("(Case Sensitive)Please enter the name of the file: ");
			String userFile = userInput.next();
			System.out.println();
			augmentedMatrix = sourceFromFile(numberOfEquations, userFile);
		}
		else
		{
			augmentedMatrix = sourceFromTerminal(numberOfEquations);
		}

		/*
		 * once we have the matrix, we send it to the findSolution method to get the ball rolling
		 */
		double [] solution = findSolution(augmentedMatrix);

		System.out.println("Solved final matrix: \n");

		displayMatrix(augmentedMatrix);
		System.out.println("\nSolutions Displayed Below: ");
		
		for (int i = 0; i < solution.length; i++) 
		{
           // System.out.println("\tx" + (i + 1) + " = " + solution[i]);
			System.out.printf("\tx%d = %.5f\n", (i+1), solution[i]);
        }
		
		userInput.close();
	}

	/*
	 * SOURCE FROM FILE METHOD:
	 * 	This method will allow the user to input a filename to the program to read from.
	 * it will then scan this file and take the values to a stored matrix. 
	 */
	public static double[][] sourceFromFile(int equations, String source)
	{
		double [][] returnMatrix = new double [equations][equations + 1];
		File inputSource;
		try
		{
			inputSource = new File(source);
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
			System.out.println("ERROR! File: " + source + " not found. Please try again.");
			System.exit(0);
		}

		return returnMatrix;
	}


	/*
	 * Source from terminal method
	 * 
	 * this method allows the user to input the neccesary values from the terminal and stores them in the matrix.
	 */
	public static double[][] sourceFromTerminal(int equations)
	{
		double [][] returnMatrix = new double[equations][equations + 1];
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
					returnMatrix[i][k] = userInput.nextDouble();
				}
				else
				{
					System.out.print("\tb value: ");
					returnMatrix[i][k] = userInput.nextDouble();
				}
			}
			
		}
		userInput.close();
		return returnMatrix;
	}

	/*
	 * This is the findSolution method, it is the driver for the solution process. 
	 * 
	 * we first indicate which row we would like to pivot to, by calling the pivotRow method
	 * Afterwards, we swap the rows with the swapRow method. 
	 * 
	 * we then calculate a factor, subtract a row by it and multiply by the other, effectively cancling out 
	 * in order to result in a 0. 
	 * 
	 * we then organize our results into an array to return. 
	 */
	public static double[] findSolution(double[][] augmentedMatrix) {
        int bound = augmentedMatrix.length;
		double[] solution = new double[bound];

        for (int a = 0; a < bound - 1; a++) 
		{
			int step = a + 1; 
            int row = pivotRow(augmentedMatrix, a, step);
            swapRows(augmentedMatrix, a, row);

            for (int b = a + 1; b < bound; b++) 
			{
                double factor = augmentedMatrix[b][a] / augmentedMatrix[a][a];

                for (int c = a; c <= bound; c++) 
				{
                    augmentedMatrix[b][c] -= factor * augmentedMatrix[a][c];
                }
            }
        }

        for (int i = bound - 1; i >= 0; i--) 
		{
            double sum = 0.0;
            for (int j = i + 1; j < bound; j++)
			{
                sum += augmentedMatrix[i][j] * solution[j];
            }
            solution[i] = (augmentedMatrix[i][bound] - sum) / augmentedMatrix[i][i];
        }

        return solution;
    }

	/*
	 * this is the pivot row method.
	 * 
	 * This method is used by the solution finding process in order to simplify the array down to 0's.
	 * 
	 */
    public static int pivotRow(double[][] augmentedMatrix, int bound, int step) 
	{
        int numEquations = augmentedMatrix.length;
        int pivotRow = bound;
        double maxRatio = Math.abs(augmentedMatrix[bound][bound] / getMaxCo(augmentedMatrix, bound));

        for (int i = bound + 1; i < numEquations; i++) 
		{
            double ratio = Math.abs(augmentedMatrix[i][bound] / getMaxCo(augmentedMatrix, i));

            if (ratio > maxRatio) 
			{
                maxRatio = ratio;
                pivotRow = i;
            }
        }
		System.out.println("Step: " + step);
		System.out.println("Ratio: " + maxRatio);
		System.out.println("Selected row: " + pivotRow +"\n");
		displayMatrix(augmentedMatrix);
        return pivotRow;
    }

	/*
	 * comparisison method, used to find the maximum value in the matrix. 
	 */
    public static double getMaxCo(double[][] augmentedMatrix, int row) 
	{
        int bound = augmentedMatrix.length;
        double maxCoefficient = Math.abs(augmentedMatrix[row][0]);

        for (int i = 1; i < bound; i++) 
		{
            double coefficient = Math.abs(augmentedMatrix[row][i]);
            if (coefficient > maxCoefficient) 
			{
                maxCoefficient = coefficient;
            }
        }

        return maxCoefficient;
    }

	/*
	 * print method, used to display the matrix contents at each step.
	 */
	public static void displayMatrix(double[][] matrix)
	{

		for(int i = 0; i < matrix.length ; i ++)
		{
			for(int j = 0; j < matrix.length + 1; j ++)
			{
				System.out.printf("\t %.2f\t",matrix[i][j]);
			}
			System.out.println("\n");
		}


	}

/*
 * swap method, used to change values from row to row. 
 */
    public static void swapRows(double[][] augmentedMatrix, int row1, int row2) 
	{
        double[] temp = augmentedMatrix[row1];
        augmentedMatrix[row1] = augmentedMatrix[row2];
        augmentedMatrix[row2] = temp;
    }

    
}