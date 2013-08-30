package org;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class main_peak_overlap {

	/**
	 * @param args
	 * @throws IOException 
	 */
	@SuppressWarnings({ })
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		String file_degradome="", file_micro_RNA="",file_begin="",save="";                                    //"/home/henrik/micro_RNA_VS_degradome/teszt_peaks.txt";
		Integer j,i=0,lapped_bases,OverlapStart,OverlapEnd;                                           
		HashMap<String, ArrayList<Integer>> HM_degradome=new HashMap<String, ArrayList<Integer>>();
		HashMap<String, ArrayList<Integer>> HM_micro_RNA=new HashMap<String, ArrayList<Integer>>();
		pozition_in_external_txt_file_HM HM_maker = new pozition_in_external_txt_file_HM();
		NumberOfTheOverlapedBases ST=new NumberOfTheOverlapedBases();
		help h = new help();
		
	 	//file_degradome="/home/henrik/micro_RNA_VS_degradome/bti_germ_peaks_degradome.txt";
	 	//file_micro_RNA="/home/henrik/micro_RNA_VS_degradome/bti_germ_peaks_micro_RNA.txt";
		
	 	for (String s: args) {
	        if (s.equals("-help")){h.help_printer(); System.exit(0);}
	        if (s.equals("-file_degradome"))  {file_degradome=args[i+1];}
	        if (s.equals("-file_micro_RNA"))  {file_micro_RNA=args[i+1];}
	        if (s.equals("-file_begin"))  {file_begin=args[i+1];}   //ez a cucc benne maradt nem tudom, hogy mi van ha kiszedem a hozzá kapcsolódó részeke, így működik 
	        if (s.equals("-save"))  {save=args[i+1];}
	        i++;
	 	}
	 	
	 	//!!!!!!!!!!!!!!!!!!!!!!???????????hogy hogy kell megadni a bemenő fájlok neveit ezt még körül kell hjárni HENRIK ÚR  
	 	

	 	if (file_begin.equals("") && (file_degradome.equals("") && file_micro_RNA.equals(""))) {
	 		System.out.println("ERROR: ['-file_begin'] or ['-file_degradome' and '-file_micro_RAN'] always required");
	 		System.exit(1);
	 	}
	 	

	 	if ((file_degradome.equals("")  || file_micro_RNA.equals(""))&& !(file_degradome.equals("")  && file_micro_RNA.equals(""))){
	 		System.out.println("ERROR: ['-file_begin'] or ['-file_degradome' and '-file_micro_RAN'] always required");
	 		System.exit(1);
	 	}

	 	
	 	
	 	
	 	if (!file_begin.equals("")) {
		 	file_degradome=file_begin+"_peaks_degradome.txt";
		 	file_micro_RNA=file_begin+"_peaks_micro_RNA.txt";
	 	}
	 
	 	
	 	//file_degradome="/home/henrik/micro_RNA_VS_degradome/bti_germ_peaks_degradome.txt";
	 	//file_micro_RNA="/home/henrik/micro_RNA_VS_degradome/bti_germ_peaks_micro_RNA.txt";
	 	
	 	if (save.equals("")) {
	 		if (file_begin.equals("")) {
	 			save=file_degradome.replace("_peaks_degradome.txt", "_Overlapped.txt");
	 		}else
	 		{
	 			save=file_begin+"_Overlapped.txt";
	 		}
	 	}
        //save= "/home/henrik/micro_RNA_VS_degradome/bti_germ_Overlapped.txt";

	 	BufferedWriter out = new BufferedWriter(new FileWriter(save));
	 	
	 	
    	HM_degradome=HM_maker.get_pozitions(file_degradome);
	 	HM_micro_RNA=HM_maker.get_pozitions(file_micro_RNA);
	 	
	 	System.out.println("Első kiiratás    "+HM_degradome.get("comp57940_c0_seq1"));
	 	
	 	HM_degradome=HM_maker.telescope_the_int_arrays(HM_degradome);
	 	HM_micro_RNA=HM_maker.telescope_the_int_arrays(HM_micro_RNA);
	 	
	 	System.out.println("JÓZSI  "+HM_degradome.get("comp57940_c0_seq1"));
	 	System.out.println("JÓZSI  "+HM_micro_RNA.get("comp57940_c0_seq1"));

	 	
	 	System.out.println(ST.NumberOfTheOverlapedBases(20, 50, 2, 20));
		
	 	for(String key: HM_degradome.keySet()){
			if (HM_micro_RNA.containsKey(key)){
				for (i=0; i<HM_degradome.get(key).size()-1; i=i+2){
					for (j=0; j<HM_micro_RNA.get(key).size()-1; j=j+2){
                        lapped_bases=ST.NumberOfTheOverlapedBases(HM_degradome.get(key).get(i),HM_degradome.get(key).get(i+1),HM_micro_RNA.get(key).get(j),HM_micro_RNA.get(key).get(j+1));
     					if (lapped_bases>0){
     						OverlapStart=ST.OverlapStart(HM_degradome.get(key).get(i),HM_degradome.get(key).get(i+1),HM_micro_RNA.get(key).get(j),HM_micro_RNA.get(key).get(j+1));
     						OverlapEnd=ST.OverlapEnd(HM_degradome.get(key).get(i),HM_degradome.get(key).get(i+1),HM_micro_RNA.get(key).get(j),HM_micro_RNA.get(key).get(j+1));
                            out.write(key+" "+lapped_bases+" "+OverlapStart+" "+OverlapEnd+"\n");
     						System.out.println(key+" "+lapped_bases+" "+OverlapStart+" "+OverlapEnd);
                       }
                    }
				}
			}
		}
	 	
	 	out.close();

		}
		
		
		
	}


