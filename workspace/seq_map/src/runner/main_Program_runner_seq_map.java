package runner;

/*
 * Aprogram arra szolgál, hogy meghíja a logó szerkesztős sokször egy előre meghatározott fileból!*/

import java.io.File;

public class main_Program_runner_seq_map {

	/**
	 * @param args
	 */
	   public static void main(String []args) throws Exception
	    {
		   String s;
		   File folder = new File("/home/henrik/Feltoltes/seqlogo");
		   File[] listOfFiles = folder.listFiles();

		       for (int i = 0; i < listOfFiles.length; i++) {
		         if (listOfFiles[i].isFile()) {
		           System.out.println("File " + listOfFiles[i].getName());
		         } else if (listOfFiles[i].isDirectory()) {
		           System.out.println("Directory " + listOfFiles[i].getName());
		         }
		       }
		   
		   
	  for (int i = 0; i < listOfFiles.length; i++) {
		    s="/home/henrik/Feltoltes/seqlogo/"+listOfFiles[i].getName();
	        Process ps=Runtime.getRuntime().exec(new String[]{"java","-jar","/home/henrik/ize.jar", "-file",s});
	        ps.waitFor();
	        java.io.InputStream is=ps.getInputStream();
	        byte b[]=new byte[is.available()];
	        is.read(b,0,b.length);
	        System.out.println(new String(b));
	        
	  }    
	 
	  }		// TODO Auto-generated method stub

		
		
	}


