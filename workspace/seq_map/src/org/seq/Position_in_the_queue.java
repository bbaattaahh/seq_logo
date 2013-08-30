package org.seq;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

public class Position_in_the_queue {
 
  public ArrayList<Character> next_letter(HashMap<Character, ArrayList<Integer>> hash, Integer column){
	  
	  /*Ez a függvény visszadja a hashmap key-eket egy karakter tombben. A karakterek pedig az oszlopben
	   * előfordulásuk gyakorisága szerint vannak csökkenő sorredbe rakva. 
	   * Ha ugyan olyan gyakran fordulnak elő, akkor ABC dönt!  */
	  
	  
	  Integer i,j=0,puffer;
	  Character c_puffer;
	  ArrayList<Character>c_tomb= new ArrayList<Character>();
	  ArrayList<Integer>i_tomb= new ArrayList<Integer>();
	 
	  for(Character key: hash.keySet()){
		  c_tomb.add(key);
		  i_tomb.add(hash.get(key).get(column));
	  }
	  
	  for(i=0; i<hash.size(); i++){
		  for (j=1; j<hash.size()-i; j++){
			  if ( i_tomb.get(j-1)<i_tomb.get(j)  || (i_tomb.get(j-1)==i_tomb.get(j) && c_tomb.get(j-1)<c_tomb.get(j))) {
				 puffer= i_tomb.get(j-1);
				 i_tomb.set(j-1, i_tomb.get(j));
				 i_tomb.set(j, puffer);

				 c_puffer= c_tomb.get(j-1);
				 c_tomb.set(j-1, c_tomb.get(j));
				 c_tomb.set(j, c_puffer);

			  }
		  }
	  }
	  
	  return c_tomb;
  } 	

  
  
  
  
  
  
  public HashMap<Character, Color> organized_by_alphabet(HashMap<Character, ArrayList<Integer>> hash, ArrayList<Color> letter_colors){
	  
	  /*Olyna hashMap-ot ad  vissza amelyekben a szinek hozzá vannak már rendelve az egyes szinekhez. 
	   * A betűk kirajzoltatásához kell!!
	   * Ha kevesebb színt adott meg a felhasználó, mint ahány betű van szakvenciában akkor előről kezdi a 
	   * szín hozzárendelést.   
	   * */
	  
	  HashMap<Character, Color> paired_letters_colors =new HashMap<Character, Color>();
	  ArrayList<Character> c=new ArrayList<Character>(); 
	  Character c_puffer;
	  Integer i,j;
	  
	  for(Character key: hash.keySet()){c.add(key);}
	  
	  System.out.println(c);
	  
	  for(i=0; i<hash.size(); i++){
		  for (j=1; j<hash.size()-i; j++){
			  if ( c.get(j-1)>c.get(j)) {
				 c_puffer= c.get(j-1);
				 c.set(j-1, c.get(j));
				 c.set(j, c_puffer);
			  }
		  }
	  }


	  for (i=0; i < hash.size(); i++){
		  paired_letters_colors.put(c.get(i), letter_colors.get(i % letter_colors.size()));
	  }

	  return paired_letters_colors;
	  
	  
  }
  
}
