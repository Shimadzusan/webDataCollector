package core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Launch {

	public static void main(String[] args) {
		/* next 3rd step objects to applicationContext fron SpringConfiguration.java */
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        ControlModule cm = springContext.getBean("controlModule", ControlModule.class);
        cm.action();
        //cm.someMethod();
	}

}
