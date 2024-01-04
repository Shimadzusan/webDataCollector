package source;

import configuration.ConfigurationObject;

public interface Source {
	boolean setConfigurationData(ConfigurationObject configurationObject);	//	..logical input
	String getDataFromSource(int number);		//	..logical output
}
