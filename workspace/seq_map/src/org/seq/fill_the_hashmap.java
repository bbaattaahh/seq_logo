package org.seq;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class fill_the_hashmap {





@SuppressWarnings("resource")
public HashMap<Character, ArrayList<Integer>> fill_the_matrix (String filename, Integer n, Integer counter) throws IOException{
    
    	ArrayList<Integer> t; 
    	HashMap<Character, ArrayList<Integer>> hash = new HashMap<Character, ArrayList<Integer>>();
    	
    	
    	BufferedReader br=null;
    	
    	      
    	try{
    		br = new BufferedReader(new FileReader(filename));
    	}
        catch (IOException e) {
           System.err.println("Error: " + e);
           System.out.println("Do not exist filename!");
           System.exit(4);
        }
    	
		int i,j;
        String thisLine, thisLine_puffer="START";
        
        
        
        	if (br.ready()==false) {
        		System.out.println("Empty input file!");
        		System.exit(2);
        	}
        
        
        
        while ((thisLine = br.readLine()) != null) { // while loop begins here
          n=thisLine.length();
          if (!(thisLine_puffer.equals("START"))) {
        	  if (thisLine.length()!=thisLine_puffer.length()){
        	    	System.out.println("Not good input file, not costatn line length!");
        	    	System.exit(1);
        	  }
          }
          counter=counter+1;
          for(i=0; i<thisLine.length(); i++){
        	  if(thisLine.charAt(i)<'A' || thisLine.charAt(i)>'Z'){
        		System.out.println("Invalis caharcter! You can use just latin capital letters");
      	    	System.exit(3);                 		  
        	  }
        	  
        	  if(hash.containsKey(thisLine.charAt(i))){
        		  t=hash.get(thisLine.charAt(i));
            	  t.set(i, t.get(i)+1);
        	  }
        	  else{
        		  t = new ArrayList<Integer>();
        		  for( j = 0; j < thisLine.length(); j++){
        			  if(j == i){
        				  t.add(1);
        			  }
        			  else{
        				  t.add(0);
        			  }
        		  }
        		  hash.put(thisLine.charAt(i),t);
        	  }
        	  
        	  if (hash.containsKey(thisLine.charAt(i))) {hash.put(thisLine.charAt(i), t);}
        	  thisLine_puffer=thisLine;
          }
        } // end while

        
      return hash;
    
   
	
}	
	





public int get_n (String filename, Integer n, Integer counter) throws IOException{
    
	ArrayList<Integer> t; 
	HashMap<Character, ArrayList<Integer>> hash = new HashMap<Character, ArrayList<Integer>>();
    BufferedReader br = new BufferedReader(new FileReader(filename));
	int i,j;
    String thisLine;

    while ((thisLine = br.readLine()) != null) { // while loop begins here
      n=thisLine.length();
      counter=counter+1;
      for(i=0; i<thisLine.length(); i++){
    	  if(hash.containsKey(thisLine.charAt(i))){
    		  t=hash.get(thisLine.charAt(i));
        	  t.set(i, t.get(i)+1);
    	  }
    	  else{
    		  t = new ArrayList<Integer>();
    		  for( j = 0; j < thisLine.length(); j++){
    			  if(j == i){
    				  t.add(1);
    			  }
    			  else{
    				  t.add(0);
    			  }
    		  }
    		  hash.put(thisLine.charAt(i),t);
    	  }
    	  
    	  if (hash.containsKey(thisLine.charAt(i))) {hash.put(thisLine.charAt(i), t);}
      }
    } // end while
    
  return n;



}		
	
	
public int get_counter (String filename, Integer n, Integer counter) throws IOException{
    
	ArrayList<Integer> t; 
	HashMap<Character, ArrayList<Integer>> hash = new HashMap<Character, ArrayList<Integer>>();
    BufferedReader br = new BufferedReader(new FileReader(filename));
	int i,j;
    String thisLine;

    while ((thisLine = br.readLine()) != null) { // while loop begins here
      n=thisLine.length();
      counter=counter+1;
      for(i=0; i<thisLine.length(); i++){
    	  if(hash.containsKey(thisLine.charAt(i))){
    		  t=hash.get(thisLine.charAt(i));
        	  t.set(i, t.get(i)+1);
    	  }
    	  else{
    		  t = new ArrayList<Integer>();
    		  for( j = 0; j < thisLine.length(); j++){
    			  if(j == i){
    				  t.add(1);
    			  }
    			  else{
    				  t.add(0);
    			  }
    		  }
    		  hash.put(thisLine.charAt(i),t);
    	  }
    	  
    	  if (hash.containsKey(thisLine.charAt(i))) {hash.put(thisLine.charAt(i), t);}
      }
    } // end while
    
  return counter;

}		
	
	
public boolean is_the_hashmap_good (HashMap<Character, ArrayList<Integer>> hash) throws IOException{
    
	int i=0,j=0;
	
	for(Character key1: hash.keySet()){
		j=hash.get(key1).size();
		break;
	}

	System.out.println(j);
	System.out.println("Jött a j");
	
	
	for(Character key: hash.keySet()){
		i=hash.get(key).size();
		System.out.println(i);
		System.out.println("Jön az i");
		if (i!=j) {System.out.println(i); return false;}
    	
   	} 
	
    return true;

}			
	
}
