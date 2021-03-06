package org;

public class help {

    public void help_printer (){
       System.out.println("\n\n\n------------!!!!  HELP  !!!!-------------------------------------------------------------------------------");
       System.out.println("ABOUT THE AUTHORS\n");
 	   System.out.println("This program has written by Tibor Nagy and Henrik Bata in 2013 (ABC - Agricultural Biotechnology Center, Gödöllő, Hungary).");
    	
       System.out.println("\n\n\nTHE GOAL OF THIS PROGRAM\n");

       System.out.println("The goal is the finding the pozitions in the mRNA where micro RNA and degradomes\nsequences are mapped.");
    	
    	
       System.out.println("\n\n\n\nABOUT THE OUTPUT FILES\n");
       System.out.println("The program creates one output files. One contains the pozitions and the normalized values where the peaks overlap.");
       System.out.println("There are four column in both output files. They are contains the folowing datas:");   
       System.out.println("1. column: The name of the mRNA,");
       System.out.println("2. column: Pozition of the mRNA,");
       System.out.println("3. column: The normalized degradome value (to one million read),");
       System.out.println("4. column: The normalized micro RNA value (to one million read).");
       System.out.println("\n\n\nTAGS\n\n");
       System.out.println("-help");
       System.out.println("-file_degradome    REQUIRED | Set the input file of the degradome peaks.");
       System.out.println("-file_micro_RNA    REQUIRED | Set the input file of the micro RNA peaks.");
       System.out.println("-save              OPTIONAL | You can set name and where to save the output file");

       System.out.println("\n If you do not give -save then the output file names");
       System.out.println("will be created from the nem of the inputfiles to the folder of the input file.  Example:");
       System.out.println("Input files: root1_degradome_peaks.txt   and root1_micro_RNA_peaks.txt\nOutput files: root1_Overlapped.txt");

       System.out.println("\n\nNOTES\n");
       System.out.println("This program a part of a series of programs to detect which goal is the micro RNA \n detection without reference.");
       System.out.println("The previos element of this serial: micro_RNA_VS_degradome.jar, peak_detektor.jar ");
    }
}
