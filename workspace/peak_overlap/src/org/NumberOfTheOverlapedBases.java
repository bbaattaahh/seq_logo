package org;

public class NumberOfTheOverlapedBases {
	
	public int NumberOfTheOverlapedBases (Integer a, Integer b,Integer c,Integer d){

		Integer counter=0,i;
		
		if (a>b || c>d) {
			System.out.println("ERROR: Wring input data to one_or_two_end_pont_in_the_other_section!\nRequired: a<=b  c<=d!!");
			return -1;
		}
		
		for (i=a; i<=b; i++){
			if (i>=c && i<=d) counter++;
		}
		
		
       
	    return counter;
	}
	

	
	
	
	public int OverlapStart (Integer a, Integer b,Integer c,Integer d){

		Integer i;
		
		for (i=a; i<=b; i++){
			if (i>=c && i<=d) return i; 
    	}

		return -1;
	}

	
	
	public int OverlapEnd (Integer a, Integer b,Integer c,Integer d){

		Integer i, last = -1;
		
		for (i=a; i<=b; i++){
			if (i>=c && i<=d) last=i;
    	}

		return last;
	}
	
	

}
