package controllers;

import de.htwg.se.setgame.SetGame;
import de.htwg.se.setgame.SetGameModule;
import de.htwg.se.setgame.controller.IController;
import play.mvc.Http;

import java.lang.String;
import java.lang.System;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by raina on 12.01.2015.
 */
public class GameManager {

    public static final String PLAYER = "player";
    public static final String GAME = "game";
    public static final String SESSION = "session";
    
    private Map<Http.Session, IController> games = new HashMap<Http.Session, IController>();
   
	private Stack<IController> freeGames = new Stack<IController>();

    /**
     * Get current game instance of player
     * @param session
     * @return
     */
    public IController get(Http.Session session) {
        return (hasSession(session)) ? newSession(session) : games.get(session);
    }
    
    public void setPlayer(Http.Session session, String player) {
    	session.put(PLAYER, player);
    
    }
    
    public void setKi(Http.Session session, String mode) {
		Injector injector = Guice.createInjector(new SetGameModule());
		IController c = injector.getInstance(IController.class);
		games.put(session, c);
		session.put(PLAYER, "1");
		c.setKIPlayer(mode);
	}
    
    private boolean hasSession(Http.Session session) {
        return (session.get(GAME) == null || games.get(session) == null);
    }

    private IController newSession(Http.Session session) {
        System.out.println("New game");
        IController c = (freeGames.empty()) ? createPlayer1(session) : createPlayer2(session);
        session.put(GAME, c.hashCode() + "");
        games.put(session, c);
        System.out.println("Manager: " + games.size() + " Sessions, " + freeGames.size() + " Open Games");
        return c;
    }

    private IController createPlayer1(Http.Session session) {  
    	
    	Injector injector = Guice.createInjector(new SetGameModule());
        IController c = injector.getInstance(IController.class);
    	/*
    	SetGame setGame = SetGame.getInstance();
    	IController c = setGame.getIController();
    	*/
        freeGames.push(c);
        session.put(PLAYER, "1");
        System.out.println("Create new Player 1: " + c.hashCode());
        return c;
    }

    private IController createPlayer2(Http.Session session) {
        IController c = freeGames.pop();
        session.put(PLAYER, "2");
        System.out.println("Create new Player 2: " + c.hashCode());
        return c;
    }

}
