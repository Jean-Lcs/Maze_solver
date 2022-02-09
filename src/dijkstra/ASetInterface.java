package dijkstra;


public interface ASetInterface 
{
	/**
	 * @return A boolean which indicates whether or not the vertex studied is in the table 'hashset'.
	 * 
	 * @param x
	 * 			The vertex studied.
	 */
	public boolean hasVertex(VertexInterface  x);

	/**
	 * Adds the vertex 'x' into the table 'hashset'.
	 * 
	 * @param x
	 * 			The vertex studied.
	 */
	public void addVertex(VertexInterface  x);
	

}
