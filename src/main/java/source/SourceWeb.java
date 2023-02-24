package source;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import network.HttpRequest;

/** input: url, marker, regex 
 * 	output: value from webpage for storage in database 
 * 	This class implements one from many possibility extracting data from webpage */
public class SourceWeb implements Source {
	String data = "";

	@Override
	public boolean setConfigurationData() {
		return true;
	}
	
	@Override
	public String getDataFromSource() {
		classLogic();
		return "getSourceWeb: " + data;
	}
	
	public void classLogic() {
		/* realtySector */
		/* citizenswareSector */
		
		String input = "";
		String output = "";	
		
		/* input */
		String url = "https://www.avito.ru/moskva/kvartiry/prodam-ASgBAgICAUSSA8YQ?context=H4sIAAAAAAAA_0q0MrSqLraysFJKK8rPDUhMT1WyLrYyNLNSKk5NLErOcMsvyg3PTElPLVGyrgUEAAD__xf8iH4tAAAA&localPriority=0";
		String url1 = "https://www.avito.ru/sankt-peterburg/kvartiry/prodam-ASgBAgICAUSSA8YQ?localPriority=0";
		String text = new HttpRequest().getWebText(url1);
		
		/* extracting marker from total text */
		String marker = "Продажа квартир в Санкт-Петербурге.* Недвижимость";
		String regex = "[0-9]+";
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
//        configuration.getConfiguration().get(i).setValue(matcherTwo.group());
//        System.out.println("value2: " + configuration.getConfiguration().get(i).getValue());
	
        /* output */
        
		//System.out.println(text);
	}

}
