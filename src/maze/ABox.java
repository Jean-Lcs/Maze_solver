package maze;

/**
 *  ABox is the class for arrival boxes.
 */
public class ABox extends EBox
{

	/**
	 * Constructors of a 'ABox object'
	 * 
	 * @param x
	 * 				The horizontal coordinate.
	 * @param y
	 * 				The vertical coordinate.
	 * @param maze
	 * 				The maze containing this box.
	 */
	public ABox(int x, int y, Maze maze) 
	{
		super(x,y,maze);
	}
	
	
	/**
	 * Getter for the type of the box.
	 * 
	 * @return The type of the arrival box
	 */
	public  String getType() 
	{
		return "A";
	} 
}


