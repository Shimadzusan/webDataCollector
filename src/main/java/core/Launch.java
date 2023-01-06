package core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import database.MySQLDatabase;
import network.HttpRequest;

public class Launch {

	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
		//new ReadXmlDomParser();
		//new ControlModule();
		Configuration configuration = new Configuration("configurationWebDataCollector.xml");
		
		for (int i = 0; i < configuration.getConfiguration().size(); i++) {
			try {
				String url = configuration.getConfiguration().get(i).getUrl();
				String marker = configuration.getConfiguration().get(i).getMarker();
				String regex = configuration.getConfiguration().get(i).getRegex();
				String text = new HttpRequest().getWebText(url);
				//System.out.println(text);
				
				/* extracting marker from total text */
		        Pattern patternOne = Pattern.compile(marker);
		        Matcher matcherOne = patternOne.matcher(text);
		        matcherOne.find();
		        System.out.println("marker: " + matcherOne.group());
		        String found = matcherOne.group();
		        System.out.println("found: " + found);
		        /* extracting regex from marker */
		        Pattern patternTwo = Pattern.compile(regex);
		        Matcher matcherTwo = patternTwo.matcher(found.replaceAll(" ", ""));
		        matcherTwo.find();
		        System.out.println("value: " + matcherTwo.group());
		        configuration.getConfiguration().get(i).setValue(matcherTwo.group());
		        System.out.println("value2: " + configuration.getConfiguration().get(i).getValue());
			}
			catch(IllegalStateException e) {
				System.out.println("error");
				System.out.println(configuration.getConfiguration().get(i).getUrl());
			}
		}
		
		try {
			MySQLDatabase.conn(configuration.getConfiguration());
			MySQLDatabase.writeDB();
			MySQLDatabase.closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
