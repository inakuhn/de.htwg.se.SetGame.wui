package setgame.aview;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import setgame.controller.IController;

public class GameField extends JPanel implements ActionListener{
	
	private static IController controller;
	private int index = 1;
	private int zero = 0;
	private final int one = 1;
	private final int two = 2;
	private final int three = 3;
	private final int four = 4;
	private final int ten = 10;
	private final int twenty = 20;
	
	
	public GameField(final IController controller) {
		this.controller = controller;
		
		URL resource1 = ImageIcon.class.getResource( "/card/0.gif" );
		URL resource2 = ImageIcon.class.getResource( "/card/1.gif" );
		URL resource3 = ImageIcon.class.getResource( "/card/2.gif" );
		URL resource4 = ImageIcon.class.getResource( "/card/3.gif" );
		URL resource5 = ImageIcon.class.getResource( "/card/4.gif" );
		URL resource6 = ImageIcon.class.getResource( "/card/5.gif" );
		URL resource7 = ImageIcon.class.getResource( "/card/6.gif" );
		URL resource8 = ImageIcon.class.getResource( "/card/7.gif" );
		URL resource9 = ImageIcon.class.getResource( "/card/8.gif" );
		URL resource10 = ImageIcon.class.getResource( "/card/9.gif" );
		URL resource11 = ImageIcon.class.getResource( "/card/10.gif" );
		URL resource12 = ImageIcon.class.getResource( "/card/11.gif" );
		
		
		Icon icon1 = new ImageIcon( resource1 );
		Icon icon2 = new ImageIcon( resource2 );
		Icon icon3 = new ImageIcon( resource3 );
		Icon icon4 = new ImageIcon( resource4 );
		Icon icon5 = new ImageIcon( resource5 );
		Icon icon6 = new ImageIcon( resource6 );
		Icon icon7 = new ImageIcon( resource7 );
		Icon icon8 = new ImageIcon( resource8 );
		Icon icon9 = new ImageIcon( resource9 );
		Icon icon10 = new ImageIcon( resource10 );
		Icon icon11 = new ImageIcon( resource11 );
		Icon icon12 = new ImageIcon( resource12 );
		

		JButton b1 = new JButton();
		JButton b2 = new JButton();
		JButton b3 = new JButton();
		JButton b4 = new JButton();
		JButton b5 = new JButton();
		JButton b6 = new JButton();
		JButton b7 = new JButton();
		JButton b8 = new JButton();
		JButton b9 = new JButton();
		JButton b10 = new JButton();
		JButton b11 = new JButton();
		JButton b12 = new JButton();
		
		b1.setIcon( icon1 );
		b2.setIcon( icon2 );
		b3.setIcon( icon3 );
		b4.setIcon( icon4 );
		b5.setIcon( icon5 );
		b6.setIcon( icon6 );
		b7.setIcon( icon7 );
		b8.setIcon( icon8 );
		b9.setIcon( icon9 );
		b10.setIcon( icon10 );
		b11.setIcon( icon11 );
		b12.setIcon( icon12 );
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);


		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(three, four, ten, ten));
		
		
		panel1.add(b1);
		panel1.add(b2);
		panel1.add(b3);
		panel1.add(b4);
		panel1.add(b5);
		panel1.add(b6);
		panel1.add(b7);
		panel1.add(b8);
		panel1.add(b9);
		panel1.add(b10);
		panel1.add(b11);
		panel1.add(b12);
		
		panel1.setBorder(BorderFactory.createEmptyBorder(twenty,twenty,twenty,twenty));
		this.add(panel1);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (index == one) {
			//TODO: Step 1
			index++;
		} else if (index == two) {
			//TODO: Step 2
			index++;
		} else if (index == three) {
			//TODO: Step 3
			index++;
		} else {
        	JOptionPane.showMessageDialog(null, "Only three cards "
        			+ "addicted to a SET :)" , "Warning", JOptionPane.OK_OPTION);
        	index = zero;
		}
		
	}

}
