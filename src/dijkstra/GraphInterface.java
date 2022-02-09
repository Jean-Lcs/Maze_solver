package dijkstra;
import java.util.ArrayList;


/**
 * GraphInterface is the interface for graphs.
 */
public interface GraphInterface 
{
	/**
	 * @param x
	 * 			The first vertex studied.
	 * @param y
	 * 			The second vertex studied.
	 * 
	 * @return The weight between the first and the second vertex.
	 */
	public double getWeight(VertexInterface x,VertexInterface y);

	/**
	 * @param x
	 * 			The vertex studied.
	 * @return The list of the successors of the vertex studied.
	 */
	public ArrayList<VertexInterface> getSuccessors( VertexInterface x);

	
	/**
	 * @return A single list with all vertices of the maze.
	 */
	public ArrayList<VertexInterface> vertexList();
}
