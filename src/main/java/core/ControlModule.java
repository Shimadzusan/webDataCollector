package core;

import io.prometheus.client.Counter;
import io.prometheus.client.exporter.HTTPServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import configuration.Configuration;
import configuration.ConfigurationObject;
import destination.Destination;
import network.Singleton;
import org.springframework.stereotype.Component;
import source.Source;

import java.io.IOException;

public class ControlModule {
	Configuration config;
	Source source;
	Destination destination;
	private final Logger LOG = (Logger) LogManager.getLogger(ControlModule.class);

	public ControlModule() throws IOException {}
	
	public ControlModule(Configuration config, Source source, Destination destination) throws IOException {
		this.config = config;
		this.source = source;
		this.destination = destination;
	}
	
	public void action() throws IOException {
		System.out.println("action+");
		long t = System.currentTimeMillis();	//..for time monitoring
		ConfigurationObject configurationObject = this.config.getConfiguration();
		//SimpleWDC simple = new SimpleWDC();

		for (int i = 0; i < configurationObject.getListCase().size(); i++) {
			//simple.methodX();
			source.getDataFromSource(i);
			destination.sendData(i);
		}
		long t2 = (System.currentTimeMillis() - t) / 1000;	//..for time monitoring
		LOG.info("total traffic: " + Singleton.totalTraffic + " bytes");	//..for traffic monitoring
		LOG.info("action: " + t2 + " sec");
	}
	
	public synchronized Configuration getConfig() {return config;}

	public synchronized void setConfig(Configuration config) {this.config = config;}

	public synchronized Source getSource() {return source;}

	public synchronized void setSource(Source source) {this.source = source;}

	public synchronized Destination getDestination() {return destination;}

	public synchronized void setDestination(Destination destination) {this.destination = destination;}

}
