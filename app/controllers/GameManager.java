package controllers;

import de.htwg.se.setgame.controller.IController;

import de.htwg.se.setgame.controller.impl.SetController;
import play.mvc.Http;

import javax.swing.*;
import java.lang.String;
import java.lang.System;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by raina on 12.01.2015.
 */
public class GameManager {

    public static final String PLAYER = "player";
    public static final String GAME = "game";

    private Map<Http.Session, IController> games = new HashMap<Http.Session, IController>();
    private Stack<IController> freeGames = new Stack<IController>();

    public IController get(Http.Session session) {
        return (hasSession(session)) ? newSession(session) : games.get(session);
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
        IController c = new SetController();
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
