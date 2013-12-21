package setgame.modell;



import static org.junit.Assert.fail;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import setgame.controller.Logic;
import setgame.modell.Field;
import setgame.*;
public class FieldTest {
        Field field;
        setgame.controller.Logic logic;

        @Before
        public void setUp() {
                this.field = new Field();
                this.logic = new Logic();
        }

        @Test
        public void test() {
                assert(this.field != null);
        }


        @Test
        public void testField() {
                assert((this.field instanceof Field) != false);
        }

        @Test
        public void testInit() {
                LinkedList<Card> list = new LinkedList<Card>();
        		for(Card card : field.init()){
                	list.add(card);
                }
        		assert(list.size() != 12);
        }
        

        @Test
        public void testRand() {
                int array[] = field.rand();
                boolean vertauscht;
                for (int i = array.length - 1; i >= 0; i--) {
                        vertauscht = false;
                        for (int j = 0; j < i; j++) {
                                if (array[j] > array[j + 1]) {
                                        int t = array[j];
                                        array[j] = array[j + 1];
                                        array[j + 1] = t;
                                        vertauscht = true;
                                }
                        }
                        if (!vertauscht)
                                break;
                }
                
        }


    	@Test
    	public void testFoundSet() {
    		for(Card cardOne : this.field.getAllCardsInGame()){
    			for(Card cardTwo : this.field.getAllCardsInGame()){
    				for (Card cardThree : this.field.getAllCardsInGame()){
    					if(this.logic.isAset(cardOne, cardTwo, cardThree)){
    						field.foundSet(cardOne, cardTwo, cardThree);
    					}
    				}
    			}
    			
    		}
    		System.out.println();
    		assert(this.field.getAllCardsInGame().isEmpty() != false);
    	}

    	@Test
    	public void testCardsInField() {
    		for(Card card : this.field.cardsInField()){
    		System.out.println(card);
    	
    		}
    	}
    	@Test
    	public void testSetSizeOfField() {
    		this.field.setSizeOfField(15);
    		assert(this.field.cardsInField().size() != 15);
    	}

    	@Test
    	public void testChangeCards() {
    		boolean booll = false;
    		LinkedList<Card> packcard = new LinkedList<Card>();
    		LinkedList<Card> liste = new LinkedList<Card>();
    		packcard.addAll(this.field.getPackForControler());
    		for(int index = 0; index < this.field.getPackForControler().size(); index ++){
    			liste.add(this.field.getPackForControler().get(index));
    			field.changeCards(liste);
    		
    		for(Card card : this.field.cardsInField()){
    			if(liste.get(index).equals(card)){
    				packcard.remove(card);
    			}
    		}
    		}
    		assert(packcard.isEmpty() != false);
    	}

    	@Test
    	public void testGetPackForControler() {
    		fail("Not yet implemented");
    	}

    	@Test
    	public void testGetSizeofField() {
    		fail("Not yet implemented");
    	}
}