import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Driver
{
	protected static int maximumIterations = 100; 
	protected static double desiredError = .1;
	private static int equationNumber = 1; 
	public static void main(String[] arguments)
	{
		runTest(1);
		runTest(2);
	}


	private static void runTest(int testNumber)
	{	
		
		if(testNumber == 1)
		{	//function is  2x3 – 11.7x2 + 17.7x – 5 
			double[] modifiedSecantResults = new double[3];
			double[] secantResults = new double[3];
			double[] falsePresults = new double[3];
			double[] bisectionResults = new double[3];
			double[] newtonResults = new double[3];
			printToFile("Secant method x1");
			secantResults[0] = SecantMethod.sendFunctionDetails(.7,.9);
			printToFile("FPM method x1");
			falsePresults[0] = FalsePosition.sendFunctionDetails(0,1);
			printToFile("ModSecant x1");
			modifiedSecantResults[0] = ModifiedSecant.sendFunctionDetails(.01, .8);
			printToFile("bisection x1");
			bisectionResults[0] = Bisection.sendFunctionDetails(0, 1);
			printToFile("newton x1");
			newtonResults[0] = NewtonRaphson.sendFunctionDetails(1);

			printToFile("Secant method x2");
			secantResults[1] = SecantMethod.sendFunctionDetails(1.15,1.2);
			printToFile("ModSecant x2");
			modifiedSecantResults[1] = ModifiedSecant.sendFunctionDetails(.01, 1.25);
			printToFile("FPM method x2");
			falsePresults[1] = FalsePosition.sendFunctionDetails(.5,3);
			printToFile("bisection x2");
			bisectionResults[1] = Bisection.sendFunctionDetails(1, 3);
			printToFile("newton x2");
			newtonResults[1] = NewtonRaphson.sendFunctionDetails(2.6);
			
			printToFile("Secant method x3");
			secantResults[2] = SecantMethod.sendFunctionDetails(4,5);
			printToFile("ModSecant x3");
			modifiedSecantResults[2] = ModifiedSecant.sendFunctionDetails(.01, 3);
			printToFile("FPM method x3");
			falsePresults[2] = FalsePosition.sendFunctionDetails(2,4);
			printToFile("bisection x3");
			bisectionResults[2] = Bisection.sendFunctionDetails(2, 4);
			printToFile("newton x3");
			newtonResults[2] = NewtonRaphson.sendFunctionDetails(3);
			System.out.println("Besection Results yielded: " + bisectionResults[0] +", "+ bisectionResults[1] + " ,and " + bisectionResults[2] );
			System.out.println("FalsePosition Results yielded: " + falsePresults[0] +", "+ falsePresults[1] + " ,and " + falsePresults[2] );
			System.out.println("NewtonRaphson Results yielded: " + newtonResults[0] +", "+ newtonResults[1] + " ,and " + newtonResults[2] );
			System.out.println("Secant Results yielded: " + secantResults[0] +", "+ secantResults[1] + " ,and " + secantResults[2] );
			System.out.println("Modified Secant Results yielded: " + modifiedSecantResults[0] +", "+ modifiedSecantResults[1] + " ,and " + modifiedSecantResults[2] );

		}	

		if(testNumber == 2)
		{	//function is f(x) = x + 10 – xcosh(50/x)
			equationNumber = 2;
			System.out.println();
			printToFile("bisection cosh");
			System.out.println("Besection Result yielded: " + Bisection.sendFunctionDetails(0, 200 ) );
			printToFile("FALSEPOS cosh");
			System.out.println("FalsePosition Result yielded: " + FalsePosition.sendFunctionDetails(50, 150) );
			printToFile("newton cosh");
			System.out.println("NewtonRaphson Result yielded: " + NewtonRaphson.sendFunctionDetails(150));
			printToFile("secant cosh");

			System.out.println("Secant Result yielded: " + SecantMethod.sendFunctionDetails(130, 150));
			printToFile("ModSec cosh");

			System.out.println("Modified Secant Result yielded: " + ModifiedSecant.sendFunctionDetails(.01, 150));


		}

	}

	protected static double evaluateE1(double x)
	{
		if(equationNumber == 1)
		{
			return 2*(x*x*x) - 11.7*(x*x) + 17.7*x - 5;
		}
		else
		{
			return (x + 10 - x*Math.cosh(50/x));
		}
	}

	protected static double evaluateE1Derivative(double x)
	{
		if(equationNumber == 1)
		{
			return (60*(x*x) - 234*(x) + 177 ) / (10);
		}
		else
		{
			return (((50* Math.sinh(50/x))/x)-(Math.cosh(50/x)) + 1);
		}
		
	}
	
	protected static void printToFile(String input)
	{
		try(FileWriter fw = new FileWriter("myfile.txt", true);
    		BufferedWriter bw = new BufferedWriter(fw);
    		PrintWriter out = new PrintWriter(bw))
		{	
    		out.println(input);
    		//more code
    		//more code
		} 
catch (IOException e) {
System.out.println("Error");
}


	}
	


}