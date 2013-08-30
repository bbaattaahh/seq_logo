package org;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class main_WhereIsThePoo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		
//------------VÁLTOZÓK-----------------------------------------------------
		
		BufferedReader bf;
		Integer i=0,j,counter=0,counter_orig=0;
		String line,file_controll="/home/henrik/micro_RNA_VS_degradome/control/bti_germ_degradome.tab";
		String file_micro_RNA_VS_degradome="/home/henrik/micro_RNA_VS_degradome/bti_germ_micro_RNA_vs_degradome.txt";
		String save="/home/henrik/micro_RNA_VS_degradome/bti_germ_WhereIsThePoo.txt";
		bf = new BufferedReader(new FileReader(file_controll));
		input_line_breaker Breaker=new input_line_breaker();
		ArrayList <String> str_t =new ArrayList <String>();
		ArrayList <String> str_t2 =new ArrayList <String>();
		ArrayList <String> controll_mRNA =new ArrayList <String>();
		ArrayList <Integer> controll_CutPoz=new ArrayList <Integer>();

		help h=new help();

//-------------Argumentumok lekezelése-----------------------------------------------------
		
	 	for (String s: args) {
	        if (s.equals("-help")){h.print_help(); System.exit(0);}
	        if (s.equals("-file_controll")) {file_controll=args[i+1];}
	        if (s.equals("-file_micro_RNA_vs_degradome")) {file_micro_RNA_VS_degradome=args[i+1];}
	        if (s.equals("-save")) {save=args[i+1];} 

	        i++;
	 	}
	 	
	 	
	 	if (file_controll.equals("")) {
	 		System.out.println("ERROR: '-file_controll' always required");
	 		System.exit(1);
	 	}

	 	if (file_micro_RNA_VS_degradome.equals("")) {
	 		System.out.println("ERROR: '-file_micro_RNA_vs_degradome' always required");
	 		System.exit(1);
	 	}
	 	
	 	if (save.equals("")) {
	 		save=file_micro_RNA_VS_degradome.replaceFirst("_micro_RNA_vs_degradome.txt", "_WhereIsThePoo.txt");
	 	}
	 	
	 	
	 	
		
		
//-------------Controll file beolvasása és elmentése---------------------------------------		
		
		bf = new BufferedReader(new FileReader(file_controll));
		
		while( ( line = bf.readLine()) != null){
			str_t=Breaker.braker(line, '\t');

			if (str_t.get(3).matches("0")) {
				//System.out.println(str_t);
				str_t2=Breaker.braker(str_t.get(0), ' ');
				controll_mRNA.add(str_t2.get(0));
				controll_CutPoz.add(Integer.parseInt(str_t.get(1)));
				counter_orig++;
			}
			
			
		}
		
		bf.close();
		//System.out.println(controll_CutPoz);
		//System.out.println(controll_mRNA);
		
		System.out.println("Anyádat");
		
//----------------------------'_micro_RNA_VS_degradome' fájlok beolvasása------------------------------------		

		
		bf = new BufferedReader(new FileReader(file_micro_RNA_VS_degradome));
		BufferedWriter out = new BufferedWriter(new FileWriter(save));
		
		while( (line = bf.readLine()) != null){      //Ebben a részben soronként megyünk végig az input filon

			str_t=Breaker.braker(line, ' ');
			
			for (i=0; i<controll_mRNA.size(); i++){
			  if (str_t.get(0).equals(controll_mRNA.get(i)) && controll_CutPoz.get(i)==Integer.parseInt(str_t.get(1))){
				  System.out.println(controll_mRNA.get(i)+" "+controll_CutPoz.get(i)+" "+str_t.get(2)+" "+str_t.get(3));
                  out.write(controll_mRNA.get(i)+" "+controll_CutPoz.get(i)+" "+str_t.get(2)+" "+str_t.get(3)+"\n");
			  }	
			}
			
			
		}
				
		
		
		
		bf.close();

		
//------------------Eredmények kiíratása külső fileba-----------------------------------		
	}

}
