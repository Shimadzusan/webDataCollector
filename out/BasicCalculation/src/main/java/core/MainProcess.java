package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class MainProcess extends Thread implements Runnable {
	private final static Logger LOG = (Logger) LogManager.getLogger(MainProcess.class);

	@Override
	public void run() {
		for (int i = 0; i < 180; i++) {
			long t1 = System.currentTimeMillis();
			long t10 = System.nanoTime();
			LOG.info("start version 1.1");
			new LinearEquationLogic();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long t2 = System.currentTimeMillis() - t1;
			long t20 = System.nanoTime() - t10;
			LOG.info(t2);
			LOG.info(t20/100);
		}	
	}
}
