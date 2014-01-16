package setgame.aview;

import javax.swing.*;

import setgame.controller.IController;
import setgame.controller.impl.SetController;

import java.awt.event.*;

public class MenuBar extends JMenuBar implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static IController controller = new SetController();
	private JMenu menu;
	private JMenuItem mHelp, mExit, mNewGame;
	
	public MenuBar(final IController controller) {
		this.controller = controller;
		
		menu = new JMenu("Game");
		mHelp = new JMenuItem("Help");
		mHelp.addActionListener(this);
		mExit = new JMenuItem("Exit");
		mExit.addActionListener(this);
		mNewGame = new JMenuItem("New Game");
		mNewGame.addActionListener(this);
		menu.add(mNewGame);
		menu.add(mHelp);
		menu.add(mExit);
		this.add(menu);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	        if(e.getSource() == mHelp){
	        	JOptionPane.showConfirmDialog(null, ""
	        			+ "The SET game is a puzzle that uses cards\n"
	        			+ "which have 4 features on them:\n"
	        			+ "COLORS, SYMBOLS, SHADINGS\n"
	        			+ "and the NUMBER of symbols.\n\n"
	        			+ "The COLOR can be\n"
	        			+ "RED, GREEN or PURPLE...\n\n"
	        			+ "... the SYMBOLS can be\n"
	        			+ "SQUIGGLES, DIAMONDS or OVALS...\n\n"
	        			+ "...the SHADING can be\n"
	        			+ "SOLID, STRIPED or QUOLINED...\n\n"
	        			+ "...and for NUMBER, each card has either\n"
	        			+ "ONE, TWO or THREE symbols on it.\n\n"
	        			+ "There is only one rule to make a SET.\n\n"
	        			+ "A SET is 3 cards in which each individual feature is\n"
	        			+ "either all the SAME on each card...\n"
	        			+ "...or all DIFFEREN on each card.\n\n"
	        			+ "Have fun!", "Close", JOptionPane.CLOSED_OPTION);
	        }else if ( e.getSource() == mExit ){
	        	if(JOptionPane.showConfirmDialog(null,"Really finish the game?",
	                        "Close",JOptionPane.YES_NO_OPTION) == 0){
	        		System.exit(0);
	        	}
	        }else{
	        	if ( JOptionPane.showConfirmDialog(null,
                        "Really start a new Game?", "Choice", JOptionPane.YES_NO_OPTION) == 0) {
	        			controller.newGame();
	        	}
	    }
		
	}

}
