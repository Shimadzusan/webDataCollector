package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import configuration.Configuration;
import configuration.ConfigurationObject;
import destination.Destination;
import network.Singleton;
import source.Source;

public class ControlModule {
	Configuration config;
	Source source;
	Destination destination;
	private final Logger LOG = (Logger) LogManager.getLogger(ControlModule.class);
	
	public ControlModule() {}
	
	public ControlModule(Configuration config, Source source, Destination destination) {
		this.config = config;
		this.source = source;
		this.destination = destination;
	}
	
	public void action() {
		long t = System.currentTimeMillis();	//..for time monitoring
		ConfigurationObject configurationObject = this.config.getConfiguration();
		for (int i = 0; i < configurationObject.getListCase().size(); i++) {	
			source.getDataFromSource(i);
			destination.sendData(i);
		}
		long t2 = (System.currentTimeMillis() - t) / 1000;	//..for time monitoring
		LOG.info("total traffic: " + Singleton.totalTraffic + " bytes");	//..for traffic monitoring
		LOG.info("action: " + t2 + " sec");
	}
	
	public synchronized Configuration getConfig() {
		return config;
	}

	public synchronized void setConfig(Configuration config) {
		this.config = config;
	}

	public synchronized Source getSource() {
		return source;
	}

	public synchronized void setSource(Source source) {
		this.source = source;
	}

	public synchronized Destination getDestination() {
		return destination;
	}

	public synchronized void setDestination(Destination destination) {
		this.destination = destination;
	}

}
