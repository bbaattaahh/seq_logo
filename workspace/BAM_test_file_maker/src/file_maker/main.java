package file_maker;

import java.io.File;
import java.util.Iterator;

import net.sf.samtools.BAMFileWriter;
import net.sf.samtools.BAMRecord;
import net.sf.samtools.SAMFileHeader;
import net.sf.samtools.SAMFileReader;
import net.sf.samtools.SAMFileWriter;
import net.sf.samtools.SAMFileWriterFactory;
import net.sf.samtools.SAMRecord;
import net.sf.samtools.SAMRecordIterator;

public class main {

	/**
	 * @param args
	 * A program nem működik! VERY  :(:(:(:(:(
	 */
	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		Integer i=200;
		
		SAMFileReader.setDefaultValidationStringency(SAMFileReader.ValidationStringency.SILENT);
		
		@SuppressWarnings("resource")
		final SAMFileReader inputSam = new SAMFileReader(new File ("/home/henrik/micro_RNA_VS_degradome/root1.bam"), true);
		final SAMFileWriter outputSam= new BAMFileWriter(new File ("/home/henrik/micro_RNA_VS_degradome/test_file.bam"));
		SAMRecordIterator iter = inputSam.iterator();

		
		for(i=0; i<100; i++){
			SAMRecord rec = iter.next();
			System.out.println(rec+"  "+outputSam.getFileHeader());
			outputSam.addAlignment(rec);
			//outputSam.addAlignment(adat);
			
		}
		
		outputSam.close();
		
	}

}
