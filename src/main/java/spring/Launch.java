package spring;

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
	        ConfigurationAlpha ca = new ConfigurationAlpha();
	        SourceAlpha sa = new SourceAlpha();
	        DestinationAlpha da = new DestinationAlpha();
	        
	        ControlModule cm = new ControlModule(ca, sa, da);
	        cm.action();
	}

}
