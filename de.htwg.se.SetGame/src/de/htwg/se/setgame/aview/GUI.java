package de.htwg.se.setgame.aview;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.controller.impl.SetController;
import de.htwg.se.setgame.util.observer.Event;
import de.htwg.se.setgame.util.observer.IObserver;

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static int DEFAULT_Y = 650;
	private static int DEFAULT_X = 900;
	
	private static IController controller = new SetController();
	private JPanel mainPanel;
	private SetButton setbutton;
	private GameField gamefield;
	
	public GUI(final IController controller) {
		this.controller = controller;

		this.setJMenuBar(new MenuBar(this.controller));

		JPanel mainPanel = new JPanel();
		JPanel miniPanel = new JPanel();
		
		
		mainPanel.setLayout(new GridLayout(2,1));
		miniPanel.setLayout(new GridLayout(2,1));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		setbutton = new SetButton(controller);
		gamefield = new GameField(controller);
		mainPanel.add(gamefield);
		miniPanel.add(setbutton);
		mainPanel.add(miniPanel);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.setContentPane(mainPanel);

		this.setTitle("SET - The ultimate challenge!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
	}


	public static void main(String[] args) {
		IController controller = new SetController();
		GUI game = new GUI(controller);
	}
}
