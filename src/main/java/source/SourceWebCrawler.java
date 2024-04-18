package source;

import configuration.Configuration;
import configuration.ConfigurationObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
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

    @Override
    public String getDataFromSource(int number) {
        System.out.println("SourceWebCrawler");
        if(configurationObject.getListCase().get(number).getMode().contains("crawler")) {
            System.out.println("++");
            System.out.println(configurationObject.getListCase().get(number).getListInstanceData().size());
            for (int i = 0; i < configurationObject.getListCase().get(number).getListInstanceData().size(); i++) {
                String s = configurationObject.getListCase().get(number).getListInstanceData().get(i).getUrl();
                System.out.println(s);
            }
        }
        return "";
    }

    private static HashSet extractHtmlLinks(String[] arrayAddresses) throws IOException {
        HashSet<String> resultAddresses = new HashSet<>();

        for (int i = 0; i < arrayAddresses.length; i++) {
            String url = arrayAddresses[i];
            System.out.println(arrayAddresses.length - i);
            int counter = 0;
            try {
                Document doc = Jsoup.connect(url).get();
                Elements links = doc.select("a[href]");

                for (Element link : links) {
                    String linkUrl = link.attr("abs:href");
                    //System.out.println("text: " + link.text());
//                    System.out.println(linkUrl);
                    resultAddresses.add(linkUrl);
                    counter++;
                    System.out.println(links.size() - counter);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return resultAddresses;
    }
}
