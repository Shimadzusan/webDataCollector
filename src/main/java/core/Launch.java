package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launch {
	private final static Logger LOG = (Logger) LogManager.getLogger(Launch.class);

	public static void main(String[] args) {
		LOG.info("start version 2.2");
		/* next 3rd step, objects to applicationContext from SpringConfiguration.java */
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ControlModule controlModule = springContext.getBean("controlModule", ControlModule.class);
        controlModule.action();
	}

}
