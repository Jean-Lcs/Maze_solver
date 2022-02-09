package dijkstra;
import java.util.ArrayList;

/**
 * Dijkstra is the class which finds the solution path in the maze.
 */
public class Dijkstra 
{
	/**
	 * The Dijkstra algorithm (which is known to give the shortest way in a graph) is used here to find the solution of our maze.
	 * 
	 * 
	 * 
	 * @param g
	 * 				The graph associated to the maze.
	 * @param r
	 * 				The root of the graph, which is the departure box of the maze.
	 * @param a
	 * 				A collection of vertices which will help during the algorithm.
	 * @param pi
	 * 				A PiInterface object which contains the distance of any vertex to the root.
	 * @param previous
	 * 				A PreviousInterface object which contains the relations between vertices (father/son/none).
	 * 
	 * @return The function previous, described in the parameter section.
	 */
	private static PreviousInterface dijkstra (
			GraphInterface g,
			VertexInterface r,
			ASetInterface a,
			PiInterface pi,
			PreviousInterface previous) 
	{
		
		
		
		a.addVertex(r); 																	//A={r}
		VertexInterface pivot = r;
		pi.changeDistance(r,0);																//pi(r)=0
		ArrayList<VertexInterface> vl = g.vertexList();										// we create the list of vertices
		for (VertexInterface x : vl) 
		{
			if (x!=r) 
			{
				pi.changeDistance(x,Double.POSITIVE_INFINITY);								// We set the distance to the infinite for every other vertex than the root 'r'.
			}
		}
		int n = vl.size();
		for (int i =0; i<n-1; i++) 
		{
			
			
			ArrayList<VertexInterface> l = new ArrayList<VertexInterface>();				// We create the list l which contains the successors of x who aren't in A.
			for (VertexInterface x : g.getSuccessors(pivot)) 
			{
				if (!a.hasVertex(x)) 
				{
					l.add(x);
				}
			}
			
			for (VertexInterface x : l) 													// For every distance in this list, we change its distance 
																							//if the new distance is smaller than the old one.
			{
				if (pi.getDistance(pivot)+ g.getWeight(pivot,x)<pi.getDistance(x)) 
				{
					pi.changeDistance( x,pi.getDistance(pivot)+ g.getWeight(pivot,x) );
					previous.affectsFather(x,pivot);
				}
			}
		
			
		double min = Double.POSITIVE_INFINITY;

		
		for (VertexInterface x : vl) 
		{
			

			if (!a.hasVertex(x) && pi.getDistance(x)<min ) 									// Within the vertices which aren't in 'A', we take take the 
																							//one with the smallest distance to choose the new 'pivot'. 
			{
				min = pi.getDistance(x);
				pivot=x;
			}

			
		}
		a.addVertex(pivot);																	// We add the vertex to 'A'
			
		
		}
		return previous;
		
	}
	
	
	
	
	
	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) 
	{
		ASet a= new ASet();
		Pi pi= new Pi();
		Previous previous= new Previous();
		return dijkstra(g,r,a,pi,previous);
	}
	
	
}





