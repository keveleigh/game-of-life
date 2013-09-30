package mainGame;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

/**
 * Initializes all parts of the simulation and displays them in a JFrame.
 * Also, positions the display in the center of the user's screen. 
 * 
 * @author Kurtis Eveleigh
 * @version 0.9.5
 */

@SuppressWarnings("serial")
public class SimMenu extends JMenuBar
{
	private JMenu options;
	private JMenu speedSubMenu;
	private JMenuItem start;
	private JMenuItem stop;
	private JMenuItem reset;
	private ButtonGroup speedRadioGroup;
	private JRadioButtonMenuItem fastButton;
	private JRadioButtonMenuItem normalButton;
	private JRadioButtonMenuItem slowButton;
	private LifeBoard mainBoard;
	
	public SimMenu(LifeBoard mainBoard)
	{
		this.mainBoard = mainBoard;
		SpeedListener spListen = new SpeedListener();
		StartStopListener ssListen = new StartStopListener();
		
		options = new JMenu("Options");
		start = new JMenuItem("Start");
		start.addActionListener(ssListen);
		start.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
		start.setMnemonic("Start".charAt(0));
		
		stop = new JMenuItem("Stop");
		stop.addActionListener(ssListen);
		stop.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, Event.CTRL_MASK));
		stop.setMnemonic("Stop".charAt(1));
		
		reset = new JMenuItem("Reset");
		reset.addActionListener(ssListen);
		reset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.CTRL_MASK));
		reset.setMnemonic("Reset".charAt(0));
		
		options.add(start);
		options.add(stop);
		options.addSeparator();
		options.add(reset);
		options.addSeparator();
		
		speedSubMenu = new JMenu();
	    speedSubMenu.setText("Speed");
	    speedSubMenu.setMnemonic("Speed".charAt(1));

	    speedRadioGroup = new ButtonGroup();

	    fastButton = new JRadioButtonMenuItem("Fast");
	    fastButton.setAccelerator(KeyStroke.getKeyStroke('1'));
	    fastButton.setSelected(false);
	    fastButton.setMnemonic("Fast".charAt(0));
	    fastButton.addActionListener(spListen);
	    speedRadioGroup.add(fastButton);
	    speedSubMenu.add(fastButton);
	    
	    normalButton = new JRadioButtonMenuItem("Normal");
	    normalButton.setAccelerator(KeyStroke.getKeyStroke('2'));
	    normalButton.setSelected(true);
	    normalButton.setMnemonic("Normal".charAt(0));
	    normalButton.addActionListener(spListen);
	    speedRadioGroup.add(normalButton);
	    speedSubMenu.add(normalButton);
	  
	    slowButton = new JRadioButtonMenuItem("Slow");
		slowButton.setAccelerator(KeyStroke.getKeyStroke('3'));
	    slowButton.setSelected(false);
	    slowButton.setMnemonic("Slow".charAt(0));
	    slowButton.addActionListener(spListen);
	    speedRadioGroup.add(slowButton);
	    speedSubMenu.add(slowButton);

	    options.add(speedSubMenu);

		this.add(options);
	}
	
	private class SpeedListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource().equals(fastButton))
			{
				mainBoard.changeTimerSpeed(50);
			}
			else if(e.getSource().equals(normalButton))
			{
				mainBoard.changeTimerSpeed(150);
			}
			else
			{
				mainBoard.changeTimerSpeed(250);
			}
		}
	}
	
	private class StartStopListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource().equals(start))
			{
				mainBoard.enableTimer(true);
			}
			else if(e.getSource().equals(stop))
			{
				mainBoard.enableTimer(false);
			}
			else
			{
				mainBoard.reset();
			}
		}
	}
}
