package setgame.modell;



import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import setgame.modell.Field;

public class FieldTest {
        Field f;

        @Before
        public void setUp() {
                this.f = new Field();
        }

        @Test
        public void test() {
                assert(this.f != null);
        }

        @Test
        public void testFieldradom() {
                System.out.println("ok!");
        }

        @Test
        public void testField() {
                if (!(f instanceof Field))
                        fail("Not a instance of");
        }

        @Test
        public void testInit() {
                LinkedList<Card> list = new LinkedList<Card>();
        		for(Card card : f.init()){
                	list.add(card);
                }
        		assert(list.size() != 12);
        }
        

        @Test
        public void testRand() {
                int array[] = f.rand();
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
                for (int i = 0; i < array.length; i++) {
                        System.out.println("array[" + i + "] = " + array[i]);
                }
        }
}