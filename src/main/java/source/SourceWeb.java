package source;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import configuration.Configuration;
import configuration.ConfigurationObject;
import network.HttpRequest;

/** input: url, marker, regex 
 * 	output: value from webpage for storage in database 
 * 	This class implements one from many possibility extracting data from webpage */
public class SourceWeb implements Source {
	private final Logger LOG = (Logger) LogManager.getLogger(SourceWeb.class);
	ConfigurationObject configurationObject;
	String data = "";
	
	public SourceWeb(Configuration configuration) {
		this.configurationObject = configuration.getConfiguration();
	}

	@Override
	public boolean setConfigurationData(ConfigurationObject configurationObject) {
		this.configurationObject = configurationObject;
		return true;
	}
	
	@Override
	public String getDataFromSource() {
		try {
			classLogic();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "getSourceWeb: " + data;
	}
	
	public void classLogic() throws UnsupportedEncodingException {
		/* realtySector */
		/* citizenswareSector */
		
		LOG.info("start classLogic");
		
		/* input */
		String url = "https://www.avito.ru/moskva/kvartiry/prodam-ASgBAgICAUSSA8YQ?context=H4sIAAAAAAAA_0q0MrSqLraysFJKK8rPDUhMT1WyLrYyNLNSKk5NLErOcMsvyg3PTElPLVGyrgUEAAD__xf8iH4tAAAA&localPriority=0";
		String url1 = "https://www.avito.ru/sankt-peterburg/kvartiry/prodam-ASgBAgICAUSSA8YQ?localPriority=0";
		String url2 = "https://www.avito.ru/izhevsk/kvartiry/2-k._kvartira_47m_55et._2945146349";
		String url3 = "https://www.avito.ru/izhevsk/kvartiry/prodam-ASgBAgICAUSSA8YQ?p=6"; 
				
				//"https://www.avito.ru/izhevsk/kvartiry/prodam-ASgBAgICAUSSA8YQ?f=ASgBAQECAkSSA8YQwMENuv03A0DKCCSAWYJZjt4OFAKQ3g4UAgFFxpoMHXsiZnJvbSI6MTUwMDAwMCwidG8iOjQwMDAwMDB9&map=eyJzZWFyY2hBcmVhIjp7ImxhdEJvdHRvbSI6NTYuODI0NTk5MDkzNTg1MDEsImxhdFRvcCI6NTYuODczNzg4MDYyNDIxOTgsImxvbkxlZnQiOjUzLjE5NDQ0NzgwNTQ1NjcsImxvblJpZ2h0Ijo1My4zNjkzNzA3NDg1NzE5M30sInpvb20iOjEzfQ%3D%3D";
		
		try {
//			writeDataToFile("abc.txt", new HttpRequest().getWebText(url1));
			writeDataToFile("abc.txt", new HttpRequest().getHtml(url3));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String text = new String(arrow, "UTF-8");
//		
//		System.out.println(text);
		
//		/* extracting marker from total text */
//		String marker = "Продажа квартир в Санкт-Петербурге.* Недвижимость";
//		String regex = "[0-9]+";
//        Pattern patternOne = Pattern.compile(marker);
//        Matcher matcherOne = patternOne.matcher(text);
//        matcherOne.find();
//        //System.out.println("marker: " + matcherOne.group());
//        String found = matcherOne.group();
//        //System.out.println("found: " + found);
//        /* extracting regex from marker */
//        Pattern patternTwo = Pattern.compile(regex);
//        Matcher matcherTwo = patternTwo.matcher(found.replaceAll(" ", ""));
//        matcherTwo.find();
//        System.out.println("value: " + matcherTwo.group());
//        this.data = matcherTwo.group();
//        configuration.getConfiguration().get(i).setValue(matcherTwo.group());
//        System.out.println("value2: " + configuration.getConfiguration().get(i).getValue());
	
        /* output */
        
		//System.out.println(text);
        
        LOG.info("classLogic successfully completed");
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
	
	public String readDataFromFile(String fileName) throws FileNotFoundException, IOException {
		String result = "";
		String line;
	        // defaultCharBufferSize = 8192; or 8k
	        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {  
	            while ((line = br.readLine()) != null) {
	               result = result + line + "\n";
	            }
	        }
		return result;
	}
}
