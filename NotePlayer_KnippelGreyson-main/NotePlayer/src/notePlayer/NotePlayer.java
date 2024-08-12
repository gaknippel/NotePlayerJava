package notePlayer;

import java.util.Scanner;

import core.MidiWrapper;

public class NotePlayer
{
    public static void main(String[] args)
    {
    	Scanner con = new Scanner(System.in); 
    	
    	System.out.println("Put in your notes: ");
    	
    	String text = con.nextLine();
    	
    	int trans = 0;
		
		double tempo = 1.0;	
    	
    	while (!text.equals("quit"))
    	{
    		if(text.contains("list"))
    		{
    			String insts = "0: Piano 1        1: Piano 2        2: Piano 3        3: Honky-tonk     4: E.Piano 1"
    					+ "\n5: E.Piano 2      6: Harpsichord    7: Clav.          8: Celesta        9: Glockenspiel"
    					+ "\n10: Music Box     11: Vibraphone    12: Marimba       13: Xylophone     14: Tubular-bell"
    					+ "\n15: Santur        16: Organ 1       17: Organ 2       18: Organ 3       19: Church Org.1"
    					+ "\n20: Reed Organ    21: Accordion Fr  22: Harmonica     23: Bandoneon     24: Nylon-str.Gt"
    					+ "\n25: Steel-str.Gt  26: Jazz Gt.      27: Clean Gt.     28: Muted Gt.     29: Overdrive Gt"
    					+ "\n30: DistortionGt  31: Gt.Harmonics  32: Acoustic Bs.  33: Fingered Bs.  34: Picked Bs."
    					+ "\n35: Fretless Bs.  36: Slap Bass 1   37: Slap Bass 2   38: Synth Bass 1  39: Synth Bass 2"
    					+ "\n40: Violin        41: Viola         42: Cello         43: Contrabass    44: Tremolo Str"
    					+ "\n45: PizzicatoStr  46: Harp          47: Timpani       48: Strings       49: Slow Strings"
    					+ "\n50: Syn.Strings1  51: Syn.Strings2  52: Choir Aahs    53: Voice Oohs    54: SynVox"
    					+ "\n55: OrchestraHit  56: Trumpet       57: Trombone      58: Tuba          59: MutedTrumpet"
    					+ "\n60: French Horns  61: Brass 1       62: Synth Brass1  63: Synth Brass2  64: Soprano Sax"
    					+ "\n65: Alto Sax      66: Tenor Sax     67: Baritone Sax  68: Oboe          69: English Horn"
    					+ "\n70: Bassoon       71: Clarinet      72: Piccolo       73: Flute         74: Recorder"
    					+ "\n75: Pan Flute     76: Bottle Blow   77: Shakuhachi    78: Whistle       79: Ocarina"
    					+ "\n80: Square Wave   81: Saw Wave      82: Syn.Calliope  83: Chiffer Lead  84: Charang"
    					+ "\n85: Solo Vox      86: 5th Saw Wave  87: Bass & Lead   88: Fantasia      89: Warm Pad"
    					+ "\n90: Polysynth     91: Space Voice   92: Bowed Glass   93: Metal Pad     94: Halo Pad"
    					+ "\n95: Sweep Pad     96: Ice Rain      97: Soundtrack    98: Crystal       99: Atmosphere"
    					+ "\n100: Brightness   101: Goblin       102: Echo Drops   103: Star Theme   104: Sitar"
    					+ "\n105: Banjo        106: Shamisen     107: Koto         108: Kalimba      109: Bagpipe"
    					+ "\n110: Fiddle       111: Shanai       112: Tinkle Bell  113: Agogo        114: Steel Drums"
    					+ "\n115: Woodblock    116: Taiko        117: Melo. Tom 1  118: Synth Drum   119: Reverse Cym."
    					+ "\n120: Gt.FretNoise 121: Breath Noise 122: Seashore     123: Bird         124: Telephone 1"
    					+ "\n125: Helicopter   126: Applause     127: Gun Shot";
    			System.out.println(insts);	
    			text = con.nextLine();
    		}
    		if(text.contains("set"))
    		{
    		
    			String delimiter = "instrument";
    			String instrument = text.substring(text.indexOf(delimiter) + delimiter.length() + 1);
    					
    			int setInst = Integer.parseInt(instrument);
    			
    			setInstrument(setInst);
    			text = con.nextLine();
    		}
    		
    	
    		
  if(text.contains("_"))
  {	
	  tempo = 1.0;
	  trans = 0;
	  text = text + " ";
    	while (!text.equals(""))
    	{
    		
    		
    		if(text.contains(","))
    		{
    			String adj = text.substring(0,text.indexOf(","));
    			text = text.substring(text.indexOf(",") + 1);
    			String transString = adj.substring(0,adj.indexOf("_"));
    			String tempoString = adj.substring(adj.indexOf("_")+ 1);
    			trans = Integer.parseInt(transString);
    			tempo = Double.parseDouble(tempoString);
    		}
    		
	    	String Note = text.substring(0, text.indexOf(" "));
	    	
	    	String NoteLetter = Note.substring(0, Note.indexOf("_"));
	    	
	    	String Letter = NoteLetter.substring(0, 1);
	    	
	    	NoteLetter = NoteLetter.substring(1);
	    	
	    	
	    	
	    	String FirstDuration = Note.substring(Note.indexOf("_") + 1);
	    	
	    	double durationDouble = Integer.parseInt(FirstDuration);
	    	
	    	durationDouble = durationDouble * tempo;
	    	
	    	int durationMs = (int) durationDouble;
	    	
	    	
	    	
	    	
	    	int noteNumber = 0;
	    	
	    	if (Letter.equals("C"))
	    	{
	    		noteNumber = 60;
	    	}
	    	else if (Letter.equals("D"))
	    	{
	    		
	    		noteNumber = 62;
	    	}
	    	else if (Letter.equals("E"))
	    	{
	    	
	    		noteNumber = 64;
	    	}
	    	else if (Letter.equals("F"))
	    	{
	    		
	    		noteNumber = 65;
	    	}
	    	else if (Letter.equals("G"))
	    	{
	    		noteNumber = 67;
	    	}
	    	else if (Letter.equals("A"))
	    	{
	    		noteNumber = 69;
	    	}
	    	else
	    	{
	    		noteNumber = 71;
	    	}
	    	
	    	
	    	if (!NoteLetter.equals(""))
	    	{
	    		if (NoteLetter.substring(0,1).equals("#") || NoteLetter.substring(0,1).equals("b"))
	    		{
	    			String accidental = NoteLetter.substring(0,1);
	    			if(accidental.equals("b"))
	    			{
	    				noteNumber = noteNumber - 1;
	    				NoteLetter = NoteLetter.substring(1);  
	    			}
	    			if (accidental.equals("#"))
	    			{
	    				noteNumber = noteNumber + 1;
	    				NoteLetter = NoteLetter.substring(1);  
	    			}
	    		}
	    
	    	}
	    	
	    	
	    	
	    	if(!NoteLetter.equals(""))
	    	{
	    		String octave = NoteLetter;
	    		int octaveNum = Integer.parseInt(octave);
	    		noteNumber = noteNumber + 12 * octaveNum;
	    		
	    	}
	    
	    	
	    	playNote(noteNumber + trans, durationMs);
	    	
	    	text = text.substring(text.indexOf(" ") + 1);
	    	
    	}
    	text = con.nextLine();
    }
 }   	
    	
    	
    	
    	// This is where you will begin writing your code, and this is where the program will start.
    	// Although you can place all of your code here in main, we strongly suggest that you
    	// separate your code into multiple helper methods.  Your main method should then call those
    	// helper methods at the right places.  Organizing your code like this makes your code easier
    	// to read and debug, and helps avoid duplicating code.  
    }
    
    
    // You may choose to add extra helper methods here to break up your code into
    // smaller, reusable chunks
    
    
    
    
    
    
    
    
    
    
    
	//                      .d"""" """$$$$be.
	//                    -"           ^""**$$$e.
	//                  ."                   '$$$c
	//                 /                      "4$$b
	//                d  3                      $$$$
	//                $  *                   .$$$$$$
	//               .$  ^c           $$$$$e$$$$$$$$.
	//               d$L  4.         4$$$$$$$$$$$$$$b
	//               $$$$b ^ceeeee.  4$$ECL.F*$$$$$$$
	//   e$""=.      $$$$P d$$$$F $ $$$$$$$$$- $$$$$$
	//  z$$b. ^c     3$$$F "$$$$b   $"$$$$$$$  $$$$*"      .=""$c
	// 4$$$$L        $$P"  "$$b   .$ $$$$$...e$$        .=  e$$$.
	// ^*$$$$$c  %..   *c    ..    $$ 3$$$$$$$$$$eF     zP  d$$$$$
	//   "**$$$ec   "   %ce""    $$$  $$$$$$$$$$*    .r" =$$$$P""
	//         "*$b.  "c  *$e.    *** d$$$$$"L$$    .d"  e$$***"
	//           ^*$$c ^$c $$$      4J$$$$$% $$$ .e*".eeP"
	//              "$$$$$$"'$=e....$*$$**$cz$$" "..d$*"
	//                "*$$$  *=%4.$ L L$ P3$$$F $$$P"
	//                   "$   "%*ebJLzb$e$$$$$b $P"
	//                     %..      4$$$$$$$$$$ "
	//                      $$$e   z$$$$$$$$$$%
	//                       "*$c  "$$$$$$$P"
	//                        ."""*$$$$$$$$bc
	//                     .-"    .$***$$$"""*e.
	//                  .-"    .e$"     "*$c  ^*b.
	//           .=*""""    .e$*"          "*bc  "*$e..
	//         .$"        .z*"               ^*$e.   "*****e.
	//         $$ee$c   .d"                     "*$.        3.
	//         ^*$E")$..$"                         *   .ee==d%
	//            $.d$$$*                           *  J$$$e*
	//             """""                              "$$$"
	
	// WWWWWWWW                           WWWWWWWW                                                      iiii                                        !!!  !!!  !!! 
	// W::::::W                           W::::::W                                                     i::::i                                      !!:!!!!:!!!!:!!
	// W::::::W                           W::::::W                                                      iiii                                       !:::!!:::!!:::!
	// W::::::W                           W::::::W                                                                                                 !:::!!:::!!:::!
	//  W:::::W           WWWWW           W:::::Waaaaaaaaaaaaa  rrrrr   rrrrrrrrr   nnnn  nnnnnnnn    iiiiiiinnnn  nnnnnnnn       ggggggggg   ggggg!:::!!:::!!:::!
	//   W:::::W         W:::::W         W:::::W a::::::::::::a r::::rrr:::::::::r  n:::nn::::::::nn  i:::::in:::nn::::::::nn    g:::::::::ggg::::g!:::!!:::!!:::!
	//    W:::::W       W:::::::W       W:::::W  aaaaaaaaa:::::ar:::::::::::::::::r n::::::::::::::nn  i::::in::::::::::::::nn  g:::::::::::::::::g!:::!!:::!!:::!
	//     W:::::W     W:::::::::W     W:::::W            a::::arr::::::rrrrr::::::rnn:::::::::::::::n i::::inn:::::::::::::::ng::::::ggggg::::::gg!:::!!:::!!:::!
	//      W:::::W   W:::::W:::::W   W:::::W      aaaaaaa:::::a r:::::r     r:::::r  n:::::nnnn:::::n i::::i  n:::::nnnn:::::ng:::::g     g:::::g !:::!!:::!!:::!
	//       W:::::W W:::::W W:::::W W:::::W     aa::::::::::::a r:::::r     rrrrrrr  n::::n    n::::n i::::i  n::::n    n::::ng:::::g     g:::::g !:::!!:::!!:::!
	//        W:::::W:::::W   W:::::W:::::W     a::::aaaa::::::a r:::::r              n::::n    n::::n i::::i  n::::n    n::::ng:::::g     g:::::g !!:!!!!:!!!!:!!
	//         W:::::::::W     W:::::::::W     a::::a    a:::::a r:::::r              n::::n    n::::n i::::i  n::::n    n::::ng::::::g    g:::::g  !!!  !!!  !!! 
	//          W:::::::W       W:::::::W      a::::a    a:::::a r:::::r              n::::n    n::::ni::::::i n::::n    n::::ng:::::::ggggg:::::g                
	//           W:::::W         W:::::W       a:::::aaaa::::::a r:::::r              n::::n    n::::ni::::::i n::::n    n::::n g::::::::::::::::g  !!!  !!!  !!! 
	//            W:::W           W:::W         a::::::::::aa:::ar:::::r              n::::n    n::::ni::::::i n::::n    n::::n  gg::::::::::::::g !!:!!!!:!!!!:!!
	//             WWW             WWW           aaaaaaaaaa  aaaarrrrrrr              nnnnnn    nnnnnniiiiiiii nnnnnn    nnnnnn    gggggggg::::::g  !!!  !!!  !!! 
	//                                                                                                                                     g:::::g                
	//                                                                                                                         gggggg      g:::::g                
	//                                                                                                                         g:::::gg   gg:::::g                
	//                                                                                                                          g::::::ggg:::::::g                
	//                                                                                                                           gg:::::::::::::g                 
	//                                                                                                                             ggg::::::ggg                   
	//                                                                                                                                gggggg                         
    
    // WARNING!!!!  You will CALL these methods, but you MUST NOT MODIFY any
    // of the code below
    

    /**
     * WARNING!!!  DO NOT MODIFY THIS METHOD.
     * 
     * Once you have calculated the MIDI note number and its duration, call this
     * method to play that note.
     * 
     * @param noteNumber The MIDI note number, as described in the spec.
     * @param durationMs The number of milliseconds to play the note.  A larger number will play the note for a longer time.
     */
    public static void playNote(int noteNumber, int durationMs)
    {
    	// WARNING!!!  DO NOT MODIFY THIS METHOD.
        MidiWrapper.playNote(noteNumber, durationMs);
    }
    
    
    
    
	/**
	 * WARNING!!!  DO NOT MODIFY THIS METHOD.
	 * 
	 * Call this method to change the instrument used to play notes.
	 * 
	 * @param instrumentNumber The MIDI instrument number to begin using.  Must
	 * be in the range between 0 and 127 inclusive.
	 */
	public static void setInstrument(int instrumentNumber)
	{
		// WARNING!!!  DO NOT MODIFY THIS METHOD.
		MidiWrapper.setInstrument(instrumentNumber);
	}
    
}
