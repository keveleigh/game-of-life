package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

/**
 * Uses JMenuBar to provide tools and options at the top of the simulation window. 
 * 
 * @author Kurtis Eveleigh
 * @version 1.0.0
 */

@SuppressWarnings("serial")
public class SimMenu extends JMenuBar
{
	private JMenu speedMenu;
	private JButton startStop;
	private JButton step;
	private JButton reset;
	private ButtonGroup speedRadioGroup;
	private JRadioButtonMenuItem fastButton;
	private JRadioButtonMenuItem normalButton;
	private JRadioButtonMenuItem slowButton;
	private LifeBoard mainBoard;
	private JLabel genLabel;
	private int genNum = 0;
	
	public SimMenu(LifeBoard mainBoard)
	{
		this.mainBoard = mainBoard;
		SpeedListener spListen = new SpeedListener();
		
		startStop = new JButton("Start");
		startStop.addActionListener(new StartStopListener());
		
		step = new JButton("Step");
		step.addActionListener(new StepListener());
		
		reset = new JButton("Reset");
		reset.addActionListener(new ResetListener());
		
		speedMenu = new JMenu("Speed");
		
	    speedRadioGroup = new ButtonGroup();

	    fastButton = new JRadioButtonMenuItem("Fast");
	    fastButton.setAccelerator(KeyStroke.getKeyStroke('1'));
	    fastButton.setSelected(false);
	    fastButton.setMnemonic('f');
	    fastButton.addActionListener(spListen);
	    speedRadioGroup.add(fastButton);
	    speedMenu.add(fastButton);
	    
	    normalButton = new JRadioButtonMenuItem("Normal");
	    normalButton.setAccelerator(KeyStroke.getKeyStroke('2'));
	    normalButton.setSelected(true);
	    normalButton.setMnemonic('n');
	    normalButton.addActionListener(spListen);
	    speedRadioGroup.add(normalButton);
	    speedMenu.add(normalButton);
	  
	    slowButton = new JRadioButtonMenuItem("Slow");
		slowButton.setAccelerator(KeyStroke.getKeyStroke('3'));
	    slowButton.setSelected(false);
	    slowButton.setMnemonic('s');
	    slowButton.addActionListener(spListen);
	    speedRadioGroup.add(slowButton);
	    speedMenu.add(slowButton);
	    
	    genLabel = new JLabel(" Generations: " + genNum);
	    
		this.add(startStop);
		this.add(step);
		this.add(reset);
	    this.add(speedMenu);
		this.add(genLabel);
	}
	
	public void nextGen()
	{
		genNum++;
		genLabel.setText(" Generations: " + genNum);
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
			if(mainBoard.timerIsEnabled())
			{
				startStop.setText("Start");
				mainBoard.enableTimer(false);
				step.setEnabled(true);
			}
			else
			{
				startStop.setText("Stop");
				mainBoard.enableTimer(true);
				step.setEnabled(false);
			}

		}
	}
	
	private class ResetListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			genNum = 0;
			genLabel.setText(" Generations: " + genNum);
			startStop.setText("Start");
			step.setEnabled(true);
			mainBoard.reset();
		}
		
	}
	
	private class StepListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			mainBoard.step();
		}
	}
}