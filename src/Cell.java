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