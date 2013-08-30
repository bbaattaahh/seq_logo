package org;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class pozition_in_external_txt_file_HM {

	@SuppressWarnings("resource")
	public HashMap<String, ArrayList<Integer>> get_pozitions(String file) throws IOException{
		
		HashMap<String, ArrayList<Integer>> t=new HashMap<String, ArrayList<Integer>>();
		ArrayList<Integer> nt;
		
		Integer counter=0,m=0,i;
		String s1="",s2="",s3="",line;
		
		BufferedReader bf;
		bf = new BufferedReader(new FileReader(file));
		
		while( ( line = bf.readLine()) != null){
             
			
			
			m=1;	
            
			s1="";
			s2="";
			s3="";
			//System.out.println(s1+s2+s3+s4);
			for (i=0; i<line.length(); i++){
				if (line.charAt(i)==' ') {m++; i++; if (i==line.length()) break; }
				if (m==1) {s1=s1+line.charAt(i);}
				if (m==2) {s2=s2+line.charAt(i);}
				if (m==3) {s3=s3+line.charAt(i);}

			}

			if (!t.containsKey(s1)) {
				//System.out.println(s1+"  "+s2+"   "+s3);
				nt=new ArrayList<Integer>();
				nt.add(Integer.parseInt(s2));
				t.put(s1, nt);
				}
			else {
				//nt=new ArrayList<Integer>();
                nt=t.get(s1);
                nt.add(Integer.parseInt(s2));
                t.put(s1, nt);
			}
			
			
            counter++;

			
			if (counter % 100000==0) System.out.println(counter);

			
			
		}

		System.out.println("Vége egynek     "+t.get("comp57940_c0_seq1"));
		
		return t;
	}

	
	

	
	
	public HashMap<String, ArrayList<Integer>> telescope_the_int_arrays(HashMap<String, ArrayList<Integer>> input_t) throws IOException{
	
		/*
		 * Ez programrészlet arra jó, hogy a hash map-ban lévő pozíciókat összenyomja
		 * pl. hash mapban van: KEY [20,21,22,23,24,25,26,40,41,42,43]
		 * ebből csinél:        KEY [20,26,40,43]
		 * 
		 * Ebből adódóan mindig páros számú elemet tartalmaz a hash mapban a string-hez tartozó ArrayList<Integer>*/
		
		HashMap<String, ArrayList<Integer>> t=new HashMap<String, ArrayList<Integer>>();
		ArrayList<Integer> nt;
		Integer i;
		
		for(String key: input_t.keySet()){
			nt=new ArrayList<Integer>();
			for (i=0; i<input_t.get(key).size()-1; i++){
        	   if (i==0) nt.add(input_t.get(key).get(0));     //????TIBIIIIIIIIIIII Itt lehetnek platóban egybe lapoló csócsok??? Kell figyelni az intenzitásra?
        	   if (input_t.get(key).get(i)!=input_t.get(key).get(i+1)-1) {
        		   nt.add(input_t.get(key).get(i));
        		   nt.add(input_t.get(key).get(i+1));
        	   }
            }

			nt.add(input_t.get(key).get(input_t.get(key).size()-1));
			t.put(key, nt);
		}
		
		return t;
	}
	
	
	
	
}
