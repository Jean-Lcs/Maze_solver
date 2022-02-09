package maze;

/**
 *  DBox is the class for departure boxes.
 */
public class DBox extends EBox
{
	/**
	 * Constructors of a 'DBox object'
	 * 
	 * @param x
	 * 				The horizontal coordinate.
	 * @param y
	 * 				The vertical coordinate.
	 * @param maze
	 * 				The maze containing this box.
	 */
	public DBox(int x, int y, Maze maze) 
	{
		super(x,y,maze);
	}
	
	/**
	 * Getter for the type of the box.
	 * 
	 * @return The type of the departure box
	 */
	public  String getType() 
	{
		return "D";
	} 
}

