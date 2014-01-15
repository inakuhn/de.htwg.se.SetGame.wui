package setgame.aview;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import setgame.controller.IController;

public class Point extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField player1;
	private JTextField player2;
	

	
	private static IController controller;
	
	public Point(final IController controller) {
		this.controller = controller;
		
		JPanel panel1 = new JPanel();
		
		JLabel p1 = new JLabel("  Player 1  ");
		JLabel p2 = new JLabel("  Player 2  ");
		player1 = new JTextField("0", 5 );
		player2 = new JTextField("0", 5 );
		player1.setEditable(false);
		player2.setEditable(false);
		
		panel1.setLayout(new GridLayout(1,4));
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.LINE_AXIS));
		panel1.add(p1);
		panel1.add(player1);
		panel1.add(p2);
		panel1.add(player2);
		panel1.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.add(panel1);
	}
	
	public void player1add(int point) {
		Integer p1 = new Integer(point);
		String point_s = p1.toString();
		player1.setText(point_s);;
	}
	
}
