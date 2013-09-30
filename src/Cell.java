package mainGame;

/**
 * Initializes all parts of the simulation and displays them in a JFrame.
 * Also, positions the display in the center of the user's screen. 
 * 
 * @author Kurtis Eveleigh
 * @version 0.9.5
 */

public class Cell
{
	private int state;
	
	public Cell()
	{
		state = 0;
	}
	
	public void changeState()
	{
		if(state == 0)
		{
			state = 1;
		}
		else
		{
			state = 0;
		}
	}
	
	public void die()
	{
		state = 0;
	}
	
	public void live()
	{
		state = 1;
	}
	
	public int getState()
	{
		return state;
	}
}