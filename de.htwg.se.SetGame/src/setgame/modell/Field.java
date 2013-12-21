package setgame.modell;

import java.util.LinkedList;

/**
 * Class Field.
 * @author David Simon & Raina Bertolini
 * @date 7.12.2013
 * @category Modell
 */
public class Field {

	/**
	 * Instance variable
	 *
	 */
	private static int FIELDSIZE = 12;
	private static final int MAX = 81;
	private static final int ONE = 1;
	private static int COUNTER = 0;
	private Pack pack;
	LinkedList<Integer> ramdomListe;
	LinkedList<Card> cardInFieldGame;
	LinkedList<Card> freeCard;
	int array[];
	
	/**
	 *  All used Cards will be write in the LinkedList register
	 */
	private LinkedList<Card> register = new LinkedList<Card>();

	public Field() {
		this.pack = new Pack();
		this.freeCard =  new LinkedList<Card>();
		this.cardInFieldGame = new LinkedList<Card>();
		this.ramdomListe = new LinkedList<Integer>();
		this.array = new int[MAX];
		init();
		rand();
	}

	/** Field will be initializes.
	 *  @return give back filled field
	 */
	public LinkedList<Card> init() {
		
		return fillField();
	}

	/** Filled array with integer number.
	 *  @return filled array
	 */
	public void rand() {
		int [] tem = new int[MAX];
		boolean b;
		for (int index = 0; index < MAX; index++) {
			b = true;
			int element = (int) (Math.random() * MAX + ONE);
			for (int t = 0; t < MAX; t++) {
				if (element == tem[t] && index > 0) {
					index = index - 1;
					b = false;
				}
			}
			if (b) {

					this.ramdomListe.add(index, element);
					
					tem[index] = element;
				}
			System.out.println("Elemte for ramdommm list = "+ramdomListe);
							
		}
		for(int index = 0; index < tem.length; index++){
			
			this.array[index] = tem[index];
		}
		
	}

	/** Filled field with cards from the class Card
	 *  @return filled Field with Cards
	 */
	private LinkedList<Card> fillField() {

		for (int index = 0; index < FIELDSIZE; index++) {
			if(array[index] == 81){
				array[index] = 0;
				int indexOf81 = ramdomListe.indexOf(81);
				ramdomListe.add(indexOf81, 0);
				ramdomListe.remove(81);
			}
			this.cardInFieldGame.add(index, pack.getPack().get(this.ramdomListe.get(index)));
			
			register.add(pack.getPack().get(this.ramdomListe.get(index)));
//			this.ramdomListe.remove(index);
		}

		return cardInFieldGame;

	}
	
	/**
	 * Fill the variable fill with one card information and gives back.
	 * @return fill - return one "card information" 
	 */
	private Card setCardsInField() {	
		
		Card fill;
		int randfill[] = this.array;
		boolean close = false;
		
		while(COUNTER != randfill.length) {
			close = false;
			
			if (register.equals(randfill[COUNTER])) {
				close = true;
				COUNTER++;
			}
			
			if (close == false) {
				fill = pack.getPack().get(randfill[COUNTER]);
				register.add(pack.getPack().get(randfill[COUNTER]));
				return fill;
			}
		}

		return null;
	}
	/**
	 * Insert new Cards in the field where cardOne , cardTwo ,cardThree went.
	 * @param cardOne
	 * @param cardTwo
	 * @param cardThree
	 */
	public void foundSet(Card cardOne, Card cardTwo, Card cardThree){		
		for(Card control : cardInFieldGame) {
			
			if(cardOne.equals(control)) {
				if(this.pack.getPack().remove(cardOne)) {
				}
				
			} else if (cardTwo.equals(control)) {
				if(this.pack.getPack().remove(cardTwo)) {
				}
				
			} else if (cardThree.equals(control)) {
				if(this.pack.getPack().remove(cardThree)) {
				}
				
			} 
			
		}	
	}


	
	
	/**
	 * @return all the cards in the field
	 */
	public LinkedList<Card> cardsInField(){
		LinkedList<Card> list = new LinkedList<Card>();
		
		for(Card add : cardInFieldGame) {
			list.add(add);
		}
		
		return list;
	}
	
	/**
	 *	changes the size of the field in the game or at the begin with out losing Cards. 
	 */
	public void setSizeOfField(int size){
		if(size < FIELDSIZE){
			changeFieldToSmallSize(size);
		}else if(size > FIELDSIZE){
			FIELDSIZE = size;
//			cardInFieldGame = new Card[FIELDSIZE];
		}
	}
	
	private void changeFieldToSmallSize(int size) {
		LinkedList<Card> savelist = new LinkedList<Card>();
		int saveSize = size + 1;
		
		for(int n = saveSize; n < FIELDSIZE; n++) {
			savelist.add(cardInFieldGame.get(n));
		}
		
		register.remove(savelist);
		cardInFieldGame.retainAll(savelist);
		
	}
	
    /** the Controller always prove if a Set in Field is, if not the look through the existent pack
     * and prove if still existing a Set if yes calls the changed Cards.
     * @param liste
     */
    public void changeCards(LinkedList<Card> liste){
    	int size = liste.size();
    	
    	if(FIELDSIZE >= size) {
    		
    		for (int n = 0; n < size; n++) {
//    			cardInFieldGame[n] = liste.get(n);
    		}
    		
    	} else {
    		
    		setSizeOfField(size);
    		
    		for (int n = 0; n < size; n++) {
//    			cardInFieldGame[n] = liste.get(n);
    		}
    		
    	}
   
    	
    }
	
	/**
	 * @return the unused Cards in game!
	 */
	public LinkedList<Card> getPackForControler(){
		LinkedList<Card> list = new LinkedList<Card>();
		
		for (Card rest : pack.getPack()) {
			if(!rest.equals(register)) {
				list.add(rest);
			}
		}
		
		return list;
	}
	
	public int getSizeofField() {
		return cardInFieldGame.size();
	}
	public LinkedList<Card> getAllCardsInGame(){
		LinkedList<Card> list = new LinkedList<Card>();
		for(Card card : this.pack.getPack()){
			list.add(card);
		}
		return list;
	}

}
