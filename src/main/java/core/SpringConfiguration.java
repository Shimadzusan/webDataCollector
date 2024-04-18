package core;

import java.io.FileNotFoundException;
import java.io.IOException;

//import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
//import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import destination.Destination;
import destination.DestinationDataBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import configuration.ConfigurationAlpha;
import configuration.ConfigurationBetta;
import configuration.ConfigurationDelta;
import destination.DestinationAlpha;
import destination.DestinationFile;
import source.Source;
import source.SourceAlpha;
import source.SourceWeb;
import org.springframework.context.annotation.ComponentScan;
import source.SourceWebCrawler;

@Configuration
@ComponentScan({"core", "source", "destination"})
@PropertySource("classpath:configuration.properties")
public class SpringConfiguration {
	
	@Value("${configuration.name}")
    private String configurationFile;

	@Value("${configuration.mainTimeInterval}")
	public int mainTimeInterval;
	
	@Bean
	public ConfigurationAlpha configurationAlpha() throws IOException {
		return new ConfigurationAlpha(configurationFile);}
	
	@Bean
	public ConfigurationBetta configurationBetta() throws FileNotFoundException, IOException {
		return new ConfigurationBetta(configurationFile);
	}
	
	@Bean
	public ConfigurationDelta configurationDelta() throws FileNotFoundException, IOException {
		return new ConfigurationDelta(configurationFile);
	}
	
	@Bean
	public SourceAlpha sourceAlpha() {return new SourceAlpha();}

	@Bean
	public SourceWeb sourceWeb() throws FileNotFoundException, IOException {
		SourceWeb sourceWeb = new SourceWeb(configurationBetta());//..only for example and comparisons
		for (int i = 0; i < 25; i++) {
			sourceWeb.exampleMethod();
		}
		return sourceWeb;
	}

	@Bean
	public SourceWebCrawler sourceWebCrawler() throws FileNotFoundException, IOException {return new SourceWebCrawler(configurationAlpha());}

	@Bean
	public DestinationAlpha destinationAlpha() {return new DestinationAlpha();}

	@Bean
	public DestinationDataBase destinationDataBase() {return new DestinationDataBase();}
	
	@Bean
	public DestinationFile destinationFile() throws FileNotFoundException, IOException {
		return new DestinationFile(configurationBetta());
	}
	
	@Bean
	public ControlModule controlModule() throws FileNotFoundException, IOException {
		/* dependency injection instead @Autowired */
		return new ControlModule(configurationBetta(), sourceWeb(), destinationFile());
	}

	@Bean (name = "controlModuleAlt")
	public ControlModule controlModuleAtl() throws FileNotFoundException, IOException {
		/* dependency injection instead @Autowired */
		return new ControlModule(configurationAlpha(), sourceWebCrawler(), destinationDataBase());
	}


}
