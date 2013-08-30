import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import net.sf.samtools.SAMFileReader;
import net.sf.samtools.SAMRecord;
import net.sf.samtools.SAMRecordIterator;

import java.util.ArrayList;
import java.util.HashMap;

public class main_micro_RNA_vs_degradome {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        /* Program célja: helpben... (-help)
         * Készítette:Nagy Tibor, Bata Henrik (Gödöllő 2013 nyár aug. 16.)
         * Freeware... Nem mintha bárki az életben fejleszteni akarná.....
         * 
         * 
         * !!!!AMIVEL NAGY SZOPÁS LEHET!!!!!
         * A bam fileban van egy header rész, és egy rész ami  a rekordokt tárolja. A két rész nem egyenlő hosszú
         * ode kell figyellni, hogy melyik hazsnált tömb hova tartozik!! 
         * Header részhetz csak a header és a len tömbök tartoznak.
         * */
		
		
		Integer i=0,j,k,l,mutato=0,sum_degradome=0,sum_micro_RNA=0,PufferK;
		HashMap <String, ArrayList<Integer>> HashMap_degradome = new HashMap <String, ArrayList<Integer>>();
		HashMap <String, ArrayList<Integer>> HashMap_micro_RNA = new HashMap <String, ArrayList<Integer>>();
		ArrayList <Integer> t =new ArrayList<Integer>();
		ArrayList <Integer> puffer =new ArrayList<Integer>();
		ArrayList <String> header =new ArrayList<String>();
		ArrayList <String> ReferenceName =new ArrayList<String>();
		ArrayList <Boolean> is_it_degradome =new ArrayList<Boolean>();
		ArrayList <Boolean> is_it_good_RNA =new ArrayList<Boolean>();
		ArrayList <Integer> ReferencePoz =new ArrayList<Integer>();
		ArrayList <Integer> CigarLen =new ArrayList<Integer>();
		ArrayList <Integer> ReadLength =new ArrayList<Integer>();
		ArrayList <Integer> len =new ArrayList<Integer>();
		which_RNA_is_good a =new which_RNA_is_good();
		String file="", save="";
		help h=new help();

	 	for (String s: args) {
	        if (s.equals("-help")){h.print_help(); System.exit(0);}
	        if (s.equals("-file"))  {file=args[i+1];}
	        if (s.equals("-save")) {save =args[i+1];}
	        i++;
	 	}

	 	if (file.equals("")) {
	 		System.out.println("ERROR: '-file' always required");
	 		System.exit(1);
	 	}
	 	
	 	if (save.equals("")) {
	 		save=file.replace(".bam", "_micro_RNA_vs_degradome.txt");
	 	}
	 	
		BufferedWriter out = new BufferedWriter(new FileWriter(save));
		
		SAMFileReader.setDefaultValidationStringency(SAMFileReader.ValidationStringency.SILENT);
		
		@SuppressWarnings("resource")
		final SAMFileReader inputSam = new SAMFileReader(new File (file), true);

        
        SAMRecordIterator iter = inputSam.iterator();
		
        System.out.println("1");
        System.out.println(file);
        
        
        /*
         * Ebben a szakaszban olvassa be a bam fileből az adatokat. (A rekordokból.
         * A tömbök nevei azt hiszem magukért beszélnek.... :)
         * */
        
        
        while(iter.hasNext()){
			SAMRecord rec = iter.next();                                          
			CigarLen.add(rec.getCigarLength()); 		
			ReadLength.add(rec.getReadLength()); 		
			ReferenceName.add(rec.getReferenceName());
			is_it_degradome.add(rec.getSAMString().contains("degradome"));
			ReferencePoz.add(rec.getReferencePositionAtReadPosition(1));//???
	//		if (rec.getReferencePositionAtReadPosition(1)==0) {
		//		System.out.println((rec.getReferencePositionAtReadPosition(1)+" "+rec.getReferenceName()+"  "+rec.getCigarLength()+" "+rec.getCigarString()+" "+rec.getAlignmentStart()));//???
			//}
			
		}


        
        
		for (i=0; i<inputSam.getFileHeader().getSequenceDictionary().size(); i++){
     
			t =new ArrayList<Integer>();
			for (j=0; j<inputSam.getFileHeader().getSequence(i).getSequenceLength(); j++) t.add(0);
			
			HashMap_degradome.put(inputSam.getFileHeader().getSequence(i).getSequenceName(),t);
			
			t =new ArrayList<Integer>();
			for (j=0; j<inputSam.getFileHeader().getSequence(i).getSequenceLength(); j++) t.add(0);
			
			HashMap_micro_RNA.put(inputSam.getFileHeader().getSequence(i).getSequenceName(),t);
			
			header.add(inputSam.getFileHeader().getSequence(i).getSequenceName());
			len.add(inputSam.getFileHeader().getSequence(i).getSequenceLength());
			
            
		} 

		
        System.out.println("2");
		
		
		is_it_good_RNA=a.good_RNA(CigarLen, ReferenceName,len, ReadLength, ReferencePoz,header);
		
        for (i=0; i<is_it_degradome.size(); i++){
        	if (is_it_degradome.get(i)) {sum_degradome++;}
        	else {sum_micro_RNA++;}
        }
		
			
		l=0;
		for (i=0; i<inputSam.getFileHeader().getSequenceDictionary().size(); i++){
			mutato=0;
			for(j=l; j<ReferenceName.size(); j++){
				if (mutato==1 && !ReferenceName.get(j).equals(ReferenceName.get(j-1))) {
					if (i % 100==0) {System.out.println(i+"/"+inputSam.getFileHeader().getSequenceDictionary().size());}
					break;
					}
				
				if (inputSam.getFileHeader().getSequence(i).getSequenceName().equals(ReferenceName.get(j))){
					mutato=1;
					l=j;
					if (is_it_good_RNA.get(j)) {
						if (is_it_degradome.get(j)){
							if (ReferencePoz.get(j)==0) PufferK=0;
							else PufferK=ReferencePoz.get(j)-1;
							for (k=PufferK; k<ReferencePoz.get(j)+ReadLength.get(j)-1; k++){
								puffer=new ArrayList <Integer>();
								//System.out.println(ReferencePoz.get(j));
								puffer=HashMap_degradome.get(inputSam.getFileHeader().getSequence(i).getSequenceName());
								puffer.set(k, (int)(puffer.get(k)+1));
								HashMap_degradome.put(inputSam.getFileHeader().getSequence(i).getSequenceName(), puffer);
								
							}
						}
						else{
							if (ReferencePoz.get(j)==0) PufferK=0;
							else PufferK=ReferencePoz.get(j)-1;
							for (k=PufferK; k<ReferencePoz.get(j)+ReadLength.get(j)-1; k++){
								puffer=new ArrayList <Integer>();
							    puffer=HashMap_micro_RNA.get(inputSam.getFileHeader().getSequence(i).getSequenceName());
								puffer.set(k, (int)(puffer.get(k)+1));
								HashMap_micro_RNA.put(inputSam.getFileHeader().getSequence(i).getSequenceName(), puffer);
								}
							}
					}
				}
			}
		}
		
		
        System.out.println("3");

        
		j=0;
		for (i=0; i<header.size();i++){
			for (j=0; j<len.get(i); j++){
				out.write(header.get(i)+" "+(int)(j+1)+" "+(double)(HashMap_degradome.get(header.get(i)).get(j))*1000000.0/(double)sum_degradome+" "+(double)(HashMap_micro_RNA.get(header.get(i)).get(j))*1000000.0/(double)sum_micro_RNA+"\n");		
			}
		}
		
        System.out.println("4 "+sum_micro_RNA+"      "+sum_degradome);

		
		out.close();
		
	}

	
	
}
