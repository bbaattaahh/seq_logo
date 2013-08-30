package org.seq;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class scan {
	BufferedReader bf;
	
	scan(String filename) throws IOException{
		bf = new BufferedReader(new FileReader(filename));
		String line;
		while( (line = bf.readLine()) != null){
			System.out.println(line);
		}
		bf.close();
	}
}
