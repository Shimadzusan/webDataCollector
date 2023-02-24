package configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import core.InstanceData;
import util.DataOperation;

public class ConfigurationDelta implements Configuration {
	String configurationFile = "";
	List<String> target = new ArrayList();
	List<String> url = new ArrayList();
	List<InstanceData> instanceData = new ArrayList();
	DataOperation dataOperation = new DataOperation();
	
	public ConfigurationDelta(String configurationFile) throws FileNotFoundException, IOException {
		this.configurationFile = configurationFile;
		System.out.println("delta");
		
	}

	@Override
	public String getConfiguration() {
		return "configurationDelta";
	}

	@Override
	public String readConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

}
