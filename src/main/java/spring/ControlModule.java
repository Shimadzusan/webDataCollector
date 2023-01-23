package spring;

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
		String s = "";
		s = s + config.getConfiguration() + " ";
		s = s + source.getSource() + " ";
		s = s + destination.getDestination() + " ";
		System.out.println(s);
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
