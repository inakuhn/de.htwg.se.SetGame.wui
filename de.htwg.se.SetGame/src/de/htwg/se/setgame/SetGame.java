package de.htwg.se.setgame;
import org.apache.log4j.PropertyConfigurator;

import de.htwg.se.setgame.aview.tui.TextUI;
import de.htwg.se.setgame.controller.IController;

import java.util.Scanner;

public final class SetGame {
	private static Scanner scanner;
	private static TextUI tui;
	private IController controller;
	private static SetGame instance = null;
	
	public static SetGame getInstance(){
		if(instance == null)
			new SetGame();
		return instance;
	}
	private SetGame(){
		
	}
}
