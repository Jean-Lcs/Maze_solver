package dijkstra;
import java.util.Hashtable;

/**
 * Pi is a class which contains all the indications on the distances of vertices to the root.
 */
public class Pi implements PiInterface
{
	/**
	 * Table 'hashtable'.
	 * The key is the vertex and the value associated to the key is its distance to the root.
	 */
	private Hashtable<VertexInterface,Integer> hashtable;
	
	/**
	 * Constructors of the table 'hashtable'.
	 */
	public Pi() 
	{
		this.hashtable = new Hashtable<VertexInterface,Integer>();
	}
	

	/**
	 * Getter for the value associated to the key 'x', which is its distance to the root.
	 * 
	 * @param x
	 * 				The vertex x studied.
	 * 
	 * @return The distance of x to the root.
	 */
	@Override
	public double getDistance(VertexInterface x) {
		return hashtable.get(x);
	}

	
	/**
	 * Setter for the value associated to the key 'x', which is its distance to the root.
	 * 
	 * @param x
	 * 				The vertex x studied.
	 * @param d
	 * 				The new distance.
	 */
	@Override
	public void changeDistance(VertexInterface x, double d) 
	{
		hashtable.put(x,(int) d);
	}

}
