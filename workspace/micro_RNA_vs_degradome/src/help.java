
public class help {

	public void print_help(){
		System.out.println("Majd ha nékem sok pénzem lesz felülök a repülőre!!!ALEP MÉG FOS!!!Ez a HELP MÉG FOSSSSS meg kellen jól fogalmazni hogy mi a faszra jó ez!!!");
		System.out.println("THE GOAL OF THIS PROGRAM");
		System.out.println("The authors assume it is known what the bam/sam files use for!\n\n\n");
		System.out.println("Tha program has been made to creat from bam/sam files an txt files.");
		System.out.println("In the output txt file the user can find the listing the number of the perfectly matched \n micro degradomes and RNA-s in each base pozition.");
		System.out.println("The columns of the txt files contains respectively tha following datas:");
		System.out.println("1. The name of the mRNA-s,\n2. The pozitoin in the mRNA-s\n3. The number of the mapped degradomes\n4. The number of the mapped micro RNA-s");
		System.out.println("\n\n\nPARAMETERS\n\n\n");
		System.out.println("-help   Congratulation, you have already found it!");
		System.out.println("-file   You can set the input bam file. This tag is alway required.");
		System.out.println("-save   You can set where to save and name of the output txt. It is optional tag. \n      Default: The program will put the output file a folder of the input bam file and the out put file will be formed from the name of the inputfile with '_micro_RNA_vs_degradome.txt' tail.\n             Use absolute reference!");
		System.out.println("\n\n\nSOME USEFUL NOTES\n\nWith tag -Xmx3G give more memory to the java program, because of the\n big size of the bam files.");
		System.out.println("Keep calm, the making an output takes a lot of time! :)");
		
	}
	
	
}
