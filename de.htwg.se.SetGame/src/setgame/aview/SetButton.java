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

public class SetButton extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton setbutton;
	
	private static IController controller;
	private String card1 = null;
	private String card2 = null;
	private String card3 = null;
	private boolean player1 = false;
	private boolean player2 = false;
	private final int one = 1;
	private final int two = 2;
	
	
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
			 if(player1 == true ) {
	//			 controller.isAsetForController(card1, card2, card3, one);
				 player1 = false;
			 } else if (player2 == true) {
	//			 controller.isAsetForController(card1, card2, card3, two);
				 player2 = false;
			 }
		}
		
	}
	
	public void Choice() {
		
			Object[] options = {"Player1", "Player2"};
	 
	                int selected = JOptionPane.showOptionDialog(null,
	                               "Which Player?", "Choice",JOptionPane.DEFAULT_OPTION, 
	                               JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	                if(selected == 0) {
	                	JTextField Card1 = new JTextField();
	            		JTextField Card2 = new JTextField();
	            		JTextField Card3 = new JTextField();
	                            Object[] message = {"First Card", Card1, 
	                    		"Second Card", Card2, "Third Card", Card3};
	             
	                            JOptionPane pane = new JOptionPane( message, 
	                                                            JOptionPane.PLAIN_MESSAGE);
	                            pane.createDialog(null, "SET").setVisible(true);
	                            
	                            this.card1 = Card1.getText();
	                            this.card2 = Card1.getText();
	                            this.card3 = Card1.getText();
	                            player1 = true;
	                            
	                } else if (selected == 1) {
		                	JTextField Card1 = new JTextField();
		            		JTextField Card2 = new JTextField();
		            		JTextField Card3 = new JTextField();
		                            Object[] message = {"First Card", Card1, 
		                    		"Second Card", Card2, "Third Card", Card3};
		             
		                            JOptionPane pane = new JOptionPane( message, 
		                                                            JOptionPane.PLAIN_MESSAGE);
		                            pane.createDialog(null, "SET").setVisible(true);
		                            
		                            this.card1 = Card1.getText();
		                            this.card2 = Card1.getText();
		                            this.card3 = Card1.getText();
		                            player2 = true;
	                	
	                }
	 
	 
	}
	

}
