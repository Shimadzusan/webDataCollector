package debug;

import com.sun.management.ThreadMXBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.net.HttpURLConnection;
import java.net.URL;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import network.HttpRequest;
import source.CmdCurl;
import source.SourceWeb;
import util.DataOperation;
import util.LocalReflect;

import java.net.*;
import java.io.*;

import java.io.IOException;
import java.util.Set;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class Debug {
    private final static Logger LOG = (Logger) LogManager.getLogger(Debug.class);


    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        alt_glassdoor();

    //JMX
//        try {
//            String hostname = "localhost";  // Replace with your JMX hostname
//            int port = 3555;  // Replace with your JMX port number
//
//            JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + hostname + ":" + port + "/jmxrmi");
//            JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
//
//            MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
////            QueryExp query = Query.match(Query.attr("ThreadCount"), Query.value("int"));
//            ObjectName mbeanName = new ObjectName("java.lang:type=Threading,*");
//            Set<ObjectInstance> mbeans = mbsc.queryMBeans(mbeanName, null);
//            for (ObjectInstance mbean : mbeans) {
//                ObjectName objectName = mbean.getObjectName();
//                System.out.println("MBean: " + objectName);
////                for (MBeanAttributeInfo attribute : mbsc.getMBeanInfo(objectName).getAttributes()) {
//                MBeanAttributeInfo attribute = mbsc.getMBeanInfo(objectName).getAttributes()[0];
//                String attributeName = attribute.getName();
//                    Object attributeValue = mbsc.getAttribute(objectName, "ThreadCount");
//                    System.out.println("  Attribute Name: " + attributeName + " - Value: " + attributeValue);
////                }
//            }

            //Set<ObjectInstance> mbeans = mbsc.queryMBeans(null, null);
//            for (ObjectInstance mbean : mbeans) {
//                ObjectName objectName = mbean.getObjectName();
//                System.out.println("MBean: " + objectName);
//                MBeanInfo mBeanInfo = mbsc.getMBeanInfo(objectName);
//                MBeanAttributeInfo[] attributes = mBeanInfo.getAttributes();
//                for (MBeanAttributeInfo attribute : attributes) {
//                    System.out.println("  Attribute: " + attribute.getName() + " - Type: " + attribute.getType() + " - Description: " + attribute.getDescription());
//                }
//            }
//            for (ObjectInstance mbean : mbeans) {
//                ObjectName objectName = mbean.getObjectName();
//                System.out.println("MBean: " + objectName);
//                MBeanAttributeInfo[] attributes = mbsc.getMBeanInfo(objectName).getAttributes();
//                for (MBeanAttributeInfo attribute : attributes) {
//                    String attributeName = attribute.getName();
//                    Object attributeValue = null;
//                    try {
//                        attributeValue = mbsc.getAttribute(objectName, attributeName);
//                    } catch (RuntimeMBeanException e){
//                        System.out.println("RuntimeMBeanException+++");
//                    }
//                    System.out.println("  Attribute Name: " + attributeName + " - Value: " + attributeValue);
//                }
//            }


            //jmxc.close();
        }

    private static void alt_glassdoor() {
        System.out.println("..uniq_case_1");
        String text = new CmdCurl().getWebText("https://us.jobsora.com/jobs/usa/q-attorney");
        System.out.println(text.length());
        System.out.println(text);
    }

//   catch (IOException e) {
//            e.printStackTrace();
//        } catch (ReflectionException e) {
//            throw new RuntimeException(e);
//        } catch (InstanceNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IntrospectionException e) {
//            throw new RuntimeException(e);
//        } catch (AttributeNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (MBeanException e) {
//            throw new RuntimeException(e);
//        } catch (MalformedObjectNameException e) {
//            throw new RuntimeException(e);
//        }
//        catch (RuntimeMBeanException e) {
//            System.out.println("RuntimeMBeanException++");
//        }
        ///////////////////////////////////////////////////////////////////
        //        DataOperation dataOperation = new DataOperation();
//        String s = dataOperation.readDataFromFile("C:\\Users\\tokug\\Desktop\\counter_heap.txt");
//
//        String[] s_array = s.split("\\n");
//        for (int i = 0; i < s_array.length; i++) {
//            String[] s2_array = s_array[i].split("\\.");
//            try {
//                System.out.println(s2_array[0] + " " + s2_array[1]);
//            } catch (IndexOutOfBoundsException e) {}
//        }
        ////////////////////////////////////////////////////////
        //        byte[] byteArray = { 109, 101, 116, 114, 105, 99, 95, 50 }; // Replace this with your actual byte array
//
//        String str = new String(byteArray, StandardCharsets.UTF_8); // Assuming UTF-8 encoding, replace with the appropriate encoding if needed
//
//        System.out.println(str);
        //headHunter();
//        String command = "curl https://justjoin.it/all-locations/java";
//        try {
//            Process process = Runtime.getRuntime().exec(command);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//
//        // Load a class using the ClassLoader
//        Class<?> myClass = classLoader.loadClass("debug.Debug");
//
//        // Print the name of the loaded class
//        System.out.println("Loaded class: " + myClass.getName());
//		while(true) {
//			int i = 25 + 15;
//			//System.out.println(i);
//			int s = i +100;
//
//		}
        //avito();

//		 try {
//	            // URL of the mockAPI service
//	            URL url = new URL("https://64ba7c295e0670a501d63f8e.mockapi.io/glassdoor");
//
//	            // Create an HTTP connection
//	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//	            // Set the HTTP request method to POST
//	            connection.setRequestMethod("POST");
//
//	            // Set the content type as JSON
//	            connection.setRequestProperty("Content-Type", "application/json");
//
//	            // Enable input and output streams
//	            connection.setDoInput(true);
//	            connection.setDoOutput(true);
//
//	            // Create the JSON payload
//	            String payload = "{\r\n" +
//	            		"  \"time\": 20230704,\r\n" +
//	            		"  \"us_java_dev\": null,\r\n" +
//	            		"  \"us_driver\": 64152,\r\n" +
//	            		"  \"us_accountant\": 39554,\r\n" +
//	            		"  \"us_attorney\": 11679,\r\n" +
//	            		"  \"us_sales_manager\": null,\r\n" +
//	            		"  \"us_nurse\": 99027,\r\n" +
//	            		"  \"uk_java_dev\": 2870,\r\n" +
//	            		"  \"uk_driver\": 13324,\r\n" +
//	            		"  \"uk_accountant\": 13394,\r\n" +
//	            		"  \"uk_attorney\": null,\r\n" +
//	            		"  \"uk_sales_manager\": null,\r\n" +
//	            		"  \"uk_nurse\": 22490\r\n" +
//	            		" }";
//
//	            // Write the JSON payload to the connection's output stream
//	            OutputStream outputStream = connection.getOutputStream();
//	            outputStream.write(payload.getBytes());
//	            outputStream.flush();
//	            outputStream.close();
//
//	            // Get the HTTP response code
//	            int responseCode = connection.getResponseCode();
//
//	            // Read the response from the server
//	            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//	            String line;
//	            StringBuilder response = new StringBuilder();
//	            while ((line = reader.readLine()) != null) {
//	                response.append(line);
//	            }
//	            reader.close();
//
//	            // Print the response
//	            System.out.println("Response Code: " + responseCode);
//	            System.out.println("Response: " + response.toString());
//
//	            // Close the connection
//	            connection.disconnect();
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }

//		joinItPl();
        //	new HttpRequest().sendHttpPostRequest();

//		String text = "в РоссииНа карте 753 вакансии «C#» Найдено 753 вакансии По соответствию За всё время Подработка Подработка Временная работаНеполный деньОт 4 часов в деньРазовое заданиеПо вечерамПо выходным Исключить слова Исключить слова Уровень дохода руб. Не имеет значения от 5 000 руб. 185 от 95 000 руб. 170 от 180 000 руб. 125 от 270 000 руб. 48 от 360 000 руб. 19 от 450 000 руб. 9 Своя зарплата Указан доход 185 Уровень";
//		String text1 = "Компании в РоссииНа карте 2 753 вакансии «C#» Найдено 2 753 вакансии По соответствию За всё время Подработка Подработка Временная работаНеполный деньОт 4 часов в деньРазовое заданиеПо вечерамПо выходным Исключить слова Исключить слова Уровень дохода руб. Не имеет значения от 5 000 руб. 185 от 95 000 руб. 170 от 180 000 руб. 125 от 270 000 руб. 48 от 360 000 руб. 19 от 450 000 руб. 9 Своя зарплата Указан доход 185 Уровень";
//		/* extracting marker from total text */
////        Pattern patternOne = Pattern.compile("[\\w]\\s[0-9]+ ваканси");
////		 Pattern patternOne = Pattern.compile("[\\w] [0-9]+ вакансии По");
//		 Pattern patternOne = Pattern.compile("Найдено.*По соответствию");
//        Matcher matcherOne = patternOne.matcher(text);
//        matcherOne.find();
//        System.out.println("marker: " + matcherOne.group());
//        String found = matcherOne.group();
//        System.out.println("found: " + found);
//
//		System.out.println(found.replaceAll(" ", ""));

//		String url = "https://hh.ru/search/resume?text=C%23&clusters=true&exp_period=all_time&logic=normal&pos=full_text&clusters=true&area=1&specialization=1.221&order_by=publication_time&no_magic=false&from=suggest_post";
//		String text = new HttpRequest().getWebText(url);
//		System.out.println(text);

        //System.out.println(buildRequest());

//		xmlToJavaObject();
        //glassDoor();
        //divideFile();
//		all();
//		localReflect();

//		 URL url = new URL("https://lenta.ru");
//	     URLConnection con = url.openConnection();
//	     System.out.println(con.getInputStream());

//		version_3();
//		headHunterJava();

//		String s = "https://hh.ru/search/vacancy?text=Java&only_with_salary=false&specialization=1.221&area=1&enable_snippets=true&clusters=true&no_magic=true&salary=&from=suggest_post&page=2;\\{\"auctionData.*;\\{\"auctionData.*;sun;itSector;vacMoscowJavaDev";
//			//System.out.println(s);
//
//			for (int i = 20; i < 40; i++) {
//				System.out.println("https://hh.ru/search/vacancy?text=Java&only_with_salary=false&specialization=1.221&area=1&enable_snippets=true&clusters=true&no_magic=true&salary=&from=suggest_post&page=" + i + ";\\{\"auctionData.*;\\{\"auctionData.*;sun;itSector;vacMoscowJavaDev");
//			}


    public static void joinItPl() throws IOException {
//		String url = "https://64ba7c295e0670a501d63f8e.mockapi.io/users";
//		String text = new HttpRequest().getWebText(url);
//		System.out.println(text);

//		 URL url = new URL("https://64ba7c295e0670a501d63f8e.mockapi.io/users");
//	     URLConnection con = url.openConnection();
//	     System.out.println(con.getInputStream());
        String url = "https://jobitt.com/job-openings/countries/poland";
        String text = new HttpRequest().getWebText(url);
        System.out.println(text);
    }

    public static void headHunter() {
        //String url = "https://hh.ru/search/vacancy?text=Java&only_with_salary=false&specialization=1.221&area=1&enable_snippets=true&clusters=true&no_magic=true&salary=&from=suggest_post";
        String url = "https://hh.ru/search/resume?text=Java&logic=normal&pos=full_text&exp_period=all_time&specialization=1.221&area=1&relocation=living_or_relocation&salary_from=&salary_to=&currency_code=RUR&education=none&age_from=&age_to=&gender=unknown&order_by=publication_time&search_period=0&items_on_page=20&from=suggest_post";
        String text = new HttpRequest().getWebText(url);
        System.out.println(text);
    }

    public static void localReflect() throws FileNotFoundException, IOException {
        LocalReflect lr = new LocalReflect();
    }

    public static void all() {
        Integer z = new Integer(5);
        Properties props = System.getProperties();
        //System.out.println(props);
        System.out.println(System.getenv());
    }

    public static void avito() {
        System.out.println("..avito debug");
        //String url = "https://www.avito.ru/moskva/kvartiry/prodam-ASgBAgICAUSSA8YQ?localPriority=0";
        String url = "https://www.avito.ru/moskva/kvartiry/prodam-ASgBAgICAUSSA8YQ?localPriority=0";
//		String text = new HttpRequest().getWebText(url);
//		System.out.println(text);

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
        String text = "%22currentParent%22%3Afalse%2C%22opened%22%3Afalse%2C%22level%22";


        try {
            int x = 100 - 10;
            String decodedString = URLDecoder.decode(text, "UTF-8");
            System.out.println(decodedString);
        }
        catch(java.lang.IllegalStateException e) {
            System.out.println("No match found");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void glassDoor() throws IOException {
        System.out.println("..headHunterJava");
        //String url = "https://www.glassdoor.com/Job/new-york-java-developer-jobs-SRCH_IL.0,8_IC1132348_KO9,23.htm";
        //String url = "https://www.glassdoor.com/Job/us-driver-jobs-SRCH_IL.0,2_IN1_KO3,9.htm?context=Jobs&clickSource=searchBox";

        String url = "https://www.glassdoor.com/Job/us-attorney-jobs-SRCH_IL.0,2_IN1_KO3,11.htm?context=Jobs&clickSource=searchBox";
//		String text = new HttpRequest().getWebText(url);
        String text = new HttpRequest().getHtml(url);
        System.out.println(text);
        Integer x = new Integer(2);


        String marker = "in United States .* jobs Most Relevant";
        String regex = "[0-9]+";

        try {
            Pattern patternOne = Pattern.compile(marker);
            Matcher matcherOne = patternOne.matcher(text);
            matcherOne.find();
            //System.out.println("marker: " + matcherOne.group());
            String found = matcherOne.group();
            //System.out.println("found: " + found);
            /* extracting regex from marker */
            Pattern patternTwo = Pattern.compile(regex);
            Matcher matcherTwo = patternTwo.matcher(found.replaceAll(" ", ""));
            matcherTwo.find();
            System.out.println("value: " + matcherTwo.group());
            //this.data = matcherTwo.group();

            //configurationObject.getListCase().get(number).getListInstanceData().get(i).setValue(matcherTwo.group());
            //configurationObject.getConfiguration().get(i).setValue(matcherTwo.group()); delete in next commit
        }
        catch(java.lang.IllegalStateException e) {
            System.out.println("No match found");
        }

//		        URL url = new URL("https://www.glassdoor.com/Job/new-york-java-developer-jobs-SRCH_IL.0,8_IC1132348_KO9,23.htm");
//		        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//
//		        con.setRequestMethod("GET");
//		        con.setRequestProperty("User-Agent", "Mozilla/5.0");
//
//		        int responseCode = con.getResponseCode();
//		        System.out.println("Response code: " + responseCode);
//
//		        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//		        String inputLine;
//		        StringBuffer content = new StringBuffer();
//		        while ((inputLine = in.readLine()) != null) {
//		            content.append(inputLine);
//		        }
//		        in.close();
//
//		        System.out.println("Response body: " + content);

    }

    public static String buildRequest() throws ClassNotFoundException, SQLException {
        String columns = "";
        String values = "";
        DataOperation var1 = new DataOperation();//.. generate date for sql


        String s = "insert itSector(date," + columns + ") values(" + var1.getDate("YYYYMMdd") + "," + values + ")";
        System.out.println("buildRequest ...complete");
        return s;
    }

    public static void xmlToJavaObject() {
        System.out.println("**--");
        String xmlString = "<configuration>\r\n" +
                "  <cases>\r\n" +
                "    <case>\r\n" +
                "      <fileConfig>target.csv</fileConfig>\r\n" +
                "      <thread>8</thread>\r\n" +
                "      <mode>test</mode>\r\n" +
                "    </case>\r\n" +
                "	<case>\r\n" +
                "      <fileConfig>avito.csv</fileConfig>\r\n" +
                "      <thread>4</thread>\r\n" +
                "      <mode>test</mode>\r\n" +
                "	</case>\r\n" +
                "  </cases>\r\n" +
                "  <dataBase>\r\n" +
                "	  <login>admin</login>\r\n" +
                "	  <password>pass</password>\r\n" +
                "  </dataBase>\r\n" +
                " </configuration>";

        JAXBContext jaxbContext;

        try
        {
            jaxbContext = JAXBContext.newInstance(ConfigurationObject.class, Case.class, Cases.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            ConfigurationObject configurationObject = (ConfigurationObject) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));
            //Case c = configurationObject.getCases()[1];
            Cases cc = configurationObject.getCases();
            Case c = cc.getCases()[0];
            ////System.out.println(configurationObject.getCases().length);
            System.out.println(c.getFileConfig());
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }

    }

    public static void divideFile() {
        // input and output filenames
//	      String inputFileName = "/media/worker/DA626DDB626DBCBF/Users/user/Desktop/eclipse-workspace/webDataCollector/03052023.json";
//	      String[] outputFiles = {"/media/worker/DA626DDB626DBCBF/Users/user/Desktop/eclipse-workspace/webDataCollector/output1.txt", "/media/worker/DA626DDB626DBCBF/Users/user/Desktop/eclipse-workspace/webDataCollector/output2.txt", "output3.txt", "output4.txt", "output5.txt"};

        String inputFileName = "02052023.json";
        String[] outputFiles = {"output1.txt", "output2.txt", "output3.txt", "output4.txt", "output5.txt"};

        // Define the buffer size
        int bufferSize = 548576;

        try (FileInputStream inputStream = new FileInputStream(inputFileName)) {
            System.out.println("size: " + inputStream.available());
            byte[] buffer = new byte[bufferSize];
            int bytesRead = 0;
            int fileNumber = 1;

            // Create output files and write data to them
            for (String outputFile : outputFiles) {
                FileOutputStream outputStream = new FileOutputStream(outputFile);
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                    if (outputStream.getChannel().size() >= bufferSize) {
                        break;
                    }
                }
                outputStream.close();
                System.out.println("File " + fileNumber + " created.");
                fileNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}