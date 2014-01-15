package setgame.aview;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwg.se.util.observer.IObserver;
import de.htwg.se.util.observer.Event;
import setgame.controller.IController;

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static int DEFAULT_Y = 650;
	private static int DEFAULT_X = 900;
	
	private static IController controller;
	private JPanel mainPanel;
	private Point point;
	private SetButton setbutton;
	private GameField gamefield;
	
	public GUI(final IController controller) {
		this.controller = controller;

		this.setJMenuBar(new MenuBar(this.controller));

		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		JPanel miniPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		
		mainPanel.setLayout(new GridLayout(2,1));
		miniPanel.setLayout(new GridLayout(2,1));
		point = new Point(controller);
		setbutton = new SetButton(controller);
		gamefield = new GameField(controller);
		mainPanel.add(gamefield);
		miniPanel.add(setbutton);
		miniPanel.add(point);
		mainPanel.add(miniPanel);
		this.setContentPane(mainPanel);

		this.setTitle("SET - The ultimate challenge!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
	}


	public static void main(String[] args) {
		GUI game = new GUI(controller);
	}
}
