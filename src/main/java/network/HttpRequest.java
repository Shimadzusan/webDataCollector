package network;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/* implementation org.jsoup */
public class HttpRequest {
	
	public String getWebText(String url) {
		Document doc = null;
			try {
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				e.printStackTrace();
			}
		String webText = doc.text(); //Исходный текст
		return webText;
	}
	
	public String getHtml(String url) {
		Document doc = null;
			try {
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				e.printStackTrace();
			}
		String html = doc.text(); //Исходный текст
		return html;
	}

}
