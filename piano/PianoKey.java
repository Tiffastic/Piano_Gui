package piano;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;

public class PianoKey extends JButton
{
	private Clip clip;
	
	public PianoKey()
	{
		addMouseListener(new PianoMouseListener());
		
		// these two statements are needed if upon mousePressed the button is to change color (blue).
		// or else the button only changes color after the mouse is released.  
		setContentAreaFilled(false);
		setOpaque(true);
	}

	
	public void loadAudioClip(String fileNote)
	{
		try {
			//http://stackoverflow.com/questions/11919009/using-javax-sound-sampled-clip-to-play-loop-and-stop-mutiple-sounds-in-a-game

                AudioInputStream sound = AudioSystem.getAudioInputStream(getClass().getResource(fileNote));
             // load the sound into memory (a Clip)
                clip = AudioSystem.getClip();
                clip.open(sound);
        }
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Unsupported Audio File: " + e);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Input/Output Error: " + e);
        }
        catch (LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
        }
		
	}
	
	private class PianoMouseListener extends MouseAdapter
	{
		@Override
		public void mousePressed(MouseEvent e)
		{
			  clip.setFramePosition(0);
			  clip.start(); 
			  setBackground(Color.blue);
		}	
		
	
		
	}
	

	
	
}
