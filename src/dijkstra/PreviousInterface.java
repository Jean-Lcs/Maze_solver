package dijkstra;


/**
 * Previous is a class which contains all the indications on the relations between vertices: father, son.
 */
public interface PreviousInterface 
{
	/**
	 * Setter for the value associated to the key 'x', which is its father.
	 * 
	 * @param son
	 * 				The vertex which is the son of the father.
	 * @param father
	 * 				The vertex which is the father of the son.
	 */
	public void affectsFather(VertexInterface son, VertexInterface father);
	
	/**
	 * Getter for the value associated to the key 'x', which is its father.
	 * 
	 * @param son
	 * 				The vertex of which we want to know the father.
	 * 
	 * @return The father of the vertex in the parameters.
	 */
	public VertexInterface getFather(VertexInterface son);
	
	/**
	 * @param x
	 * 				The vertex studied.
	 * 
	 * @return A boolean which indicates whether or not the vertex 'x' has a son.
	 */
	public boolean hasVertex(VertexInterface x);
}
