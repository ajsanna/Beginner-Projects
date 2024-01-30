/*
 * Alexander J Sanna
 * CS2400 - 002 
 * Decemeber 2nd, 2022
 * 
 * 
 * Description: The GraphAlgorithms
 * these are the algorithms that can be performed on any basic graph. 
 */


public interface GraphAlgorithmsInterface<T>
{
	QueueInterface<T> getBreadthFirstTraversal(T origin);

	QueueInterface<T> getDepthFirstTraversal(T origin);

	StackInterface<T> getTopologicalOrder();

	int getShortestPath(T begin, T end, StackInterface<T> path);

	double getCheapestPath(T begin, T end, StackInterface<T> path);

}
