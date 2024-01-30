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

import java.util.PriorityQueue;

public class DiGraph<T> implements BasicGraphInterface<T>
{
	//the vertices are stored in a dictionary ADT for easy quick access. 
	//number of edges tracked 
	DictionaryInterface<T, VertexInterface<T>> vertices;
	private int numberOfEdges;

public QueueInterface<T> getBreadthFirstTraversal(T origin)
{
	//not implemented
	return null; 
}
public QueueInterface<T> getDepthFirstTraversal(T origin)
{
	//not implemented
	return null;
}
public StackInterface<T> getTopologicalOrder()
{
	//not implemented
	return null;
}
public int getShortestPath(T begin, T end, StackInterface<T> path)
{
	//not implemented
	return 0; 
}

/*
 * This is dijstras algorithm to get the cheapest path. 
 * Works by using the priority queue ADT
 */
public double getCheapestPath(T begin, T end, StackInterface<T> path)
{
	VertexInterface<T> beginVertex = vertices.getValue(begin);
	//System.out.println(beginVertex.getLabel());
	VertexInterface<T> endVertex = vertices.getValue(end);
	boolean done = false; 
	//System.out.println("Status");
	PriorityQueue<EntryPQ> priorityQueue = new PriorityQueue<>();
	EntryPQ current = new EntryPQ(beginVertex, 0, null);
	priorityQueue.add(current);
	while(!done && !priorityQueue.isEmpty())
	{
		EntryPQ frontEntry = priorityQueue.remove();
		//System.out.println(frontEntry.getDistance());
		VertexInterface<T> frontVertex = frontEntry.getVertex();
		//System.out.println(frontVertex.getLabel());
		if(!frontVertex.isVisited())
		{
			frontVertex.visit();
			frontVertex.setCost(frontEntry.getDistance());
			frontVertex.setPredecessor(frontEntry.getPred());
			if(frontVertex.getLabel().equals(endVertex.getLabel()))
			{
				done = true;
			}
			else
			{
				Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();
				Iterator<Double> weights = frontVertex.getWeightIterator();
				while(neighbors.hasNext())
				{
					VertexInterface<T> nextNeighbor = neighbors.next();
					double weightOfEdgeToNeighbor = weights.next();
					if(!nextNeighbor.isVisited())
					{
						double nextCost = weightOfEdgeToNeighbor + frontEntry.getDistance();
						priorityQueue.add(new EntryPQ(nextNeighbor, nextCost, frontVertex));
					}

				}
			}
		}
	}
	double pathCost = endVertex.getCost() ;
	path.push(endVertex.getLabel());
	VertexInterface<T> vertex = endVertex; 
	while(vertex.hasPredecessor())
	{
		vertex = vertex.getPredecessor();
		//pathCost+= vertex.getCost();
		path.push(vertex.getLabel());
	}
	resetGraph();
	return pathCost; 
}
/*
 * Private method to reset the visited flag and predecessor reference. 
 * This is essential to be called after all algorithms run. 
 */
private void resetGraph()
{
	Iterator<T> keys = vertices.getKeyIterator();
	while(keys.hasNext())
	{
		VertexInterface<T> current = vertices.getValue(keys.next());
		current.unvisit();
		current.setCost(0);
		current.setPredecessor(null);

	}
}


/*
 * Constructor. makes the dictionary object for storage. 
 */
public DiGraph()
{
	vertices = new MapDictionary<>();
	numberOfEdges = 0; 
}
/*
 * Add a vertex to the graph. 
 */
public boolean addVertex(T vertexLabel)
{

	VertexInterface<T> addition = vertices.add(vertexLabel, new Airports<T>(vertexLabel));
	return addition == null; 
}
/*
 * add an edge to the graph with a weight
 */
public boolean addEdge(T begin, T end, double edgeWeight)
{
	if(hasEdge(begin, end))
	{
		return false;
	}
	boolean result = false; 
	VertexInterface<T> beginVertex = vertices.getValue(begin);
	VertexInterface<T> endVertex = vertices.getValue(end);

	if(beginVertex!=null && endVertex != null)
	{
		result = beginVertex.connect(endVertex, edgeWeight);
	}
	if(result)
	{

		numberOfEdges++;
	}

	



	return result; 
}
/*
 * add an edge to the graph UNWEIGHTED
 */
public boolean addEdge(T begin, T end)
{
	boolean result = false; 
	VertexInterface<T> beginVertex = vertices.getValue(begin);
	VertexInterface<T> endVertex = vertices.getValue(end);

	if(beginVertex!=null && endVertex != null)
	{
		result = beginVertex.connect(endVertex);
	}
	if(result){numberOfEdges++;}

	





	return result ; 
}
/*
 * had edge  returns boolean if the edge exists
 */
public boolean hasEdge(T begin, T end)
{
	boolean result = false; 
	VertexInterface<T> start = vertices.getValue(begin);
	VertexInterface<T> target = vertices.getValue(end);
	if(!start.hasNeighbor())
	{
		return false;
	}
	Iterator<VertexInterface<T>> neighbors = start.getNeighborIterator();
	while(neighbors.hasNext())
	{
		if(neighbors.next().getLabel().equals(target.getLabel()))
		{
			return true; 
		}
	}
	return result; 
}
/*
 * boolean returns if the graph is empty 
 */
public boolean isEmpty()
{
	
	return vertices.isEmpty();
}
/*
 * returns number of vertices
 */
public int getNumberOfVertices()
{
	return vertices.getSize(); //stub
}
/*
 * returns number of edges
 */
public int getNumberOfEdges()
{
	return numberOfEdges; //stub
}
/*
 * clears the graph of all vertices and edges
 */
public void clear()
{
	vertices.clear();

}
	
/*
 * This is the inner class EntryPQ. It implements comparable
 * so that the priority queue can compare the two. 
 */
class EntryPQ implements Comparable<EntryPQ>
{
	VertexInterface<T> vertex; 
	double distance; 
	VertexInterface<T> pred;
	public EntryPQ(VertexInterface<T> vertex, double distance, VertexInterface<T> pred)
	{
		this.vertex = vertex; 
		this.distance = distance; 
		this.pred = pred; 
		
	}
	public VertexInterface<T> getVertex()
	{
		return vertex;
	}
	public double getDistance()
	{
		return distance; 
	}
	public VertexInterface<T> getPred()
	{
		return pred; 
	}

	public int compareTo(EntryPQ rhs)
	{
		//System.out.println(lhs);
		if(this.getDistance()>rhs.getDistance()) 
		{
			return 1;
		}
		else if(this.getDistance()<rhs.getDistance())
		{
			return -1; 
		}
		return 0; 
	}


}


}


