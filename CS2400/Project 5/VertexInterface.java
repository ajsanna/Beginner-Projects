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
import java.util.Iterator;

public interface VertexInterface<T>
{
		/**
		 * returns the label of the vertex
		 * @return
		 */
		T getLabel();
		/**
		 * visits the vertex. marks the visit flag
		 */
		void visit();

		/**
		 * unvisits the vertex. marks the visit flag
		 */
		void unvisit();
		/**
		 * find out if a vertex has been visited
		 * @return
		 */
		boolean isVisited();
		/**
		 * connect. creates an edge between 2 vertices with a weight 
		 * @param end
		 * @param weight
		 * @return
		 */
		boolean connect(VertexInterface<T> end, double weight);
	/**
	 * Connect without weight parameter. 
	 * @param end
	 * @return
	 */
		boolean connect(VertexInterface<T> end);
		/**
		 * Gives an iterator to process through all the neighbors this vertex has
		 * @return
		 */
		Iterator<VertexInterface<T>> getNeighborIterator();

		/**
		 * returns an iterator to process through the weights of each edge
		 * @return
		 */
		Iterator<Double> getWeightIterator();
		/**
		 * determine whether this vertex has a neighbor
		 * @return
		 */
		boolean hasNeighbor();

		/**
		 * gives the unvisted neighbor of this vertex. 
		 * @return
		 */
		VertexInterface<T> getUnvisitedNeighbor();

		/**
		 * sets the vertex that goes to this vertex. 
		 * @param predecessor
		 */
		void setPredecessor(VertexInterface<T> predecessor);

		/**
		 * returns the vertex that connects to this vertex. 
		 * @return
		 */
		VertexInterface<T> getPredecessor();

		/**
		 * determines whether the vertex has a vertex before it 
		 * @return
		 */
		boolean hasPredecessor();
		/**
		 * sets the cost of a path to a vertex. 
		 * @param newCost
		 */
		void setCost(double newCost);
		/**
		 * returns the cost of a specified path to this vertex. 
		 * @return
		 */
		double getCost();
		
}
