package source;

import util.DataOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdCurl {
    CmdCurl() {
        String command = "curl https://www.avito.ru/moskva/kvartiry/prodam-ASgBAgICAUSSA8YQ?localPriority=0";

        DataOperation dataOperation = new DataOperation();
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String result = sb.toString();
            //System.out.println(result.contains("Продажа квартир в Москве" + "Продажа квартир в Москве"));
            dataOperation.writeDataToFile("avito_debug.txt",result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
