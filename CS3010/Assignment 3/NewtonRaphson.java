public class NewtonRaphson extends Driver
{

	public static double sendFunctionDetails(double x0)
	{
		double root = 0; 
		root = evaluate(x0);
		return root;
	}
	private static double evaluate(double guess)
	{
		double error = evaluateE1(guess)/evaluateE1Derivative(guess);
		int count = 0; 
		while(Math.abs(error) > desiredError && count < maximumIterations)
		{
			error = evaluateE1(guess)/evaluateE1Derivative(guess);
			guess = guess - error;
			printToFile(String.valueOf(error));
		}
		return guess; 
	}
}