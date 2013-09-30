package mainGame;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * Initializes all parts of the simulation and displays them in a JFrame.
 * Also, positions the display in the center of the user's screen. 
 * 
 * @author Kurtis Eveleigh
 * @version 0.9.5
 */

public class MainPanel
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Game of Life");
		LifeBoard mainBoard = new LifeBoard();
		SimMenu topMenu = new SimMenu(mainBoard);
		frame.setJMenuBar(topMenu);
		Dimension frameSize = new Dimension(506,551);
		frame.setMinimumSize(frameSize);
		frame.setResizable(false);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
		if (frameSize.height > screenSize.height) 
		{
			frameSize.height = screenSize.height; 
		}
		if (frameSize.width > screenSize.width) 
		{
			frameSize.width = screenSize.width; 
		}
		frame.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); 

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mainBoard); //Adds the JPanel to the JFrame for display.
		frame.setVisible(true);
		frame.pack();
	}
}