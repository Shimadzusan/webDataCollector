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
		LOG.info("start version 2.2");
		/* next 3rd step, objects to applicationContext from SpringConfiguration.java */
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ControlModule controlModule = springContext.getBean("controlModule", ControlModule.class);
        controlModule.action();
//		SimpleWDC asd = new SimpleWDC();
//		for (int i = 0; i < 100; i++) {
//			Thread.sleep(5000);
//			asd.methodX();
//
//		}
	}

}
