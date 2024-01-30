public class SecantMethod extends Driver
{
	

	public static double sendFunctionDetails(double x0, double x1)
	{
		double root = 0;
		root = evaluate(x0, x1);
		return root;
	}
	private static double evaluate(double guess1, double guess2)
	{
		if(evaluateE1(guess2) * evaluateE1(guess1) > 0)
		{
			double intermediate = 0;
			double intermediate2 = 1; 
			int iterations = 0; 
			while (Math.abs(intermediate2 - intermediate) > desiredError && iterations < maximumIterations)
			{
				intermediate = (guess1*evaluateE1(guess2) - guess2*evaluateE1(guess1)) / (evaluateE1(guess2) - evaluateE1(guess1) );
				double center = evaluateE1(intermediate);
				if(center == 0)
				{
					return intermediate; 
				}

				guess1 = guess2;
				guess2 = intermediate; 
				iterations++;
				intermediate2 = (guess1*evaluateE1(guess2) - guess2*evaluateE1(guess1)) / (evaluateE1(guess2) - evaluateE1(guess1) );
				double error = Math.abs(intermediate2 - intermediate);
				printToFile(String.valueOf(error));
			}
			
			return intermediate2;
		}
		else
		{
			System.out.println("Bisection Detected1");
			return Bisection.sendFunctionDetails(guess1, guess2);
		}
	}
}
