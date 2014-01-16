package setgame.aview;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import setgame.controller.IController;

public class GameField extends JPanel implements ActionListener{
	
	private static IController controller;
	private final int three = 3;
	private final int four = 4;
	private final int ten = 10;
	private final int twenty = 20;
	
	
	public GameField(final IController controller) {
		this.controller = controller;
		
		URL resource1 = ImageIcon.class.getResource( "/card/GOO1.gif" );
		URL resource2 = ImageIcon.class.getResource( "/card/GOO2.gif" );
		URL resource3 = ImageIcon.class.getResource( "/card/GOO3.gif" );
		URL resource4 = ImageIcon.class.getResource( "/card/GOS1.gif" );
		URL resource5 = ImageIcon.class.getResource( "/card/GOS2.gif" );
		URL resource6 = ImageIcon.class.getResource( "/card/GOS3.gif" );
		URL resource7 = ImageIcon.class.getResource( "/card/GOST1.gif" );
		URL resource8 = ImageIcon.class.getResource( "/card/GOST2.gif" );
		URL resource9 = ImageIcon.class.getResource( "/card/GOST3.gif" );
		URL resource10 = ImageIcon.class.getResource( "/card/GRO1.gif" );
		URL resource11 = ImageIcon.class.getResource( "/card/GRO2.gif" );
		URL resource12 = ImageIcon.class.getResource( "/card/GRO3.gif" );
		
		
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

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(three, four, ten, ten));
		
		JLabel p1 = new JLabel( icon1 );
		JLabel p2 = new JLabel( icon2 );
		JLabel p3 = new JLabel( icon3 );
		JLabel p4 = new JLabel( icon4 );
		JLabel p5 = new JLabel( icon5 );
		JLabel p6 = new JLabel( icon6 );
		JLabel p7 = new JLabel( icon7 );
		JLabel p8 = new JLabel( icon8 );
		JLabel p9 = new JLabel( icon9 );
		JLabel p10 = new JLabel( icon10 );
		JLabel p11 = new JLabel( icon11 );
		JLabel p12 = new JLabel( icon12 );
		
		panel1.add(p1);
		panel1.add(p2);
		panel1.add(p3);
		panel1.add(p4);
		panel1.add(p5);
		panel1.add(p6);
		panel1.add(p7);
		panel1.add(p8);
		panel1.add(p9);
		panel1.add(p10);
		panel1.add(p11);
		panel1.add(p12);
		
		panel1.setBorder(BorderFactory.createEmptyBorder(twenty,twenty,twenty,twenty));
		this.add(panel1);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
