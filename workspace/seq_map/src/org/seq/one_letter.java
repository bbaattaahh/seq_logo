/*
 * A megnevezés kicsit félre vezető lehet, itt történik az 1. verziójú logó 
 * újraméretezése is. 
 * Alapvetően az egy db kirajzolandó betű képének méretezése történik itt. */
 

package org.seq;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class one_letter {
	



    
	public BufferedImage letter( Character c, Double rate, Integer sum, Integer actual, Integer h , Color bg_color,HashMap<Character, Color> paired_letters_and_colors) throws IOException{
        /* c: a képen szereplő character
         * rate: a szélesség és a magasság aránya
         * sum: az egy oszlopban lévő szekvenciák száma
         * actual: Az adott oszlopban ebből a betűből hány db van összesen.
         * h: mennyire van elcsúsztattva az adott kép kirajzolása a kép tetejéhez képest 
         * bg_color: A háttárszíne.
         * paired_letters_and_colors: kapcsolótábla a szinek és a karakterek között*/
		
		BufferedImage image = new BufferedImage(80,100,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = image.createGraphics();
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 135);
	   	g2.setFont(font);
	   	g2.setColor(bg_color);
	   	g2.fillRect(0, 0, 80, 100);
	   	g2.setColor(paired_letters_and_colors.get(c));
	   	g2.drawString(String.valueOf(c), 0, 100);

    	ImageIO.write(image, "png", new File("letter.png"));
    	PictureScaler a=new PictureScaler("letter.png");
    	image=a.getFasterScaledInstance(image, 50, (int)((double)actual/(double)sum*rate*50.0), RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR,false);
    	ImageIO.write(image, "png", new File("letter.png"));
	    return image;
	}

	
	public BufferedImage number( Integer i, Color number_color,Color bg_color) throws IOException{
 		/*Elkészíti a kiírásra szánt számot a képre.*/
		Integer k=1;
		
		if (i>9) {k=2;}
		
		BufferedImage image = new BufferedImage(k*80,100,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = image.createGraphics();
		Font font = new Font(Font.MONOSPACED, Font.PLAIN, 135);
	   	g2.setFont(font);
	   	g2.setColor(bg_color);
	   	g2.fillRect(0, 0, k*80, 100);
	   	g2.setColor(number_color);
	   	g2.drawString(String.valueOf(i), 0, 100);

    	ImageIO.write(image, "png", new File("number.png"));
    	PictureScaler a=new PictureScaler("number.png");
    	image=a.getFasterScaledInstance(image, k*20, 25, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR,false);
    	ImageIO.write(image, "png", new File("number.png"));

	    return image;
	}
	
	public void resize( BufferedImage image, Integer lenx, Integer x, String filename) throws IOException{
		ImageIO.write(image, "png", new File(filename));
    	PictureScaler a=new PictureScaler(filename);
    	image=a.getFasterScaledInstance(image, lenx, (int)((double)150/((double)x/(double)lenx)), RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR,false);
    	ImageIO.write(image, "png", new File(filename));
	}

}//Class