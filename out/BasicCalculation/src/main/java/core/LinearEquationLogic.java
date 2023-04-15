package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class LinearEquationLogic {
	
	private final static Logger LOG = (Logger) LogManager.getLogger(LinearEquationLogic.class);
	
	public LinearEquationLogic() {
		
		/* generation first random line */
		StraightLine straightLine1 = new StraightLine();
//		straightLine1.generateStraightLine(2, 2, 6, 4); //..works, y = 0.5x + 1.0
//		straightLine1.generateStraightLine(7, 1, 10, 4); // y = 1.0x -6.0
//		straightLine1.generateStraightLine(2,1,4,4); // y = 1.5x -2.0
//		straightLine1.generateStraightLine(3,1,3,0); //Infinity
//		straightLine1.generateStraightLine(0,3,2,2); // y = -0.5x + 3.0
//		straightLine1.generateStraightLine(2,0,1,4); // y = -4.0x + 8.0
		straightLine1.generateStraightLine();
		
		straightLine1.toString();
		double[] r = straightLine1.convertToEquation();	
		double var1 = r[0];// first part of the equation
		double var2 = r[1];// second part of the equation
		
		/* generation second random line */
		StraightLine straightLine2 = new StraightLine();
		straightLine2.generateStraightLine();
		straightLine2.toString();
		double[] r2 = straightLine2.convertToEquation();
		double var3 = r2[0];// first part of the equation
		double var4 = r2[1];// second part of the equation
		
		/* solution an linear equation, calculating the point of intersection */
		double var5 = var1 - var3;
		double var6 = var4 - var2;
		double var7 = var6 / var5;
		
		LOG.info("the point of intersection:");
		LOG.info("var7 x: " + var7);
		double var8 = var1 * var7 + var2; // injection value in equation
		LOG.info("var8 y: " + var8);
	}
	
	/** The variable 'number' it is quantity of points */
	public Point generateRandomPoints(int number) {
		return null;
	}

}
