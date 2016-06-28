import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import javax.swing.*;
import java.util.*;

/**
 * AllPanel class
 * 
 * Takes in all panels and listens for actions.
 *  
 * @author Johnson
 *
 */
public class AllPanel extends JPanel
{
	private JButton newFrame, next, run, stop;
	private JLabel current;
	private ArrayList<PaintPanel> panelList = new ArrayList<PaintPanel>();
	private PaintPanel pp;
	private inputPanel ip;
	private int count = 0, totalCount = 1, countNum = 1, DELAY, timeCount = 0;
	private Timer timer;
	private boolean checkNew = false;
	
	/**
	 * Constructor for all panels.
	 */
	public AllPanel()
	{
		current = new JLabel("Current Frame: " + countNum + "/" + totalCount);
		add(current);
		newFrame = new JButton("New Frame");
		next = new JButton("Next Frame");
		run = new JButton("Run");
		stop = new JButton("Stop");
		timer = new Timer(DELAY, new run2Listener());
		add(newFrame);
		add(next);
		add(run);
		add(stop);
		ip=new inputPanel();
		pp=new PaintPanel(ip);
		DELAY = Integer.parseInt(JOptionPane.showInputDialog("Delay time for animation: "));
		
		add(ip,BorderLayout.WEST);
		add(pp);
		newFrame.addActionListener(new newListener());
		next.addActionListener(new nextListener());
		run.addActionListener(new runListener());
		stop.addActionListener(new stopListener());
		panelList.add(pp);
	}
	
	/**
	 * Listener for new button
	 * 
	 * @author Johnson
	 *
	 */
	private class newListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (checkNew)
			{
				countNum = totalCount;
				checkNew = false;
			}
			remove(ip);
			remove(pp);
			
			ip.removeAll();
			pp.removeAll();
			updateUI();
			ip = new inputPanel();
			pp = new PaintPanel(ip);
			add(ip, BorderLayout.WEST);
			add(pp);
			totalCount++;
			countNum++;
			count++;
			current.setText("Current Frame: " + countNum + "/" + totalCount);
			panelList.add(pp);
		}
	}
	
	/**
	 * Listener for next button
	 * 
	 * @author Johnson
	 *
	 */
	private class nextListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			checkNew = false;
			if (count != (totalCount-1))
			{
				count++;
			}
			else
			{
				count = 0;
				countNum = 0;
			}
			remove(ip);
			remove(pp);
			ip.removeAll();
			pp.removeAll();
			updateUI();
			ip = new inputPanel();
			pp = panelList.get(count);
			add(ip, BorderLayout.WEST);
			add(pp);
			countNum++;
			current.setText("Current Frame: " + countNum + "/" + totalCount);
			
		}
	}
	
	/**
	 * Listener for run listener
	 * 
	 * @author Johnson
	 *
	 */
	private class runListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			timer.start();
		}
	}
	
	/**
	 * Every DELAY seconds click nextFrame
	 * 
	 * @author Johnson
	 *
	 */
	private class run2Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			next.doClick();
		}
	}
	
	/**
	 * Stop the timer
	 * 
	 * @author Johnson
	 *
	 */
	private class stopListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			timer.stop();
			checkNew = true;
		}
	}
}