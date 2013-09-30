package mainGame;

/**
 * Initializes all parts of the simulation and displays them in a JFrame.
 * Also, positions the display in the center of the user's screen. 
 * 
 * @author Kurtis Eveleigh
 * @version 0.9.5
 */

public class LifeGame
{
	private Cell[][] cells;
	
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
		int[][] neighbors = new int[300][300];
		for(int i=0; i<cells.length; i++)
		{
			for(int j=0; j<cells[0].length; j++)
			{
				try
				{
					neighbors[i][j] += cells[i+1][j+1].getState();
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
				}
				try
				{
					neighbors[i][j] += cells[i+1][j].getState();
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
				}
				try
				{
					neighbors[i][j] += cells[i+1][j-1].getState();
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
				}
				try
				{
					neighbors[i][j] += cells[i][j+1].getState();
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
				}
				try
				{
					neighbors[i][j] += cells[i][j-1].getState();
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
				}
				try
				{
					neighbors[i][j] += cells[i-1][j+1].getState();
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
				}
				try
				{
					neighbors[i][j] += cells[i-1][j].getState();
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
				}
				try
				{
					neighbors[i][j] += cells[i-1][j-1].getState();
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
				}
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
	
	public Cell[][] getCells()
	{
		return cells;
	}
}