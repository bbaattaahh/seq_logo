package org.seq;

import java.awt.Color;
import java.util.Random;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Policy;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.imageio.ImageIO;



public class png_maker {
    public int x=2400;
    public int y=150;
    
    
    
    public void drawImage(HashMap<Character, ArrayList<Integer>> c, Integer n, Integer len, Integer counter, Integer lenx, Integer start_seq,Color number_color, Color bg_color, ArrayList<Color> letter_colors, Double rate, String save) throws IOException{
    
    Integer i=0,j,k;	
   	ArrayList<Integer> d=new ArrayList<Integer>();
   	ArrayList<Integer> high=new ArrayList<Integer>();   //Megmutatja, hogy a maximálisan felhasználható függőleges pielekből eddig mennyit használtunk fel. A 1-es típusú logónál!
   	ArrayList<Integer> high2=new ArrayList<Integer>();  //Megmutatja, hogy a maximálisan felhasználható függőleges pielekből eddig mennyit használtunk fel. A 2-es típusú logónál!
   	ArrayList<Integer> wide=new ArrayList<Integer>();   //Megmutatja, hogy melyik pixelnél kezdődik a kírás természetesen hurizontálisan
   	ArrayList<Integer> max=new ArrayList<Integer>();    //Tárolja a legnagyobb előforfuláci számot egy adott oszlopra!
   	Random rand = new Random();
   	one_letter a=new one_letter();
   	Position_in_the_queue p=new Position_in_the_queue(); 
   	ArrayList<Character> organized_c=new ArrayList<Character>(); 
   	HashMap<Character, Color> paired_letters_and_colors=new HashMap<Character, Color>();
   	
   	paired_letters_and_colors=p.organized_by_alphabet(c, letter_colors);
   	
   	
   	float r = rand.nextFloat();
   	float g = rand.nextFloat();
   	float b = rand.nextFloat();
   	
   	Color randomColor = new Color(r, g, b);
   	
   	
   	for (i=0; i<n; i++){high2.add(0); high.add(0); wide.add(0); max.add(0);} //Kezdő értékek megadása.
   	wide.add(0);
   	



   	for(Character key: c.keySet()){
   	    d=c.get(key);
   		for (i=0; i<n; i++){
   			if (d.get(i)>max.get(i)) {max.set(i, d.get(i));}
   		}
   	}
   	
   	
   	for (i=1; i<n+1; i++){
   	   wide.set(i, (wide.get(i-1)+max.get(i-1)*135/counter*80/140));
   	}
   	
   	x=wide.get(n)+1;
	BufferedImage image = new BufferedImage(x,y,BufferedImage.TYPE_INT_RGB);
	Graphics2D g2 = image.createGraphics();
	g2.setColor(bg_color);
    g2.fillRect(0, 0, x, y);


	
	
	
	BufferedImage actual_sized_letter;
	BufferedImage actual_sized_number;
	
	BufferedImage image3 = new BufferedImage(n*50,(int)((double)50*rate)+40,BufferedImage.TYPE_INT_RGB);
	Graphics2D g3 = image3.createGraphics();
	g3.setColor(bg_color);
    g3.fillRect(0, 0, n*50, (int)((double)50*rate)+40);

   	
	for (i=0; i<n; i++){
		organized_c=p.next_letter(c, i);
		if (start_seq-1+i+1>9) {k=2;} else {k=1;};
		for (j=0; j<organized_c.size(); j++){
			d=c.get(organized_c.get(j));
			if (d.get(i)!=0) {
				actual_sized_letter=a.letter(organized_c.get(j),rate,counter,d.get(i), high2.get(i),bg_color, paired_letters_and_colors);
				actual_sized_number=a.number(start_seq-1+i+1, number_color, bg_color);
				g3.drawImage(actual_sized_letter, i*50, high2.get(i), null);
				g3.drawImage(actual_sized_number, i*50+5-((k-2)*10), 115, null);
				high2.set(i, high2.get(i)+(int)((double)d.get(i)/(double)counter*rate*50.0));
			}
	    ImageIO.write(image3, "png", new File(save));
		}
	    
	}
   	
	a.resize(image3, lenx,(int)x, save);
   	
   /*Be épített plusz funkció de nem tetszett a kolegáknak így ki lett írtódva a programból!! */   	
/*   	for(Character key: c.keySet()){
   	    d=c.get(key);
   	    
   	    
   	   	r = rand.nextFloat();
   	   	g = rand.nextFloat();
   	   	b = rand.nextFloat();
   	   	
   	   	randomColor = new Color(r, g, b);
   	    
   	    g2.setColor(randomColor);

   	    

   	    
   	    for (i=0; i<n; i++){
 
   	    	
   	 	    Font font = new Font(Font.MONOSPACED, Font.PLAIN, (d.get(i)*135/counter));
   	    	g2.setFont(font);
   	    	g2.drawString(String.valueOf(key), wide.get(i)+(max.get(i)-d.get(i))*135/counter/2*80/130, 100-(high.get(i)*100/135));

   	    
   	    	high.set(i, (d.get(i)*135/counter)+high.get(i));
   	    	if (d.get(i)==max.get(i)) {
   	    		Font font2 = new Font(Font.MONOSPACED, Font.PLAIN, 20);
   	   	    	g2.setFont(font2);
   	   	    	Color cpuffer=g2.getColor();
   	   	    	g2.setColor(number_color);
   	  	    	g2.drawString(String.valueOf(i+1), (wide.get(i)+wide.get(i+1))/2-5, 130);
   	   	    	g2.setColor(cpuffer);
   	    	}
  	    	
   	    	ImageIO.write(image, "png", new File(save.replaceFirst(".png", "_1_version.png")));
	
   	    	
  	    	a.resize(image, lenx,(int)x, save.replaceFirst(".png", "_1_version.png"));
    	    
   		}
   	}
*/    }
	



}
