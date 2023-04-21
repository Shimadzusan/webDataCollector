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
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import configuration.Configuration;
import configuration.ConfigurationObject;
import network.HttpRequest;

/** input: URL, marker, regex 
 * 	output: value from webpage for storage in database 
 * 	This class implements one from many possibility extracting data from webpage */
public class SourceWeb implements Source {
	private final Logger LOG = (Logger) LogManager.getLogger(SourceWeb.class);
	ConfigurationObject configurationObject;
	String data = "";
	int number;
	
	public SourceWeb(Configuration configuration) {
		this.configurationObject = configuration.getConfiguration();
	}

	@Override
	public boolean setConfigurationData(ConfigurationObject configurationObject) {
		this.configurationObject = configurationObject;
		return true;
	}
	
	@Override
	public String getDataFromSource(int number) {
		this.number = number;
		try {
			classLogic();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "getSourceWeb: " + data;
	}
	
	public void classLogic() throws UnsupportedEncodingException {
		/* realtySector */
		/* citizenswareSector */
		
		LOG.info("start classLogic");
		
		/* input */
		for (int i = 0; i < configurationObject.getListCase().get(number).getListInstanceData().size(); i++) {
			System.out.println(configurationObject.getListCase().get(number).getListInstanceData().get(i).getUrl());
			String text = new HttpRequest().getWebText(configurationObject.getListCase().get(number).getListInstanceData().get(i).getUrl());
			/* extracting marker from total text */
			String marker = configurationObject.getListCase().get(number).getListInstanceData().get(i).getMarker();
			String regex = configurationObject.getListCase().get(number).getListInstanceData().get(i).getRegex();
	        
			try {
			Pattern patternOne = Pattern.compile(marker);
	        Matcher matcherOne = patternOne.matcher(text);
	        matcherOne.find();
	        //System.out.println("marker: " + matcherOne.group());
	        String found = matcherOne.group();
	        //System.out.println("found: " + found);
	        /* extracting regex from marker */
	        Pattern patternTwo = Pattern.compile(regex);
	        Matcher matcherTwo = patternTwo.matcher(found.replaceAll(" ", ""));
	        matcherTwo.find();
	        System.out.println("value: " + matcherTwo.group());
	        this.data = matcherTwo.group();
	        
	        configurationObject.getListCase().get(number).getListInstanceData().get(i).setValue(matcherTwo.group());
	        //configurationObject.getConfiguration().get(i).setValue(matcherTwo.group()); delete in next commit
			}
			catch(java.lang.IllegalStateException e) {
				System.out.println("No match found");
			}
        /* output */
		//System.out.println(text);
        //System.out.println("value2: " + configurationObject.getListCase().get(1).getListInstanceData().get(i).getValue());
    	
//        LOG.info(text);
		}
        LOG.info("classLogic successfully completed");
	}
	
}
