package source;

import util.DataOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CmdCurl {
    public CmdCurl() {}

    public String getWebText(String url) {
        String command = "curl " + url;
        String result = "";
        DataOperation dataOperation = new DataOperation();

        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String htmlString = result;
        Document doc = Jsoup.parse(htmlString);
        String text = doc.body().text();
        return text;
    }
}
