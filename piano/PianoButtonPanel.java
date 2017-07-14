package piano;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLayeredPane;


public class PianoButtonPanel extends JLayeredPane
{
	private int numOfWhiteKeys = 16;
	private int numOf2SetBlackKeys = 3;
	private int numOf3SetBlackKeys = 2;
	
	private String[] whiteNotes = {"48.wav", "50.wav", "52.wav",
			"53.wav", "55.wav", "57.wav", "59.wav",
			"60.wav", "62.wav", "64.wav", "65.wav",
			"67.wav", "69.wav", "71.wav", "72.wav",
			"74.wav"};
	
	
	private String[] set2BlackNotes = {"49.wav", "51.wav", "61.wav", "63.wav",
			 "73.wav", "75.wav"};
	
	private String[] set3BlackNotes = { "54.wav","56.wav", "58.wav", "66.wav", 
			"68.wav", "70.wav"};
	
	public PianoButtonPanel()
	{
		initializeWhiteKeys();
		initializeBlackKeys();
	}
	
	
	// add white keys to the panel
	// using JLayeredPane, we set the white keys with an integer of 0, so that it will be beneath the black keys
	// each white key (JButton) can have its location set (.setLocation), and we load in a music file name to its
	// .loadAudioClip method parameter. This method gives its Clip clip field something to play.  
	private void initializeWhiteKeys()
	{
		int xCoord = 0, yCoord = 0;
		for (int i = 1; i <= numOfWhiteKeys; i++)
		{
			// make a new whiteKey (JButton)
			WhitePianoKeys whiteKey = new WhitePianoKeys();
			// set the whiteKey's location
			whiteKey.setLocation(xCoord, yCoord); 
			// give each whiteKey it's sound file
			whiteKey.loadAudioClip(whiteNotes[i-1]);
			// increase the x coordinate for the next whiteKey
			xCoord += WhitePianoKeys.WIDTH; 
	
			// add whiteKey to the JLayeredPanel, using an Integer (must be the wrapper class) to set its
			// depth.  If it's number is higher than the other components, then it will be above them,
			// if it's number is lower than the other components, than it will be beneath them.  
			add(whiteKey, new Integer(0));
		}
		
	}
	
	// fill the panel with black keys
	private void initializeBlackKeys()
	{
		// the set of 2 black keys
		int xCoord = 70, yCoord = 0;
		int index = 0;
		for (int i = 1; i <= numOf2SetBlackKeys; i++)
		{
			for (int j = 1; j <= 2; j++)
			{
					BlackPianoKeys blackKey = new BlackPianoKeys();
					blackKey.setLocation(xCoord, yCoord);
					blackKey.loadAudioClip(set2BlackNotes[index++]);					
					xCoord += (BlackPianoKeys.WIDTH + 60);
			
					// since the white keys have an Integer of 0, the black keys with its higher
					// Integer (1) will be above the white keys.
					add(blackKey, new Integer(1));
					
			}
			xCoord += 10;  // add the bit of white key so we can start our index easier
			xCoord += (4*WhitePianoKeys.WIDTH + 70);  // the white keys in between
			 // the spaces that the next black key will be at
		}
		
		// the set of 3 black keys
		xCoord = 360;
		index = 0;
		for (int i = 1; i <= numOf3SetBlackKeys; i++)
		{
			
			for (int j = 1; j <= 3; j++)
			{
				BlackPianoKeys blackKey = new BlackPianoKeys();
				blackKey.setLocation(xCoord, yCoord);
				blackKey.loadAudioClip(set3BlackNotes[index++]);
				xCoord += (BlackPianoKeys.WIDTH+65);
				//add(blackKey, 1, -1);
				//add(blackKey);
				add(blackKey, new Integer(1));
			}
			xCoord -= 5; // subtract that little bit of whiteKey away so we can increment our index easier. 
			
			xCoord += 360;  // spaces until the next set of 3 black keys
		}
	}

}
