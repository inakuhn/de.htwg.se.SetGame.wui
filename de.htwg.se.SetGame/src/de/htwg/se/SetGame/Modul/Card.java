package de.htwg.se.SetGame.Modul;

import java.awt.*;
import java.util.TreeMap;
import java.text.Format;
import java.util.TreeSet;

import javax.swing.text.html.FormSubmitEvent;

public class Card {
        TreeSet<Cards> pack;
        private static int numberOfCard = 0;

        /* One card in card */
        public class Cards {
                String color;
                String fomr;
                String panelFilling;
                int anz;

                public Cards(String color, String form, String panelFilling, int anzahl) {
                        if (color.equals("red") || color.equals("green")
                                        || color.equals("purple") && form.equals("beam")
                                        || form.equals("ovally") || form.equals("wave")
                                        && panelFilling.equals("halfFill")
                                        || panelFilling.equals("fill")
                                        || panelFilling.equals("empty") && anzahl == 1
                                        || anzahl == 2 || anzahl == 3) {
                                this.color = color;
                                this.fomr = form;
                                this.panelFilling = panelFilling;
                                this.anz = anzahl;
                        }

                }
        }

        public Card()  {

                this.pack = creatCards();

        }

        private TreeSet<Cards> creatCards() {
                TreeSet<Cards> list = new TreeSet<>();
                /* Reds */
                /* 1 */
                Cards card1 = new Cards("red", "balk ", "halffill", 1);
                Cards card2 = new Cards("red", "ovally ", "halffill", 1);
                Cards card3 = new Cards("red", "wave", "halffill", 1);

                Cards card4 = new Cards("red", "balk ", "fill", 1);
                Cards card5 = new Cards("red", "ovally ", "fill", 1);
                Cards card6 = new Cards("red", "wave", "fill", 1);

                Cards card7 = new Cards("red", "balk ", "empty", 1);
                Cards card8 = new Cards("red", "ovally ", "empty", 1);
                Cards card9 = new Cards("red", "wave", "empty", 1);
                /* 2 */
                Cards card10 = new Cards("red", "balk ", "halffill", 2);
                Cards card11 = new Cards("red", "ovally ", "halffill", 2);
                Cards card12 = new Cards("red", "wave", "halffill", 2);

                Cards card13 = new Cards("red", "balk ", "fill", 2);
                Cards card14 = new Cards("red", "ovally ", "fill", 2);
                Cards card15 = new Cards("red", "wave", "fill", 2);

                Cards card16 = new Cards("red", "balk ", "empty", 2);
                Cards card17 = new Cards("red", "ovally ", "empty", 2);
                Cards card18 = new Cards("red", "wave", "empty", 2);
                /* 3 */
                Cards card19 = new Cards("red", "balk ", "halffill", 3);
                Cards card20 = new Cards("red", "ovally ", "halffill", 3);
                Cards card21 = new Cards("red", "wave", "halffill", 3);

                Cards card22 = new Cards("red", "balk ", "fill", 3);
                Cards card23 = new Cards("red", "ovally ", "fill", 3);
                Cards card24 = new Cards("red", "wave", "fill", 3);

                Cards card25 = new Cards("red", "balk ", "empty", 3);
                Cards card26 = new Cards("red", "ovally ", "empty", 3);
                Cards card27 = new Cards("red", "wave", "empty", 3);

                /* green */
                /* 1 */
                Cards card28 = new Cards("green", "balk ", "halffill", 1);
                Cards card29 = new Cards("green", "ovally ", "halffill", 1);
                Cards card30 = new Cards("green", "wave", "halffill", 1);

                Cards card31 = new Cards("green", "balk ", "fill", 1);
                Cards card32 = new Cards("green", "ovally ", "fill", 1);
                Cards card33 = new Cards("green", "wave", "fill", 1);

                Cards card34 = new Cards("green", "balk ", "empty", 1);
                Cards card35 = new Cards("green", "ovally ", "empty", 1);
                Cards card36 = new Cards("green", "wave", "empty", 1);
                /* 2 */
                Cards card37 = new Cards("green", "balk ", "halffill", 2);
                Cards card38 = new Cards("green", "ovally ", "halffill", 2);
                Cards card39 = new Cards("green", "wave", "halffill", 2);

                Cards card40 = new Cards("green", "balk ", "fill", 2);
                Cards card41 = new Cards("green", "ovally ", "fill", 2);
                Cards card42 = new Cards("green", "wave", "fill", 2);

                Cards card43 = new Cards("green", "balk ", "empty", 2);
                Cards card44 = new Cards("green", "ovally ", "empty", 2);
                Cards card45 = new Cards("green", "wave", "empty", 2);
                /* 3 */
                Cards card46 = new Cards("green", "balk ", "halffill", 3);
                Cards card47 = new Cards("green", "ovally ", "halffill", 3);
                Cards card48 = new Cards("green", "wave", "halffill", 3);

                Cards card49 = new Cards("green", "balk ", "fill", 3);
                Cards card50 = new Cards("green", "ovally ", "fill", 3);
                Cards card51 = new Cards("green", "wave", "fill", 3);

                Cards card52 = new Cards("green", "balk ", "empty", 3);
                Cards card53 = new Cards("green", "ovally ", "empty", 3);
                Cards card54 = new Cards("green", "wave", "empty", 3);

                /* purple */
                /* 1 */
                Cards card55 = new Cards("purple", "balk ", "halffill", 1);
                Cards card56 = new Cards("purple", "ovally ", "halffill", 1);
                Cards card57 = new Cards("purple", "wave", "halffill", 1);

                Cards card58 = new Cards("green", "balk ", "fill", 1);
                Cards card59 = new Cards("green", "ovally ", "fill", 1);
                Cards card60 = new Cards("green", "wave", "fill", 1);

                Cards card61 = new Cards("purple", "balk ", "empty", 1);
                Cards card62 = new Cards("purple", "ovally ", "empty", 1);
                Cards card63 = new Cards("purple", "wave", "empty", 1);
                /* 2 */
                Cards card64 = new Cards("purple", "balk ", "halffill", 2);
                Cards card65 = new Cards("purple", "ovally ", "halffill", 2);
                Cards card66 = new Cards("purple", "wave", "halffill", 2);

                Cards card67 = new Cards("purple", "balk ", "fill", 2);
                Cards card68 = new Cards("purple", "ovally ", "fill", 2);
                Cards card69 = new Cards("purple", "wave", "fill", 2);

                Cards card70 = new Cards("purple", "balk ", "empty", 2);
                Cards card71 = new Cards("purple", "ovally ", "empty", 2);
                Cards card72 = new Cards("purple", "wave", "empty", 2);
                /* 3 */
                Cards card73 = new Cards("purple", "balk ", "halffill", 3);
                Cards card74 = new Cards("purple", "ovally ", "halffill", 3);
                Cards card75 = new Cards("purple", "wave", "halffill", 3);

                Cards card76 = new Cards("purple", "balk ", "fill", 3);
                Cards card77 = new Cards("purple", "ovally ", "fill", 3);
                Cards card78 = new Cards("purple", "wave", "fill", 3);

                Cards card79 = new Cards("purple", "balk ", "empty", 3);
                Cards card80 = new Cards("purple", "ovally ", "empty", 3);
                Cards card81 = new Cards("purple", "wave", "empty", 3);

                list.add(card1);
                list.add(card2);
                list.add(card3);

                list.add(card4);
                list.add(card5);
                list.add(card6);

                list.add(card7);
                list.add(card8);
                list.add(card9);

                list.add(card10);
                list.add(card11);
                list.add(card12);

                list.add(card13);
                list.add(card14);
                list.add(card15);

                list.add(card16);
                list.add(card17);
                list.add(card18);

                list.add(card19);
                list.add(card20);
                list.add(card21);

                list.add(card22);
                list.add(card23);
                list.add(card24);

                list.add(card25);
                list.add(card26);
                list.add(card27);

                list.add(card28);
                list.add(card29);
                list.add(card30);

                list.add(card31);
                list.add(card32);
                list.add(card33);

                list.add(card34);
                list.add(card35);
                list.add(card36);

                list.add(card37);
                list.add(card38);
                list.add(card39);

                list.add(card40);
                list.add(card41);
                list.add(card42);

                list.add(card43);
                list.add(card44);
                list.add(card45);

                list.add(card46);
                list.add(card47);
                list.add(card48);

                list.add(card49);
                list.add(card50);
                list.add(card51);

                list.add(card52);
                list.add(card53);
                list.add(card54);

                list.add(card55);
                list.add(card56);
                list.add(card57);

                list.add(card58);
                list.add(card59);
                list.add(card60);

                list.add(card61);
                list.add(card62);
                list.add(card63);

                list.add(card64);
                list.add(card65);
                list.add(card66);

                list.add(card67);
                list.add(card68);
                list.add(card69);

                list.add(card70);
                list.add(card71);
                list.add(card72);

                list.add(card73);
                list.add(card74);
                list.add(card75);

                list.add(card76);
                list.add(card77);
                list.add(card78);

                list.add(card79);
                list.add(card80);
                list.add(card81);
                for (Cards c : list) {
                        numberOfCard = numberOfCard + 1;
                }
                return list;

        }
        public TreeSet<Cards> getTree(){
        	return this.pack;
        }
}