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
		
		try {
			MySQLDatabase.Conn();
			MySQLDatabase.WriteDB();
			MySQLDatabase.CloseDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		for (int i = 0; i < configuration.getConfiguration().size() - 3; i++) {
//			try {
//				String url = configuration.getConfiguration().get(i).getUrl();
//				String marker = configuration.getConfiguration().get(i).getMarker();
//				String regex = configuration.getConfiguration().get(i).getRegex();
//				String text = new HttpRequest().getWebText(url);
//				
//				/* extracting marker from total text */
//		        Pattern patternOne = Pattern.compile(marker);
//		        Matcher matcherOne = patternOne.matcher(text);
//		        matcherOne.find();
//		        System.out.println("marker: " + matcherOne.group());
//		        String found = matcherOne.group();
//		        /* extracting regex from marker */
//		        Pattern patternTwo = Pattern.compile(regex);
//		        Matcher matcherTwo = patternTwo.matcher(found);
//		        matcherTwo.find();
//		        System.out.println("value: " + matcherTwo.group());
//			}
//			catch(IllegalStateException e) {
//				System.out.println("error");
//				System.out.println(configuration.getConfiguration().get(i).getUrl());
//			}
//		}

	}

}
