package spring;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan("spring")
@PropertySource("musicPlayer.properties")
public class SpringConfiguration {
	
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
		return new ConfigurationDelta("");
	}
	
	@Bean
	public SourceAlpha sourceAlpha() {
		return new SourceAlpha();
	}
	
	@Bean
	public DestinationAlpha destinationAlpha() {
		return new DestinationAlpha();
	}
	
	@Bean
	public ControlModule controlModule() throws FileNotFoundException, IOException {
		/* dependency injection instead @Autowired */
		return new ControlModule(configurationDelta(), sourceAlpha(), destinationAlpha());
	}

}
