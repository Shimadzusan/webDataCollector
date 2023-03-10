package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launch {

	public static void main(String[] args) {
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//
//	        musicPlayer.playMusic();
//
//	        System.out.println(musicPlayer.getName()[2]);
//	        System.out.println(musicPlayer.getVolume());
//	        System.out.println(musicPlayer.getDeal());
//
//	        context.close();
	        
		/* classical approach without spring */
//			ConfigurationAlpha ca = new ConfigurationAlpha();//version one
//			Configuration ca1 = new ConfigurationAlpha();//version two
//	        Configuration cb = new ConfigurationBetta();//version three
//	        
//	        SourceAlpha sa = new SourceAlpha();
//	        DestinationAlpha da = new DestinationAlpha();
//	        
//	        ControlModule cm = new ControlModule(ca, sa, da);
//	        cm.action();
	        
	    /* next step objects from applicationContext */
//	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//	        
//	        Configuration cb = context.getBean("configurationBetta", ConfigurationBetta.class);//Singleton default! no Prototype
//	        SourceAlpha sa = context.getBean("sourceAlpha", SourceAlpha.class);
//	        DestinationAlpha da = context.getBean("destinationAlpha", DestinationAlpha.class);
//	        ControlModule cm = context.getBean("controlModule", ControlModule.class);
//	        cm.action();
		
		 /* next 3rd step objects to applicationContext fron SpringConfiguration.java */
        AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        
        Configuration cd = springContext.getBean("configurationDelta", ConfigurationDelta.class);//Singleton default! no Prototype
        SourceAlpha sa = springContext.getBean("sourceAlpha", SourceAlpha.class);
        DestinationAlpha da = springContext.getBean("destinationAlpha", DestinationAlpha.class);
        ControlModule cm = springContext.getBean("controlModule", ControlModule.class);
        cm.action();
        //cm.someMethod();
	}

}
