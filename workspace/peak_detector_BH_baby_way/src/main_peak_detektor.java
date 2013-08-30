import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class main_peak_detektor {
	
	/*
	 * Ez a program arra való hogy a  micro_RNA_VS_degradome.jar ból kijövő fájból kiszedegesse
	 * a degradomok, és micro RNA-sek csúcsait egy-egy külön txt filbe.
	 * A txt filokat kér külön blokk banhozza létre. Kicsit favágó lett elnézést!! Csak az első blokk lett komentelve 
	 * a msáodik ugyan az csak a változók mások
	 * 
	 * Bővebb infó a help-ben!!!    (-help))  */
   
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InterruptedException {
		
		BufferedReader bf;
		Boolean reduce=false;
		String s1="",s2="",s3="",s4="",file="",save_micro_RNA="", save_degradome="";//"/home/henrik/micro_RNA_VS_degradome/teszt_peaks.txt";
		Integer mode=0,i=0,m=1,counter=0;                                           //Az s1-s4 változókkla szedegetem ki az adatokat az input file-ból
		Double last_d=0.0,last_m=0.0;                                               //A save_... változókban vannak az output filok nevei.
		ArrayList<String>mRNA_Name=new ArrayList<String>();                         //Ezekben a dinamikus tömbökben tárolom az esetleges platókat!    
		ArrayList<Integer>mRNA_poz=new ArrayList<Integer>();                        //mode: ez mutatja meg hogy emelkedik vagy csökken a hupli!
		ArrayList<Double>norm_degradome=new ArrayList<Double>();
		ArrayList<Double>norm_micro_RNA=new ArrayList<Double>();
		help h = new help();
		//BufferedWriter out_m = new BufferedWriter(new FileWriter(save));	
		String line;
		
		
		
		
		
//-----------------------Argomentumok lekezelése----------------------------
		
	 	for (String s: args) {
	        if (s.equals("-help")){h.help_printer(); System.exit(0);}
	        if (s.equals("-file"))  {file=args[i+1];}
	        if (s.equals("-save_degradome"))  {save_degradome =args[i+1];}
	        if (s.equals("-save_micro_RNA"))  {save_micro_RNA =args[i+1];}
	        i++;
	 	}
	 	
        //file="/home/henrik/micro_RNA_VS_degradome/root1_micro_RNA_vs_degradome.txt";
	 	
	 	if (file.equals("")) {
	 		System.out.println("ERROR: '-file' always required");
	 		System.exit(1);
	 	}

		bf = new BufferedReader(new FileReader(file));

	 	
	 	if (save_degradome.equals("")) {
	        save_degradome=file.replace("_micro_RNA_vs_degradome.txt", "_peaks_degradome.txt");
	 	}
	 	
	 	if (save_micro_RNA.equals("")) {
	        save_micro_RNA=file.replace("_micro_RNA_vs_degradome.txt", "_peaks_micro_RNA.txt");
	 	}

	 	
	 	
	 	
		BufferedWriter out_d = new BufferedWriter(new FileWriter(save_degradome));	
		BufferedWriter out_m = new BufferedWriter(new FileWriter(save_micro_RNA));		 	
	 	
	 	
//----------------Degradom csúcsainak kiszedése--------------------		
		
		
		
	 	
		while( (line = bf.readLine()) != null){      //Ebben a részben soronként megyünk végig az input filon
			m=1;                                     //A benne lévő sorok space-szel vannak elválasztva
			s1="";                                   //Hogy melyik micsoda az a helpben! (-help)
			s2="";
			s3="";
			s4="";
			//System.out.println(s1+s2+s3+s4);
			for (i=0; i<line.length(); i++){
				if (line.charAt(i)==' ') {m++; i++; if (i==line.length()) break; }
				if (m==1) {s1=s1+line.charAt(i);}
				if (m==2) {s2=s2+line.charAt(i);}
				if (m==3) {s3=s3+line.charAt(i);}
				if (m==4) {s4=s4+line.charAt(i);}

			}
			
       
			mode=0;     //A mode változó mondja meg, hogy a függvényünk léppen növekszik e vagy csökken
			
			if (last_d.equals(Double.parseDouble(s3))){
				//System.out.println(counter+" Stagnál");
				mode=2;
			}
			
			
			if (last_d>Double.parseDouble(s3)) {
				//System.out.println(counter+" Csökken");
				mode=3;
			}
			
			
			if (last_d<Double.parseDouble(s3)){
				//System.out.println(counter+" Növekszik");
                mode=1;
			}
			
			counter++;
		
			                                                
			switch (mode){
			case 1: reduce=false;	                  //Attól függően hogy milyen módban van a függvényünk a szeroint teszi meg a program szükséges lépéseket
				                                      //A reducere azért vans szükség, hogy kiküszöböljük azt, hogy a csöökkenésnél  benne maradjanak a köztes részek
				    mRNA_Name.clear();
			        mRNA_poz.clear();
			        norm_degradome.clear();
			        
			        mRNA_Name.add(s1);
					mRNA_poz.add(Integer.parseInt(s2));
					norm_degradome.add(Double.parseDouble(s3));
			        break;
					
			case 2:	if (Double.parseDouble(s3)!=0.0){
				    	mRNA_Name.add(s1);
				    	mRNA_poz.add(Integer.parseInt(s2));
				    	norm_degradome.add(Double.parseDouble(s3));
			        }
			        break;
                    
			case 3: if (!reduce){
				    for(i=0; i<mRNA_Name.size(); i++){
				    		out_d.write(mRNA_Name.get(i)+" "+mRNA_poz.get(i)+" "+norm_degradome.get(i)+"\n");
			   	            out_d.flush();
			   	            //System.out.println(mRNA_Name.get(i)+" "+mRNA_poz.get(i)+" "+norm_degradome.get(i));  
		         	}
			        reduce=true;
	                mRNA_Name.clear();
	                mRNA_poz.clear();
	                norm_degradome.clear();
			        }
	                break;
	         
			default:  System.out.println("!!!Anyádat!!!");
	         
				    
			}
			
			last_d=Double.parseDouble(s3);
			
		
		}
	
		
//----------------Micro RNA-k csúcsainak kiszedése--------------------		
		
		
		counter=0;
		mRNA_Name.clear();
	    mRNA_poz.clear();
	    norm_degradome.clear();
		bf = new BufferedReader(new FileReader(file));
		reduce=false;
		
		
		while( (line = bf.readLine()) != null){
			m=1;
			s1="";
			s2="";
			s3="";
			s4="";
			//System.out.println(s1+s2+s3+s4);
			for (i=0; i<line.length(); i++){
				if (line.charAt(i)==' ') {m++; i++; if (i==line.length()) break; }
				if (m==1) {s1=s1+line.charAt(i);}
				if (m==2) {s2=s2+line.charAt(i);}
				if (m==3) {s3=s3+line.charAt(i);}
				if (m==4) {s4=s4+line.charAt(i);}

			}
			

			mode=0;
			
			if (last_m.equals(Double.parseDouble(s4))){
				//System.out.println(counter+" Stagnál");
				mode=2;
			}
			
			
			if (last_m>Double.parseDouble(s4)) {
				//System.out.println(counter+" Csökken");
				mode=3;
			}
			
			
			if (last_m<Double.parseDouble(s4)){
				//System.out.println(counter+" Növekszik");
                mode=1;
			}

			counter++;
			
			
			switch (mode){
			case 1: //mRNA_Name=new ArrayList<String>();
			        //mRNA_poz=new ArrayList<Integer>();
			        //norm_degradome=new ArrayList<Double>();
				    reduce=false;	
				
     				mRNA_Name.clear();
			        mRNA_poz.clear();
			        norm_micro_RNA.clear();
			        
			        mRNA_Name.add(s1);
					mRNA_poz.add(Integer.parseInt(s2));
					norm_micro_RNA.add(Double.parseDouble(s4));
			        break;
					
			case 2:	if (Double.parseDouble(s4)!=0.0){
				    	mRNA_Name.add(s1);
				    	mRNA_poz.add(Integer.parseInt(s2));
				    	norm_micro_RNA.add(Double.parseDouble(s4));
			        }
                    //System.out.println(Integer.parseInt(s2));
			        break;
                    
			case 3: if(!reduce){
				    for(i=1; i<mRNA_Name.size(); i++){
				    		out_m.write(mRNA_Name.get(i)+" "+mRNA_poz.get(i)+" "+norm_micro_RNA.get(i)+"\n");
				    		out_m.flush();
				    		//System.out.println(mRNA_Name.get(i)+" "+mRNA_poz.get(i)+" "+norm_micro_RNA.get(i));  
		         	}
			        reduce=true;
			        mRNA_Name.clear();
	                mRNA_poz.clear();
	                norm_micro_RNA.clear();
			}
	                break;
	         
			default:  System.out.println("!!!Anyádat!!!");
	         
				    
			}
			
			last_m=Double.parseDouble(s4);
			
		}
		
		
		
		
		out_d.close();
		out_m.close();
		bf.close();
	    }
	
}
