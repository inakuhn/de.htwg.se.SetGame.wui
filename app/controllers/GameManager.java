package controllers;

import de.htwg.se.setgame.controller.IController;

import de.htwg.se.setgame.controller.impl.SetController;
import play.mvc.Http;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by raina on 12.01.2015.
 */
public class GameManager {


    private Map<Http.Session, IController> games = new HashMap<Http.Session, IController>();
    private Stack<IController> freeGames = new Stack<IController>();

    public IController get(Http.Session session) {
        if (games.get(session) == null) {
            IController c;
            if (freeGames.empty()) {
                c = new SetController();
                freeGames.push(c);
            } else {
                c = freeGames.pop();
            }
            games.put(session, c);

        }

        return games.get(session);
    }

}
