import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class LifeBoard extends JPanel
{
	private Timer timer;
//	private JButton startButton;
	private LifeGame game;
	
	public LifeBoard()
	{
		timer = new Timer(50, new TimerListener());
		timer.setRepeats(true);
//		startButton = new JButton("Start");
//		startButton.addActionListener(new StartListener());
		game = new LifeGame();
		addMouseListener(new ClickListener());
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
	
//	private class StartListener implements ActionListener
//	{
//		@Override
//		public void actionPerformed(ActionEvent e)
//		{
//			timer.start();
//		}
//	}
	
	private class ClickListener implements MouseListener
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
			Point loc = e.getPoint();
			game.getCells()[loc.x/5+100][loc.y/5+100].changeState();
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent e)
		{	
			timer.stop();
		}

		@Override
		public void mouseExited(MouseEvent e)
		{	
			timer.start();
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{		
		}
		
		@Override
		public void mouseClicked(MouseEvent e)
		{
		}
	}
}