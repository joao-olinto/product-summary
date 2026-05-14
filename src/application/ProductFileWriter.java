package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ProductFileWriter {

	//method for writing in the summary file
	public void writeFileSummary(File file,String summaryText) {
		
		//"try-with-resources" ensures that open resources are automatically closed.
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			
			bw.write("======== LISTA DE PRODUTOS ========");
			bw.newLine();
			bw.newLine();
			
			//Here, only a write command occurs, as the text is constructed using StringBuilder.
			bw.write(summaryText);
			bw.newLine();
		}
		catch(IOException e) {
			System.out.println("error writing to the file: "+ e .getMessage());
			e.printStackTrace();
		}
	}
}
