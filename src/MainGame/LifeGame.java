package MainGame;

/**
 * Provides the logic for the simulation.
 * 
 * @author Kurtis Eveleigh
 * @version 1.0.0
 */

public class LifeGame
{
	private Cell[][] cells;
	private int[][] neighbors;
	
	public LifeGame()
	{
		cells = new Cell[300][300];
		for(int i=0; i<cells.length; i++)
		{
			for(int j=0; j<cells[0].length; j++)
			{
				cells[i][j] = new Cell();
			}
		}
	}
	
	public void updateAll()
	{
		neighbors = new int[300][300];
		for(int i=0; i<cells.length; i++)
		{
			for(int j=0; j<cells[0].length; j++)
			{
				neighbors[i][j] = getNumNeighbors(i,j);
			}
		}
		
		for(int i=0; i<cells.length; i++)
		{
			for(int j=0; j<cells[0].length; j++)
			{
				if(neighbors[i][j] < 2 || neighbors[i][j] > 3)
				{
					cells[i][j].die();
				}
				else if((neighbors[i][j] == 2 && cells[i][j].getState() == 1) || (neighbors[i][j] == 3))
				{
					cells[i][j].live();
				}
			}
		}
	}
	
	public void updateNeighborsOf(int i, int j)
	{
		neighbors[i+1][j+1] = getNumNeighbors(i+1,j+1);
		neighbors[i+1][j] = getNumNeighbors(i+1,j);
		neighbors[i+1][j-1] = getNumNeighbors(i+1,j-1);
		neighbors[i][j+1] = getNumNeighbors(i,j+1);
		neighbors[i][j-1] = getNumNeighbors(i,j-1);
		neighbors[i-1][j+1] = getNumNeighbors(i-1,j+1);
		neighbors[i-1][j] = getNumNeighbors(i-1,j);
		neighbors[i-1][j-1] = getNumNeighbors(i-1,j-1);
	}
	
	public int getNumNeighbors(int i, int j)
	{
		int neighbors = 0;
		try
		{
			neighbors += cells[i+1][j+1].getState();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
		}
		try
		{
			neighbors += cells[i+1][j].getState();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
		}
		try
		{
			neighbors += cells[i+1][j-1].getState();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
		}
		try
		{
			neighbors += cells[i][j+1].getState();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
		}
		try
		{
			neighbors += cells[i][j-1].getState();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
		}
		try
		{
			neighbors += cells[i-1][j+1].getState();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
		}
		try
		{
			neighbors += cells[i-1][j].getState();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
		}
		try
		{
			neighbors += cells[i-1][j-1].getState();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
		}
		return neighbors;
	}
	
	public Cell[][] getCells()
	{
		return cells;
	}
}