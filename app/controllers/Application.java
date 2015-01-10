package controllers;

import de.htwg.se.setgame.SetGame;
import de.htwg.se.setgame.aview.tui.TextUI;
import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.modell.ICard;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;
import views.html.solve;

import java.lang.Integer;
import java.lang.Package;
import java.lang.String;
import java.lang.System;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

public class Application extends Controller {

    static IController controller = SetGame.getInstance(false).getIController();
    
    public static Result index() {
        return ok(views.html.index.render(controller, getField()));
    }
    public static Result solve() {
        List<Integer> result = new LinkedList<>();
        List<ICard> setInGame = controller.getASetInGame();
        Map<Integer,ICard> indexAndCard = getIndexAndCard();
            for (ICard setCard : setInGame) {
                  for(Integer cardIndex: indexAndCard.keySet()){
                      if(indexAndCard.get(cardIndex).comparTo(setCard)){
                          result.add(cardIndex);
                  }
            }
        }
        return ok(views.html.solve.render(controller, getField(), result));
    }

    public static Result help() {
        return ok(views.html.help.render());
    }


    private static List<Integer> getField() {
        List<ICard> packList = controller.getPack().getPack();
        List<Integer> result = new LinkedList<Integer>();

        result.addAll(getIndexAndCard().keySet());

        return result;
    }

    public static Result size(Integer number) {
        controller.setFieldSize(number);
        return ok(views.html.index.render(controller, getField()));
    }
    public static Result set(Integer player, Integer cardOne, Integer cardTwo, Integer cardThree) {
        List<ICard> allCardsInField =controller.getCardInFieldGame();
        ICard first = allCardsInField.get(cardOne);
        ICard sec = allCardsInField.get(cardTwo);
        ICard th = allCardsInField.get(cardThree);
        controller.isASetForController(first, sec, th, player);
        return ok(views.html.index.render(controller, getField()));
    }

    public static Result reset() {
        controller.newGame();
        return ok(views.html.index.render(controller, getField()));
    }
    private static Map<Integer,ICard> getIndexAndCard(){
        List<ICard> packList = controller.getPack().getPack();
        Map<Integer,ICard> result = new HashMap<Integer,ICard>();

        for (ICard card:controller.getCardInFieldGame()) {
            for (int i = 0; i < packList.size(); i++) {
                if (card.comparTo(packList.get(i))) {
                    result.put(i,packList.get(i));
                }
            }
        }

        return result;
    }
}
