/*
 * Alexander J Sanna
 * CS2400 - 002 
 * Decemeber 2nd, 2022
 * 
 * 
 * Description: The DiGraph
 * Using a dictionary we are able to store the data of the vertices and the edges
 * efficiently. This was incredibly useful and efficient
 * This is the effective storage of vertices and edges in the map.
 */


public interface BasicGraphInterface<T> extends GraphAlgorithmsInterface<T>
{
	/**
	 * Add vertex allows for a point on a graph to be created.
	 * @param vertexLabel
	 * @return whether the addition was successful
	 */
	boolean addVertex(T vertexLabel);
	/**
	 * Adds a connection between 2 vertices.
	 * @param begin
	 * @param end
	 * @return whether the addition was successful
	 */
	boolean addEdge(T begin, T end);
	/**
	 * Adds a connections with a weight to it.
	 * @param begin
	 * @param end
	 * @param edgeWeight
	 * @return whether the addition was successful
	 */
	boolean addEdge(T begin, T end, double edgeWeight);
	/**
	 * searches to see if a specific edge exists.
	 * @param begin
	 * @param end
	 * @return whether the search was successful
	 */
	boolean hasEdge(T begin, T end);
	
	/**
	 * checks if the graph has data in it
	 * @return
	 */
	boolean isEmpty();
	/**
	 * get the number of vertices on the graph
	 * @return
	 */
	int getNumberOfVertices();
	/**	
 	* returns the number of edges (connections) in the graph
 	* @return
 	*/
	int getNumberOfEdges();
	/**
	 * clears all data from the graph. 
	 */
	void clear();

}




