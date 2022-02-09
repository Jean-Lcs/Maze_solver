import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import dijkstra.Dijkstra;
import dijkstra.PreviousInterface;
import maze.Maze;
import maze.MazeReadingException;
import maze.EBox;
import maze.MBox;

public class Main 
{

	
	
	public static void main(String[] args) 
			
	{
		
		
		int fileNumber=8;														// fileNumber is an integer between 1 and 8 that 
																				// we modify to chose the maze we want to use
		
		ArrayList<String> listOfFiles= new ArrayList<String>();
		listOfFiles.add("data/lab1.txt");
		listOfFiles.add("data/lab1-sol.txt");
		listOfFiles.add("data/lab2.txt");
		listOfFiles.add("data/lab2-sol.txt");
		listOfFiles.add("data/lab3.txt");
		listOfFiles.add("data/lab3-sol.txt");
		listOfFiles.add("data/lab4.txt");
		listOfFiles.add("data/lab4-sol.txt");
		listOfFiles.add("data/lab5withWrongFormat.txt");
		listOfFiles.add("data/Empty-text-file.txt");
		listOfFiles.add("data/lab6withWrongBoxes.txt");
		listOfFiles.add("data/Empty-text-file.txt");
		listOfFiles.add("data/lab7withoutAnySolution.txt");
		listOfFiles.add("data/Empty-text-file.txt");
		listOfFiles.add("data/lab8withoutAnyDeparture.txt");
		listOfFiles.add("data/Empty-text-file.txt");
		
		String fileName = listOfFiles.get(2*fileNumber-2);						// The correct file name is now in 'fileName'
		String fileNameSolution = listOfFiles.get(2*fileNumber-1);				// The file containing the solution is automatically chosen.
		
		
		
		int width=0;															// The dimensions are determined by reading the text
		int height=0;

		FileReader     fr1 = null;
		BufferedReader br1 = null;
		
		
		fr1 = null ;
		br1 = null;
		
		
		
		try 
		{
			fr1 = new FileReader(fileName) ;
			br1 = new BufferedReader(fr1) ;
		
			height++;
			while (br1.read()!='\n') 
			{
				width++;
			}
			while (br1.readLine()!=null)
			{
				height++;
			}
			
		} catch(IOException e) {System.out.println("An IO or Maze reading exception occured"); }
				
		
		
		Maze maze = new Maze(height,width);											// We initialize the maze with the correct dimensions and correct file.
		try {
			maze.initFromTextFile(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MazeReadingException e) {
			e.printStackTrace();
		}										
		

		
		
		for(int i=0;i<maze.getHeight();i++) 										// We find the departure and the arrival of the maze
		{
			for(int j=0;j<maze.getwidth();j++) 
			{
				String s = maze.getTable().get(i).get(j).getType();
				if (s == "A") 
				{
					maze.setArrival(maze.getTable().get(i).get(j));
				}
				
				if (s == "D") 
				{
					maze.setDeparture(maze.getTable().get(i).get(j));
				} 
			}
		}
		
		if (maze.getArrival()==null || maze.getDeparture()==null ) 
		{
			System.out.println("The arrival or the departure of the maze is missing.");
			return;
		}
		
		
		PreviousInterface previous = Dijkstra.dijkstra(maze,maze.getDeparture());	// Dijkstra is used to create the 'previous' function.
		
		
		if (!previous.hasVertex(maze.getArrival())) 								// If the arrival doesn't have a father, the maze has no solution.
		{
			System.out.println("Le labyrinthe n'a pas de solution");
			return;
		}
		
		MBox box = maze.getArrival();												// While going up until the departure, we set the type of the
		while (box.getType()!="D") 													// boxes to "." to spot the path in the solution file text
		{
			box=(MBox) previous.getFather(box);
			((EBox) box).setType(".");
		}
		
		
		maze.saveToTextFile(fileNameSolution);										// We can now read the maze and save its content in the file
		
	}
	

}
