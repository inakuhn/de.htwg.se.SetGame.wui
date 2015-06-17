package controllers;

import de.htwg.se.setgame.controller.IController;
import de.htwg.se.setgame.model.ICard;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 */
public class Helper {

    private IController controller;

    /**
     *
     * @param controller
     */
    public Helper(IController controller) {
        this.controller = controller;
    }

    /**
     *
     * @return List<Integer>
     *     return The IDs of the Cards in the field.
     */
    public List<Integer> getField() {
        return new LinkedList<Integer>(getIndexAndCard().keySet());
    }

    /**
     *
     * @return
     */
    public Map<Integer,ICard> getIndexAndCard(){
        List<ICard> packList = controller.getNewPack();
        Map<Integer,ICard> result = new HashMap<Integer,ICard>();

        for (ICard card:controller.getCardInFieldGame()) {
            for (int i = 0; i < packList.size(); i++) {
                if (card.compareTo(packList.get(i))) {
                    result.put(i,packList.get(i));
                }
            }
        }

        return result;
    }

    /**
     *
     * @param index
     * @return
     */
    public ICard getCard(Integer index) {
        Map<Integer,ICard> allCardsInField = getIndexAndCard();
        return allCardsInField.get(index);
    }

    /**
     *
     * @return
     */
    public List<Integer> getASet() {
        List<ICard> setInGame = controller.getASetInGame();
        Map<Integer,ICard> indexAndCard = getIndexAndCard();

        List<Integer> result = new LinkedList<Integer>();
        for (ICard setCard : setInGame) {
            for(Integer cardIndex: indexAndCard.keySet()){
                if(indexAndCard.get(cardIndex).compareTo(setCard)){
                    result.add(cardIndex);
                }
            }
        }
        return result;
    }

    /**
     *
     * @param player
     * @param cardOne
     * @param cardTwo
     * @param cardThree
     * @return
     */
    public Object isASet(Integer player, Integer cardOne, Integer cardTwo, Integer cardThree) {

        List<Integer> indexBeforeSetCall = getField();
        ICard first = getCard(cardOne);
        ICard second = getCard(cardTwo);
        ICard th = getCard(cardThree);
        if(first != null && second != null & th != null) {
            controller.isASetForController(first, second, th, player);
        }else{
            return false;
        }
        List<Integer> indexAfterSetCall = getField();

        return !indexBeforeSetCall.containsAll(indexAfterSetCall);

    }
}