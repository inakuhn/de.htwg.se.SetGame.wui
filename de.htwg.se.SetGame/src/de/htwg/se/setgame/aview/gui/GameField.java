package de.htwg.se.setgame.aview.gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.LinkedList;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.modell.impl.Card;
import de.htwg.se.setgame.modell.impl.Pack;

public class GameField extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static IController controller;
	private static int index = 0;
	private final static int zero = 0;
	private final static int one = 1;
	private final static int two = 2;
	private final static int three = 3;
	private final static int four = 4;
	private final static int ten = 10;
	private final static int twenty = 20;

	private static JButton b1 = new JButton();
	private static JButton b2 = new JButton();
	private static JButton b3 = new JButton();
	private static JButton b4 = new JButton();
	private static JButton b5 = new JButton();
	private static JButton b6 = new JButton();
	private static JButton b7 = new JButton();
	private static JButton b8 = new JButton();
	private static JButton b9 = new JButton();
	private static JButton b10 = new JButton();
	private static JButton b11 = new JButton();
	private static JButton b12 = new JButton();

	private static Boolean a1 = false;
	private static Boolean a2 = false;
	private static Boolean a3 = false;
	private static Boolean a4 = false;
	private static Boolean a5 = false;
	private static Boolean a6 = false;
	private static Boolean a7 = false;
	private static Boolean a8 = false;
	private static Boolean a9 = false;
	private static Boolean a10 = false;
	private static Boolean a11 = false;
	private static Boolean a12 = false;

	private static int number1 = 0;
	private static int number2 = 1;
	private static int number3 = 2;
	private static int number4 = 3;
	private static int number5 = 4;
	private static int number6 = 5;
	private static int number7 = 6;
	private static int number8 = 7;
	private static int number9 = 8;
	private static int number10 = 9;
	private static int number11 = 10;
	private static int number12 = 11;
	
	private static URL resource1;
	private static URL resource2;
	private static URL resource3;
	private static URL resource4;
	private static URL resource5;
	private static URL resource6;
	private static URL resource7;
	private static URL resource8;
	private static URL resource9;
	private static URL resource10;
	private static URL resource11;
	private static URL resource12;
	
	private static Icon icon1;
	private static Icon icon2;
	private static Icon icon3;
	private static Icon icon4;
	private static Icon icon5;
	private static Icon icon6;
	private static Icon icon7;
	private static Icon icon8;
	private static Icon icon9;
	private static Icon icon10;
	private static Icon icon11;
	private static Icon icon12;
	
	private static JPanel panel1 = new JPanel();
	
	static Card[] card = new Card[5];
	private static Pack pack;
	static TreeMap<Integer, String> cardToPicture;
	static LinkedList<Card> saveList;
	static LinkedList<String> urlListe;
	static LinkedList<String> test;
	
	private static Integer cardkey = new Integer(zero);

	public GameField(final IController controller) {
		this.controller = controller;
		controller.addObserver(null);
		
		cardToPicture = new TreeMap<Integer, String>();
		saveList = new LinkedList<Card>();
		urlListe = new LinkedList<String>();
		test = new LinkedList<String>();
		
		pack = new Pack();
		
		for (int i = 0; i < pack.getPack().size(); i++) {
			test.add("/pack/" + i + ".gif");
		}
		for (int index1 = 0; index1 < pack.getPack().size(); index1++) {
			cardToPicture.put(index1, test.get(index1));
		}

		for (Card card : pack.getPack()) {
			for (Card key : controller.getField().getCardInFieldGame().values()) {
				if (card.comparTo(key)) {
					urlListe.add(cardToPicture.get(cardkey));
					saveList.add(key);
				}
			}
			cardkey++;
		}

		cardkey = zero;
		
		resource1 = ImageIcon.class.getResource(urlListe.get(number1));
		resource2 = ImageIcon.class.getResource(urlListe.get(number2));
		resource3 = ImageIcon.class.getResource(urlListe.get(number3));
		resource4 = ImageIcon.class.getResource(urlListe.get(number4));
		resource5 = ImageIcon.class.getResource(urlListe.get(number5));
		resource6 = ImageIcon.class.getResource(urlListe.get(number6));
		resource7 = ImageIcon.class.getResource(urlListe.get(number7));
		resource8 = ImageIcon.class.getResource(urlListe.get(number8));
		resource9 = ImageIcon.class.getResource(urlListe.get(number9));
		resource10 = ImageIcon.class.getResource(urlListe.get(number10));
		resource11 = ImageIcon.class.getResource(urlListe.get(number11));
		resource12 = ImageIcon.class.getResource(urlListe.get(number12));
		
		icon1 = new ImageIcon(resource1);
		icon2 = new ImageIcon(resource2);
		icon3 = new ImageIcon(resource3);
		icon4 = new ImageIcon(resource4);
		icon5 = new ImageIcon(resource5);
		icon6 = new ImageIcon(resource6);
		icon7 = new ImageIcon(resource7);
		icon8 = new ImageIcon(resource8);
		icon9 = new ImageIcon(resource9);
		icon10 = new ImageIcon(resource10);
		icon11 = new ImageIcon(resource11);
		icon12 = new ImageIcon(resource12);
		
		b1.setIcon(icon1);
		b2.setIcon(icon2);
		b3.setIcon(icon3);
		b4.setIcon(icon4);
		b5.setIcon(icon5);
		b6.setIcon(icon6);
		b7.setIcon(icon7);
		b8.setIcon(icon8);
		b9.setIcon(icon9);
		b10.setIcon(icon10);
		b11.setIcon(icon11);
		b12.setIcon(icon12);

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

		panel1.setBorder(BorderFactory.createEmptyBorder(twenty, twenty,
				twenty, twenty));
		this.add(panel1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == b1 && a1 == false) {
			index++;
			a1 = true;
			card[index] = saveList.get(number1);
		} else if (source == b1 && a1 == true) {
			JOptionPane.showMessageDialog(null, "" + "Not a second time :P",
					"Warning", JOptionPane.OK_OPTION);
		}

		if (source == b2 && a2 == false) {
			index++;
			a2 = true;
			card[index] = saveList.get(number2);
		} else if (source == b2 && a2 == true) {
			JOptionPane.showMessageDialog(null, "" + "Not a second time :P",
					"Warning", JOptionPane.OK_OPTION);
		}

		if (source == b3 && a3 == false) {
			index++;
			a3 = true;
			card[index] = saveList.get(number3);
		} else if (source == b3 && a3 == true) {
			JOptionPane.showMessageDialog(null, "" + "Not a second time :P",
					"Warning", JOptionPane.OK_OPTION);
		}

		if (source == b4 && a4 == false) {
			index++;
			a4 = true;
			card[index] = saveList.get(number4);
		} else if (source == b4 && a4 == true) {
			JOptionPane.showMessageDialog(null, "" + "Not a second time :P",
					"Warning", JOptionPane.OK_OPTION);
		}

		if (source == b5 && a5 == false) {
			index++;
			a5 = true;
			card[index] = saveList.get(number5);
		} else if (source == b5 && a5 == true) {
			JOptionPane.showMessageDialog(null, "" + "Not a second time :P",
					"Warning", JOptionPane.OK_OPTION);
		}

		if (source == b6 && a6 == false) {
			index++;
			a6 = true;
			card[index] = saveList.get(number6);
		} else if (source == b6 && a6 == true) {
			JOptionPane.showMessageDialog(null, "" + "Not a second time :P",
					"Warning", JOptionPane.OK_OPTION);
		}

		if (source == b7 && a7 == false) {
			index++;
			a7 = true;
			card[index] = saveList.get(number7);
		} else if (source == b7 && a7 == true) {
			JOptionPane.showMessageDialog(null, "" + "Not a second time :P",
					"Warning", JOptionPane.OK_OPTION);
		}

		if (source == b8 && a8 == false) {
			index++;
			a8 = true;
			card[index] = saveList.get(number8);
		} else if (source == b8 && a8 == true) {
			JOptionPane.showMessageDialog(null, "" + "Not a second time :P",
					"Warning", JOptionPane.OK_OPTION);
		}

		if (source == b9 && a9 == false) {
			index++;
			a9 = true;
			card[index] = saveList.get(number9);
		} else if (source == b9 && a9 == true) {
			JOptionPane.showMessageDialog(null, "" + "Not a second time :P",
					"Warning", JOptionPane.OK_OPTION);
		}

		if (source == b10 && a10 == false) {
			index++;
			a10 = true;
			card[index] = saveList.get(number10);
		} else if (source == b10 && a10 == true) {
			JOptionPane.showMessageDialog(null, "" + "Not a second time :P",
					"Warning", JOptionPane.OK_OPTION);
		}

		if (source == b11 && a11 == false) {
			index++;
			a11 = true;
			card[index] = saveList.get(number11);
		} else if (source == b11 && a11 == true) {
			JOptionPane.showMessageDialog(null, "" + "Not a second time :P",
					"Warning", JOptionPane.OK_OPTION);
		}

		if (source == b12 && a12 == false) {
			index++;
			a12 = true;
			card[index] = saveList.get(number12);
		} else if (source == b12 && a12 == true) {
			JOptionPane.showMessageDialog(null, "" + "Not a second time :P",
					"Warning", JOptionPane.OK_OPTION);
		}

		if (index == four) {
			JOptionPane.showMessageDialog(null, "Only three cards "
					+ "addicted a SET :)", "Warning", JOptionPane.OK_OPTION);
			reset();
		} 

	}

	public static Card getCardforSetOne() {
		reset();
		return card[one];
	}
	
	public static Card getCardforSetTwo() {
		return card[two];
	}

	public static Card getCardforSetThree() {
		return card[three];
	}


	private static void reset() {
		a1 = false;
		a2 = false;
		a3 = false;
		a4 = false;
		a5 = false;
		a6 = false;
		a7 = false;
		a8 = false;
		a9 = false;
		a10 = false;
		a11 = false;
		a12 = false;

		index = zero;
	}
	
	public static void updateLink() {
		
		urlListe.clear();
		saveList.clear();
		
		for (Card card : pack.getPack()) {
			for (Card key : controller.getField().getCardInFieldGame().values()) {
				if (card.comparTo(key)) {
					urlListe.add(cardToPicture.get(cardkey));
					saveList.add(key);
				}
			}
			cardkey++;
		}

		cardkey = zero;
		
		reset();
		updateGF();
		
		
	}
	
	private static void updateGF() {
		resource1 = ImageIcon.class.getResource(urlListe.get(number1));
		resource2 = ImageIcon.class.getResource(urlListe.get(number2));
		resource3 = ImageIcon.class.getResource(urlListe.get(number3));
		resource4 = ImageIcon.class.getResource(urlListe.get(number4));
		resource5 = ImageIcon.class.getResource(urlListe.get(number5));
		resource6 = ImageIcon.class.getResource(urlListe.get(number6));
		resource7 = ImageIcon.class.getResource(urlListe.get(number7));
		resource8 = ImageIcon.class.getResource(urlListe.get(number8));
		resource9 = ImageIcon.class.getResource(urlListe.get(number9));
		resource10 = ImageIcon.class.getResource(urlListe.get(number10));
		resource11 = ImageIcon.class.getResource(urlListe.get(number11));
		resource12 = ImageIcon.class.getResource(urlListe.get(number12));
		
		icon1 = new ImageIcon(resource1);
		icon2 = new ImageIcon(resource2);
		icon3 = new ImageIcon(resource3);
		icon4 = new ImageIcon(resource4);
		icon5 = new ImageIcon(resource5);
		icon6 = new ImageIcon(resource6);
		icon7 = new ImageIcon(resource7);
		icon8 = new ImageIcon(resource8);
		icon9 = new ImageIcon(resource9);
		icon10 = new ImageIcon(resource10);
		icon11 = new ImageIcon(resource11);
		icon12 = new ImageIcon(resource12);
		
		b1.setIcon(icon1);
		b2.setIcon(icon2);
		b3.setIcon(icon3);
		b4.setIcon(icon4);
		b5.setIcon(icon5);
		b6.setIcon(icon6);
		b7.setIcon(icon7);
		b8.setIcon(icon8);
		b9.setIcon(icon9);
		b10.setIcon(icon10);
		b11.setIcon(icon11);
		b12.setIcon(icon12);
	}

}
