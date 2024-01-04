package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class DataOperation {
	
	public String readDataFromFile(String fileName) throws FileNotFoundException, IOException {
		String result = "";
		String line;
		 int bufferSize = 16384;
	        // defaultCharBufferSize = 8192; or 8k
	        try (BufferedReader br = new BufferedReader(new FileReader(fileName), bufferSize)) {  
	            while ((line = br.readLine()) != null) {
	               result = result + line + "\n";
	            }
	        }
		return result;
	}
	
	 public String readDataFromFile2(String fileName) throws IOException {
		 String result = "";
		 List<String> lines = Files.readAllLines(Paths.get(fileName),StandardCharsets.UTF_8);
	     for (int i = 0; i < lines.size(); i++) {
			result = result + lines.get(i);
		}
		return result;
	 }
	
	public boolean writeDataToFile(String fileName, String text) throws IOException {
//		try (FileWriter fw = new FileWriter(fileName);
//			       BufferedWriter bw = new BufferedWriter(fw)) {
//			      bw.write(text);
//			      bw.newLine(); // add new line, System.lineSeparator()
//			  }

				 // append mode
			  try (FileWriter fw = new FileWriter(fileName, false);
			       BufferedWriter bw = new BufferedWriter(fw)) {
			      bw.write(text);
			      bw.newLine();
			  }
		return true;
	}

	/* example YYYYMMDD for input */
	public String getDate(String pattern) {
		Calendar calendar = Calendar.getInstance();
		DateFormat formatter = new SimpleDateFormat(pattern);
		String date = formatter.format(calendar.getTime());
		return date;
	}
}