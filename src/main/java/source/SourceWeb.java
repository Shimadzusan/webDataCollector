package source;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import configuration.Configuration;
import configuration.ConfigurationObject;
import network.HttpRequest;
import network.HttpRequestDecorator;

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
		LOG.info("start classLogic");

		for (int i = 0; i < configurationObject.getListCase().get(number).getListInstanceData().size(); i++) {
			System.out.println(configurationObject.getListCase().get(number).getListInstanceData().get(i).getUrl());
//			String text = new HttpRequest().getWebText(configurationObject.getListCase().get(number).getListInstanceData().get(i).getUrl());
			String method = "cmd_url";
			String text = new HttpRequestDecorator().getWebText(configurationObject.getListCase().get(number).getListInstanceData().get(i).getUrl());
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
		        Matcher matcherTwo = patternTwo.matcher(found);
		        String result = "";
		        while(matcherTwo.find()) {
		            result = result + matcherTwo.group();
		        }
		        
		        System.out.println("value: " + i + " " + result);
		        this.data = result;
		        configurationObject.getListCase().get(number).getListInstanceData().get(i).setValue(result);
		        //configurationObject.getConfiguration().get(i).setValue(matcherTwo.group()); delete in next commit
			}
			catch(java.lang.IllegalStateException e) {LOG.error(e);}
			catch(java.lang.NullPointerException e) {LOG.error(e);}
		}
        LOG.info("classLogic successfully completed");
	}
	
}
