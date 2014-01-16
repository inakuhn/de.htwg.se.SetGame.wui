package de.htwg.setgame;
import setgame.aview.tui.TextUI;
import setgame.controller.IController;
import org.apache.*;

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
