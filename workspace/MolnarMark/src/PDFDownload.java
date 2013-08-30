import java.io.*;
import java.net.*;

public class PDFDownload {
    public static String URL = "http://www.sigmaaldrich.com/MSDS/MSDS/PrintMSDSAction.do?name=msdspdf_1308219090353674";
    public static String FOLDER = "home/henrik/";

    public static void main() {
    	String filename = "";
    	try {
    		saveUrl(FOLDER + filename, URL + filename);
    	} catch (MalformedURLException e) {
    		System.out.println("MalformedURLException");
    	} catch (IOException e) {
    		System.out.println("IOException");                              
    	}                       
    }       



    public static void saveUrl(String filename, String urlString) throws MalformedURLException, IOException {
    	BufferedInputStream in = null;
    	FileOutputStream fout = null;
    	try {
    		URL url = new URL(urlString);
    		in = new BufferedInputStream(url.openStream());
    		fout = new FileOutputStream(filename);

    		byte data[] = new byte[1024];
    		int count;
    		while ((count = in.read(data, 0, 1024)) != -1) {
    			fout.write(data, 0, count);
    		}
    	} finally {
    		if (in != null)
    			in.close();
    		if (fout != null)
    			fout.close();
    	}
    }
}