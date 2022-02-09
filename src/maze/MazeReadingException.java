package maze;

@SuppressWarnings("serial")
public class MazeReadingException extends Exception
{
	public MazeReadingException(String fileName, int j, String msg) 
	{
		super("Error in" + fileName + ",line." + j + ".\n" + msg);
	}

}
