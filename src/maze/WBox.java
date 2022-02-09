package maze;

/**
 *  DBox is the class for wall boxes.
 */
public class WBox extends MBox
{
	/**
	 * Constructors of a 'WBox object'
	 * 
	 * @param x
	 * 				The horizontal coordinate.
	 * @param y
	 * 				The vertical coordinate.
	 * @param maze
	 * 				The maze containing this box.
	 */
	public WBox(int x, int y, Maze maze) 
	{
		super(x,y,maze);
	}
	
	
	/**
	 * @return A boolean which indicates whether or not the box is empty.
	 */
	public boolean isEmpty()
	{
		return false;
	} 
	
	
	/**
	 * Getter for the type of the box.
	 * 
	 * @return The type of the departure box.
	 */
	public  String getType() 
	{
		return "W";
	}


	
}
	

