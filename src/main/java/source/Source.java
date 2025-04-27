package source;

import configuration.ConfigurationObject;

import java.io.IOException;

public interface Source {
	boolean setConfigurationData(ConfigurationObject configurationObject);	//	..logical input
	/* this method is first candidate to generic methods because unknown what type must have returning object */
	String getDataFromSource(int number) throws IOException;		//	..logical output
}
