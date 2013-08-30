package org_TurnOff;

import java.io.IOException;

public class TurnOffTheComputer {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main_TurnOff(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		/*Henrik bátyó saját gép kikapcsoló programja*/
		
//-----------------VÁLTOZÓK-------------------------		
		
		Integer sleepSeconds=10,i=0,h,m,sec;
		String shutdownCommand,time="00:00:00";
	    String operatingSystem = System.getProperty("os.name");
        help help=new help();
	    time_disassemble t=new time_disassemble(); 
	    
//----------Argumentumok lekezelése-------------
	 	for (String s: args) {
	        if (s.equals("-help")){help.help_printer(); System.exit(0);}
	        if (s.equals("-time")) {time =args[i+1];}
	        i++;
	 	}
	    
		if (time=="00:00:00") {
	 		System.out.println("'-tiem' is always existed!"); 
	 	    System.exit(1);
	 	    } 
	    
//----------------Megadott idő kezelése----------	    
	    
	 	h=t.hour(time);
	 	m=t.minute(time);
	 	sec=t.secundum(time);

	 	sleepSeconds=h*3600+m*60+sec;
	 	
//----------Alvás-----------------------------------------
	    Thread.sleep(sleepSeconds);
//-----------Kikaopcsolás--------------------------------
	 	
	 	
	    if ("Linux".equals(operatingSystem) || "Mac OS X".equals(operatingSystem)) {
	        shutdownCommand = "shutdown -h now";
	    }
	    else if ("Windows".equals(operatingSystem)) {
	        shutdownCommand = "shutdown.exe -s -t 0";
	    }
	    else {
	        throw new RuntimeException("Unsupported operating system.");
	    }

	    Runtime.getRuntime().exec(shutdownCommand);
	    System.exit(0);

	}

}
