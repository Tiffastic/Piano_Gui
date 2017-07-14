package piano;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PianoApp extends JFrame
{
	PianoButtonPanel panel = new PianoButtonPanel(); 
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				new PianoApp();
			}
		});
	}
	public PianoApp()
	{
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
		add(panel); 
	}
}
