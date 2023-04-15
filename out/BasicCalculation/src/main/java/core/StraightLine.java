package core;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class StraightLine {
	private final static Logger LOG = (Logger) LogManager.getLogger(StraightLine.class);
	Point point1;
	Point point2;
	
	public void generateStraightLine() {
		this.point1 = new Point();
		this.point2 = new Point();
		
		this.point1.setX(getRandomNumber());
		this.point1.setY(getRandomNumber());
		this.point2.setX(getRandomNumber());
		this.point2.setY(getRandomNumber());
		
		// упорядочиваем точки в прямой для определения наклона прямой...
		generateStraightLine(this.point1.getX(),this.point1.getY(),this.point2.getX(),this.point2.getY());
	}
	
	/** for debugging */
	public void generateStraightLine(int point1, int point2, int point3, int point4) {
		this.point1 = new Point();
		this.point2 = new Point();
		// упорядочиваем точки в прямой для определения наклона прямой...
		if(point1 <= point3) {
			this.point1.setX(point1);
			this.point1.setY(point2);
			this.point2.setX(point3);
			this.point2.setY(point4);
		}
		
		if(point1 > point3) {
			this.point1.setX(point3);
			this.point1.setY(point4);
			this.point2.setX(point1);
			this.point2.setY(point2);
		}
	}
	
	public int getRandomNumber() {
		Random rn = new Random();
//		int n = rn.nextInt(10) - 5;
		int n = rn.nextInt(5) + 1;
		return n;
	}
	
	@Override
	public String toString() {
		LOG.info("straightLine point1/point2");
		LOG.info(this.point1.getX() + ";" + this.point1.getY() + " " + this.point2.getX() + ";" + this.point2.getY());
		return null;
	}
	
	/** convertion points to equation */
	public double[] convertToEquation() {
		int x1 = this.point1.getX();
		int y1 = this.point1.getY();
		int x2 = this.point2.getX();
		int y2 = this.point2.getY();
		
		// getting koeff_1
		int x = 0;
		if(x1 > x2)x = x2 - x1;
		if(x1 < x2)x = x1 - x2;
		if(x1 == x2)x = 0;
		
		int y = 0;
		if(y1 > y2)y = y2 - y1;
		if(y1 < y2)y = y1 - y2;
		if(y1 == y2)y = 0;
		
		x = Math.abs(x);
		y = Math.abs(y);
		LOG.info("x=" + x);
		LOG.info("y=" + y);
		
		double koef1 = 0;
		if(x > y) koef1 = (double)y / (double)x;
		if(x < y) koef1 = (double)y / (double)x;
		if(x == y) koef1 = 1;
		
		if(x1 < x2 && y1 > y2  ) koef1 = koef1 - (koef1 * 2);
		if(x1 > x2 && y1 > y2  ) koef1 = koef1 - (koef1 * 2);
		
		String result = String.format("%.3f",koef1);
		LOG.info("koef1: " + result);
		
		// getting koef2		
		double koef2 = (double)Math.abs(y1) - ((double)Math.abs(x1) * koef1);
		LOG.info("koef2: " + koef2);
		
		// result
		LOG.info("equation:");
		
		if(koef2 > 0)LOG.info("y = " + koef1 + "x + " + koef2);
		if(koef2 < 0)LOG.info("y = " + koef1 + "x " + koef2);	
		
		double[] r = {koef1, koef2}; 
		return r;
	}

}
