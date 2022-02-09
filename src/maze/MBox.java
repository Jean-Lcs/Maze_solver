package maze;

import dijkstra.VertexInterface;

/**
 *  MBox is the class for any box.
 */
public abstract class MBox implements VertexInterface
{
	/**
	 * Horizontal coordinate of the box.
	 */
	private final int x;
	
	/**
	 * Horizontal coordinate of the box.
	 */
	private final int y;
	
	/**
	 * Maze containing the box.
	 */
	private Maze maze;


	
	/**
	 * Constructors of a 'MBox object'
	 * 
	 * @param x
	 * 				The horizontal coordinate.
	 * @param y
	 * 				The vertical coordinate.
	 * @param maze
	 * 				The maze containing this box.
	 */
	public MBox(int x, int y, Maze maze) 
	{
		this.x=x;
		this.y=y;
		this.maze=maze;

	}

	
	/**
	 * Getter for the horizontal coordinate.
	 * 
	 * @return The horizontal coordinate.
	 */
	public int getX()
	{
		return this.x;
	}
	
	/**
	 * Getter for the vertical coordinate.
	 * 
	 * @return The vertical coordinate.
	 */
	public int getY()
	{
		return this.y;
	}
	
	
	/**
	 * @return A boolean which indicates whether or not the box is empty.
	 */
	public boolean isEmpty()
	{
		String str = this.getType();
		return (str=="E" || str=="A" || str=="D");
	} 			
	
	/**
	 * Getter for the type of the box.
	 * 
	 * @return The type of the empty box.
	 */
	public abstract String getType(); 
	

}
