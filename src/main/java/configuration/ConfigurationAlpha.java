package configuration;

import core.InstanceData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import util.DataOperation;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class ConfigurationAlpha implements Configuration {

	private final Logger LOG = (Logger) LogManager.getLogger(ConfigurationBetta.class);
	String configurationFile = "";
	List<Case> listCase = new ArrayList<Case>();	//..beginning of parssing config file... creating nessecary variables
	ConfigurationObject configurationObject = new ConfigurationObject();
	DataOperation dataOperation = new DataOperation();

	public ConfigurationAlpha() {}

	public ConfigurationAlpha(String configurationFile) throws FileNotFoundException, IOException {
		this.configurationFile = configurationFile;
		logging("start reading configuration, file: " + configurationFile);
		String xmlString = dataOperation.readDataFromFile(configurationFile);
		logging("reading configuration successfully completed");

		/* initialization every case from configurationFile */
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(ConfigurationObject.class, Case.class, Cases.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			ConfigurationObject configurationObject = (ConfigurationObject) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));
			Cases cases = configurationObject.getCases();

			for (int i = 0; i < cases.getCases().length; i++) {
				List<InstanceData> instanceData = new ArrayList<InstanceData>();
				Case casse = cases.getCases()[i];
//				System.out.println(casse.getFileConfig());
//				System.out.println(casse.getThread());
//				System.out.println(casse.getMode());

				//init instanceData..
				if(casse.getMode().contains("crawler")) {
					String[] csv = (dataOperation.readDataFromFile(casse.getFileConfig())).split("\\n");

					try {
						for (int j = 1; j < csv.length; j++) {
							InstanceData id = new InstanceData();
							String[] array = csv[j].split(";");
							id.setUrl(array[0]);
							id.setAlgorithm(array[1]);
							id.setTableData(array[3]);
//							id.setFileDestination(array[3]);
//							id.setTypeOfSourceExtractor(array[4]);
							instanceData.add(id);
						}
					} catch (ArrayIndexOutOfBoundsException e) {
					}

					casse.setListInstanceData(instanceData);
					listCase.add(casse);
				}
			}
			this.configurationObject.setListCase(listCase);

			logging("initialization configurationObject successfully completed");
			LOG.info("amount cases: " + cases.getCases().length);
		}
		catch (JAXBException e) {e.printStackTrace();}
	}

	@Override
	public ConfigurationObject getConfiguration() {return this.configurationObject;}

	@Override
	public String readConfiguration() {return null;}

	private void readConfigurationFile() {

	}

	private boolean logging(String logMessage) {
		LOG.info(logMessage);
		return true;
	}

}
