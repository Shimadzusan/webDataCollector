package core;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import configuration.ConfigurationAlpha;
import configuration.ConfigurationBetta;
import configuration.ConfigurationDelta;
import destination.DestinationAlpha;
import destination.DestinationFile;
import source.SourceAlpha;
import source.SourceWeb;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan({"core", "source", "destination"})
//@PropertySource("musicPlayer.properties")
public class SpringConfiguration {
	String configurationFile = "configurationWebDataCollector.xml";
	
	@Bean
	public ConfigurationAlpha configurationAlpha() {
		return new ConfigurationAlpha();
	}
	
	@Bean
	public ConfigurationBetta configurationBetta() {
		return new ConfigurationBetta();
	}
	
	@Bean
	public ConfigurationDelta configurationDelta() throws FileNotFoundException, IOException {
		return new ConfigurationDelta(configurationFile);
	}
	
	@Bean
	public SourceAlpha sourceAlpha() {
		return new SourceAlpha();
	}
	
	@Bean
	public SourceWeb sourceWeb() throws FileNotFoundException, IOException {
		return new SourceWeb(configurationDelta());
	}
	
	@Bean
	public DestinationAlpha destinationAlpha() {
		return new DestinationAlpha();
	}
	
	@Bean
	public DestinationFile destinationFile() throws FileNotFoundException, IOException {
		return new DestinationFile(configurationDelta());
	}
	
	@Bean
	public ControlModule controlModule() throws FileNotFoundException, IOException {
		/* dependency injection instead @Autowired */
		return new ControlModule(configurationDelta(), sourceWeb(), destinationFile());
	}

}
