package piano;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class WhitePianoKeys extends PianoKey
{
	public static final int WIDTH = 100;
	public static final int HEIGHT = 500; 
	
	public WhitePianoKeys()
	{
		setBackground(Color.white); 
		setSize(100, 500);
		addMouseListener(new WhiteKeyMouseListener());
	}
	
	
	private class WhiteKeyMouseListener extends MouseAdapter
	{
		@Override
		public void mouseExited(MouseEvent e)
		{
			setBackground(Color.white);
		}
	}
	
}
