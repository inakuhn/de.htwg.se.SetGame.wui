package controllers;

import de.htwg.se.setgame.SetGame;
import de.htwg.se.setgame.aview.tui.TextUI;
import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.modell.ICard;
import play.mvc.Controller;
import play.mvc.Result;

import java.lang.Integer;
import java.lang.Package;
import java.lang.String;
import java.lang.System;
import java.util.List;
import java.util.LinkedList;

public class Application extends Controller {

    static IController controller = SetGame.getInstance(false).getIController();
    
    public static Result index() {
        return ok(views.html.index.render(controller, getField()));
    }

    public static Result help() {
        return ok(views.html.help.render());
    }

    private static List<Integer> getField() {
        List<ICard> packList = controller.getPack().getPack();
        List<Integer> result = new LinkedList<Integer>();

        for (ICard card:controller.getCardInFieldGame()) {
            for (int i = 0; i < packList.size(); i++) {
                if (card.comparTo(packList.get(i))) {
                    result.add(i);
                }
            }
        }

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
        controller.isASetForController(first,sec,th,player);
        return ok(views.html.index.render(controller, getField()));
    }

    public static Result reset() {
        controller.newGame();
        return ok(views.html.index.render(controller, getField()));
    }
}
