package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import util.DataOperation;

/* the implementation can be absolutely any */
public class Configuration {
	String configurationFile = "";
	List<String> target = new ArrayList();
	List<String> url = new ArrayList();
	List<InstanceData> instanceData = new ArrayList();
	DataOperation dataOperation = new DataOperation();
	
	public Configuration(String configurationFile) throws FileNotFoundException, IOException {
		this.configurationFile = configurationFile;
		readConfigurationFile();
		csvParse();
	}
	
	private void readConfigurationFile() {
		// Instantiate the Factory
	      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

	      try {
	          // optional, but recommended
	          // process XML securely, avoid attacks like XML External Entities (XXE)
	          dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

	          // parse XML file
	          DocumentBuilder db = dbf.newDocumentBuilder();

	          Document doc = db.parse(new File(configurationFile));

	          // optional, but recommended
	          // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	          doc.getDocumentElement().normalize();

	          System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

	          // get <case>
	          NodeList list = doc.getElementsByTagName("case");
	          System.out.println("cases: " + list.getLength());

	          for (int temp = 0; temp < list.getLength(); temp++) {
	              Node node = list.item(temp);
	              if (node.getNodeType() == Node.ELEMENT_NODE) {
	                  Element element = (Element) node;

	                  // get staff's attribute
//	                  String id = element.getAttribute("id");
	//
//	                  // get text
	                  String fileConfig = element.getElementsByTagName("fileConfig").item(0).getTextContent();
//	                  String lastname = element.getElementsByTagName("lastname").item(0).getTextContent();
//	                  String nickname = element.getElementsByTagName("nickname").item(0).getTextContent();
	//
//	                  NodeList salaryNodeList = element.getElementsByTagName("salary");
//	                  String salary = salaryNodeList.item(0).getTextContent();
	//
//	                  // get salary's attribute
//	                  String currency = salaryNodeList.item(0).getAttributes().getNamedItem("currency").getTextContent();
	//
//	                  System.out.println("Current Element :" + node.getNodeName());
//	                  System.out.println("Staff Id : " + id);
	                  System.out.println("fileConfig: " + fileConfig);
//	                  System.out.println("Last Name : " + lastname);
//	                  System.out.println("Nick Name : " + nickname);
//	                  System.out.printf("Salary [Currency] : %,.2f [%s]%n%n", Float.parseFloat(salary), currency);
	                  target.add(fileConfig);
	              }
	          }

	      } catch (ParserConfigurationException | SAXException | IOException e) {
	          e.printStackTrace();
	      }
	}
	
	public List<InstanceData> getConfiguration() {
		return this.instanceData;
	}
	
	public String csvParse() throws FileNotFoundException, IOException {
		for (int i = 0; i < target.size(); i++) {
			
			String[] csv = (dataOperation.readDataFromFile(target.get(i))).split("\\n");
			
				for (int j = 1; j < csv.length; j++) {
					InstanceData id = new InstanceData();
					String[] array = csv[j].split(";");
//					url.add(array[0]);
					id.setUrl(array[0]);
					id.setMarker(array[1]);
					id.setRegex(array[2]);
					instanceData.add(id);
				}
		}
		return "";
	}

}
