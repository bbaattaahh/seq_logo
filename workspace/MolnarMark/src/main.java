import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;


public class main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		PDFDownload PDF =new PDFDownload();
		PDF.main();
		PDF.saveUrl("jó.pdf" , null);
		System.out.println("Your winner");
	}

}
