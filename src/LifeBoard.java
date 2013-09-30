package mainGame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Initializes all parts of the simulation and displays them in a JFrame.
 * Also, positions the display in the center of the user's screen. 
 * 
 * @author Kurtis Eveleigh
 * @version 0.9.5
 */

@SuppressWarnings("serial")
public class LifeBoard extends JPanel
{
	private Timer timer;
	private LifeGame game;
	private Point lastMouseLoc;
	
	public LifeBoard()
	{
		timer = new Timer(150, new TimerListener());
		timer.setRepeats(true);
		game = new LifeGame();
		addMouseListener(new ClickListener());
		addMouseMotionListener(new ClickListener());
	}
	
	public void enableTimer(boolean enable)
	{
		if(enable)
		{
			timer.start();
		}
		else
		{
			timer.stop();
		}
	}
	
	public void changeTimerSpeed(int newSpeed)
	{
		timer.setDelay(newSpeed);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Cell[][] cells = game.getCells();
		for(int i=100; i<200; i++)
		{
			for(int j=100; j<200; j++)
			{
				if(cells[i][j].getState() == 1)
				{
					g.fillRect((i-100)*5, (j-100)*5, 5, 5);
				}
			}
		}
	}
	
	private class TimerListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			game.updateAll();
			repaint();
		}
	}
		
	private class ClickListener implements MouseListener, MouseMotionListener
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
			lastMouseLoc = e.getPoint();
			game.getCells()[lastMouseLoc.x/5+100][lastMouseLoc.y/5+100].changeState();
			repaint();
		}
		
		@Override
		public void mouseDragged(MouseEvent e)
		{
			Point newLoc= e.getPoint();
			if(newLoc.x/5 != lastMouseLoc.x/5 && newLoc.y/5 != lastMouseLoc.y/5)
			{
				lastMouseLoc = newLoc;
				game.getCells()[newLoc.x/5+100][newLoc.y/5+100].changeState();
			}
			if(newLoc.x/5 != lastMouseLoc.x/5)
			{
				lastMouseLoc.x = newLoc.x;
				game.getCells()[newLoc.x/5+100][newLoc.y/5+100].changeState();
			}
			if(newLoc.y/5 != lastMouseLoc.y/5)
			{
				lastMouseLoc.y = newLoc.y;
				game.getCells()[newLoc.x/5+100][newLoc.y/5+100].changeState();
			}
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e)
		{	
		}

		@Override
		public void mouseExited(MouseEvent e)
		{	
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{		
		}
		
		@Override
		public void mouseClicked(MouseEvent e)
		{
		}

		@Override
		public void mouseMoved(MouseEvent arg0)
		{
		}
	}

	public void reset()
	{
		timer.stop();
		game = new LifeGame();	
		repaint();
	}
}