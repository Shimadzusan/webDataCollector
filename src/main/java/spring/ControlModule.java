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
	
	public void action() {
		String s = "";
		s = s + config.getConfiguration();
		s = s + source.getSource();
		s = s + destination.getDestination();
		System.out.println(s);
	}

}
