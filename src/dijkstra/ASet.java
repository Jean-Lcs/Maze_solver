/**
	 * ASet is the class that we call 'A' in the implementation of the Dijkstra algorithm.
	 */

package dijkstra;
import java.util.HashSet;

public class ASet implements ASetInterface{
	
	/**
	 * Table of vertices.
	 */
	private HashSet<VertexInterface> hashset;

	
	/**
	 * Constructor of the table 'hashset'.
	 */
	public ASet() 
	{
		hashset = new HashSet<VertexInterface>();
	}
	
	
	/**
	 * @return A boolean which indicates whether or not the vertex studied is in the table 'hashset'.
	 * 
	 * @param x
	 * 			The vertex studied.
	 */
	@Override
	public boolean hasVertex(VertexInterface x) {
		return hashset.contains(x);
	}

	/**
	 * Adds the vertex 'x' into the table 'hashset'.
	 * 
	 * @param x
	 * 			The vertex studied.
	 */
	@Override
	public void addVertex(VertexInterface x) {
		hashset.add(x);
	}

}
