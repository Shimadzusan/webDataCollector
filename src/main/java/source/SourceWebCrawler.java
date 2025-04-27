package source;

import configuration.Configuration;
import configuration.ConfigurationObject;
import network.HttpRequestDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class SourceWebCrawler implements Source{
    private final Logger LOG = (Logger) LogManager.getLogger(SourceWebCrawler.class);
    ConfigurationObject configurationObject;
    String data = "";
    int number;//..number of row in configuration, maybe
    int exampleVar = 1;

    public SourceWebCrawler(Configuration configuration) throws IOException {
        this.configurationObject = configuration.getConfiguration();
    }

    @Override
    public boolean setConfigurationData(ConfigurationObject configurationObject) {
        return false;
    }

    /* this method is first candidate to generic methods because unknown what type must have returning object */
    @Override
    public String getDataFromSource(int number) throws IOException {
        System.out.println("SourceWebCrawler");
        if(configurationObject.getListCase().get(number).getMode().contains("crawler")) {
            System.out.println("++");
            System.out.println(configurationObject.getListCase().get(number).getListInstanceData().size());

            ArrayList<String[]> crawlerData = new ArrayList<>();

            for (int i = 0; i < configurationObject.getListCase().get(number).getListInstanceData().size(); i++) {
                String url = configurationObject.getListCase().get(number).getListInstanceData().get(i).getUrl();
                System.out.println(url);

//                String[] variableRowCrawlerData = new String[]{"10","20","30"};//..url;link;content
                HashSet<String> hset2level = extractHtmlLinks(url);
                for (String link : hset2level) {
                    String[] variableRowCrawlerData = new String[]{"10","20","30"};//..url;link;content
                    if(link.contains("http")) {
                    String content = new HttpRequestDecorator().getWebText(link);
                    variableRowCrawlerData[2] = content;
                    variableRowCrawlerData[1] = link;
                    variableRowCrawlerData[0] = url;
                    crawlerData.add(variableRowCrawlerData);}
                }
                configurationObject.getListCase().get(number).getListInstanceData().get(i).setCrawlerData(crawlerData);
            }
        }
        return "";
    }

    private HashSet extractHtmlLinks(String arrayAddresses) throws IOException {
        HashSet<String> resultAddresses = new HashSet<>();

//        for (int i = 0; i < arrayAddresses.length; i++) {
            String url = arrayAddresses;
//            System.out.println(arrayAddresses.length - i);
            int counter = 0;
            try {
                Document doc = Jsoup.connect(url).get();
                Elements links = doc.select("a[href]");

                for (Element link : links) {
                    String linkUrl = link.attr("abs:href");
                    //System.out.println("text: " + link.text());
                    System.out.println(linkUrl);
                    resultAddresses.add(linkUrl);
                    counter++;
                    System.out.println(links.size() - counter);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
//        }

        return resultAddresses;
    }
}
