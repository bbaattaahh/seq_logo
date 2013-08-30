package org_paresnipe_input;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;



public class main_peresnip_input {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf;
		Integer i=0,input_type=1,counter=0;
		String line;
		String file="/home/henrik/paresnipinput/GSM278370-4061.txt";
		String save="/home/henrik/paresnipinput/GSM278370-4061_paresnip_input.fasta";
		bf = new BufferedReader(new FileReader(file));
		input_line_breaker Breaker=new input_line_breaker();
		ArrayList <String> str_t =new ArrayList <String>();
		help h=new help();

//-------------Argumentumok lekezelése-----------------------------------------------------
		
	 	for (String s: args) {
	        if (s.equals("-help")){h.print_help(); System.exit(0);}
	        if (s.equals("-file")) {file=args[i+1];}
	        if (s.equals("-save")) {save=args[i+1];} 

	        i++;
	 	}
	 	
	 	
	 	
		
		
		bf = new BufferedReader(new FileReader(file));
		BufferedWriter out = new BufferedWriter(new FileWriter(save));
		
		if (input_type==0){
			while( ( line = bf.readLine()) != null){
				str_t=Breaker.braker(line, '\t');

				for (i=0; i<Integer.parseInt(str_t.get(1)); i++){
					out.write(">"+counter+"\n");
					out.write(str_t.get(0)+"\n");
					counter++;
				}
			
			}	
		}

		
		
		if (input_type==1){
			while( ( line = bf.readLine()) != null){
				line = bf.readLine();
				str_t=Breaker.braker(line, '\t');

				  Random randomGenerator = new Random();
			      int randomInt = randomGenerator.nextInt(10);
				  randomInt++;
			      System.out.println(randomInt);
				
				for (i=0; i<randomInt; i++){
					counter++;
					out.write(">"+counter+"\n");
					out.write(line+"\n");
				}
			
			}	
		}

		
		bf.close();
	 	out.close();
	 	System.out.println("Your winner!");
	 	
		
	}

}
