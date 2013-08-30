package org_TurnOff;

public class time_disassemble {

	public int hour(String time){
		
		String p=""; //puffer
		Integer i;
		
		for (i=0; i<time.length(); i++){
			if (time.charAt(i)!=':'){
				p=p+time.charAt(i);
			}else{
				break;
			}
		}
         		
				
		return Integer.parseInt(p); 
	} 
	

	public int minute(String time){
		
		String p=""; //puffer
		Integer i,m=0;
		
		for (i=0; i<time.length(); i++){
			if (time.charAt(i)!=':'){m++;}
			if (m==1){p=p+time.charAt(i);
			if (m==2) {break;}
			}
		}
         		
				
		return Integer.parseInt(p); 
	} 


	public int secundum(String time){
		
		String p=""; //puffer
		Integer i,m=0;
		
		for (i=0; i<time.length(); i++){
			if (time.charAt(i)!=':'){m++;}
			if (m==2){p=p+time.charAt(i);
			if (m==3) {break;}
			}
		}
         		
				
		return Integer.parseInt(p); 
	} 

	
	
}
