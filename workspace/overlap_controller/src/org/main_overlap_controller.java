package org;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class main_overlap_controller {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		BufferedReader bf;
		Integer i=0,j,counter=0,counter_orig=0;
		String save,line,file_controll="/home/henrik/micro_RNA_VS_degradome/control/bti_germ_degradome.tab";
		String file_Overlapped="/home/henrik/micro_RNA_VS_degradome/bti_germ_Overlapped.txt";
		bf = new BufferedReader(new FileReader(file_controll));
		System.out.println("Anyádat");
		input_line_breaker Breaker=new input_line_breaker();
		ArrayList <String> str_t =new ArrayList <String>();
		ArrayList <String> str_t2 =new ArrayList <String>();
		ArrayList <String> controll_mRNA =new ArrayList <String>();
		ArrayList <Integer> controll_CutPoz=new ArrayList <Integer>();
		ArrayList <String> My_mRNA =new ArrayList <String>();
		ArrayList<Integer> My_StartCutPoz=new ArrayList <Integer>();
		ArrayList<Integer> My_EndCutPoz=new ArrayList <Integer>();
		help h=new help();
		
		
//-----------------------Argomentumok lekezelése----------------------------
		
	 	for (String s: args) {
	        if (s.equals("-help")){h.print_help(); System.exit(0);}
	        if (s.equals("-file_controll"))  {file_controll=args[i+1];}
	        if (s.equals("-file_Overlapped"))  {file_Overlapped=args[i+1];}
	        if (s.equals("-save"))  {save =args[i+1];}
	        i++;
	 	}
	 	
        //file="/home/henrik/micro_RNA_VS_degradome/root1_micro_RNA_vs_degradome.txt";
	 	
	 	if (file_controll.equals("")) {
	 		System.out.println("ERROR: '-file_controll' always required");
	 		System.exit(1);
	 	}

	 	if (file_Overlapped.equals("")) {
	 		System.out.println("ERROR: '-file_Overlapped' always required");
	 		System.exit(1);
	 	}

	 	
/*	 	if (save.equals("")) {
	        save=file_Overlapped.replace("_micro_RNA_vs_degradome.txt", "_peaks_degradome.txt");
	 	}

*/	 	
		
		
		
		
//-------------Controll file beolvasása és elmentése---------------------------------------		
		
		
		bf = new BufferedReader(new FileReader(file_controll));
				
		while( ( line = bf.readLine()) != null){
			str_t=Breaker.braker(line, '\t');

			if (str_t.get(3).matches("0")) {
				System.out.println(str_t);
				str_t2=Breaker.braker(str_t.get(0), ' ');
				controll_mRNA.add(str_t2.get(0));
				controll_CutPoz.add(Integer.parseInt(str_t.get(1)));
				counter_orig++;
			}
			
			
		}
		
		bf.close();
		System.out.println(controll_CutPoz);
		System.out.println(controll_mRNA);
		

		
//-------------Általam kreaélt file beolvasása és elmentése---------------------				
		
		bf = new BufferedReader(new FileReader(file_Overlapped));
		
		while( ( line = bf.readLine()) != null){
			str_t=Breaker.braker(line, ' ');
			My_mRNA.add(str_t.get(0));
			My_StartCutPoz.add(Integer.parseInt(str_t.get(2)));
			My_EndCutPoz.add(Integer.parseInt(str_t.get(3)));
		}
		bf.close();
		
        //System.out.println(My_EndCutPoz);
 
		
//-------------Egyezések megkeresése és kiiratása  képernyőre---------------------				
        
        for (i=0; i<controll_mRNA.size(); i++){
            for (j=0; j<My_mRNA.size(); j++){
            	if (controll_mRNA.get(i).equals(My_mRNA.get(j))){
            		if (My_StartCutPoz.get(j)<=controll_CutPoz.get(i) && My_EndCutPoz.get(j)>=controll_CutPoz.get(i)){
            			counter++;
            			System.out.println(controll_mRNA.get(i)+" "+My_StartCutPoz.get(j)+" "+My_EndCutPoz.get(j)+" "+controll_CutPoz.get(i) );
            		}
            	}
            }
            	System.out.println(controll_mRNA.get(i));
        }
        
        System.out.println(counter_orig+"  "+counter);
        
	}

}
