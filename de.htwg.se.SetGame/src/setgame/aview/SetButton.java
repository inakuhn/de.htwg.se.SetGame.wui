package setgame.aview;

import java.awt.*;
import java.awt.event.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import setgame.controller.IController;
import setgame.aview.Point;

public class SetButton extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton setbutton;
	
	private static IController controller;
	private boolean player1status = false;
	private boolean player2status = false;
	private final int one = 1;
	private final int two = 2;


	private int player1point = 0;
	private int player2point = 0;
	
	
	public SetButton(final IController controller) {
		this.controller = controller;
		
		JPanel panel1 = new JPanel();
        setbutton = new JButton("SET");
        setbutton.addActionListener(this);
        panel1.add(setbutton);
        this.add(panel1);        
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == setbutton) {
			 Choice();
			 if(player1status == true ) {
				 //TODO: player 1
				 player1status = false;
			 } else if (player2status == true) {
				 //TODO: player 2
				 player2status = false;
			 }
		}
		
	}
	
	public void Choice() {
		
			Object[] options = {"Player1", "Player2"};
	 
	                int selected = JOptionPane.showOptionDialog(null,
	                               "Which Player?", "Choice",JOptionPane.DEFAULT_OPTION, 
	                               JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	                if(selected == 0) {
	                	Point play = null;
	                	play.player1add(player1point);
	                	
	                } else if (selected == 1) {
	 
	 
	                }	
	}
	

}
