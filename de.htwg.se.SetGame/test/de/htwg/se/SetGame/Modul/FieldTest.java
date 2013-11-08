package de.htwg.se.SetGame.Modul;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FieldTest {
	Field f;

	@Before
	public void setUp() {
		this.f = new Field();

	}

	@Test
	public void test() {

	}

	@Test
	public void testFieldradom() {
		int array[] = f.rand();
		// int numberofArray = 0;
		// for(int i = 0; i < array.length;i++){
		// for(int t = 0 ; t < array.length;t++){
		// if(t == array[i]){
		// System.out.println(i+"  number: "+t + " in index: "+i);
		// numberofArray++;
		//
		// }
		//
		// }
		//
		// }
		// if(numberofArray == array.length){
		// System.out.println("true");
		// }else{
		// System.out.println("false!! \n numberofarray = "+numberofArray+"\narray length:  "+
		// array.length );
		// }
		//
		//

		boolean vertauscht;
		for (int i = array.length - 1; i >= 0; i--) {
			vertauscht = false;
			// Durchlauf des Felds von 0 bis i:
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
		for(int i = 0 ; i < array.length; i++){
			System.out.println("array["+i+"] = "+array[i]);
		}

	}

}
