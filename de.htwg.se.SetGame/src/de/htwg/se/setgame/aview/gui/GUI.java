package de.htwg.se.setgame.aview.gui;

import java.awt.GridLayout;

import javax.swing.*;

import com.google.inject.Inject;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.controller.impl.SetController;

public class GUI extends JFrame {
	
	private static final long serialVersionUID = 1L;	
	private IController controller = new SetController();
	
	@SuppressWarnings("unused")
	private JPanel mainPanel;
	
	private SetButton setbutton;
	private GameField gamefield;
	
	@Inject
	public GUI(final IController controller) {
		this.controller = controller;
		controller.addObserver(null);

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
		controller.newGame();
		new GUI(controller);
	}
}
