package org;

public class help {

	public void print_help(){
		System.out.println("---------------------!!!! HELP !!!!-----------------");
		System.out.println("THE GOAL OF THIS PROGRAM");
		System.out.println("The program has written to check the '_Overlapped.txt' files from controll files.");
		System.out.println("The control files were created by Tibor Nagy.");
		System.out.println("The out put datas are not saved to external file!");
		System.out.println("The cloumns on the screen:");
		System.out.println("1. The name of the mRNA-s,\n2. The start pozitoin of overlaps from the '_Overlapped.txt'-s,\n3.The end pozitoin of overlaps from the '_Overlapped.txt'-s,\n4. The cut pozition from the cut controll file.");

		System.out.println("\n\n\nTAGS\n");
		System.out.println("-help   Congratulation, you have already found it!  :-D");
		System.out.println("-file_Overlapped  | REQUIRED     You can set the input '*_Overlapped' file.");
		System.out.println("-file_controll    | REQUIRED     You can set the input controll file");
		
		
		
		//System.out.println("-save             | OPTIONAL     You can set where to save results.\n      Default: The program will put the output file a folder of the input files and the out put file will be formed from the name of the inputfile with '' tail.\n             Use absolute reference!");
		System.out.println("\n\n\nSOME USEFUL NOTES\n\nWith tag -Xmx3G give more memory to the java program, because of the\n big size of the bam files.");
		System.out.println("Keep calm! :)");
		
	}
	
	
}
