package org.mbk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Proba elso    = new Proba();
		Proba masodik = new Proba();
		ArrayList<Double> tomb = new ArrayList<Double>();
		HashMap<String, Proba> hash = new HashMap<String, Proba>();
		String szoveg = "hello";
		String txt = "hello";
		StringBuilder buffer = new StringBuilder();
		buffer.toString();
		elso.a = 20;
		elso.inc();
		elso.inc();
		elso.showCounter();
		masodik.showCounter();
		if(szoveg ==  txt){
			System.out.println("Equals");
		}
		else{
			System.out.println("Not equal");
		}
		System.out.println(szoveg);
		
		tomb.add(23.43);
		tomb.add(12.23);
		for(int i = 0; i < tomb.size()+10; i++){
			try{
				System.out.println("Value: " + tomb.get(i));
			}
			catch(IndexOutOfBoundsException e){
				System.out.println("Ouch");
			}
		}
		
      System.out.println("Hello word");
      try {
		scan olvaso = new scan("/home/henrik/Feltoltes/pmid/ki.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
