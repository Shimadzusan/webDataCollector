package spring;

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
	public SourceAlpha sourceAlpha() {
		return new SourceAlpha();
	}
	
	@Bean
	public DestinationAlpha destinationAlpha() {
		return new DestinationAlpha();
	}
	
	@Bean
	public ControlModule controlModule() {
		/* dependency injection instead @Autowired */
		return new ControlModule(configurationAlpha(), sourceAlpha(), destinationAlpha());
	}

}
