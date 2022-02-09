package dijkstra;
import java.util.Hashtable;


public class Previous implements PreviousInterface{
	
	/**
	 * Table 'hashtable'.
	 * The key is the son vertex and the value associated to the key its father.
	 */
	private Hashtable<VertexInterface,VertexInterface> hashtable;
	
	/**
	 * Constructors of the table 'hashtable'.
	 */
	public Previous() 
	{
		this.hashtable= new Hashtable<VertexInterface,VertexInterface>();
	}

	
	/**
	 * Setter for the value associated to the key 'x', which is its father.
	 * 
	 * @param son
	 * 				The vertex which is the son of the father.
	 * @param father
	 * 				The vertex which is the father of the son.
	 */
	@Override
	public void affectsFather(VertexInterface son, VertexInterface father) 
	{
		hashtable.put(son,father);
	}

	/**
	 * Getter for the value associated to the key 'x', which is its father.
	 * 
	 * @param son
	 * 				The vertex of which we want to know the father.
	 * 
	 * @return The father of the vertex in the parameters.
	 */
	@Override
	public VertexInterface getFather(VertexInterface son) {
		return hashtable.get(son);
	}
	
	/**
	 * @param x
	 * 				The vertex studied.
	 * 
	 * @return A boolean which indicates whether or not the vertex 'x' has a son.
	 */
	public boolean hasVertex(VertexInterface x) 
	{
		return hashtable.containsKey(x);
	}
	
	
	
	

}
