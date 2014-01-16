package setgame.aview;

import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import setgame.controller.IController;
import setgame.controller.impl.SetController;

public class SetButton extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton setbutton;
	private JButton mix;
	
	private static IController controller = new SetController();
	private boolean player1status = false;
	private boolean player2status = false;
	private final int one = 1;
	private final int two = 2;
	
    private JTextField player1;
    private JTextField player2;

	private int player1point = 0;
	private int player2point = 0;
	
	
	public SetButton(final IController controller) {
		this.controller = controller;
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2,1));
		panel1.setLayout(new GridLayout(1,2));
         
        JLabel p1 = new JLabel(" Player 1 ");
        JLabel p2 = new JLabel(" Player 2 ");
        player1 = new JTextField("0", 5 );
        player2 = new JTextField("0", 5 );
        player1.setEditable(false);
        player2.setEditable(false);
		
		
        setbutton = new JButton("SET");
        setbutton.addActionListener(this);
        mix = new JButton("MIX");
        mix.addActionListener(this);
        panel1.add(setbutton);
        panel1.add(mix);
    
        
        panel2.setLayout(new GridLayout(1,4));
        panel2.add(p1);
        panel2.add(player1);
        panel2.add(p2);
        panel2.add(player2);

        mainPanel.add(panel1);
        mainPanel.add(panel2);
        this.add(mainPanel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == setbutton) {
			//TODO: SET Controller
		} else if (source == mix) {
			//TODO: Mix Controller
		}
		
		Integer play1 = new Integer(controller.geTplayerOnePoints());
		player1.setText(play1.toString());
		Integer play2 = new Integer(controller.geTplayerTwoPoints());
		player2.setText(play2.toString());
		
	}
	
	public void Choice() {
		
			Object[] options = {"Player1", "Player2"};
	 
	                int selected = JOptionPane.showOptionDialog(null,
	                               "Which Player?", "Choice",JOptionPane.DEFAULT_OPTION, 
	                               JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	                if(selected == 0) {

	                	
	                } else if (selected == 1) {
	 
	 
	                }	
	}
	

}
