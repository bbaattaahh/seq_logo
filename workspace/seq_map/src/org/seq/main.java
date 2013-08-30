package org.seq;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.text.html.StyleSheet;



public class main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	@SuppressWarnings({ })
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		
	 String filename="",save="test2.npg";
	 Double rate=2.0;  							    //2es típusú logónál megmondja a 100%os betű (Egy adott pozícióban csak egy bázis található!!) hossza és magassága közötti arányt.        
	 Integer i=0,j,k=0,n=0,counter=0,start_seq=1; 	//n: az egy sorban lévő szekvenciák száma.
	 help h=new help ();                            		   	        //counter: egy oszlopban lévő szekvenciák száma. 
	 HashMap<Character, ArrayList<Integer>> hash = new HashMap<Character, ArrayList<Integer>>();  //Ebben a hash mapban vannak eltárolva az egyes bázisok gyakoriságai pozíciónként   	
 	 Integer lenx=1000;                             //Majd később a felhasználó által megadható paraméter lesz. Hogy mekkorra legyen a kép hosza 
     ArrayList<Color> letter_colors= new ArrayList<Color>();
     letter_colors.add(Color.black);
     Color number_color=Color.black;
     Color bg_color=Color.white;
     StyleSheet to_color = new StyleSheet();
     fill_the_hashmap reader=new fill_the_hashmap();

       
     
     /*Állítható paraméterek lekezelése*/
     
    for (String s: args) {k++;}
     
 	for (String s: args) {
        if (s.equals("-help")){h.help_print(); System.exit(0);}
        if (s.equals("-bgcolor"))  {bg_color=to_color.stringToColor(args[i+1]);}
        if (s.equals("-numcolor")) {number_color = to_color.stringToColor(args[i+1]); if (args[i+1].isEmpty()) {System.out.println("Missing numcolor"); System.exit(5);}}
        if (s.equals("-lettercolors")){
            letter_colors.clear();
            j=i+1;
            while (j!=k && args[j].charAt(0)!='-'){
            	letter_colors.add(to_color.stringToColor(args[j]));
            	j++; 
            }
         	}

        if (s.equals("-first_number")) {start_seq=Integer.parseInt(args[i+1]);}
        if (s.equals("-rate")) {rate=Double.parseDouble(args[i+1]);}
        if (s.equals("-file")) {filename=args[i+1]; save=filename.substring(0, filename.length()-4); save=save+"_seq_logo.png";}
        if (s.equals("-save")) {save=args[i+1];} 
        if (s.equals("-lenx")) {lenx=Integer.parseInt(args[i+1]);} 
        

        i++;
 	}
 	
 	if (filename=="") {
 		System.out.println("'-file' tag is always existed!"); 
 	    System.exit(5);
 	    } 

    save=filename.substring(0, filename.length()-4); save=save+"_seq_logo.png";  //Default érték megadása a save-nek.
 	

 	hash=reader.fill_the_matrix(filename, n, counter);
    n=reader.get_n(filename, n, counter);
    counter=reader.get_counter(filename, n, counter);

    
    try {
        png_maker b=new png_maker(); 
        b.drawImage(hash,n,2400,counter,lenx,start_seq, number_color, bg_color,letter_colors,rate,save);
        
      } 
        catch (IOException e) {
        System.err.println("Error: " + e);
      }
    
    
    //Eltakarítja a segéd file-okat!!!
    
    File file1=new File("number.png");
    file1.delete();
    
    File file2=new File("letter.png");
    file2.delete();
    
	}


}	

