package de.htwg.se.setgame;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.impl.Log4jContextFactory;

import com.google.inject.Inject;
import com.google.inject.Guice;
import com.google.inject.Injector;

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
		//set logging throgh log4j
		PropertyConfigurator.configure("log4j.properties");
		Injector injector = Guice.createInjector(new )
		
	}
}
