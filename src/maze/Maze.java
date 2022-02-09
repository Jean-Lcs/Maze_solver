package maze;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

/**
 *  Maze is the class for the mazes.
 */
public class Maze 
	implements GraphInterface
	
{
	/**
	 * Height of the maze. Can not be modified.
	 */
	private final int height; 	
	
	/**
	 * Width of the maze. Can not be modified.
	 */
	private final int width;

	/**
	 * Arrival box of the maze.
	 */
	private MBox arrival;
	
	/**
	 * Departure box of the maze.
	 */
	private MBox departure;
	
	/**
	 * Matrix which contains the different boxes of the maze.
	 */
	private ArrayList<ArrayList<MBox>> table; 		
	
	
	/**
	 * Constructors of a 'Maze object'
	 * 
	 * While created, all the boxes to 'Empty' are initialized to 'Empty' in order to have a maze with the right dimensions, but it will be modified later on.
	 * 
	 * @param height
	 * 				The height of the maze.
	 * @param width
	 * 				The width of the maze.
	 */
	public Maze(int height,int width) 
	{
		this.height=height;
		this.width=width;
		this.table = new ArrayList<ArrayList<MBox>>();
		for (int i=0;i<height;i++) 
		{
		ArrayList<MBox> tableLine = new ArrayList<MBox>();
			for (int j=0;j<width;j++) 
			{
				tableLine.add( new EBox(i,j,this));
			}
			this.table.add(tableLine);
		}

	}
	/**
	 * @param arrival
	 * 					The arrival box of the maze.
	 */
	public void setArrival(MBox arrival) 
	{
		this.arrival=arrival;
	}
	
	/**
	 * @return The arrival box of the maze.
	 */
	public MBox getArrival() 
	{
		return this.arrival;
	}
	
	/**
	 * @param departure
	 * 					The box which is the departure
	 */
	public void setDeparture(MBox departure) 
	{
		this.departure=departure;
	}
	
	/**
	 * @return The departure box of the maze
	 */
	public MBox getDeparture() 
	{
		return this.departure;
	}
	
	/**
	 * getter for the height
	 * 
	 * @return The height of the maze.
	 */
	public int getHeight()				
	{
		return this.height;
	}
	
	/**
	 * getter for the width
	 * 
	 * @return The width of the maze.
	 */
	public int getwidth()				
	{
		return this.width;
	}
	
	public ArrayList<ArrayList<MBox>> getTable()
	{
		return this.table;	
	}

	

	/**
	 * @param vertex
	 * 				The vertex we want to know the neighbors of.
	 * @return The list of neighbors of the vertex in parameters.
	 */
	public ArrayList<MBox> getNeighbors(MBox vertex)
	{
		ArrayList<MBox> res = new ArrayList<MBox>();
		int x = vertex.getX();
		int y = vertex.getY();
		if (x>0) {res.add(table.get(y).get(x-1));}								// If the vertex isn't on the left vertical border, we add his left neighbour
		if (x<width-1) {res.add(table.get(y).get(x+1));}						// If the vertex isn't on the right vertical border, we add his right neighbour
		if (y>0) {res.add(table.get(y-1).get(x));}								// If the vertex isn't on the bottom horizontal border, we add his bottom neighbour
		if (y<height-1) {res.add(table.get(y+1).get(x));}						// If the vertex isn't on the top horizontal border, we add his top neighbour
		return res;
	}
	
	
	
	/**
	 * @param x
	 * 				The vertex 'x' we want to know the successors of.
	 * @return The list of successors of the vertex in parameters.
	 */
	public ArrayList<VertexInterface> getSuccessors(VertexInterface x)
	{
		ArrayList<VertexInterface> res= new ArrayList<VertexInterface>();
		for (MBox m: getNeighbors((MBox) x)) 					// Within the neighbor of the studied vertex
		{
			if (m.isEmpty()) {res.add(m);}						// We add the neighbor to the successor if it is an empty box 
		}
		return res;
	}
	
	
	
	/**
	 * @param x
	 * 			The first vertex studied.
	 * @param y
	 * 			The second vertex studied.
	 * 
	 * @return The weight between the first and the second vertex (it equals 1 for a maze).
	 */
	@Override
	public double getWeight(VertexInterface x, VertexInterface y) 
	{
		return 1;
	}



				
				

	/**
	 * Converts the maze (text) of the file into the maze of the class (type Maze).
	 * 
	 * @param fileName
	 * 				The path of the file containing the maze, with a text structure.
	 * 
	 * @throws IOException if an IO exception occurs.
	 * 
	 * @throws MazeReadingException if the length of a line is different from the width of the maze.
	 */
	public final void initFromTextFile(String fileName) 						
	throws IOException, MazeReadingException
	{
		FileReader     fr = null;
		BufferedReader br = null;
		try
		{
			fr = new FileReader(fileName) ;
			br = new BufferedReader(fr) ;
			ArrayList<ArrayList<MBox>> res =new ArrayList<ArrayList<MBox>>();
			
			for (int i=0; i<height; i++)
			{
				String line=br.readLine();
				int length=line.length();
				if (length!=width) 	
				{
					br.close();
					throw new MazeReadingException(fileName,i,"The width of the line is "+String.valueOf(length)+" and not "+String.valueOf(width)+".");
				}
				res.add(lineToMBox(line,i,fileName));
			}	
			this.table = res;
		} catch(IOException e) {System.out.println("An IO exception occured"); }
		finally 
		{
				try
				{
					fr.close();
					br.close();
				}catch(Exception e) {}
				
		}
	}
	
	
	
	/**
	 * Converts a line of text (type String) into a matching line of boxes.
	 * 
	 * @param line
	 * 				The string which is to be converted.
	 * @param i
	 * 				The number of the line in the maze.
	 * @param fileName
	 * 				Path of the file which created the parameter line. It has to be a parameter to throw the exception.
	 * 
	 * @return The list of boxes matching the letters of the string line.
	 * 
	 * @throws MazeReadingException If there is a wrong character in the text file
	 */
	public ArrayList<MBox> lineToMBox(String line, int i,String fileName) throws MazeReadingException 
	{
		ArrayList<MBox> res= new ArrayList<MBox>();
		for (int j=0; j<width; j++) 
		{
			char c = line.charAt(j);
			switch(c)
			{
			case 'E': 
				res.add(new EBox(j,i, this));
				break;
			case 'W': 
				res.add(new WBox(j,i, this));
				break;
			case 'A': 
				res.add(new ABox(j,i, this));
				break;
			case 'D': 
				res.add(new DBox(j,i, this));
				break;
			default: throw new MazeReadingException(fileName,i,"your caracter "+c+" is not one of the possible boxes: E,A,D,W");
			}
			
		}
		
		return res;
	}
	
	
	
	/**
	 * Converts the maze (type Maze) into a text in the fileName document.
	 * 
	 * @param fileName
	 * 				Path of the text document in which the maze will be saved.
	 */
	public final void saveToTextFile(String fileName) 
	{
		PrintWriter pw = null;
		try 
		{
			pw  = new PrintWriter(fileName);
			for (int j=0; j<height; j++)
			{
				for (int i=0; i<width; i++) 
				{
					{
						pw.write(this.table.get(j).get(i).getType());
						System.out.print(this.table.get(j).get(i).getType());
					}
				}
				System.out.println();
				pw.write('\n');
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		pw.close();
	}
	
	
	/**
	 * @return A single list with all vertices of the maze.
	 */
	@Override
	public ArrayList<VertexInterface> vertexList() 
	{
		ArrayList<VertexInterface> res = new ArrayList<VertexInterface>();
		for (ArrayList<MBox> vertexList: table) 
		{
			for (MBox vertex: vertexList) 
			{
				res.add(vertex);
			}
		}
		return res;
	}



	

	}
	
	
	
	
	
	
	
	

	


