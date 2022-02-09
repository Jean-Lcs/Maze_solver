package maze;

/**
 *  EBox is the class for empty boxes.
 */
public class EBox extends MBox
{
	/**
	 * Type of the EBox. It is "E" at the beginning and it is changed to "." if the box is on the path of the solution.
	 */
	private String type;
	
	
	/**
	 * Constructors of a 'EBox object'
	 * 
	 * @param x
	 * 				The horizontal coordinate.
	 * @param y
	 * 				The vertical coordinate.
	 * @param maze
	 * 				The maze containing this box.
	 */
	public EBox(int x, int y, Maze maze) 					// Constructor of the EBox.
	{
		super(x,y,maze);
		type= "E";
	}
	
	/**
	 * Setter for the type oh the EBox.
	 * 
	 * @param type
	 * 				Type of the box.
	 */
	public void setType(String type) 						// Changes the type of the EBox.
	{
		this.type=type;
	}

	/**
	 * @return A boolean which indicates whether or not the box is empty.
	 */
	public boolean isEmpty()
	{
		return true;
	} 
	
	/**
	 * Getter for the type of the bow.
	 * 
	 * @return The type of the empty box
	 */
	public  String getType() 
	{
		return type;
	}


}
