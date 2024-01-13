package debug;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleHttpRequest {
    public static void main(String[] args) throws InterruptedException {
        while(true) {
            Thread.sleep(1000);
            try {
                URL url = new URL("http://localhost:8080/counter_response");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println(response.toString());
                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}