package network;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


/** implementation decorator pattern */
public class HttpRequestDecorator {
	private final Logger LOG = (Logger) LogManager.getLogger(HttpRequestDecorator.class);
	String webText = "";
	String html = "";
	
	public String getWebText(String url) {
		webText = new HttpRequest().getWebText(url);
		LOG.info("url: " + url);
		LOG.info("traffic size: " + getTrafficLength(webText));
		Singleton.totalTraffic = Singleton.totalTraffic + getTrafficLength(webText);  
		return webText;
	}
	
	/** This method added as new behaviors of Decorator */
	public int getTrafficLength(String text) {
		return text.length();
	}
	
}
