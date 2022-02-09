package dijkstra;

/**
 * Pi is a class which contains all the indications on the distances of vertices to the root.
 */
public interface PiInterface 
{
	
	/**
	 * Getter for the value associated to the key 'x', which is its distance to the root.
	 * 
	 * @param x
	 * 				The vertex x studied.
	 * 
	 * @return The distance of x to the root.
	 */
	public double getDistance(VertexInterface x);
	
	
	/**
	 * Setter for the value associated to the key 'x', which is its distance to the root.
	 * 
	 * @param x
	 * 				The vertex x studied.
	 * @param d
	 * 				The new distance.
	 */
	public void changeDistance(VertexInterface x, double d);
	
}
