/*
 * Alexander J Sanna
 * CS2400 - 002 
 * Decemeber 2nd, 2022
 * 
 * 
 * Description: The Airports class
 * this is the implementation of the vertex interface. it stores the data and how 
 * the individual data is related to other data via edges and costs. 
 * This is used to represent each indiv. airport in the system. 
 */


import java.util.Iterator;
import java.util.ArrayList; 


public class Airports<T> implements VertexInterface<T>
{
	private T label;
	private boolean visited;
	private VertexInterface<T> previousVertex;
	private double cost; 
	private ArrayList<Edge> edges; 
	
	

	public Airports(T label)
	{
		this.label = label;
		edges = new ArrayList<>();
		visited = false; 
		cost = 0; 
		previousVertex = null; 
	}

	public T getLabel()
	{
		return label; 
	}

	public void visit()
	{
		visited = true;
	}

	public void unvisit()
	{
		visited = false; 
	}

	public boolean isVisited()
	{
		return visited; 
	}

	public boolean connect(VertexInterface<T> end, double weight)
	{
		edges.add(new Edge(end, weight));
		return true;
		
	}

	public boolean connect(VertexInterface<T> end)
	{
		edges.add(new Edge(end, 0));
		return false; //stub
	}

	public Iterator<VertexInterface<T>> getNeighborIterator()
	{
		ArrayList<VertexInterface<T>> vertices = new ArrayList<>();
		for(int i = 0; i < edges.size(); i ++)
		{		
			vertices.add(edges.get(i).getEndVertex());
		}
		Iterator<VertexInterface<T>> result = vertices.iterator();
		return result; //stub
	}

	public Iterator<Double> getWeightIterator()
	{
		ArrayList<Double> weight = new ArrayList<>();
		for(int i = 0; i < edges.size(); i ++)
		{		
			weight.add(edges.get(i).getWeight());
		}
		Iterator<Double> result = weight.iterator();
		return result; //stub
	}

	public boolean hasNeighbor()
	{

		boolean neighbor = false; 

		if(!edges.isEmpty())
		{
			neighbor = true; 
		}

		return neighbor;
	}

	public VertexInterface<T> getUnvisitedNeighbor()
	{
		VertexInterface<T> target = null;  
		for(int i = 0; i < edges.size(); i ++)
		{
			if(!edges.get(i).getEndVertex().isVisited())
			{
				target = edges.get(i).getEndVertex();
				i = 100; 
			}
		}
		return target;
		//stub
	}

	public void setPredecessor(VertexInterface<T> predecessor)
	{
		this.previousVertex = predecessor;
	}

	public VertexInterface<T> getPredecessor()
	{
		return previousVertex; //stub
	}

	public boolean hasPredecessor()
	{
		return previousVertex!=null; 
		
	}

	public void setCost(double newCost)
	{
		this.cost = newCost;
	}

	public double getCost()
	{
		return cost; 
	}

	
	protected class Edge
	{
		private VertexInterface<T> vertex;
		private double weight;

		protected Edge(VertexInterface<T> endVertex, double edgeWeight)
		{
			this.vertex = endVertex;
			this.weight = edgeWeight;

		}

		protected VertexInterface<T> getEndVertex()
		{
			return vertex;
		}
		protected double getWeight()
		{
			return weight;
		}


	}

}
