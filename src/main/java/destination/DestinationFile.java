package destination;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import configuration.Configuration;
import configuration.ConfigurationObject;
import util.DataOperation;

public class DestinationFile implements Destination {
	private final Logger LOG = (Logger) LogManager.getLogger(DestinationFile.class);
	ConfigurationObject configurationObject;
	String data = "";
	DataOperation dataOperation = new DataOperation();
	
	public DestinationFile(Configuration configuration) {this.configurationObject = configuration.getConfiguration();}

	@Override
	public String getDestination() {return "getDestination";}

	@Override
	public boolean sendData(int number) {
		String data = dataOperation.getDate("YYYYMMdd") + ";";
		for (int j = 0; j < configurationObject.getListCase().get(number).getListInstanceData().size(); j++) {
			String value = configurationObject.getListCase().get(number).getListInstanceData().get(j).getValue();
			data = data + value + ";";
		}
		
		data = data.substring(0, data.length() - 1);
		String dest = configurationObject.getListCase().get(number).getListInstanceData().get(0).getFileDestination();

		try {
			dataOperation.writeDataToFile(dest, dataOperation.readDataFromFile(dest) + data);
		} catch (IOException e) {LOG.error(e);}

		LOG.info("data to " + dest + " sent");
		return false;
	}

}
