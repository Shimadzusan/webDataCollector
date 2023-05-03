package network;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/* implementation org.jsoup */
public class HttpRequest {
	private final Logger LOG = (Logger) LogManager.getLogger(HttpRequest.class);
	String webText = "";
	String html = "";
	
	public String getWebText(String url) {
		Document doc = null;
		String userAgent = "Mozilla/5.0";
			try {
				doc = Jsoup.connect(url).userAgent(userAgent).get();
				webText = doc.text(); //Исходный текст
			}
			catch(IOException e) {LOG.error(e);}
			catch(java.lang.NullPointerException e) {LOG.error(e);}
		
		return webText;
	}
	
	public String getHtml(String url) {
		Document doc = null;
			try {
				doc = Jsoup.connect(url).get();
				html = doc.html(); //html
			}
			catch(IOException e) {LOG.error(e);}
			catch(java.lang.NullPointerException e) {LOG.error(e);}
		
		return html;
	}

}
