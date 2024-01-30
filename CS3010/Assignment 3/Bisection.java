public class Bisection extends Driver
{


	public static double sendFunctionDetails(double x0, double x1)
	{
		double root = 0; 
		root = evaluate(x0, x1);
		return root;
	}

	private static double evaluate(double guess1, double guess2)
	{	
		double solution = -9999;
		if(evaluateE1(guess1) * evaluateE1(guess2) > 0)
		{
			System.out.println("Bisection error. Incorrect bounds.");
			return solution;
		}
		int count = 0; 
		double center = guess1; 
		double previousCenter = 0; 
		double error = 9.0;
		while(error > desiredError && count < maximumIterations)
		{
			//previousCenter = 0;
			center = (guess1 + guess2) / 2;
			if(evaluateE1(center) == 0)
			{
				solution = center; 
				return solution; 
			}
			else if((evaluateE1(guess1) * evaluateE1(center)) / 2 < 0)
			{	
				guess2 = center; 
			}
			else
			{
				guess1 = center; 
			}
			if(count!=0)
			{
				error = (Math.abs(center-previousCenter)/center);
				printToFile(String.valueOf(error));

			}
			previousCenter = center; 
			count ++;
		}
		return center;
	}
}
