package controllers;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.modell.ICard;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

public class Helper {

    private IController controller;

    public Helper(IController controller) {
        this.controller = controller;
    }

    public List<Integer> getField() {
        return new LinkedList<Integer>(getIndexAndCard().keySet());
    }

    public Map<Integer,ICard> getIndexAndCard(){
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


    public ICard getCard(Integer index) {
        Map<Integer,ICard> allCardsInField = getIndexAndCard();
        System.out.println("Card in Set: "+index);
        System.out.println(allCardsInField.get(index));
        return allCardsInField.get(index);
    }


    public List<Integer> getASet() {
        List<ICard> setInGame = controller.getASetInGame();
        Map<Integer,ICard> indexAndCard = getIndexAndCard();

        List<Integer> result = new LinkedList<Integer>();
        for (ICard setCard : setInGame) {
            for(Integer cardIndex: indexAndCard.keySet()){
                if(indexAndCard.get(cardIndex).comparTo(setCard)){
                    result.add(cardIndex);
                }
            }
        }
        return result;
    }
}