import java.awt.Dimension;

import javax.swing.JFrame;

public class MainPanel
{
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Game of Life");
		LifeBoard mainBoard = new LifeBoard();
		frame.setMinimumSize(new Dimension(506,528));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mainBoard); //Adds the JPanel to the JFrame for display.
		frame.setVisible(true);
		frame.pack();
	}
}