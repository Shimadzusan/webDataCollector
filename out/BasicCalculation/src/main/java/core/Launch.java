package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Launch {
	private final static Logger LOG = (Logger) LogManager.getLogger(Launch.class);

	public static void main(String[] args) {

		for (int i = 0; i < 500; i++) {
//			long t1 = System.currentTimeMillis();
//			long t10 = System.nanoTime();
//			LOG.info("start version 1.1");
//			new LinearEquationLogic();
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			long t2 = System.currentTimeMillis() - t1;
//			long t20 = System.nanoTime() - t10;
//			LOG.info(t2);
//			LOG.info(t20/100);
			MainProcess mainProcess = new MainProcess();
			mainProcess.start();
		}

	}

}
