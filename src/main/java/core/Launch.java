package core;

import io.prometheus.client.Counter;
import io.prometheus.client.exporter.HTTPServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Launch {
	private final static Logger LOG = (Logger) LogManager.getLogger(Launch.class);

	public static void main(String[] args) throws InterruptedException, IOException {
//		while(true) {
			LOG.info("start version 2.5");
			/* next 3rd step, objects to applicationContext from SpringConfiguration.java */
			AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
			//ControlModule controlModule = springContext.getBean("controlModule", ControlModule.class);
			//ControlModule controlModuleAlt = springContext.getBean("controlModuleAlt", ControlModule.class);
			int delay = springContext.getBean(SpringConfiguration.class).mainTimeInterval;// ..uses for day delay
			//controlModule.action();
			//controlModuleAlt.action();
			ControlModule controlModuleContact = springContext.getBean("controlModuleContact", ControlModule.class);
			controlModuleContact.action();
//			Thread.sleep(delay);
//		}
	}

}
