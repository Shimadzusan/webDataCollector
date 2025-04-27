package network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import util.DataOperation;

/* implementation org.jsoup */
public class HttpRequest {
	private final Logger LOG = (Logger) LogManager.getLogger(HttpRequest.class);
	String webText = "";
	String html = "";
	
	public String getWebText(String url) {
		Document doc = null;
		String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36";
			try {
				doc = Jsoup.connect(url).userAgent(userAgent).get();
				webText = doc.text(); //Исходный текст
			}
			catch(MalformedURLException e) {
				System.out.println("++++");}
			catch(IOException e) {LOG.error(e);}
			catch(java.lang.NullPointerException e) {LOG.error(e);}
        return webText;
	}
	
	public String getHtml(String url) {
		Document doc = null;
			try {
				doc = Jsoup.connect(url).get();
				html = doc.outerHtml(); //html
			}
			catch(IOException e) {LOG.error(e);}
			catch(java.lang.NullPointerException e) {LOG.error(e);}
		return html;
	}

}
