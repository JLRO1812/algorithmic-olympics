package model;

public class CircleManager {

	private final double MIN_RADIUS = 5;
	private final double MAX_RADIUS = 40;
	private final double PLUS = 5;
	
	private double radius;
	private boolean increment;
	
	public CircleManager(double radius) {
		this.radius = radius;
		increment = true;
	}
	
	public void changeRadius() {
		if(increment) 
			increase();
		else
			decrease();
	}
	
	private void increase() {
		if(radius>=MAX_RADIUS) {
			radius-=PLUS;
			increment = false;
		}else {
			radius+=PLUS;
		}
	}
	
	private void decrease() {
		if(radius<=MIN_RADIUS) {
			radius+=PLUS;
			increment = true;
		}else {
			radius-=PLUS;
		}
	}
	
	public double getRadius() {
		return radius;
	}
}
