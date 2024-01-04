package network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
			catch(IOException e) {LOG.error(e);}
			catch(java.lang.NullPointerException e) {LOG.error(e);}
		
		return webText;
	}
	
	public String getHtml(String url) {
		Document doc = null;
			try {
				doc = Jsoup.connect(url).get();
//				html = doc.outerHtml(); //html
				
				 Element rootDiv = doc.selectFirst("#root");
				 System.out.println(rootDiv.attributes());
				 System.out.println(rootDiv.childNodeSize());
				 System.out.println(rootDiv.childrenSize());
				 System.out.println(rootDiv.nodeName());
				 System.out.println(rootDiv);
			        String innerText = rootDiv.text();
			        System.out.println(innerText);
			}
			catch(IOException e) {LOG.error(e);}
			catch(java.lang.NullPointerException e) {LOG.error(e);}
		
		return html;
	}
	
	public boolean sendHttpPostRequest() throws IOException {
		 String url = "https://64ba7c295e0670a501d63f8e.mockapi.io/glassdoor";

	        HttpsURLConnection httpClient = (HttpsURLConnection) new URL(url).openConnection();

	        //add reuqest header
	        httpClient.setRequestMethod("POST");
	        httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");
	        httpClient.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

	        String urlParameters = new DataOperation().readDataFromFile("C:\\Users\\user\\eclipse-workspace\\clientModule\\glassdoor.json");

	        // Send post request
	        httpClient.setDoOutput(true);
	        try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
	            wr.writeBytes(urlParameters);
	            wr.flush();
	        }

	        int responseCode = httpClient.getResponseCode();
	        System.out.println("\nSending 'POST' request to URL : " + url);
	        System.out.println("Post parameters : " + urlParameters);
	        System.out.println("Response Code : " + responseCode);

	        try (BufferedReader in = new BufferedReader(
	                new InputStreamReader(httpClient.getInputStream()))) {

	            String line;
	            StringBuilder response = new StringBuilder();

	            while ((line = in.readLine()) != null) {
	                response.append(line);
	            }

	            //print result
	            System.out.println(response.toString());

	        }

	    
		
		return true;
	}

}
