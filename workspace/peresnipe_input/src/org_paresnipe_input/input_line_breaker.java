package org_paresnipe_input;

import java.util.ArrayList;

public class input_line_breaker {
	
	public ArrayList<String> braker(String line, Character BreakChar){
		/*
		 * Bejövő sztinget eltördel a törő karakternél
		 * String ArrayList-ban adja vissza a sor szavait.
		 *
		 **/
		
		
		ArrayList<String> t=new ArrayList<String>();
		String puffer="";
		Integer i; 
		
		for (i=0; i<line.length(); i++){
			if (line.charAt(i)==BreakChar) {
				t.add(puffer);
				puffer="";
			}
			else{
			    puffer=puffer+line.charAt(i);
			}
		} 
		
		t.add(puffer);
		
		
		return t;
		
	}
	

}
