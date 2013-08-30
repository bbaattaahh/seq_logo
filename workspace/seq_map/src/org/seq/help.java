package org.seq;

public class help {
 
   public static void help_print(){

	   System.out.println("\n\n------------------------------------HELP--------------------------\n\n");
	   System.out.println("ABOUT THE AUTHORS");
	   System.out.println();
	   System.out.println("This program has written by Tibor Nagy and Henrik Bata in 2013. The authors goal was to create an universal saqvention logo maker to help of the work of ABC (Agricultural Biotechnology Center, Gödöllő, Hungary).");
	   System.out.println();
	   System.out.println("We hope you will use this program easily and successfully.");
	   System.out.println("\n\n\n\nINPUT FILE\n");
	   System.out.println("The input file have to contain the listed sequences. The length of each sequences heva to be the same and you have to use a the one-letter-form of the bases and or the amino acides. Use capital letters.");
	   System.out.println("\n\n\nOUTPUT LOGO\n");
	   System.out.println("The name of the logo is created from the name of the input file. If you do not use the save argument, teh created logo will be saved to the folder of the input file. Using of the argument '-save' you can add the name and the saving folder of the new logo. If you use '-save' always applay absolute references.");
	   System.out.println("\n\n\nTAGS\n");
	   System.out.println("  -help");
       System.out.println("  -file path and filename          | REQUIRED  You can set the absolut or relativ way to the input file.");
       System.out.println("  -bgcolor white                   | OPTIONAL  You can set the backgroungcolor of the logo.");
	   System.out.println("  -numcolor black                  | OPTIONAL  You can set the color of the numbers on the logo.");
	   System.out.println("  -lettercolor black               | OPTIONAL  You can set the colors of the bases.????? If there are more different base than colors");
	   System.out.println("  -firstnum 1                      | OPTIONAL  You can set the first number.");
	   System.out.println("  -rate 2.0                        | OPTIONAL  You can set rate of width and the high of one letter on the logo.");
	   System.out.println("  -save '-file'_saq_logo.npg       | OPTIONAL  You can set the name and the saving folder of the logo. Use absolute reference!");
       System.out.println("  -lenx 1000                       | OPTIONAL  You can set the width of the created logo.");
	   System.out.println("\n\n");
	   System.out.println("ERRORS-RETURN VALUES\n\n\t1 Not constant line length.\n\t2 Empty file.\n\t3 Invalid character.\n\t4");
	   System.out.println();
   }	
	
}
