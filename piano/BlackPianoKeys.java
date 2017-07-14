package piano;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class BlackPianoKeys extends PianoKey
{
	public static final int WIDTH = 50;
	public static final int HEIGHT = 280; 
	
	public BlackPianoKeys()
	{
		setBackground(Color.black);
		setSize(50, 280);
		addMouseListener(new BlackKeyMouseListener());

	}
	
	private class BlackKeyMouseListener extends MouseAdapter
	{
		@Override
		public void mouseExited(MouseEvent e)
		{
			setBackground(Color.black);
		}
	}
	

}
