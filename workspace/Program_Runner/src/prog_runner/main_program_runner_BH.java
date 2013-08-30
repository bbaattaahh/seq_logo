package prog_runner;

/*
 * Aprogram arra szolgál, hogy meghíja a logó szerkesztős sokször egy előre meghatározott fileból!*/

import java.io.File;
import java.util.ArrayList;

public class main_program_runner_BH {

	/**
	 * @param args
	 */
	   public static void main(String []args) throws Exception
	    {
		   
		   ArrayList<File> file_puffer=new ArrayList<File>();
		   String save_folder="",run_program="", input_folder="", other_commands="", file_type="";
		   Integer i=0;
		   
		 	for (String s: args) {
		        if (s.equals("-help")){System.out.print("Még nincs help!!"); System.exit(0);}
		        if (s.equals("-run_program"))  {run_program=args[i+1];}
		        if (s.equals("-input_folder"))  {input_folder=args[i+1];}
		        if (s.equals("-file"))  {}
		        if (s.equals("-save_folder")) {save_folder=args[i+1];}     //???? Ezt hogyan.
		        if (s.equals("-other_commands")) {other_commands =args[i+1];}
		        if (s.equals("-file_type")) {file_type =args[i+1];}
		        i++;
		 	}

		   
/*		 	if (file.equals("")) {
		 		System.out.println("ERROR: '-file' always required");//??? Ez kell??
		 		System.exit(1);
		 	}
	*/	 	
		 	if (run_program.equals("")) {
		 		System.out.println("ERROR: '-run_program' always required");
		 		System.exit(2);
		 	}
		 	
		 	if (input_folder.equals("")) {
		 		System.out.println("ERROR: '-input_folder' always required");
		 		System.exit(3);
		 	}
		 	
           file_type="w";//El van barmolva ez a rész
		 	
		   File folder = new File(input_folder);
		   File[] listOfFiles = folder.listFiles();
		   int hossz=listOfFiles.length;
				   
		   if (!file_type.equals("")){
			   for(i=0; i<listOfFiles.length; i++){
				   if (listOfFiles[i].getName().matches("_micro_RNA_vs_degradome.txt")){
					   file_puffer.add(listOfFiles[i]);
				   }
				   listOfFiles[i]=null;
			   }
			   
			   for(i=0; i<file_puffer.size(); i++){
				   listOfFiles[i]=file_puffer.get(i);
				 
			   }
			   hossz=file_puffer.size();
		   }
		   

		   
		       for (i = 0; i < hossz; i++) {
		         if (listOfFiles[i].isFile()) {
		           System.out.println("File " + listOfFiles[i].getName());
		         } else if (listOfFiles[i].isDirectory()) {
		           System.out.println("Directory " + listOfFiles[i].getName());
		         }
		       }
		   
		   
		       System.out.println("Itt avgyok");       
		       
	  for (i = 0; i < hossz; i++) {
		  
		    String which_file=input_folder+"/"+listOfFiles[i].getName();//which_file ebben van eltárolva hogy a meghívott programnak mit kell meghívnia
		    //System.out.println(which_file+"       hohohoho      "+run_program);
		    System.out.println("java "+"-jar "+run_program+ " -file "+which_file);
		    Process ps=Runtime.getRuntime().exec(new String[]{"java","-Xmx5G","-jar",run_program, "-file",which_file});
            System.out.println("Lefutott egy!");       

            do {}
            while(ps.waitFor()!=0);
            
 	        java.io.InputStream is=ps.getInputStream();
	        byte b[]=new byte[is.available()];
	        is.read(b,0,b.length);
	        System.out.println(new String(b));
	        
	  }    
	 
	  }		// TODO Auto-generated method stub

		
		
	}


