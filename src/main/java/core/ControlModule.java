package core;

import configuration.Configuration;
import configuration.ConfigurationObject;
import destination.Destination;
import source.Source;

public class ControlModule {
	Configuration config;
	Source source;
	Destination destination;
	
	public ControlModule() {}
	
	public ControlModule(Configuration config, Source source, Destination destination) {
		this.config = config;
		this.source = source;
		this.destination = destination;
	}
	
	@Deprecated
	public void someMethod() {
		System.out.println("someMethod");
	}
	
	public void action() {
		ConfigurationObject configurationObject = this.config.getConfiguration();
		for (int i = 0; i < configurationObject.getListCase().size(); i++) {	
			source.getDataFromSource(i);
			destination.sendData(i);
		}
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
